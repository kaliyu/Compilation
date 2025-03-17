package ir.translation;

import ast.*;
import ast.Expression;
import ir.Frame;
import ir.Register;
import ir.com.*;
import ir.expr.*;
import semantic.*;
import support.*;

import java.util.*;
import java.util.stream.Collectors;

public class Translate {
	private static final TypeConverter typeConverter = new TypeConverter();

	private static ir.Type ofType(Type type) {
		return type.accept(typeConverter);
	}

	public static Pair<Label, List<Pair<Frame, List<Command>>>> 
	  run(SymbolTable symbolTable, Program program) {
		TranslationVisitor translator = new TranslationVisitor(symbolTable);
		program.accept(translator);
		Errors e = translator.errors;
		if(translator.mainLabel==null){
			e.add("pas de fonction main.");
		}
		if(e.hasErrors()){
			System.out.println("Erreurs de traduction en code intermédiaire :");
			e.print();
			System.out.println("Sortie avant production assembleur");
			System.exit(1);
		  }
		  return new Pair<>(translator.mainLabel, translator.fragments);
	}
	private static class TypeConverter extends ast.BaseVisitor<ir.Type> {
	//pour convertir les types de l’AST en types de l’IR
	public TypeConverter(){
		super(null);
	}
	@Override
	public ir.Type visit(TypePrim type) {
		switch (type.getPrim()) {
		case INT:
			return ir.Type.INT;
		case BOOL:
			return ir.Type.BYTE;
		}
		throw new Error("Traduction IR :type primitif non géré : "+type.getPrim().toString());
	}
}

private static class TranslationVisitor extends ast.BaseVisitor<Result>{
	public Errors errors;
	//La table des symboles et le typeChecker, utiles pour au moins deux
	//éléments :
	//- Savoir à quel bloc se réfère un nom de variable (pile des blocs)
	//- Savoir quel est le type pour les registres associés aux variables.
	private final SymbolTable symbolTable;
	private final TypeChecker typeChecker;
	
	//Chaque nom de méthode est associé à un frame (construit par le
	//FramesBuilder)
	private final Map<String, Frame> frames;

	//Dans chaque bloc, chaque variable est associée à un registre.
	private final Map<Block,Map<String, Register>> varToReg;

	//Chaque méthode sera enregistrée dans une liste de paires, avec son
	//frame et son code.
	private final List<Pair<Frame, List<Command>>> fragments;

	//Le frame courant, auquel on ajoute en particulier les registres
	//temporaires nécessaires au calcul de la fonction (qui seront empilés
	//lors de l’appel).
	private Frame currentFrame;
	//Un label spécifique, correspondant au point d’entrée de la fonction
	//main.
	private Label mainLabel;

