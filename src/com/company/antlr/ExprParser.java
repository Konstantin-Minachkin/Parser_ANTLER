// Generated from Expr.g by ANTLR 4.7.2
package com.company.antlr;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ExprParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, ARABIAN=5, ROME=6, ID=7, WS=8, SMALLERTHAN=9, 
		BIGGERTHAN=10, EQUAL=11, INCREM=12, DECREM=13;
	public static final int
		RULE_all_program = 0, RULE_program = 1, RULE_operator = 2, RULE_dowhile = 3, 
		RULE_condition = 4, RULE_value = 5, RULE_number = 6, RULE_incDec = 7, 
		RULE_print = 8;
	private static String[] makeRuleNames() {
		return new String[] {
			"all_program", "program", "operator", "dowhile", "condition", "value", 
			"number", "incDec", "print"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "'do'", "'while'", "'print'", null, null, null, null, "'<'", 
			"'>'", "'='", "'++'", "'--'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, "ARABIAN", "ROME", "ID", "WS", "SMALLERTHAN", 
			"BIGGERTHAN", "EQUAL", "INCREM", "DECREM"
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
	public String getGrammarFileName() { return "Expr.g"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ExprParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class All_programContext extends ParserRuleContext {
		public ProgramContext program() {
			return getRuleContext(ProgramContext.class,0);
		}
		public TerminalNode EOF() { return getToken(ExprParser.EOF, 0); }
		public All_programContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_all_program; }
	}

	public final All_programContext all_program() throws RecognitionException {
		All_programContext _localctx = new All_programContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_all_program);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(18);
			program();
			setState(19);
			match(EOF);
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

	public static class ProgramContext extends ParserRuleContext {
		public List<OperatorContext> operator() {
			return getRuleContexts(OperatorContext.class);
		}
		public OperatorContext operator(int i) {
			return getRuleContext(OperatorContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(26);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__3) | (1L << ID))) != 0)) {
				{
				{
				setState(21);
				operator();
				setState(22);
				match(T__0);
				}
				}
				setState(28);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
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

	public static class OperatorContext extends ParserRuleContext {
		public DowhileContext dowhile() {
			return getRuleContext(DowhileContext.class,0);
		}
		public IncDecContext incDec() {
			return getRuleContext(IncDecContext.class,0);
		}
		public PrintContext print() {
			return getRuleContext(PrintContext.class,0);
		}
		public OperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operator; }
	}

	public final OperatorContext operator() throws RecognitionException {
		OperatorContext _localctx = new OperatorContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_operator);
		try {
			setState(32);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				enterOuterAlt(_localctx, 1);
				{
				setState(29);
				dowhile();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(30);
				incDec();
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 3);
				{
				setState(31);
				print();
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

	public static class DowhileContext extends ParserRuleContext {
		public ProgramContext prog;
		public ConditionContext cond;
		public ProgramContext program() {
			return getRuleContext(ProgramContext.class,0);
		}
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public DowhileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dowhile; }
	}

	public final DowhileContext dowhile() throws RecognitionException {
		DowhileContext _localctx = new DowhileContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_dowhile);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(34);
			match(T__1);
			setState(35);
			((DowhileContext)_localctx).prog = program();
			setState(36);
			match(T__2);
			setState(37);
			((DowhileContext)_localctx).cond = condition();
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

	public static class ConditionContext extends ParserRuleContext {
		public ValueContext left;
		public Token cmp;
		public ValueContext right;
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public TerminalNode SMALLERTHAN() { return getToken(ExprParser.SMALLERTHAN, 0); }
		public TerminalNode BIGGERTHAN() { return getToken(ExprParser.BIGGERTHAN, 0); }
		public TerminalNode EQUAL() { return getToken(ExprParser.EQUAL, 0); }
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_condition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39);
			((ConditionContext)_localctx).left = value();
			setState(40);
			((ConditionContext)_localctx).cmp = _input.LT(1);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SMALLERTHAN) | (1L << BIGGERTHAN) | (1L << EQUAL))) != 0)) ) {
				((ConditionContext)_localctx).cmp = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(41);
			((ConditionContext)_localctx).right = value();
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

	public static class ValueContext extends ParserRuleContext {
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public TerminalNode ID() { return getToken(ExprParser.ID, 0); }
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_value);
		try {
			setState(45);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ARABIAN:
			case ROME:
				enterOuterAlt(_localctx, 1);
				{
				setState(43);
				number();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(44);
				match(ID);
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

	public static class NumberContext extends ParserRuleContext {
		public TerminalNode ARABIAN() { return getToken(ExprParser.ARABIAN, 0); }
		public TerminalNode ROME() { return getToken(ExprParser.ROME, 0); }
		public NumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number; }
	}

	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_number);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(47);
			_la = _input.LA(1);
			if ( !(_la==ARABIAN || _la==ROME) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
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

	public static class IncDecContext extends ParserRuleContext {
		public Token op;
		public TerminalNode ID() { return getToken(ExprParser.ID, 0); }
		public TerminalNode INCREM() { return getToken(ExprParser.INCREM, 0); }
		public TerminalNode DECREM() { return getToken(ExprParser.DECREM, 0); }
		public IncDecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_incDec; }
	}

	public final IncDecContext incDec() throws RecognitionException {
		IncDecContext _localctx = new IncDecContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_incDec);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(49);
			match(ID);
			setState(50);
			((IncDecContext)_localctx).op = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==INCREM || _la==DECREM) ) {
				((IncDecContext)_localctx).op = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
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

	public static class PrintContext extends ParserRuleContext {
		public ValueContext text;
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public PrintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_print; }
	}

	public final PrintContext print() throws RecognitionException {
		PrintContext _localctx = new PrintContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_print);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(52);
			match(T__3);
			setState(53);
			((PrintContext)_localctx).text = value();
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\17:\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2\3\2\3\2"+
		"\3\3\3\3\3\3\7\3\33\n\3\f\3\16\3\36\13\3\3\4\3\4\3\4\5\4#\n\4\3\5\3\5"+
		"\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7\5\7\60\n\7\3\b\3\b\3\t\3\t\3\t\3"+
		"\n\3\n\3\n\3\n\2\2\13\2\4\6\b\n\f\16\20\22\2\5\3\2\13\r\3\2\7\b\3\2\16"+
		"\17\2\64\2\24\3\2\2\2\4\34\3\2\2\2\6\"\3\2\2\2\b$\3\2\2\2\n)\3\2\2\2\f"+
		"/\3\2\2\2\16\61\3\2\2\2\20\63\3\2\2\2\22\66\3\2\2\2\24\25\5\4\3\2\25\26"+
		"\7\2\2\3\26\3\3\2\2\2\27\30\5\6\4\2\30\31\7\3\2\2\31\33\3\2\2\2\32\27"+
		"\3\2\2\2\33\36\3\2\2\2\34\32\3\2\2\2\34\35\3\2\2\2\35\5\3\2\2\2\36\34"+
		"\3\2\2\2\37#\5\b\5\2 #\5\20\t\2!#\5\22\n\2\"\37\3\2\2\2\" \3\2\2\2\"!"+
		"\3\2\2\2#\7\3\2\2\2$%\7\4\2\2%&\5\4\3\2&\'\7\5\2\2\'(\5\n\6\2(\t\3\2\2"+
		"\2)*\5\f\7\2*+\t\2\2\2+,\5\f\7\2,\13\3\2\2\2-\60\5\16\b\2.\60\7\t\2\2"+
		"/-\3\2\2\2/.\3\2\2\2\60\r\3\2\2\2\61\62\t\3\2\2\62\17\3\2\2\2\63\64\7"+
		"\t\2\2\64\65\t\4\2\2\65\21\3\2\2\2\66\67\7\6\2\2\678\5\f\7\28\23\3\2\2"+
		"\2\5\34\"/";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}