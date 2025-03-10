package ast;
 public class ExpInt extends Expression{

	private final int value;

	public ExpInt(Position position,int value){
		this.position=position;
		this.value=value;
	}

	public int getValue(){
		return value;
	}

	
	public <T> T accept(Visitor<T> visitor){
       		return visitor.visit(this);
	}
}
