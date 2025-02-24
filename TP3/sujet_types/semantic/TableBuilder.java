package semantic;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Stack;

import ast.*;
import support.Errors;

public class TableBuilder extends ast.BaseVisitor<Void>{
	
	private final SymbolTable symbolTable;
	private final Stack<Block> parentBlocks;
	private final Errors errors;
	public TableBuilder(){
		super(null);
		errors=new Errors();
		parentBlocks=new Stack<>();
		symbolTable=new SymbolTable();
	}

	public SymbolTable getTable(){
		if(symbolTable.getErrors().hasErrors()){
			System.out.println("erreurs dans table");
			symbolTable.getErrors().print();
			System.out.println("Sortie après construction de la table des symboles.");
			System.exit(1);
		}
		if(errors.hasErrors()){
			System.out.println("erreurs dans construction table");
			errors.print();
			System.out.println("Sortie après construction de la table des symboles.");
			System.exit(1);
		}
		return symbolTable;
	}

	@Override
	public Void visit(Block b){
		symbolTable.localTable(b);
		parentBlocks.push(b);
		super.visit(b);
		parentBlocks.pop();
		return null;
	}
	@Override
	public Void visit(StatVarDecl vd) {
		String id = vd.getId().getName();
		Type type = vd.getType();
		Type t = symbolTable.variableLookup(id, parentBlocks);
		if(t!= null){
			errors.add(vd," : variable"+id+"déjà déclarée en "+t.getPosition());
		}
		if(parentBlocks.empty()){
			errors.add(vd,"erreur : pile de blocs vide");
		}
		symbolTable.addLocalVariable(parentBlocks.peek(), id, type);
		return null;
	}

}
