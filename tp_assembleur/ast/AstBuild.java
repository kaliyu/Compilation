package ast;

import java.util.List;
import java.util.ArrayList;

import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr.v4.runtime.*;
import parser.*;
import parser.gazoParser.*;
import ast.*;



public class AstBuild extends parser.gazoBaseVisitor<Node> implements parser.gazoVisitor<Node> {

	private static Position position(ParserRuleContext ctx){
		return new Position(ctx.start.getLine(),ctx.start.getCharPositionInLine());
	}


	@Override public Node visitProgram(gazoParser.ProgramContext ctx) {
		List<StatementContext> listStatCont = ctx.statement();
		List<Statement> statList=new ArrayList<Statement>();
		for(StatementContext sc : listStatCont){
			statList.add((Statement)visit(sc));
		}
		Statement sList =new StatList(position(ctx),statList);

		return new Program(position(ctx),sList);
	}
	@Override public Node visitExRead(gazoParser.ExReadContext ctx){
		return new ExpRead(position(ctx));
	}
	@Override public Node visitStatAff(gazoParser.StatAffContext ctx){
		Id id=new Id(position(ctx),ctx.Id().getText());
		Expression e = (Expression)visit(ctx.exp());
		return new StatAff(position(ctx),id,e);
	}
	
	@Override public Node visitStatList(gazoParser.StatListContext ctx) { 
		List<StatementContext> listStat = ctx.statement();
		List<Statement> statList= new ArrayList<Statement>();
		for(StatementContext stat : listStat){
			statList.add((Statement)visit(stat));
		}
		return new StatList(position(ctx), statList);
				
	}

	@Override public Node visitStatPrint(gazoParser.StatPrintContext ctx) { 
		Expression exp = (Expression)visit(ctx.exp());
		return new StatPrint(position(ctx),exp);
	}

	/**
	 * EXPRESSIONS
	 * */
	@Override public Node visitExId(gazoParser.ExIdContext ctx) { 
		return new ExpId(position(ctx),ctx.Id().getText());
	}

	@Override public Node visitExParenthesis(gazoParser.ExParenthesisContext ctx) { 
		return visit(ctx.exp());
       	}
	
	@Override public Node visitExInt(gazoParser.ExIntContext ctx) {
		return new ExpInt(position(ctx), Integer.parseInt(ctx.Int().getText())); 
	}
	@Override public Node visitExUnop(gazoParser.ExUnopContext ctx) { 
		Expression exp=(Expression)visit(ctx.exp());
		String unop=ctx.Op().getSymbol().getText();
		UnOp op = switch(unop){
			case "-" -> UnOp.MIN;
			default -> throw new IllegalStateException("Unexpected value");
		};
		return new ExpUn(position(ctx), exp, op);
	}
	@Override public Node visitExBinop(gazoParser.ExBinopContext ctx) {
		Expression exp1=(Expression)visit(ctx.exp(0));
		Expression exp2=(Expression)visit(ctx.exp(1));
		String binop = ctx.Op().getSymbol().getText();
		BinOp op = switch(binop){
			case "+" -> BinOp.ADD;
			case "-" -> BinOp.MIN;
			case "*" -> BinOp.MULT;
			default -> throw new IllegalStateException("Unexpected value");
		};
		return new ExpBin(position(ctx), exp1,op,exp2);
	}



}