	public TranslationVisitor(SymbolTable symbolTable) {
		super(null);
		this.symbolTable = symbolTable;
		this.varToReg = new HashMap<>();
		this.typeChecker = new TypeChecker(symbolTable);
		this.fragments = new LinkedList<>();
		this.frames = new HashMap<>();
		this.currentFrame = null;
		this.mainLabel = null;
		this.errors = new Errors();
	}

//----REGISTRES-------
	private Register registerLookup(String name) {
		Register reg;
		for (Block block : typeChecker.getVisitedBlocks().getStack()) {
			Map<String,Register> map = varToReg.get(block);
	
			reg=map.get(name);
			//System.out.println("lookup "+block+": "+name);
			if (reg != null) return reg;
		}
		support.Maps.print(varToReg);
		errors.add("Erreur interne, pas de registre associé à la variable " + name);
		return null;
	}

//---EXPRESSIONS------
	@Override
	public Result visit(ExpCons exp) {
		//TODO
		//Retourner un octet = à 1 pour true, 0 pour false.
		Constant constant = exp.getConstant();
		int rest = 1;
		switch (constant) {
			case TRUE:
				rest = 1;
			case FALSE:
				rest = 0;
			default:
				break;
		}
		return new Result(new ir.expr.Int(rest));
	}
	@Override
	public Result visit(ExpInt exp) {
		int entier = exp.getValue();
		return new Result(new ir.expr.Int(entier));
	}
	@Override
	public Result visit(ExpId exp){
		//TODO 
		//Retourner une seule instruction, celle qui lit dans le
		//registre associé à la variable.
		String id = exp.getValue();
		Register reg = registerLookup(id); 
		return new Result(new ReadReg(reg));
	}
	public Result visit(ExpRead e){
	//création d’un frame pour la lecture, avec un nom qui sera rajouté
	//explicitement dans le code assembleur.
		Frame frame = new Frame(Label.named("entryReadInt"),
			Label.named("exitReadInt"),
			new LinkedList<>(),
			new Register(ir.Type.INT)
			);
		Type type = new TypePrim(null,TypePrim.Prim.INT);
		List<Command> code = new LinkedList<>();
		List<ir.expr.Expression> args = new LinkedList<>();
		Result result = makeFunCall(type,frame,args,code);
		return result;
	}
	@Override
	public Result visit(ExpBin exp) {
		Result left = exp.getLeftExp().accept(this);
		Result right = exp.getRightExp().accept(this);
		BinOp op = exp.getOp();
		ir.expr.Expression binary = new Binary(left.getExp(), right.getExp(), op);
		

		List<Command> code = new LinkedList<>();
		code.addAll(left.getCode());
		code.addAll(right.getCode());
		return new Result(binary, code);
	}
	
	@Override
	public Result visit(ExpUn exp) {
		//TODO
		UnOp unop = exp.getOp();
		Result result = exp.getExp().accept(this);
		ir.expr.Expression unaire = new Unary(result.getExp(), unop);

		return new Result(unaire);
	}

	@Override
	public Result visit(ExpCallMethod exp){
		String functionName = exp.getMethod().getName();
	
		Pair<List<ir.expr.Expression>, List<Command>> translation = translateExpressions(exp.getArgs());
		List<Command> code = translation.getSnd();
		List<ir.expr.Expression> arguments = translation.getFst();
		MethodSig signature = symbolTable.methodLookup(functionName);
		if(signature==null) errors.add("Erreur interne, " + functionName+" pas dans la table");
	
		List<Type> argumentTypes = getArgumentTypes(exp.getArgs());
		Type returnType = signature.getReturnType();
	
		Frame frame = frames.get(functionName);
		Result result= makeFunCall(returnType,frame,arguments,code);
		return result;
	}

	
	
	
//-------INSTRUCTIONS--------

	@Override
	public Result visit(StatVarDecl stm) {
	// Declaration de variable : nouveau registre
	// TODO :
	// 	-Créer un registre (avec le bon type)
	// 	-Récupérer le bloc actuel (celui déterminé par le typeChecker
	//	-Mettre l’id et le registre dans la map 'varToReg'
	//	-Ajouter le registre au frame courant.
	//	-Retourner un code vide.
		return null;
	}

	@Override
	public Result visit(StatAff s) {
	//	- Compilation de l’expression
	//	- Récupération du registre lié à la variable (le registre
	//	devrait être dans la Map, si les phases précédentes ont bien
	//	fait leur travail.)
	//	- Renvoyer le code permettant de calculer l’expression, auquel
	//	on ajoute une écriture de l’expression dans le registre
	//	obtenu au point précédent.
		return null;	
	}
	@Override 
	public Result visit(StatPrint s){
		Expression e=s.getExpression();
		Frame frame = new Frame(Label.named("entryPrintInt"),
				Label.named("exitPrintInt"),
				ListTools.mklist(new Register(ir.Type.INT)),
				new Register(ir.Type.INT)
				);
		Result r = e.accept(this);
	
		List<Command> code = r.getCode();
		List<ir.expr.Expression> args = ListTools.mklist(r.getExp());
		//on laisse un int en retour par défaut, car toutes les fonctions
		//doivent retourne qqchose. 
		Type type = new TypePrim(null,TypePrim.Prim.INT);
		Result result = makeFunCall(type,frame,args,code);
		
	    	return result;
	}

  
	@Override
	public Result visit(StatReturn stm) {
		//compiler l’expression, récupérer le registre de retour du
		//frame courant, puis produire le code qui :
		//  - permet de calculer l’expression
		//  - écrit cette expression dans le registre de retour
		//  - saute au point de sortie du frame courant
		//  TODO
		return null;
	}
	
