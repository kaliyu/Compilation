package ast;
 public abstract class Expression extends Node{
	abstract public <T> T accept(Visitor <T> visitor);
}

