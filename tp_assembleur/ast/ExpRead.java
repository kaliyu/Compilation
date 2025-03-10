package ast;
public class ExpRead extends Expression{

	public ExpRead(Position p){
		this.position=p;
	}

	public <T> T accept(Visitor<T> visitor){
		return visitor.visit(this);
	}
}
