package semantic;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;
import java.util.ArrayList;
import ast.*;
import semantic.SymbolTable;
import support.Errors;


public class TypeChecker extends ast.BaseVisitor<Type>{
	private SymbolTable table;
	private String currentMethod;
	private Stack<Block> parentBlocks;

	public Stack<Block> getParenBlocks(){
		return parentBlocks;
	}
	private Errors errors;

	//Type pour les instructions	
	private final static Type statType = new TypePrim(null, TypePrim.Prim.STAT);
	//Type pour les expressions mal typées
	//(permet de retourner quelque chose et d’analyser l’AST en entier
	//malgré les erreurs)
	
	private final static Type errType = new TypePrim(null, TypePrim.Prim.IND);

	public TypeChecker(SymbolTable t){
		super(null);//on appelle le visiteur générique avec null comme
			    //valeur par défaut
		parentBlocks=new Stack<>();
		this.table=t;
		this.errors=new Errors();
		
	}

	public void check(){
		if(errors.hasErrors()){
			System.out.println("Erreurs de typage : ");
			errors.print();
			System.out.println("Sortie après analyse de types.");
			System.exit(1);
		}
	}
	
	//Ici : coder les méthodes visit pour les nœeuds de l’AST nécessaires.
}
	

