package ast;
public interface VisitorExp<T>{
	T visit(ExpBin e);
	T visit(ExpId e);
	T visit(ExpInt e);
	T visit(ExpUn e);
	T visit(ExpRead e);
}
