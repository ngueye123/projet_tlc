// $ANTLR 3.5.2 While.g 2026-11-23 17:43:09

    package fr.tlc.whilecompiler;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class WhileLexer extends Lexer {
	public static final int EOF=-1;
	public static final int T__33=33;
	public static final int T__34=34;
	public static final int T__35=35;
	public static final int T__36=36;
	public static final int T__37=37;
	public static final int T__38=38;
	public static final int T__39=39;
	public static final int T__40=40;
	public static final int T__41=41;
	public static final int T__42=42;
	public static final int T__43=43;
	public static final int T__44=44;
	public static final int T__45=45;
	public static final int T__46=46;
	public static final int T__47=47;
	public static final int T__48=48;
	public static final int T__49=49;
	public static final int T__50=50;
	public static final int T__51=51;
	public static final int T__52=52;
	public static final int T__53=53;
	public static final int T__54=54;
	public static final int T__55=55;
	public static final int T__56=56;
	public static final int T__57=57;
	public static final int T__58=58;
	public static final int T__59=59;
	public static final int ASSIGN=4;
	public static final int ATOM=5;
	public static final int CALL=6;
	public static final int COMMANDS=7;
	public static final int COMMENT=8;
	public static final int CONS=9;
	public static final int Dec=10;
	public static final int EQ=11;
	public static final int EXPRS=12;
	public static final int FOR=13;
	public static final int FOREACH=14;
	public static final int FUNCTION=15;
	public static final int HD=16;
	public static final int IF=17;
	public static final int INPUTS=18;
	public static final int LIST=19;
	public static final int Maj=20;
	public static final int Min=21;
	public static final int NIL=22;
	public static final int NOP=23;
	public static final int OUTPUTS=24;
	public static final int PROGRAM=25;
	public static final int Symbol=26;
	public static final int TL=27;
	public static final int VAR=28;
	public static final int VARS=29;
	public static final int Variable=30;
	public static final int WHILE=31;
	public static final int WS=32;

	// delegates
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public WhileLexer() {} 
	public WhileLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public WhileLexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "While.g"; }

	// $ANTLR start "T__33"
	public final void mT__33() throws RecognitionException {
		try {
			int _type = T__33;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// While.g:6:7: ( '%' )
			// While.g:6:9: '%'
			{
			match('%'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__33"

	// $ANTLR start "T__34"
	public final void mT__34() throws RecognitionException {
		try {
			int _type = T__34;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// While.g:7:7: ( '(' )
			// While.g:7:9: '('
			{
			match('('); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__34"

	// $ANTLR start "T__35"
	public final void mT__35() throws RecognitionException {
		try {
			int _type = T__35;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// While.g:8:7: ( ')' )
			// While.g:8:9: ')'
			{
			match(')'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__35"

	// $ANTLR start "T__36"
	public final void mT__36() throws RecognitionException {
		try {
			int _type = T__36;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// While.g:9:7: ( ',' )
			// While.g:9:9: ','
			{
			match(','); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__36"

	// $ANTLR start "T__37"
	public final void mT__37() throws RecognitionException {
		try {
			int _type = T__37;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// While.g:10:7: ( ':' )
			// While.g:10:9: ':'
			{
			match(':'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__37"

	// $ANTLR start "T__38"
	public final void mT__38() throws RecognitionException {
		try {
			int _type = T__38;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// While.g:11:7: ( ':=' )
			// While.g:11:9: ':='
			{
			match(":="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__38"

	// $ANTLR start "T__39"
	public final void mT__39() throws RecognitionException {
		try {
			int _type = T__39;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// While.g:12:7: ( ';' )
			// While.g:12:9: ';'
			{
			match(';'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__39"

	// $ANTLR start "T__40"
	public final void mT__40() throws RecognitionException {
		try {
			int _type = T__40;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// While.g:13:7: ( '=?' )
			// While.g:13:9: '=?'
			{
			match("=?"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__40"

	// $ANTLR start "T__41"
	public final void mT__41() throws RecognitionException {
		try {
			int _type = T__41;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// While.g:14:7: ( 'cons' )
			// While.g:14:9: 'cons'
			{
			match("cons"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__41"

	// $ANTLR start "T__42"
	public final void mT__42() throws RecognitionException {
		try {
			int _type = T__42;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// While.g:15:7: ( 'do' )
			// While.g:15:9: 'do'
			{
			match("do"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__42"

	// $ANTLR start "T__43"
	public final void mT__43() throws RecognitionException {
		try {
			int _type = T__43;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// While.g:16:7: ( 'else' )
			// While.g:16:9: 'else'
			{
			match("else"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__43"

	// $ANTLR start "T__44"
	public final void mT__44() throws RecognitionException {
		try {
			int _type = T__44;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// While.g:17:7: ( 'fi' )
			// While.g:17:9: 'fi'
			{
			match("fi"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__44"

	// $ANTLR start "T__45"
	public final void mT__45() throws RecognitionException {
		try {
			int _type = T__45;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// While.g:18:7: ( 'for' )
			// While.g:18:9: 'for'
			{
			match("for"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__45"

	// $ANTLR start "T__46"
	public final void mT__46() throws RecognitionException {
		try {
			int _type = T__46;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// While.g:19:7: ( 'foreach' )
			// While.g:19:9: 'foreach'
			{
			match("foreach"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__46"

	// $ANTLR start "T__47"
	public final void mT__47() throws RecognitionException {
		try {
			int _type = T__47;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// While.g:20:7: ( 'function' )
			// While.g:20:9: 'function'
			{
			match("function"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__47"

	// $ANTLR start "T__48"
	public final void mT__48() throws RecognitionException {
		try {
			int _type = T__48;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// While.g:21:7: ( 'hd' )
			// While.g:21:9: 'hd'
			{
			match("hd"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__48"

	// $ANTLR start "T__49"
	public final void mT__49() throws RecognitionException {
		try {
			int _type = T__49;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// While.g:22:7: ( 'if' )
			// While.g:22:9: 'if'
			{
			match("if"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__49"

	// $ANTLR start "T__50"
	public final void mT__50() throws RecognitionException {
		try {
			int _type = T__50;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// While.g:23:7: ( 'in' )
			// While.g:23:9: 'in'
			{
			match("in"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__50"

	// $ANTLR start "T__51"
	public final void mT__51() throws RecognitionException {
		try {
			int _type = T__51;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// While.g:24:7: ( 'list' )
			// While.g:24:9: 'list'
			{
			match("list"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__51"

	// $ANTLR start "T__52"
	public final void mT__52() throws RecognitionException {
		try {
			int _type = T__52;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// While.g:25:7: ( 'nil' )
			// While.g:25:9: 'nil'
			{
			match("nil"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__52"

	// $ANTLR start "T__53"
	public final void mT__53() throws RecognitionException {
		try {
			int _type = T__53;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// While.g:26:7: ( 'nop' )
			// While.g:26:9: 'nop'
			{
			match("nop"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__53"

	// $ANTLR start "T__54"
	public final void mT__54() throws RecognitionException {
		try {
			int _type = T__54;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// While.g:27:7: ( 'od' )
			// While.g:27:9: 'od'
			{
			match("od"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__54"

	// $ANTLR start "T__55"
	public final void mT__55() throws RecognitionException {
		try {
			int _type = T__55;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// While.g:28:7: ( 'read' )
			// While.g:28:9: 'read'
			{
			match("read"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__55"

	// $ANTLR start "T__56"
	public final void mT__56() throws RecognitionException {
		try {
			int _type = T__56;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// While.g:29:7: ( 'then' )
			// While.g:29:9: 'then'
			{
			match("then"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__56"

	// $ANTLR start "T__57"
	public final void mT__57() throws RecognitionException {
		try {
			int _type = T__57;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// While.g:30:7: ( 'tl' )
			// While.g:30:9: 'tl'
			{
			match("tl"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__57"

	// $ANTLR start "T__58"
	public final void mT__58() throws RecognitionException {
		try {
			int _type = T__58;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// While.g:31:7: ( 'while' )
			// While.g:31:9: 'while'
			{
			match("while"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__58"

	// $ANTLR start "T__59"
	public final void mT__59() throws RecognitionException {
		try {
			int _type = T__59;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// While.g:32:7: ( 'write' )
			// While.g:32:9: 'write'
			{
			match("write"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__59"

	// $ANTLR start "COMMENT"
	public final void mCOMMENT() throws RecognitionException {
		try {
			int _type = COMMENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// While.g:46:5: ( '//' (~ ( '\\r' | '\\n' ) )* ( ( '\\r' )? '\\n' | EOF ) | '/*' ( options {greedy=false; } : . )* '*/' )
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( (LA5_0=='/') ) {
				int LA5_1 = input.LA(2);
				if ( (LA5_1=='/') ) {
					alt5=1;
				}
				else if ( (LA5_1=='*') ) {
					alt5=2;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 5, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 5, 0, input);
				throw nvae;
			}

			switch (alt5) {
				case 1 :
					// While.g:46:7: '//' (~ ( '\\r' | '\\n' ) )* ( ( '\\r' )? '\\n' | EOF )
					{
					match("//"); 

					// While.g:46:12: (~ ( '\\r' | '\\n' ) )*
					loop1:
					while (true) {
						int alt1=2;
						int LA1_0 = input.LA(1);
						if ( ((LA1_0 >= '\u0000' && LA1_0 <= '\t')||(LA1_0 >= '\u000B' && LA1_0 <= '\f')||(LA1_0 >= '\u000E' && LA1_0 <= '\uFFFF')) ) {
							alt1=1;
						}

						switch (alt1) {
						case 1 :
							// While.g:
							{
							if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '\uFFFF') ) {
								input.consume();
							}
							else {
								MismatchedSetException mse = new MismatchedSetException(null,input);
								recover(mse);
								throw mse;
							}
							}
							break;

						default :
							break loop1;
						}
					}

					// While.g:46:28: ( ( '\\r' )? '\\n' | EOF )
					int alt3=2;
					int LA3_0 = input.LA(1);
					if ( (LA3_0=='\n'||LA3_0=='\r') ) {
						alt3=1;
					}

					else {
						alt3=2;
					}

					switch (alt3) {
						case 1 :
							// While.g:46:29: ( '\\r' )? '\\n'
							{
							// While.g:46:29: ( '\\r' )?
							int alt2=2;
							int LA2_0 = input.LA(1);
							if ( (LA2_0=='\r') ) {
								alt2=1;
							}
							switch (alt2) {
								case 1 :
									// While.g:46:29: '\\r'
									{
									match('\r'); 
									}
									break;

							}

							match('\n'); 
							}
							break;
						case 2 :
							// While.g:46:42: EOF
							{
							match(EOF); 

							}
							break;

					}

					_channel=HIDDEN;
					}
					break;
				case 2 :
					// While.g:47:7: '/*' ( options {greedy=false; } : . )* '*/'
					{
					match("/*"); 

					// While.g:47:12: ( options {greedy=false; } : . )*
					loop4:
					while (true) {
						int alt4=2;
						int LA4_0 = input.LA(1);
						if ( (LA4_0=='*') ) {
							int LA4_1 = input.LA(2);
							if ( (LA4_1=='/') ) {
								alt4=2;
							}
							else if ( ((LA4_1 >= '\u0000' && LA4_1 <= '.')||(LA4_1 >= '0' && LA4_1 <= '\uFFFF')) ) {
								alt4=1;
							}

						}
						else if ( ((LA4_0 >= '\u0000' && LA4_0 <= ')')||(LA4_0 >= '+' && LA4_0 <= '\uFFFF')) ) {
							alt4=1;
						}

						switch (alt4) {
						case 1 :
							// While.g:47:39: .
							{
							matchAny(); 
							}
							break;

						default :
							break loop4;
						}
					}

					match("*/"); 

					_channel=HIDDEN;
					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COMMENT"

	// $ANTLR start "WS"
	public final void mWS() throws RecognitionException {
		try {
			int _type = WS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// While.g:51:5: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
			// While.g:51:7: ( ' ' | '\\t' | '\\r' | '\\n' )+
			{
			// While.g:51:7: ( ' ' | '\\t' | '\\r' | '\\n' )+
			int cnt6=0;
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( ((LA6_0 >= '\t' && LA6_0 <= '\n')||LA6_0=='\r'||LA6_0==' ') ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// While.g:
					{
					if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt6 >= 1 ) break loop6;
					EarlyExitException eee = new EarlyExitException(6, input);
					throw eee;
				}
				cnt6++;
			}

			_channel=HIDDEN;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WS"

	// $ANTLR start "Variable"
	public final void mVariable() throws RecognitionException {
		try {
			int _type = Variable;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// While.g:159:5: ( Maj ( Maj | Min | Dec )* ( '!' | '?' )? )
			// While.g:159:7: Maj ( Maj | Min | Dec )* ( '!' | '?' )?
			{
			mMaj(); 

			// While.g:159:11: ( Maj | Min | Dec )*
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( ((LA7_0 >= '0' && LA7_0 <= '9')||(LA7_0 >= 'A' && LA7_0 <= 'Z')||(LA7_0 >= 'a' && LA7_0 <= 'z')) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// While.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop7;
				}
			}

			// While.g:159:30: ( '!' | '?' )?
			int alt8=2;
			int LA8_0 = input.LA(1);
			if ( (LA8_0=='!'||LA8_0=='?') ) {
				alt8=1;
			}
			switch (alt8) {
				case 1 :
					// While.g:
					{
					if ( input.LA(1)=='!'||input.LA(1)=='?' ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Variable"

	// $ANTLR start "Symbol"
	public final void mSymbol() throws RecognitionException {
		try {
			int _type = Symbol;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// While.g:163:5: ( Min ( Maj | Min | Dec )* ( '!' | '?' )? )
			// While.g:163:7: Min ( Maj | Min | Dec )* ( '!' | '?' )?
			{
			mMin(); 

			// While.g:163:11: ( Maj | Min | Dec )*
			loop9:
			while (true) {
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( ((LA9_0 >= '0' && LA9_0 <= '9')||(LA9_0 >= 'A' && LA9_0 <= 'Z')||(LA9_0 >= 'a' && LA9_0 <= 'z')) ) {
					alt9=1;
				}

				switch (alt9) {
				case 1 :
					// While.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop9;
				}
			}

			// While.g:163:30: ( '!' | '?' )?
			int alt10=2;
			int LA10_0 = input.LA(1);
			if ( (LA10_0=='!'||LA10_0=='?') ) {
				alt10=1;
			}
			switch (alt10) {
				case 1 :
					// While.g:
					{
					if ( input.LA(1)=='!'||input.LA(1)=='?' ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Symbol"

	// $ANTLR start "Maj"
	public final void mMaj() throws RecognitionException {
		try {
			// While.g:166:14: ( 'A' .. 'Z' )
			// While.g:
			{
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Maj"

	// $ANTLR start "Min"
	public final void mMin() throws RecognitionException {
		try {
			// While.g:167:14: ( 'a' .. 'z' )
			// While.g:
			{
			if ( (input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Min"

	// $ANTLR start "Dec"
	public final void mDec() throws RecognitionException {
		try {
			// While.g:168:14: ( '0' .. '9' )
			// While.g:
			{
			if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Dec"

	@Override
	public void mTokens() throws RecognitionException {
		// While.g:1:8: ( T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | COMMENT | WS | Variable | Symbol )
		int alt11=31;
		alt11 = dfa11.predict(input);
		switch (alt11) {
			case 1 :
				// While.g:1:10: T__33
				{
				mT__33(); 

				}
				break;
			case 2 :
				// While.g:1:16: T__34
				{
				mT__34(); 

				}
				break;
			case 3 :
				// While.g:1:22: T__35
				{
				mT__35(); 

				}
				break;
			case 4 :
				// While.g:1:28: T__36
				{
				mT__36(); 

				}
				break;
			case 5 :
				// While.g:1:34: T__37
				{
				mT__37(); 

				}
				break;
			case 6 :
				// While.g:1:40: T__38
				{
				mT__38(); 

				}
				break;
			case 7 :
				// While.g:1:46: T__39
				{
				mT__39(); 

				}
				break;
			case 8 :
				// While.g:1:52: T__40
				{
				mT__40(); 

				}
				break;
			case 9 :
				// While.g:1:58: T__41
				{
				mT__41(); 

				}
				break;
			case 10 :
				// While.g:1:64: T__42
				{
				mT__42(); 

				}
				break;
			case 11 :
				// While.g:1:70: T__43
				{
				mT__43(); 

				}
				break;
			case 12 :
				// While.g:1:76: T__44
				{
				mT__44(); 

				}
				break;
			case 13 :
				// While.g:1:82: T__45
				{
				mT__45(); 

				}
				break;
			case 14 :
				// While.g:1:88: T__46
				{
				mT__46(); 

				}
				break;
			case 15 :
				// While.g:1:94: T__47
				{
				mT__47(); 

				}
				break;
			case 16 :
				// While.g:1:100: T__48
				{
				mT__48(); 

				}
				break;
			case 17 :
				// While.g:1:106: T__49
				{
				mT__49(); 

				}
				break;
			case 18 :
				// While.g:1:112: T__50
				{
				mT__50(); 

				}
				break;
			case 19 :
				// While.g:1:118: T__51
				{
				mT__51(); 

				}
				break;
			case 20 :
				// While.g:1:124: T__52
				{
				mT__52(); 

				}
				break;
			case 21 :
				// While.g:1:130: T__53
				{
				mT__53(); 

				}
				break;
			case 22 :
				// While.g:1:136: T__54
				{
				mT__54(); 

				}
				break;
			case 23 :
				// While.g:1:142: T__55
				{
				mT__55(); 

				}
				break;
			case 24 :
				// While.g:1:148: T__56
				{
				mT__56(); 

				}
				break;
			case 25 :
				// While.g:1:154: T__57
				{
				mT__57(); 

				}
				break;
			case 26 :
				// While.g:1:160: T__58
				{
				mT__58(); 

				}
				break;
			case 27 :
				// While.g:1:166: T__59
				{
				mT__59(); 

				}
				break;
			case 28 :
				// While.g:1:172: COMMENT
				{
				mCOMMENT(); 

				}
				break;
			case 29 :
				// While.g:1:180: WS
				{
				mWS(); 

				}
				break;
			case 30 :
				// While.g:1:183: Variable
				{
				mVariable(); 

				}
				break;
			case 31 :
				// While.g:1:192: Symbol
				{
				mSymbol(); 

				}
				break;

		}
	}


	protected DFA11 dfa11 = new DFA11(this);
	static final String DFA11_eotS =
		"\5\uffff\1\31\2\uffff\14\27\6\uffff\1\27\1\55\1\27\1\57\2\27\1\62\1\63"+
		"\1\64\3\27\1\70\2\27\1\73\3\27\1\uffff\1\27\1\uffff\1\101\1\27\3\uffff"+
		"\1\27\1\104\1\105\1\uffff\2\27\1\uffff\2\27\1\112\1\113\1\27\1\uffff\1"+
		"\27\1\116\2\uffff\1\117\1\120\2\27\2\uffff\2\27\3\uffff\1\125\1\126\2"+
		"\27\2\uffff\1\131\1\27\1\uffff\1\133\1\uffff";
	static final String DFA11_eofS =
		"\134\uffff";
	static final String DFA11_minS =
		"\1\11\4\uffff\1\75\2\uffff\2\157\1\154\1\151\1\144\1\146\2\151\1\144\1"+
		"\145\2\150\6\uffff\1\156\1\41\1\163\1\41\1\162\1\156\3\41\1\163\1\154"+
		"\1\160\1\41\1\141\1\145\1\41\2\151\1\163\1\uffff\1\145\1\uffff\1\41\1"+
		"\143\3\uffff\1\164\2\41\1\uffff\1\144\1\156\1\uffff\1\154\1\164\2\41\1"+
		"\141\1\uffff\1\164\1\41\2\uffff\2\41\2\145\2\uffff\1\143\1\151\3\uffff"+
		"\2\41\1\150\1\157\2\uffff\1\41\1\156\1\uffff\1\41\1\uffff";
	static final String DFA11_maxS =
		"\1\172\4\uffff\1\75\2\uffff\2\157\1\154\1\165\1\144\1\156\1\151\1\157"+
		"\1\144\1\145\1\154\1\162\6\uffff\1\156\1\172\1\163\1\172\1\162\1\156\3"+
		"\172\1\163\1\154\1\160\1\172\1\141\1\145\1\172\2\151\1\163\1\uffff\1\145"+
		"\1\uffff\1\172\1\143\3\uffff\1\164\2\172\1\uffff\1\144\1\156\1\uffff\1"+
		"\154\1\164\2\172\1\141\1\uffff\1\164\1\172\2\uffff\2\172\2\145\2\uffff"+
		"\1\143\1\151\3\uffff\2\172\1\150\1\157\2\uffff\1\172\1\156\1\uffff\1\172"+
		"\1\uffff";
	static final String DFA11_acceptS =
		"\1\uffff\1\1\1\2\1\3\1\4\1\uffff\1\7\1\10\14\uffff\1\34\1\35\1\36\1\37"+
		"\1\6\1\5\23\uffff\1\12\1\uffff\1\14\2\uffff\1\20\1\21\1\22\3\uffff\1\26"+
		"\2\uffff\1\31\5\uffff\1\15\2\uffff\1\24\1\25\4\uffff\1\11\1\13\2\uffff"+
		"\1\23\1\27\1\30\4\uffff\1\32\1\33\2\uffff\1\16\1\uffff\1\17";
	static final String DFA11_specialS =
		"\134\uffff}>";
	static final String[] DFA11_transitionS = {
			"\2\25\2\uffff\1\25\22\uffff\1\25\4\uffff\1\1\2\uffff\1\2\1\3\2\uffff"+
			"\1\4\2\uffff\1\24\12\uffff\1\5\1\6\1\uffff\1\7\3\uffff\32\26\6\uffff"+
			"\2\27\1\10\1\11\1\12\1\13\1\27\1\14\1\15\2\27\1\16\1\27\1\17\1\20\2\27"+
			"\1\21\1\27\1\22\2\27\1\23\3\27",
			"",
			"",
			"",
			"",
			"\1\30",
			"",
			"",
			"\1\32",
			"\1\33",
			"\1\34",
			"\1\35\5\uffff\1\36\5\uffff\1\37",
			"\1\40",
			"\1\41\7\uffff\1\42",
			"\1\43",
			"\1\44\5\uffff\1\45",
			"\1\46",
			"\1\47",
			"\1\50\3\uffff\1\51",
			"\1\52\11\uffff\1\53",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\54",
			"\1\27\16\uffff\12\27\5\uffff\1\27\1\uffff\32\27\6\uffff\32\27",
			"\1\56",
			"\1\27\16\uffff\12\27\5\uffff\1\27\1\uffff\32\27\6\uffff\32\27",
			"\1\60",
			"\1\61",
			"\1\27\16\uffff\12\27\5\uffff\1\27\1\uffff\32\27\6\uffff\32\27",
			"\1\27\16\uffff\12\27\5\uffff\1\27\1\uffff\32\27\6\uffff\32\27",
			"\1\27\16\uffff\12\27\5\uffff\1\27\1\uffff\32\27\6\uffff\32\27",
			"\1\65",
			"\1\66",
			"\1\67",
			"\1\27\16\uffff\12\27\5\uffff\1\27\1\uffff\32\27\6\uffff\32\27",
			"\1\71",
			"\1\72",
			"\1\27\16\uffff\12\27\5\uffff\1\27\1\uffff\32\27\6\uffff\32\27",
			"\1\74",
			"\1\75",
			"\1\76",
			"",
			"\1\77",
			"",
			"\1\27\16\uffff\12\27\5\uffff\1\27\1\uffff\32\27\6\uffff\4\27\1\100\25"+
			"\27",
			"\1\102",
			"",
			"",
			"",
			"\1\103",
			"\1\27\16\uffff\12\27\5\uffff\1\27\1\uffff\32\27\6\uffff\32\27",
			"\1\27\16\uffff\12\27\5\uffff\1\27\1\uffff\32\27\6\uffff\32\27",
			"",
			"\1\106",
			"\1\107",
			"",
			"\1\110",
			"\1\111",
			"\1\27\16\uffff\12\27\5\uffff\1\27\1\uffff\32\27\6\uffff\32\27",
			"\1\27\16\uffff\12\27\5\uffff\1\27\1\uffff\32\27\6\uffff\32\27",
			"\1\114",
			"",
			"\1\115",
			"\1\27\16\uffff\12\27\5\uffff\1\27\1\uffff\32\27\6\uffff\32\27",
			"",
			"",
			"\1\27\16\uffff\12\27\5\uffff\1\27\1\uffff\32\27\6\uffff\32\27",
			"\1\27\16\uffff\12\27\5\uffff\1\27\1\uffff\32\27\6\uffff\32\27",
			"\1\121",
			"\1\122",
			"",
			"",
			"\1\123",
			"\1\124",
			"",
			"",
			"",
			"\1\27\16\uffff\12\27\5\uffff\1\27\1\uffff\32\27\6\uffff\32\27",
			"\1\27\16\uffff\12\27\5\uffff\1\27\1\uffff\32\27\6\uffff\32\27",
			"\1\127",
			"\1\130",
			"",
			"",
			"\1\27\16\uffff\12\27\5\uffff\1\27\1\uffff\32\27\6\uffff\32\27",
			"\1\132",
			"",
			"\1\27\16\uffff\12\27\5\uffff\1\27\1\uffff\32\27\6\uffff\32\27",
			""
	};

	static final short[] DFA11_eot = DFA.unpackEncodedString(DFA11_eotS);
	static final short[] DFA11_eof = DFA.unpackEncodedString(DFA11_eofS);
	static final char[] DFA11_min = DFA.unpackEncodedStringToUnsignedChars(DFA11_minS);
	static final char[] DFA11_max = DFA.unpackEncodedStringToUnsignedChars(DFA11_maxS);
	static final short[] DFA11_accept = DFA.unpackEncodedString(DFA11_acceptS);
	static final short[] DFA11_special = DFA.unpackEncodedString(DFA11_specialS);
	static final short[][] DFA11_transition;

	static {
		int numStates = DFA11_transitionS.length;
		DFA11_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA11_transition[i] = DFA.unpackEncodedString(DFA11_transitionS[i]);
		}
	}

	protected class DFA11 extends DFA {

		public DFA11(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 11;
			this.eot = DFA11_eot;
			this.eof = DFA11_eof;
			this.min = DFA11_min;
			this.max = DFA11_max;
			this.accept = DFA11_accept;
			this.special = DFA11_special;
			this.transition = DFA11_transition;
		}
		@Override
		public String getDescription() {
			return "1:1: Tokens : ( T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | COMMENT | WS | Variable | Symbol );";
		}
	}

}
