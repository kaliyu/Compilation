package ast;
public interface Visitor <T> extends VisitorExp<T>{
	public T visit(Id e);
	public T visit(Program p);
	public T visit(StatAff a);
	public T visit(StatList s);
	public T visit(StatPrint s);

}

