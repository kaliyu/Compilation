package semantic;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Stack;
import support.Errors;
import ast.*;

public class SymbolTable {
	private Errors errors;
	public Errors getErrors(){return errors;}
	//pour les fonctions : 
	private Map<String,MethodSig> methods;
	//pour les blocs : chaque bloc
	// est associé à sa table locale.
	private Map<Block,Map<String,Type>> blocks;

	public SymbolTable(){
		methods=new HashMap<>();
		blocks=new HashMap<>();
		errors=new Errors();
	}

	public void addMethod(String nom,MethodSig ms){
		this.methods.put(nom, ms);
	}
	public void addLocalVariable(Block block,String nom,Type type){
		if (!blocks.containsKey(block)) {
			errors.add(block, "Erreur : le bloc " + block + " n'a pas de table locale.");
		} else {
			Map<String, Type> table = blocks.get(block);
			if (table.containsKey(nom)) {  // Vérifier si la variable existe déjà
				errors.add(block, "Erreur : la variable '" + nom + "' est déjà déclarée dans ce bloc.");
			} else {
				table.put(nom, type);
			}
		}
	}
	public void localTable(Block b){
		if(blocks.get(b) == null){
			Map<String,Type> localT = new HashMap<>();
			blocks.put(b,localT);
		}
	}
	public MethodSig methodLookup(String name){
		return methods.get(name);
	}
	public Type variableLookup(String name,Stack<Block> history){
		Type t = null;
    	for (Block b : history) {  // Utilisation correcte de history au lieu de vb.getStack()
        // System.out.print("lookup ["+name+"] in "+b);
			Map<String, Type> table = blocks.get(b);
			if (table == null) {
				String s = "[Table des symboles] : pas de table locale associée au bloc " + b;
				errors.add(b, s);
			} else {
				t = table.get(name);
				if (t != null) {
					// System.out.print(" -> oui ("+t.getName()+")\n");
					return t;
				}
			}
    	}
    return null;
	}

	//Pour afficher le contenu de la table
	public void print(){
		System.out.println("Table des symboles : ");
		System.out.println("Méthodes : ");
		for (Map.Entry entry : methods.entrySet()){
			System.out.println("clé: "+entry.getKey()
					+ " | valeur: " 
					+ entry.getValue());
		}
		System.out.println("Blocs : ");
		for (Map.Entry entry : blocks.entrySet()){
			System.out.println("clé: "+entry.getKey()
					+ " | valeur: " 
					+ entry.getValue());
		}

	}

}
