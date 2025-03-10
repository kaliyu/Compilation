package main;

import java.io.*;
import java.util.List;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import parser.gazoLexer;
import parser.gazoParser;
import ast.*;

import java.nio.file.*;


public class Main{


	private static ParseTree parse(InputStream inputStream) throws IOException{
		CharStream input = CharStreams.fromStream(inputStream);
		gazoLexer lexer = new gazoLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		gazoParser parser = new gazoParser(tokens);

		ParseTree tree = parser.program();

		if(parser.getNumberOfSyntaxErrors()!=0){
			System.out.println("erreur de syntaxe : sortie après analyse syntaxique");
			System.exit(1);
		}
		return tree;
	}

					
	public static void main(String[] args) throws IOException{

		InputStream inputStream = System.in;
		ParseTree tree = parse(inputStream);
		
		AstBuild astB=new AstBuild();
		Program ast= (Program) tree.accept(astB);

		mips.Translate tr=new mips.Translate();
		String code = ast.accept(tr);
		System.out.println(code);
	}
}
