grammar gazo;//Generator of Assembly with Zero Optimisation
//Règles de grammaire


program : statement*;
statement : '{' statement* '}'				#statList
	|'print' '(' exp ')' ';'			#statPrint
	|Id '=' exp ';'					#statAff
;

exp : exp Op exp			#exBinop
	|Op	 exp			#exUnop
	|'read' '(' ')'			#exRead
	|Int				#exInt		
	|Id				#exId
	|'(' exp ')'			#exParenthesis
;


//Lexèmes

Int : [0-9]+;
Op :  '+' | '-' |'*' ;
Id : [a-zA-Z][0-9a-zA-Z_]*;
WS : [ \t\r\n]+ -> skip;


