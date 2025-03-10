package ast;
 public enum BinOp{
	ADD{
		public String toString(){
			return "+";
		}
	},
	MIN{
		public String toString(){
			return "-";
		}
	},
	MULT{
		public String toString(){
			return "*";
		}
	}


}
