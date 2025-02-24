package ast;

import java.util.List;
import java.util.ArrayList;

import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr.v4.runtime.*;
import parser.*;
import parser.schParser.*;
import ast.*;



public class AstBuild extends parser.schBaseVisitor<Node> implements parser.schVisitor<Node> {

	private static Position position(ParserRuleContext ctx){
		return new Position(ctx.start.getLine(),ctx.start.getCharPositionInLine());
	}


	@Override public Node visitProgram(schParser.ProgramContext ctx) {
		List<StatementContext> listStatCont = ctx.statement();
		List<Statement> statList=new ArrayList<Statement>();
		List<MethodDeclContext> listMetCont = ctx.methodDecl();
		List<MethodDecl> metList=new ArrayList<MethodDecl>();
		for(MethodDeclContext md : listMetCont){
			metList.add((MethodDecl)visit(md));
		}
		for(StatementContext sc : listStatCont){
			statList.add((Statement)visit(sc));
		}
		StatList sList =new StatList(position(ctx),statList);
		Block b = new Block(position(ctx),sList);

		return new Program(position(ctx),b,metList);
	}
	@Override public Node visitStatAff(schParser.StatAffContext ctx){
		Id id=new Id(position(ctx),ctx.Id().getText());
		Expression e = (Expression)visit(ctx.exp());
		return new StatAff(position(ctx),id,e);
	}

	@Override public Node visitStatVarDecl(schParser.StatVarDeclContext ctx){
		Type t=(Type) visit(ctx.type());
		Id id=new Id(position(ctx),ctx.Id().getText());
		return new StatVarDecl(position(ctx),id,t);
	}

	@Override public Node visitStatReturn(schParser.StatReturnContext ctx){
		Expression e = (Expression)visit(ctx.exp());
		return new StatReturn(position(ctx),e);
	}
	



	@Override public Node visitMethodDecl(schParser.MethodDeclContext ctx) { 
		Type type =(Type) visit(ctx.type());
		Id id = new Id(position(ctx),ctx.Id().getText());
		StatementContext statContext =(ctx.statement());
		Statement statement=(Statement)visit(statContext);
		Block block=new Block(position(ctx),statement);
		
		List<FormalContext> formalContextList = ctx.formal();
		List<Formal> formalList = new ArrayList<Formal>();
		for(FormalContext fc : formalContextList){
			Formal f = (Formal)visit(fc);
			formalList.add(f);
		}

		return new MethodDecl(position(ctx),type,id,formalList,block);


	}

	@Override public Node visitFormal(schParser.FormalContext ctx) { 
		Type type = (Type)visit(ctx.type());
		Id id = new Id(position(ctx),ctx.Id().getText());

		return new Formal(position(ctx), type, id);
	}

	@Override public Node visitBoolType(schParser.BoolTypeContext ctx){
		return new TypePrim(position(ctx),TypePrim.Prim.BOOL);
	}

	@Override public Node visitIntType(schParser.IntTypeContext ctx){
		return new TypePrim(position(ctx),TypePrim.Prim.INT);
	}
	
	@Override public Node visitStatList(schParser.StatListContext ctx) { 
		List<StatementContext> listStat = ctx.statement();
		List<Statement> statList= new ArrayList<Statement>();
		for(StatementContext stat : listStat){
			statList.add((Statement)visit(stat));
		}
		return new StatList(position(ctx), statList);
				
	}

	@Override public Node visitStatIf(schParser.StatIfContext ctx) { 
		Expression exp = (Expression)visit(ctx.exp());
		Statement test = (Statement)visit(ctx.statement(0));
		Block bTest=new Block(position(ctx),test);
		Statement statElse = (Statement)visit(ctx.statement(1));
		Block bElse=new Block(position(ctx),statElse);
		
		return new StatIf(position(ctx),exp,bTest,bElse);	
	}

		
	@Override public Node visitStatWhile(schParser.StatWhileContext ctx) { 
		Expression exp =(Expression) visit(ctx.exp());
		Statement stat = (Statement)visit (ctx.statement());
		Block b=new Block(position(ctx),stat);
		return new StatWhile(position(ctx),exp,b);
	}

	@Override public Node visitStatPrint(schParser.StatPrintContext ctx) { 
		Expression exp = (Expression)visit(ctx.exp());
		return new StatPrint(position(ctx),exp);
	}

	/**
	 * EXPRESSIONS
	 * */
	@Override public Node visitExId(schParser.ExIdContext ctx) { 
		return new ExpId(position(ctx),ctx.Id().getText());
	}
	@Override public Node visitExFalse(schParser.ExFalseContext ctx) { 
		return new ExpCons(position(ctx),Constant.FALSE);
	}
	@Override public Node visitExTrue(schParser.ExTrueContext ctx) { 
		return new ExpCons(position(ctx),Constant.TRUE);
	}

	@Override public Node visitExParenthesis(schParser.ExParenthesisContext ctx) { 
		return visit(ctx.exp());
       	}
	@Override public Node visitExCall(schParser.ExCallContext ctx) {
		Id method = new Id(position(ctx),ctx.Id().getText());
		List<Expression> args = new ArrayList<>();
		for(ExpContext ec : ctx.exp()){
			args.add((Expression)visit(ec));
		}

		return new ExpCallMethod(position(ctx),method,args); 
	}
	@Override public Node visitExInt(schParser.ExIntContext ctx) {
		return new ExpInt(position(ctx), Integer.parseInt(ctx.Int().getText())); 
	}

	@Override public Node visitExRead(schParser.ExReadContext ctx){
		return new ExpRead(position(ctx));
	}


	@Override public Node visitExBinop(schParser.ExBinopContext ctx) {
		Expression exp1=(Expression)visit(ctx.exp(0));
		Expression exp2=(Expression)visit(ctx.exp(1));
		String binop = ctx.Binop().getSymbol().getText();
		BinOp op = switch(binop){
			case "+" -> BinOp.ADD;
			case "-" -> BinOp.MIN;
			case "*" -> BinOp.MULT;
			case "<" -> BinOp.LT;
			case "<=" -> BinOp.LEQ;
			case ">=" -> BinOp.GEQ;
			case ">" -> BinOp.GT;
			case "&&" -> BinOp.AND;
			case "==" -> BinOp.EQ;
			case "!=" -> BinOp.NEQ;
			case "||" -> BinOp.OR;
			case "/" -> BinOp.DIV;


			default -> throw new IllegalStateException("Unexpected value");
		};
		return new ExpBin(position(ctx), exp1,op,exp2);
	}
	@Override public Node visitExUnop(schParser.ExUnopContext ctx) { 
		Expression exp=(Expression)visit(ctx.exp());
		String unop=ctx.Unop().getSymbol().getText();
		UnOp op = switch(unop){
			case "!" -> UnOp.NOT;
			case "-" -> UnOp.MIN;
			default -> throw new IllegalStateException("Unexpected value");
		};
		return new ExpUn(position(ctx), exp, op);
	}




}
