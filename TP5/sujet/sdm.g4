grammar sdm;//software, data and methods

//Lexèmes

Id : [a-zA-Z][0-9a-zA-Z_]*;
Int : [0-9]+;
Min : '-';
Unop : '!'|Min ;
Binop : '&&' |'<' |'>'|'!='|'/'| '+' | Min
|'*'|'=='|'+='|'||'|'<='|'>=' ;
	//todo:commentaires
Comm : '//' [.^\n]* '\n' ;

WS : [ \t\r\n]+ -> skip;
Char : '\'' . '\'';

//Règles de grammaire


program : (methodDecl)*mainMethod;

mainMethod : 'int' 'main' '(' ')' statement;
methodDecl : type Id '(' (formal (',' formal)*)? ')' statement ;

formal : type Id;

type : 'int'		#intType
	|'boolean'	#boolType
;
statement : '{' statement* '}'				#statList
	|'if' '(' exp ')' statement 'else' statement	#statIf
	|'while' '(' exp ')' statement			#statWhile
	|'for' '(' statement  exp ';'  statement ')' statement   #statFor
	|'print' '(' exp ')' ';'			#statPrint
	|Id '=' exp ';'					#statAff
	|Id '++' ';'					#statIncr
	|'return' exp ';'				#statReturn
	|type Id ';'					#statVarDecl
	|type Id '=' exp ';'				#statVarDeclAff
;

exp : exp Binop exp			#exBinop
	|Unop exp			#exUnop
	|Int				#exInt	
	|'true'				#exTrue
	|'false'			#exFalse	
	|Id				#exId
	|'(' exp ')'			#exParenthesis
	|Id '(' (exp (',' exp)*)?  ')'	#exCall
	|'read' '(' ')'			#exRead
;


