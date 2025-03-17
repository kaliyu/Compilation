package parser;
 // Generated from sdm.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class sdmParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, Id=21, Int=22, Min=23, Unop=24, Binop=25, 
		Comm=26, WS=27, Char=28;
	public static final int
		RULE_program = 0, RULE_mainMethod = 1, RULE_methodDecl = 2, RULE_formal = 3, 
		RULE_type = 4, RULE_statement = 5, RULE_exp = 6;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "mainMethod", "methodDecl", "formal", "type", "statement", 
			"exp"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'int'", "'main'", "'('", "')'", "','", "'boolean'", "'{'", "'}'", 
			"'if'", "'else'", "'while'", "'for'", "';'", "'print'", "'='", "'++'", 
			"'return'", "'true'", "'false'", "'read'", null, null, "'-'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, "Id", "Int", "Min", 
			"Unop", "Binop", "Comm", "WS", "Char"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "sdm.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public sdmParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public MainMethodContext mainMethod() {
			return getRuleContext(MainMethodContext.class,0);
		}
		public List<MethodDeclContext> methodDecl() {
			return getRuleContexts(MethodDeclContext.class);
		}
		public MethodDeclContext methodDecl(int i) {
			return getRuleContext(MethodDeclContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sdmListener ) ((sdmListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sdmListener ) ((sdmListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sdmVisitor ) return ((sdmVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(17);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(14);
					methodDecl();
					}
					} 
				}
				setState(19);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(20);
			mainMethod();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MainMethodContext extends ParserRuleContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public MainMethodContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mainMethod; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sdmListener ) ((sdmListener)listener).enterMainMethod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sdmListener ) ((sdmListener)listener).exitMainMethod(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sdmVisitor ) return ((sdmVisitor<? extends T>)visitor).visitMainMethod(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MainMethodContext mainMethod() throws RecognitionException {
		MainMethodContext _localctx = new MainMethodContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_mainMethod);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(22);
			match(T__0);
			setState(23);
			match(T__1);
			setState(24);
			match(T__2);
			setState(25);
			match(T__3);
			setState(26);
			statement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MethodDeclContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode Id() { return getToken(sdmParser.Id, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public List<FormalContext> formal() {
			return getRuleContexts(FormalContext.class);
		}
		public FormalContext formal(int i) {
			return getRuleContext(FormalContext.class,i);
		}
		public MethodDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sdmListener ) ((sdmListener)listener).enterMethodDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sdmListener ) ((sdmListener)listener).exitMethodDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sdmVisitor ) return ((sdmVisitor<? extends T>)visitor).visitMethodDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodDeclContext methodDecl() throws RecognitionException {
		MethodDeclContext _localctx = new MethodDeclContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_methodDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(28);
			type();
			setState(29);
			match(Id);
			setState(30);
			match(T__2);
			setState(39);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__0 || _la==T__5) {
				{
				setState(31);
				formal();
				setState(36);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(32);
					match(T__4);
					setState(33);
					formal();
					}
					}
					setState(38);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(41);
			match(T__3);
			setState(42);
			statement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FormalContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode Id() { return getToken(sdmParser.Id, 0); }
		public FormalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sdmListener ) ((sdmListener)listener).enterFormal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sdmListener ) ((sdmListener)listener).exitFormal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sdmVisitor ) return ((sdmVisitor<? extends T>)visitor).visitFormal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormalContext formal() throws RecognitionException {
		FormalContext _localctx = new FormalContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_formal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			type();
			setState(45);
			match(Id);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeContext extends ParserRuleContext {
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	 
		public TypeContext() { }
		public void copyFrom(TypeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IntTypeContext extends TypeContext {
		public IntTypeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sdmListener ) ((sdmListener)listener).enterIntType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sdmListener ) ((sdmListener)listener).exitIntType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sdmVisitor ) return ((sdmVisitor<? extends T>)visitor).visitIntType(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BoolTypeContext extends TypeContext {
		public BoolTypeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sdmListener ) ((sdmListener)listener).enterBoolType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sdmListener ) ((sdmListener)listener).exitBoolType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sdmVisitor ) return ((sdmVisitor<? extends T>)visitor).visitBoolType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_type);
		try {
			setState(49);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				_localctx = new IntTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(47);
				match(T__0);
				}
				break;
			case T__5:
				_localctx = new BoolTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(48);
				match(T__5);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	 
		public StatementContext() { }
		public void copyFrom(StatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StatWhileContext extends StatementContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public StatWhileContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sdmListener ) ((sdmListener)listener).enterStatWhile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sdmListener ) ((sdmListener)listener).exitStatWhile(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sdmVisitor ) return ((sdmVisitor<? extends T>)visitor).visitStatWhile(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StatVarDeclContext extends StatementContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode Id() { return getToken(sdmParser.Id, 0); }
		public StatVarDeclContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sdmListener ) ((sdmListener)listener).enterStatVarDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sdmListener ) ((sdmListener)listener).exitStatVarDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sdmVisitor ) return ((sdmVisitor<? extends T>)visitor).visitStatVarDecl(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StatVarDeclAffContext extends StatementContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode Id() { return getToken(sdmParser.Id, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public StatVarDeclAffContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sdmListener ) ((sdmListener)listener).enterStatVarDeclAff(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sdmListener ) ((sdmListener)listener).exitStatVarDeclAff(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sdmVisitor ) return ((sdmVisitor<? extends T>)visitor).visitStatVarDeclAff(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StatListContext extends StatementContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public StatListContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sdmListener ) ((sdmListener)listener).enterStatList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sdmListener ) ((sdmListener)listener).exitStatList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sdmVisitor ) return ((sdmVisitor<? extends T>)visitor).visitStatList(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StatAffContext extends StatementContext {
		public TerminalNode Id() { return getToken(sdmParser.Id, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public StatAffContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sdmListener ) ((sdmListener)listener).enterStatAff(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sdmListener ) ((sdmListener)listener).exitStatAff(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sdmVisitor ) return ((sdmVisitor<? extends T>)visitor).visitStatAff(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StatPrintContext extends StatementContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public StatPrintContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sdmListener ) ((sdmListener)listener).enterStatPrint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sdmListener ) ((sdmListener)listener).exitStatPrint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sdmVisitor ) return ((sdmVisitor<? extends T>)visitor).visitStatPrint(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StatIfContext extends StatementContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public StatIfContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sdmListener ) ((sdmListener)listener).enterStatIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sdmListener ) ((sdmListener)listener).exitStatIf(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sdmVisitor ) return ((sdmVisitor<? extends T>)visitor).visitStatIf(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StatReturnContext extends StatementContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public StatReturnContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sdmListener ) ((sdmListener)listener).enterStatReturn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sdmListener ) ((sdmListener)listener).exitStatReturn(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sdmVisitor ) return ((sdmVisitor<? extends T>)visitor).visitStatReturn(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StatIncrContext extends StatementContext {
		public TerminalNode Id() { return getToken(sdmParser.Id, 0); }
		public StatIncrContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sdmListener ) ((sdmListener)listener).enterStatIncr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sdmListener ) ((sdmListener)listener).exitStatIncr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sdmVisitor ) return ((sdmVisitor<? extends T>)visitor).visitStatIncr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StatForContext extends StatementContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public StatForContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sdmListener ) ((sdmListener)listener).enterStatFor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sdmListener ) ((sdmListener)listener).exitStatFor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sdmVisitor ) return ((sdmVisitor<? extends T>)visitor).visitStatFor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_statement);
		int _la;
		try {
			setState(110);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				_localctx = new StatListContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(51);
				match(T__6);
				setState(55);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2251458L) != 0)) {
					{
					{
					setState(52);
					statement();
					}
					}
					setState(57);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(58);
				match(T__7);
				}
				break;
			case 2:
				_localctx = new StatIfContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(59);
				match(T__8);
				setState(60);
				match(T__2);
				setState(61);
				exp(0);
				setState(62);
				match(T__3);
				setState(63);
				statement();
				setState(64);
				match(T__9);
				setState(65);
				statement();
				}
				break;
			case 3:
				_localctx = new StatWhileContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(67);
				match(T__10);
				setState(68);
				match(T__2);
				setState(69);
				exp(0);
				setState(70);
				match(T__3);
				setState(71);
				statement();
				}
				break;
			case 4:
				_localctx = new StatForContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(73);
				match(T__11);
				setState(74);
				match(T__2);
				setState(75);
				statement();
				setState(76);
				exp(0);
				setState(77);
				match(T__12);
				setState(78);
				statement();
				setState(79);
				match(T__3);
				setState(80);
				statement();
				}
				break;
			case 5:
				_localctx = new StatPrintContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(82);
				match(T__13);
				setState(83);
				match(T__2);
				setState(84);
				exp(0);
				setState(85);
				match(T__3);
				setState(86);
				match(T__12);
				}
				break;
			case 6:
				_localctx = new StatAffContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(88);
				match(Id);
				setState(89);
				match(T__14);
				setState(90);
				exp(0);
				setState(91);
				match(T__12);
				}
				break;
			case 7:
				_localctx = new StatIncrContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(93);
				match(Id);
				setState(94);
				match(T__15);
				setState(95);
				match(T__12);
				}
				break;
			case 8:
				_localctx = new StatReturnContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(96);
				match(T__16);
				setState(97);
				exp(0);
				setState(98);
				match(T__12);
				}
				break;
			case 9:
				_localctx = new StatVarDeclContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(100);
				type();
				setState(101);
				match(Id);
				setState(102);
				match(T__12);
				}
				break;
			case 10:
				_localctx = new StatVarDeclAffContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(104);
				type();
				setState(105);
				match(Id);
				setState(106);
				match(T__14);
				setState(107);
				exp(0);
				setState(108);
				match(T__12);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpContext extends ParserRuleContext {
		public ExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp; }
	 
		public ExpContext() { }
		public void copyFrom(ExpContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExUnopContext extends ExpContext {
		public TerminalNode Unop() { return getToken(sdmParser.Unop, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public ExUnopContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sdmListener ) ((sdmListener)listener).enterExUnop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sdmListener ) ((sdmListener)listener).exitExUnop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sdmVisitor ) return ((sdmVisitor<? extends T>)visitor).visitExUnop(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExIdContext extends ExpContext {
		public TerminalNode Id() { return getToken(sdmParser.Id, 0); }
		public ExIdContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sdmListener ) ((sdmListener)listener).enterExId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sdmListener ) ((sdmListener)listener).exitExId(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sdmVisitor ) return ((sdmVisitor<? extends T>)visitor).visitExId(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExReadContext extends ExpContext {
		public ExReadContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sdmListener ) ((sdmListener)listener).enterExRead(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sdmListener ) ((sdmListener)listener).exitExRead(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sdmVisitor ) return ((sdmVisitor<? extends T>)visitor).visitExRead(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExFalseContext extends ExpContext {
		public ExFalseContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sdmListener ) ((sdmListener)listener).enterExFalse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sdmListener ) ((sdmListener)listener).exitExFalse(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sdmVisitor ) return ((sdmVisitor<? extends T>)visitor).visitExFalse(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExCallContext extends ExpContext {
		public TerminalNode Id() { return getToken(sdmParser.Id, 0); }
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public ExCallContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sdmListener ) ((sdmListener)listener).enterExCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sdmListener ) ((sdmListener)listener).exitExCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sdmVisitor ) return ((sdmVisitor<? extends T>)visitor).visitExCall(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExParenthesisContext extends ExpContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public ExParenthesisContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sdmListener ) ((sdmListener)listener).enterExParenthesis(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sdmListener ) ((sdmListener)listener).exitExParenthesis(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sdmVisitor ) return ((sdmVisitor<? extends T>)visitor).visitExParenthesis(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExIntContext extends ExpContext {
		public TerminalNode Int() { return getToken(sdmParser.Int, 0); }
		public ExIntContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sdmListener ) ((sdmListener)listener).enterExInt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sdmListener ) ((sdmListener)listener).exitExInt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sdmVisitor ) return ((sdmVisitor<? extends T>)visitor).visitExInt(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExBinopContext extends ExpContext {
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode Binop() { return getToken(sdmParser.Binop, 0); }
		public ExBinopContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sdmListener ) ((sdmListener)listener).enterExBinop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sdmListener ) ((sdmListener)listener).exitExBinop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sdmVisitor ) return ((sdmVisitor<? extends T>)visitor).visitExBinop(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExTrueContext extends ExpContext {
		public ExTrueContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sdmListener ) ((sdmListener)listener).enterExTrue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sdmListener ) ((sdmListener)listener).exitExTrue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof sdmVisitor ) return ((sdmVisitor<? extends T>)visitor).visitExTrue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpContext exp() throws RecognitionException {
		return exp(0);
	}

	private ExpContext exp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpContext _localctx = new ExpContext(_ctx, _parentState);
		ExpContext _prevctx = _localctx;
		int _startState = 12;
		enterRecursionRule(_localctx, 12, RULE_exp, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(139);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				_localctx = new ExUnopContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(113);
				match(Unop);
				setState(114);
				exp(8);
				}
				break;
			case 2:
				{
				_localctx = new ExIntContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(115);
				match(Int);
				}
				break;
			case 3:
				{
				_localctx = new ExTrueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(116);
				match(T__17);
				}
				break;
			case 4:
				{
				_localctx = new ExFalseContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(117);
				match(T__18);
				}
				break;
			case 5:
				{
				_localctx = new ExIdContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(118);
				match(Id);
				}
				break;
			case 6:
				{
				_localctx = new ExParenthesisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(119);
				match(T__2);
				setState(120);
				exp(0);
				setState(121);
				match(T__3);
				}
				break;
			case 7:
				{
				_localctx = new ExCallContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(123);
				match(Id);
				setState(124);
				match(T__2);
				setState(133);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 24903688L) != 0)) {
					{
					setState(125);
					exp(0);
					setState(130);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__4) {
						{
						{
						setState(126);
						match(T__4);
						setState(127);
						exp(0);
						}
						}
						setState(132);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(135);
				match(T__3);
				}
				break;
			case 8:
				{
				_localctx = new ExReadContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(136);
				match(T__19);
				setState(137);
				match(T__2);
				setState(138);
				match(T__3);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(146);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExBinopContext(new ExpContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_exp);
					setState(141);
					if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
					setState(142);
					match(Binop);
					setState(143);
					exp(10);
					}
					} 
				}
				setState(148);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 6:
			return exp_sempred((ExpContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean exp_sempred(ExpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 9);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u001c\u0096\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0001\u0000\u0005\u0000"+
		"\u0010\b\u0000\n\u0000\f\u0000\u0013\t\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005"+
		"\u0002#\b\u0002\n\u0002\f\u0002&\t\u0002\u0003\u0002(\b\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004"+
		"\u0001\u0004\u0003\u00042\b\u0004\u0001\u0005\u0001\u0005\u0005\u0005"+
		"6\b\u0005\n\u0005\f\u00059\t\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0003\u0005o\b\u0005\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0005\u0006\u0081\b\u0006\n\u0006\f\u0006\u0084\t\u0006\u0003"+
		"\u0006\u0086\b\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003"+
		"\u0006\u008c\b\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0005\u0006\u0091"+
		"\b\u0006\n\u0006\f\u0006\u0094\t\u0006\u0001\u0006\u0000\u0001\f\u0007"+
		"\u0000\u0002\u0004\u0006\b\n\f\u0000\u0000\u00a6\u0000\u0011\u0001\u0000"+
		"\u0000\u0000\u0002\u0016\u0001\u0000\u0000\u0000\u0004\u001c\u0001\u0000"+
		"\u0000\u0000\u0006,\u0001\u0000\u0000\u0000\b1\u0001\u0000\u0000\u0000"+
		"\nn\u0001\u0000\u0000\u0000\f\u008b\u0001\u0000\u0000\u0000\u000e\u0010"+
		"\u0003\u0004\u0002\u0000\u000f\u000e\u0001\u0000\u0000\u0000\u0010\u0013"+
		"\u0001\u0000\u0000\u0000\u0011\u000f\u0001\u0000\u0000\u0000\u0011\u0012"+
		"\u0001\u0000\u0000\u0000\u0012\u0014\u0001\u0000\u0000\u0000\u0013\u0011"+
		"\u0001\u0000\u0000\u0000\u0014\u0015\u0003\u0002\u0001\u0000\u0015\u0001"+
		"\u0001\u0000\u0000\u0000\u0016\u0017\u0005\u0001\u0000\u0000\u0017\u0018"+
		"\u0005\u0002\u0000\u0000\u0018\u0019\u0005\u0003\u0000\u0000\u0019\u001a"+
		"\u0005\u0004\u0000\u0000\u001a\u001b\u0003\n\u0005\u0000\u001b\u0003\u0001"+
		"\u0000\u0000\u0000\u001c\u001d\u0003\b\u0004\u0000\u001d\u001e\u0005\u0015"+
		"\u0000\u0000\u001e\'\u0005\u0003\u0000\u0000\u001f$\u0003\u0006\u0003"+
		"\u0000 !\u0005\u0005\u0000\u0000!#\u0003\u0006\u0003\u0000\" \u0001\u0000"+
		"\u0000\u0000#&\u0001\u0000\u0000\u0000$\"\u0001\u0000\u0000\u0000$%\u0001"+
		"\u0000\u0000\u0000%(\u0001\u0000\u0000\u0000&$\u0001\u0000\u0000\u0000"+
		"\'\u001f\u0001\u0000\u0000\u0000\'(\u0001\u0000\u0000\u0000()\u0001\u0000"+
		"\u0000\u0000)*\u0005\u0004\u0000\u0000*+\u0003\n\u0005\u0000+\u0005\u0001"+
		"\u0000\u0000\u0000,-\u0003\b\u0004\u0000-.\u0005\u0015\u0000\u0000.\u0007"+
		"\u0001\u0000\u0000\u0000/2\u0005\u0001\u0000\u000002\u0005\u0006\u0000"+
		"\u00001/\u0001\u0000\u0000\u000010\u0001\u0000\u0000\u00002\t\u0001\u0000"+
		"\u0000\u000037\u0005\u0007\u0000\u000046\u0003\n\u0005\u000054\u0001\u0000"+
		"\u0000\u000069\u0001\u0000\u0000\u000075\u0001\u0000\u0000\u000078\u0001"+
		"\u0000\u0000\u00008:\u0001\u0000\u0000\u000097\u0001\u0000\u0000\u0000"+
		":o\u0005\b\u0000\u0000;<\u0005\t\u0000\u0000<=\u0005\u0003\u0000\u0000"+
		"=>\u0003\f\u0006\u0000>?\u0005\u0004\u0000\u0000?@\u0003\n\u0005\u0000"+
		"@A\u0005\n\u0000\u0000AB\u0003\n\u0005\u0000Bo\u0001\u0000\u0000\u0000"+
		"CD\u0005\u000b\u0000\u0000DE\u0005\u0003\u0000\u0000EF\u0003\f\u0006\u0000"+
		"FG\u0005\u0004\u0000\u0000GH\u0003\n\u0005\u0000Ho\u0001\u0000\u0000\u0000"+
		"IJ\u0005\f\u0000\u0000JK\u0005\u0003\u0000\u0000KL\u0003\n\u0005\u0000"+
		"LM\u0003\f\u0006\u0000MN\u0005\r\u0000\u0000NO\u0003\n\u0005\u0000OP\u0005"+
		"\u0004\u0000\u0000PQ\u0003\n\u0005\u0000Qo\u0001\u0000\u0000\u0000RS\u0005"+
		"\u000e\u0000\u0000ST\u0005\u0003\u0000\u0000TU\u0003\f\u0006\u0000UV\u0005"+
		"\u0004\u0000\u0000VW\u0005\r\u0000\u0000Wo\u0001\u0000\u0000\u0000XY\u0005"+
		"\u0015\u0000\u0000YZ\u0005\u000f\u0000\u0000Z[\u0003\f\u0006\u0000[\\"+
		"\u0005\r\u0000\u0000\\o\u0001\u0000\u0000\u0000]^\u0005\u0015\u0000\u0000"+
		"^_\u0005\u0010\u0000\u0000_o\u0005\r\u0000\u0000`a\u0005\u0011\u0000\u0000"+
		"ab\u0003\f\u0006\u0000bc\u0005\r\u0000\u0000co\u0001\u0000\u0000\u0000"+
		"de\u0003\b\u0004\u0000ef\u0005\u0015\u0000\u0000fg\u0005\r\u0000\u0000"+
		"go\u0001\u0000\u0000\u0000hi\u0003\b\u0004\u0000ij\u0005\u0015\u0000\u0000"+
		"jk\u0005\u000f\u0000\u0000kl\u0003\f\u0006\u0000lm\u0005\r\u0000\u0000"+
		"mo\u0001\u0000\u0000\u0000n3\u0001\u0000\u0000\u0000n;\u0001\u0000\u0000"+
		"\u0000nC\u0001\u0000\u0000\u0000nI\u0001\u0000\u0000\u0000nR\u0001\u0000"+
		"\u0000\u0000nX\u0001\u0000\u0000\u0000n]\u0001\u0000\u0000\u0000n`\u0001"+
		"\u0000\u0000\u0000nd\u0001\u0000\u0000\u0000nh\u0001\u0000\u0000\u0000"+
		"o\u000b\u0001\u0000\u0000\u0000pq\u0006\u0006\uffff\uffff\u0000qr\u0005"+
		"\u0018\u0000\u0000r\u008c\u0003\f\u0006\bs\u008c\u0005\u0016\u0000\u0000"+
		"t\u008c\u0005\u0012\u0000\u0000u\u008c\u0005\u0013\u0000\u0000v\u008c"+
		"\u0005\u0015\u0000\u0000wx\u0005\u0003\u0000\u0000xy\u0003\f\u0006\u0000"+
		"yz\u0005\u0004\u0000\u0000z\u008c\u0001\u0000\u0000\u0000{|\u0005\u0015"+
		"\u0000\u0000|\u0085\u0005\u0003\u0000\u0000}\u0082\u0003\f\u0006\u0000"+
		"~\u007f\u0005\u0005\u0000\u0000\u007f\u0081\u0003\f\u0006\u0000\u0080"+
		"~\u0001\u0000\u0000\u0000\u0081\u0084\u0001\u0000\u0000\u0000\u0082\u0080"+
		"\u0001\u0000\u0000\u0000\u0082\u0083\u0001\u0000\u0000\u0000\u0083\u0086"+
		"\u0001\u0000\u0000\u0000\u0084\u0082\u0001\u0000\u0000\u0000\u0085}\u0001"+
		"\u0000\u0000\u0000\u0085\u0086\u0001\u0000\u0000\u0000\u0086\u0087\u0001"+
		"\u0000\u0000\u0000\u0087\u008c\u0005\u0004\u0000\u0000\u0088\u0089\u0005"+
		"\u0014\u0000\u0000\u0089\u008a\u0005\u0003\u0000\u0000\u008a\u008c\u0005"+
		"\u0004\u0000\u0000\u008bp\u0001\u0000\u0000\u0000\u008bs\u0001\u0000\u0000"+
		"\u0000\u008bt\u0001\u0000\u0000\u0000\u008bu\u0001\u0000\u0000\u0000\u008b"+
		"v\u0001\u0000\u0000\u0000\u008bw\u0001\u0000\u0000\u0000\u008b{\u0001"+
		"\u0000\u0000\u0000\u008b\u0088\u0001\u0000\u0000\u0000\u008c\u0092\u0001"+
		"\u0000\u0000\u0000\u008d\u008e\n\t\u0000\u0000\u008e\u008f\u0005\u0019"+
		"\u0000\u0000\u008f\u0091\u0003\f\u0006\n\u0090\u008d\u0001\u0000\u0000"+
		"\u0000\u0091\u0094\u0001\u0000\u0000\u0000\u0092\u0090\u0001\u0000\u0000"+
		"\u0000\u0092\u0093\u0001\u0000\u0000\u0000\u0093\r\u0001\u0000\u0000\u0000"+
		"\u0094\u0092\u0001\u0000\u0000\u0000\n\u0011$\'17n\u0082\u0085\u008b\u0092";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}