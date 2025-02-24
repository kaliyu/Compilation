package ast;
 import java.util.List;

public class Program extends Node{
	private Block block;
	private List<MethodDecl> listMethodDecl;

	public Program(Position pos,Block b, List<MethodDecl> lm){
		this.position=pos;
		this.block=b;
		this.listMethodDecl=lm;
	}

	public Block getBlock(){return block;}
	public List<MethodDecl> getListMethodDecl(){return listMethodDecl;}
	public <T> T accept(Visitor<T> visitor){
		return visitor.visit(this);
	}
}
			
	
