package mips;
import ast.*;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;

public class Translate extends ast.BaseVisitor<String> {
	
	private Map<String,String> regVars;
	private int numReg;
	private int maxReg;
	public Translate(){
		super("");
		numReg=0;
		maxReg=9;
		regVars=new HashMap<>();
	}
	public String visit(StatAff s){
		String exprCode = s.getExpression().accept(this); 
		String varName = s.getId().getName(); 

		
		if (!regVars.containsKey(varName)) {
			if (numReg > maxReg) {
				return "erreur: plus de registres disponibles\n";
			}
			regVars.put(varName, "t" + numReg);
			numReg++;
		}

		
		String reg = regVars.get(varName);
		return exprCode + "move $" + reg + ", $v0\n";
	}
	public String visit(ExpId e){
		if(regVars.containsKey(e.getValue())){
			return "li $" + regVars.get(e.getValue()) +"\n";
		}
		return "erreur";
		
	}
	public String visit(ExpBin e){
		String leftCode = e.getLeftExp().accept(this); 
		String rightCode = e.getRightExp().accept(this); 

		
		String code = leftCode + "move $t0, $v0\n" + rightCode + "move $t1, $v0\n";

		// Générer l'opération
		switch (e.getOp()) {
			case ADD:
				code += "add $v0, $t0, $t1\n";
				break;
			case MIN:
				code += "sub $v0, $t0, $t1\n";
				break;
			case MULT:
				code += "mul $v0, $t0, $t1\n";
				break;
		}
		return code;
	}
	public String visit(ExpInt e){
		return "li $v0 " + e.getValue() +"\n";
	}
	public String visit(StatPrint sp){
		String code = sp.getExpression().accept(this);
		return code + "move $a0 $v0\n" + "li $v0 1\n" + "syscall\n";
	}
	public String visit(StatList sl){
		String code = "";
		for(Statement s : sl.getStatList()){
			code = code + s.accept(this);
		}
		return code;
	}
	public String visit(Program p) {
		
		String instructions = p.getStat().accept(this);
	
		
		return ".data\n" +  
			   ".text\n" +
			   ".globl main\n" +
			   "main:\n" +
			   instructions + 
			   "\nli $v0, 10\n" +  // Fin du programme MIPS (syscall 10)
			   "syscall\n";
	}
	
	public String visit(ExpRead e){
		return "li $v0, 5\n" + 
			   "syscall\n";  
	}
}