	//Pour compiler une liste d’expressions dans une seule paire (exp,code)
	private	 Pair<List<ir.expr.Expression>,List<Command>> translateExpressions(List<Expression> exps) {
		//TODO
		return null;
	}

	private Result makeFunCall(Type type,Frame frame,List<ir.expr.Expression> args,List<Command> code){
		Register reg = new Register(ofType(type));
		currentFrame.addLocal(reg);
		Command call = new FunCall(reg, frame, args);
		code.add(call);
		return new Result(new ReadReg(reg), code);
	}
	//Pour récupérer la liste des types de la liste des paramètres
	List<Type> getArgumentTypes(List<Expression> args) {
		return args.stream()
			.map((a) -> a.accept(typeChecker))
			.collect(Collectors.toList());
	}
	
	@Override
	public Result visit(StatIf stm) {
		//TODO
		return null;
	}
	
	
	@Override
	public Result visit(StatWhile stm) {
		//TODO
		return null;
	}
	
	@Override
	public Result visit(Block b) {
		if(varToReg.get(b)==null){
			varToReg.put(b,new HashMap<>());
		}
		typeChecker.getVisitedBlocks().enter(b);
	
		List<Command> code = new LinkedList<>();
		Statement stm = b.getStatement();
		Result result = stm.accept(this);
		code.addAll(result.getCode());
	
	
		typeChecker.getVisitedBlocks().exit();
	      
		return new Result(code);
	}
	@Override
	public Result visit(StatList sl) {
		List<Command> code = new LinkedList<>();
		for (Statement stm : sl.getStatList()){
			Result result = stm.accept(this);
			code.addAll(result.getCode());
		}
	return new Result(code);
	}

	@Override
	public Result visit(MethodDecl md) {
		//TODO
		//-Récupérer le frame associé à la méthode,
		//-Récupérer le code du corps de la fonction
		//-Ajouter la paire frame/code aux fragments
		return null;
	}

	@Override
	public Result visit(Program program) {
		program.accept(typeChecker);
		FramesBuilder framesBuilder = new FramesBuilder();
		program.accept(framesBuilder);
		for (MethodDecl fun : program.getListMethodDecl())
			fun.accept(this);
		return null;
	}

//Classe interne : visiteur pour la constructions des Frames
private class FramesBuilder extends ast.BaseVisitor<Void> {
	FramesBuilder(){super(null);}

	@Override
	public Void visit(MethodDecl function) {
		List<Register> parameters = new LinkedList<>();
		Block b = function.getBlock();
		//on ne visite pas le bloc, alors le rajouter ici dans la Map
		varToReg.put(b,new HashMap<>());
		for (Formal argument : function.getFormal()) {
			Type argType = argument.getType();
			String argName = argument.getId().getName();
			Register register = new Register(ofType(argType));
			Map<String,Register> map = varToReg.get(b);
			//System.out.println("put "+argName+"->"+register+" dans "+b);
			map.put(argName, register);
			parameters.add(register);
		}
		Frame frame;
		Type type = function.getType();
		ir.Type irType = ofType(type);
		frame = new Frame(Label.fresh(), Label.fresh(), parameters, new Register(irType));
	
		frames.put(function.getId().getName(), frame);
		if (function.getId().getName().equals("main")){
			mainLabel = frame.getEntryPoint();
		}
		//support.Maps.print(varToReg); 
		return null;
	}
	@Override
	public Void visit(Program program) {
		for (MethodDecl function : program.getListMethodDecl()) {
			function.accept(this);
		}
		return null;
	}
}
}
}
