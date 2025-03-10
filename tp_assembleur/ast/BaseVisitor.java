package ast;


public class BaseVisitor<T> implements ast.Visitor<T>{
	
	private final T defaultValue;

	public T getDefaultValue(){
		return defaultValue;
	}
	public BaseVisitor(T val){
		this.defaultValue=val;
	}

	public T visit(ExpRead e){
		return defaultValue;
	}
	public T visit(Id e){
		return defaultValue;
	}
	public T visit(Program p){
		T res = p.getStat().accept(this);
		return res;
	}
	public T visit(StatAff a){
		a.getId().accept(this);
		return a.getExpression().accept(this);
	}
	public T visit(StatList s){
		T val = defaultValue;
		for(Statement st: s.getStatList()){
			val=st.accept(this);
		}
		return val;
	}

	public T visit(StatPrint s){
		return s.getExpression().accept(this);
	}

	public T visit(ExpUn e){
		return e.getExp().accept(this);
	}
	public T visit(ExpBin e){
		e.getLeftExp().accept(this);
		return e.getRightExp().accept(this);
	}
	public T visit(ExpId e){
		return defaultValue;
	}
	public T visit(ExpInt e){
		return defaultValue;
	}

}
