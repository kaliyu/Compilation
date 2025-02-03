import java.util.List;
class A{
	static final int x;
	int fact(int n){
		if((n==0) || (n==1)){
			return 1;
		}
		return fact(n-1)*n;
	}

	void g(){
		if( fact(x)== 32){
			x=12;
			System.out.print(fact(x));
		}
		else{
			g();
		}
	}
}
public class Obj{
	public static void main(String[] args) {
		System.out.println(fact(42));
	}
}
