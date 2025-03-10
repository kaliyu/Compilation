package ast;
 import java.util.List;

public class Program extends Node{
	private Statement inst;

	public Program(Position pos,Statement i){
		this.position=pos;
		this.inst=i;
	}

	public Statement getStat(){return inst;}
	public <T> T accept(Visitor<T> visitor){
		return visitor.visit(this);
	}
}
			
	
