package ast;
import java.util.List;
import java.util.LinkedList;
public class VisitId extends ast.BaseVisitor<Void>{

	private List<String> list;
	public String print(){
		String res ="[";
		for(String s : list){
			res=res+","+s;
		}
		return res;
	}


	public VisitId(){
		super(null);
		list=new LinkedList<String>();
	}
	public Void visit(Id i){
		list.add(i.getName());
		return null;
	}
	public Void visit(ExpId e){
		list.add(e.getValue());
		return null;
	}

}

