// $ANTLR 3.5.2 While.g 2026-11-23 17:18:51

    package fr.tlc.whilecompiler;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.tree.*;


@SuppressWarnings("all")
public class WhileParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "ASSIGN", "ATOM", "CALL", "COMMANDS", 
		"COMMENT", "CONS", "Dec", "EQ", "EXPRS", "FOR", "FOREACH", "FUNCTION", 
		"HD", "IF", "INPUTS", "LIST", "Maj", "Min", "NIL", "NOP", "OUTPUTS", "PROGRAM", 
		"Symbol", "TL", "VAR", "VARS", "Variable", "WHILE", "WS", "'%'", "'('", 
		"')'", "','", "':'", "':='", "';'", "'=?'", "'cons'", "'do'", "'else'", 
		"'fi'", "'for'", "'foreach'", "'function'", "'hd'", "'if'", "'in'", "'list'", 
		"'nil'", "'nop'", "'od'", "'read'", "'then'", "'tl'", "'while'", "'write'"
	};
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
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public WhileParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public WhileParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
		this.state.ruleMemo = new HashMap[34+1];


	}

	protected TreeAdaptor adaptor = new CommonTreeAdaptor();

	public void setTreeAdaptor(TreeAdaptor adaptor) {
		this.adaptor = adaptor;
	}
	public TreeAdaptor getTreeAdaptor() {
		return adaptor;
	}
	@Override public String[] getTokenNames() { return WhileParser.tokenNames; }
	@Override public String getGrammarFileName() { return "While.g"; }


	public static class program_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "program"
	// While.g:55:1: program : ( function )+ EOF -> ^( PROGRAM ( function )+ ) ;
	public final WhileParser.program_return program() throws RecognitionException {
		WhileParser.program_return retval = new WhileParser.program_return();
		retval.start = input.LT(1);
		int program_StartIndex = input.index();

		Object root_0 = null;

		Token EOF2=null;
		ParserRuleReturnScope function1 =null;

		Object EOF2_tree=null;
		RewriteRuleTokenStream stream_EOF=new RewriteRuleTokenStream(adaptor,"token EOF");
		RewriteRuleSubtreeStream stream_function=new RewriteRuleSubtreeStream(adaptor,"rule function");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return retval; }

			// While.g:56:5: ( ( function )+ EOF -> ^( PROGRAM ( function )+ ) )
			// While.g:56:7: ( function )+ EOF
			{
			// While.g:56:7: ( function )+
			int cnt1=0;
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==47) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// While.g:56:7: function
					{
					pushFollow(FOLLOW_function_in_program330);
					function1=function();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_function.add(function1.getTree());
					}
					break;

				default :
					if ( cnt1 >= 1 ) break loop1;
					if (state.backtracking>0) {state.failed=true; return retval;}
					EarlyExitException eee = new EarlyExitException(1, input);
					throw eee;
				}
				cnt1++;
			}

			EOF2=(Token)match(input,EOF,FOLLOW_EOF_in_program333); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_EOF.add(EOF2);

			// AST REWRITE
			// elements: function
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 56:21: -> ^( PROGRAM ( function )+ )
			{
				// While.g:56:24: ^( PROGRAM ( function )+ )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(PROGRAM, "PROGRAM"), root_1);
				if ( !(stream_function.hasNext()) ) {
					throw new RewriteEarlyExitException();
				}
				while ( stream_function.hasNext() ) {
					adaptor.addChild(root_1, stream_function.nextTree());
				}
				stream_function.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 1, program_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "program"


	public static class function_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "function"
	// While.g:60:1: function : 'function' name= Symbol ':' 'read' in= inputs '%' cmd= commands '%' 'write' out= outputs -> ^( FUNCTION $name $in $cmd $out) ;
	public final WhileParser.function_return function() throws RecognitionException {
		WhileParser.function_return retval = new WhileParser.function_return();
		retval.start = input.LT(1);
		int function_StartIndex = input.index();

		Object root_0 = null;

		Token name=null;
		Token string_literal3=null;
		Token char_literal4=null;
		Token string_literal5=null;
		Token char_literal6=null;
		Token char_literal7=null;
		Token string_literal8=null;
		ParserRuleReturnScope in =null;
		ParserRuleReturnScope cmd =null;
		ParserRuleReturnScope out =null;

		Object name_tree=null;
		Object string_literal3_tree=null;
		Object char_literal4_tree=null;
		Object string_literal5_tree=null;
		Object char_literal6_tree=null;
		Object char_literal7_tree=null;
		Object string_literal8_tree=null;
		RewriteRuleTokenStream stream_55=new RewriteRuleTokenStream(adaptor,"token 55");
		RewriteRuleTokenStream stream_33=new RewriteRuleTokenStream(adaptor,"token 33");
		RewriteRuleTokenStream stream_47=new RewriteRuleTokenStream(adaptor,"token 47");
		RewriteRuleTokenStream stream_37=new RewriteRuleTokenStream(adaptor,"token 37");
		RewriteRuleTokenStream stream_59=new RewriteRuleTokenStream(adaptor,"token 59");
		RewriteRuleTokenStream stream_Symbol=new RewriteRuleTokenStream(adaptor,"token Symbol");
		RewriteRuleSubtreeStream stream_outputs=new RewriteRuleSubtreeStream(adaptor,"rule outputs");
		RewriteRuleSubtreeStream stream_inputs=new RewriteRuleSubtreeStream(adaptor,"rule inputs");
		RewriteRuleSubtreeStream stream_commands=new RewriteRuleSubtreeStream(adaptor,"rule commands");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return retval; }

			// While.g:61:5: ( 'function' name= Symbol ':' 'read' in= inputs '%' cmd= commands '%' 'write' out= outputs -> ^( FUNCTION $name $in $cmd $out) )
			// While.g:61:7: 'function' name= Symbol ':' 'read' in= inputs '%' cmd= commands '%' 'write' out= outputs
			{
			string_literal3=(Token)match(input,47,FOLLOW_47_in_function360); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_47.add(string_literal3);

			name=(Token)match(input,Symbol,FOLLOW_Symbol_in_function364); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_Symbol.add(name);

			char_literal4=(Token)match(input,37,FOLLOW_37_in_function366); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_37.add(char_literal4);

			string_literal5=(Token)match(input,55,FOLLOW_55_in_function368); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_55.add(string_literal5);

			pushFollow(FOLLOW_inputs_in_function378);
			in=inputs();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_inputs.add(in.getTree());
			char_literal6=(Token)match(input,33,FOLLOW_33_in_function380); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_33.add(char_literal6);

			pushFollow(FOLLOW_commands_in_function384);
			cmd=commands();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_commands.add(cmd.getTree());
			char_literal7=(Token)match(input,33,FOLLOW_33_in_function386); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_33.add(char_literal7);

			string_literal8=(Token)match(input,59,FOLLOW_59_in_function388); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_59.add(string_literal8);

			pushFollow(FOLLOW_outputs_in_function392);
			out=outputs();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_outputs.add(out.getTree());
			// AST REWRITE
			// elements: name, in, cmd, out
			// token labels: name
			// rule labels: in, cmd, retval, out
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleTokenStream stream_name=new RewriteRuleTokenStream(adaptor,"token name",name);
			RewriteRuleSubtreeStream stream_in=new RewriteRuleSubtreeStream(adaptor,"rule in",in!=null?in.getTree():null);
			RewriteRuleSubtreeStream stream_cmd=new RewriteRuleSubtreeStream(adaptor,"rule cmd",cmd!=null?cmd.getTree():null);
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);
			RewriteRuleSubtreeStream stream_out=new RewriteRuleSubtreeStream(adaptor,"rule out",out!=null?out.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 63:7: -> ^( FUNCTION $name $in $cmd $out)
			{
				// While.g:63:10: ^( FUNCTION $name $in $cmd $out)
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FUNCTION, "FUNCTION"), root_1);
				adaptor.addChild(root_1, stream_name.nextNode());
				adaptor.addChild(root_1, stream_in.nextTree());
				adaptor.addChild(root_1, stream_cmd.nextTree());
				adaptor.addChild(root_1, stream_out.nextTree());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 2, function_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "function"


	public static class inputs_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "inputs"
	// While.g:67:1: inputs : ( Variable ( ',' Variable )* )? -> ^( INPUTS ( Variable )* ) ;
	public final WhileParser.inputs_return inputs() throws RecognitionException {
		WhileParser.inputs_return retval = new WhileParser.inputs_return();
		retval.start = input.LT(1);
		int inputs_StartIndex = input.index();

		Object root_0 = null;

		Token Variable9=null;
		Token char_literal10=null;
		Token Variable11=null;

		Object Variable9_tree=null;
		Object char_literal10_tree=null;
		Object Variable11_tree=null;
		RewriteRuleTokenStream stream_36=new RewriteRuleTokenStream(adaptor,"token 36");
		RewriteRuleTokenStream stream_Variable=new RewriteRuleTokenStream(adaptor,"token Variable");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return retval; }

			// While.g:68:5: ( ( Variable ( ',' Variable )* )? -> ^( INPUTS ( Variable )* ) )
			// While.g:68:7: ( Variable ( ',' Variable )* )?
			{
			// While.g:68:7: ( Variable ( ',' Variable )* )?
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0==Variable) ) {
				alt3=1;
			}
			switch (alt3) {
				case 1 :
					// While.g:68:8: Variable ( ',' Variable )*
					{
					Variable9=(Token)match(input,Variable,FOLLOW_Variable_in_inputs435); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Variable.add(Variable9);

					// While.g:68:17: ( ',' Variable )*
					loop2:
					while (true) {
						int alt2=2;
						int LA2_0 = input.LA(1);
						if ( (LA2_0==36) ) {
							alt2=1;
						}

						switch (alt2) {
						case 1 :
							// While.g:68:18: ',' Variable
							{
							char_literal10=(Token)match(input,36,FOLLOW_36_in_inputs438); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_36.add(char_literal10);

							Variable11=(Token)match(input,Variable,FOLLOW_Variable_in_inputs440); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_Variable.add(Variable11);

							}
							break;

						default :
							break loop2;
						}
					}

					}
					break;

			}

			// AST REWRITE
			// elements: Variable
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 69:7: -> ^( INPUTS ( Variable )* )
			{
				// While.g:69:10: ^( INPUTS ( Variable )* )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(INPUTS, "INPUTS"), root_1);
				// While.g:69:19: ( Variable )*
				while ( stream_Variable.hasNext() ) {
					adaptor.addChild(root_1, stream_Variable.nextNode());
				}
				stream_Variable.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 3, inputs_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "inputs"


	public static class outputs_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "outputs"
	// While.g:73:1: outputs : Variable ( ',' Variable )* -> ^( OUTPUTS ( Variable )+ ) ;
	public final WhileParser.outputs_return outputs() throws RecognitionException {
		WhileParser.outputs_return retval = new WhileParser.outputs_return();
		retval.start = input.LT(1);
		int outputs_StartIndex = input.index();

		Object root_0 = null;

		Token Variable12=null;
		Token char_literal13=null;
		Token Variable14=null;

		Object Variable12_tree=null;
		Object char_literal13_tree=null;
		Object Variable14_tree=null;
		RewriteRuleTokenStream stream_36=new RewriteRuleTokenStream(adaptor,"token 36");
		RewriteRuleTokenStream stream_Variable=new RewriteRuleTokenStream(adaptor,"token Variable");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return retval; }

			// While.g:74:5: ( Variable ( ',' Variable )* -> ^( OUTPUTS ( Variable )+ ) )
			// While.g:74:7: Variable ( ',' Variable )*
			{
			Variable12=(Token)match(input,Variable,FOLLOW_Variable_in_outputs477); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_Variable.add(Variable12);

			// While.g:74:16: ( ',' Variable )*
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( (LA4_0==36) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// While.g:74:17: ',' Variable
					{
					char_literal13=(Token)match(input,36,FOLLOW_36_in_outputs480); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_36.add(char_literal13);

					Variable14=(Token)match(input,Variable,FOLLOW_Variable_in_outputs482); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Variable.add(Variable14);

					}
					break;

				default :
					break loop4;
				}
			}

			// AST REWRITE
			// elements: Variable
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 75:7: -> ^( OUTPUTS ( Variable )+ )
			{
				// While.g:75:10: ^( OUTPUTS ( Variable )+ )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(OUTPUTS, "OUTPUTS"), root_1);
				if ( !(stream_Variable.hasNext()) ) {
					throw new RewriteEarlyExitException();
				}
				while ( stream_Variable.hasNext() ) {
					adaptor.addChild(root_1, stream_Variable.nextNode());
				}
				stream_Variable.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 4, outputs_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "outputs"


	public static class commands_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "commands"
	// While.g:79:1: commands : command ( ';' command )* -> ^( COMMANDS ( command )+ ) ;
	public final WhileParser.commands_return commands() throws RecognitionException {
		WhileParser.commands_return retval = new WhileParser.commands_return();
		retval.start = input.LT(1);
		int commands_StartIndex = input.index();

		Object root_0 = null;

		Token char_literal16=null;
		ParserRuleReturnScope command15 =null;
		ParserRuleReturnScope command17 =null;

		Object char_literal16_tree=null;
		RewriteRuleTokenStream stream_39=new RewriteRuleTokenStream(adaptor,"token 39");
		RewriteRuleSubtreeStream stream_command=new RewriteRuleSubtreeStream(adaptor,"rule command");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return retval; }

			// While.g:80:5: ( command ( ';' command )* -> ^( COMMANDS ( command )+ ) )
			// While.g:80:7: command ( ';' command )*
			{
			pushFollow(FOLLOW_command_in_commands517);
			command15=command();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_command.add(command15.getTree());
			// While.g:80:15: ( ';' command )*
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( (LA5_0==39) ) {
					alt5=1;
				}

				switch (alt5) {
				case 1 :
					// While.g:80:16: ';' command
					{
					char_literal16=(Token)match(input,39,FOLLOW_39_in_commands520); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_39.add(char_literal16);

					pushFollow(FOLLOW_command_in_commands522);
					command17=command();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_command.add(command17.getTree());
					}
					break;

				default :
					break loop5;
				}
			}

			// AST REWRITE
			// elements: command
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 81:7: -> ^( COMMANDS ( command )+ )
			{
				// While.g:81:10: ^( COMMANDS ( command )+ )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(COMMANDS, "COMMANDS"), root_1);
				if ( !(stream_command.hasNext()) ) {
					throw new RewriteEarlyExitException();
				}
				while ( stream_command.hasNext() ) {
					adaptor.addChild(root_1, stream_command.nextTree());
				}
				stream_command.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 5, commands_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "commands"


	public static class command_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "command"
	// While.g:85:1: command : ( 'nop' -> NOP | vars ':=' exprs -> ^( ASSIGN vars exprs ) | 'if' expression 'then' yes= commands 'else' no= commands 'fi' -> ^( IF expression $yes $no) | 'if' expression 'then' yes= commands 'fi' -> ^( IF expression $yes) | 'while' expression 'do' commands 'od' -> ^( WHILE expression commands ) | 'for' expression 'do' commands 'od' -> ^( FOR expression commands ) | 'foreach' Variable 'in' expression 'do' commands 'od' -> ^( FOREACH Variable expression commands ) );
	public final WhileParser.command_return command() throws RecognitionException {
		WhileParser.command_return retval = new WhileParser.command_return();
		retval.start = input.LT(1);
		int command_StartIndex = input.index();

		Object root_0 = null;

		Token string_literal18=null;
		Token string_literal20=null;
		Token string_literal22=null;
		Token string_literal24=null;
		Token string_literal25=null;
		Token string_literal26=null;
		Token string_literal27=null;
		Token string_literal29=null;
		Token string_literal30=null;
		Token string_literal31=null;
		Token string_literal33=null;
		Token string_literal35=null;
		Token string_literal36=null;
		Token string_literal38=null;
		Token string_literal40=null;
		Token string_literal41=null;
		Token Variable42=null;
		Token string_literal43=null;
		Token string_literal45=null;
		Token string_literal47=null;
		ParserRuleReturnScope yes =null;
		ParserRuleReturnScope no =null;
		ParserRuleReturnScope vars19 =null;
		ParserRuleReturnScope exprs21 =null;
		ParserRuleReturnScope expression23 =null;
		ParserRuleReturnScope expression28 =null;
		ParserRuleReturnScope expression32 =null;
		ParserRuleReturnScope commands34 =null;
		ParserRuleReturnScope expression37 =null;
		ParserRuleReturnScope commands39 =null;
		ParserRuleReturnScope expression44 =null;
		ParserRuleReturnScope commands46 =null;

		Object string_literal18_tree=null;
		Object string_literal20_tree=null;
		Object string_literal22_tree=null;
		Object string_literal24_tree=null;
		Object string_literal25_tree=null;
		Object string_literal26_tree=null;
		Object string_literal27_tree=null;
		Object string_literal29_tree=null;
		Object string_literal30_tree=null;
		Object string_literal31_tree=null;
		Object string_literal33_tree=null;
		Object string_literal35_tree=null;
		Object string_literal36_tree=null;
		Object string_literal38_tree=null;
		Object string_literal40_tree=null;
		Object string_literal41_tree=null;
		Object Variable42_tree=null;
		Object string_literal43_tree=null;
		Object string_literal45_tree=null;
		Object string_literal47_tree=null;
		RewriteRuleTokenStream stream_44=new RewriteRuleTokenStream(adaptor,"token 44");
		RewriteRuleTokenStream stream_56=new RewriteRuleTokenStream(adaptor,"token 56");
		RewriteRuleTokenStream stream_45=new RewriteRuleTokenStream(adaptor,"token 45");
		RewriteRuleTokenStream stream_46=new RewriteRuleTokenStream(adaptor,"token 46");
		RewriteRuleTokenStream stream_58=new RewriteRuleTokenStream(adaptor,"token 58");
		RewriteRuleTokenStream stream_Variable=new RewriteRuleTokenStream(adaptor,"token Variable");
		RewriteRuleTokenStream stream_38=new RewriteRuleTokenStream(adaptor,"token 38");
		RewriteRuleTokenStream stream_49=new RewriteRuleTokenStream(adaptor,"token 49");
		RewriteRuleTokenStream stream_50=new RewriteRuleTokenStream(adaptor,"token 50");
		RewriteRuleTokenStream stream_53=new RewriteRuleTokenStream(adaptor,"token 53");
		RewriteRuleTokenStream stream_42=new RewriteRuleTokenStream(adaptor,"token 42");
		RewriteRuleTokenStream stream_43=new RewriteRuleTokenStream(adaptor,"token 43");
		RewriteRuleTokenStream stream_54=new RewriteRuleTokenStream(adaptor,"token 54");
		RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
		RewriteRuleSubtreeStream stream_exprs=new RewriteRuleSubtreeStream(adaptor,"rule exprs");
		RewriteRuleSubtreeStream stream_vars=new RewriteRuleSubtreeStream(adaptor,"rule vars");
		RewriteRuleSubtreeStream stream_commands=new RewriteRuleSubtreeStream(adaptor,"rule commands");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return retval; }

			// While.g:86:5: ( 'nop' -> NOP | vars ':=' exprs -> ^( ASSIGN vars exprs ) | 'if' expression 'then' yes= commands 'else' no= commands 'fi' -> ^( IF expression $yes $no) | 'if' expression 'then' yes= commands 'fi' -> ^( IF expression $yes) | 'while' expression 'do' commands 'od' -> ^( WHILE expression commands ) | 'for' expression 'do' commands 'od' -> ^( FOR expression commands ) | 'foreach' Variable 'in' expression 'do' commands 'od' -> ^( FOREACH Variable expression commands ) )
			int alt6=7;
			switch ( input.LA(1) ) {
			case 53:
				{
				alt6=1;
				}
				break;
			case Variable:
				{
				alt6=2;
				}
				break;
			case 49:
				{
				int LA6_3 = input.LA(2);
				if ( (synpred8_While()) ) {
					alt6=3;
				}
				else if ( (synpred9_While()) ) {
					alt6=4;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 6, 3, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case 58:
				{
				alt6=5;
				}
				break;
			case 45:
				{
				alt6=6;
				}
				break;
			case 46:
				{
				alt6=7;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 6, 0, input);
				throw nvae;
			}
			switch (alt6) {
				case 1 :
					// While.g:86:7: 'nop'
					{
					string_literal18=(Token)match(input,53,FOLLOW_53_in_command557); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_53.add(string_literal18);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 87:7: -> NOP
					{
						adaptor.addChild(root_0, (Object)adaptor.create(NOP, "NOP"));
					}


					retval.tree = root_0;
					}

					}
					break;
				case 2 :
					// While.g:89:7: vars ':=' exprs
					{
					pushFollow(FOLLOW_vars_in_command576);
					vars19=vars();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_vars.add(vars19.getTree());
					string_literal20=(Token)match(input,38,FOLLOW_38_in_command578); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_38.add(string_literal20);

					pushFollow(FOLLOW_exprs_in_command580);
					exprs21=exprs();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_exprs.add(exprs21.getTree());
					// AST REWRITE
					// elements: vars, exprs
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 90:7: -> ^( ASSIGN vars exprs )
					{
						// While.g:90:10: ^( ASSIGN vars exprs )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ASSIGN, "ASSIGN"), root_1);
						adaptor.addChild(root_1, stream_vars.nextTree());
						adaptor.addChild(root_1, stream_exprs.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 3 :
					// While.g:92:7: 'if' expression 'then' yes= commands 'else' no= commands 'fi'
					{
					string_literal22=(Token)match(input,49,FOLLOW_49_in_command605); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_49.add(string_literal22);

					pushFollow(FOLLOW_expression_in_command607);
					expression23=expression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_expression.add(expression23.getTree());
					string_literal24=(Token)match(input,56,FOLLOW_56_in_command609); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_56.add(string_literal24);

					pushFollow(FOLLOW_commands_in_command613);
					yes=commands();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_commands.add(yes.getTree());
					string_literal25=(Token)match(input,43,FOLLOW_43_in_command615); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_43.add(string_literal25);

					pushFollow(FOLLOW_commands_in_command619);
					no=commands();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_commands.add(no.getTree());
					string_literal26=(Token)match(input,44,FOLLOW_44_in_command621); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_44.add(string_literal26);

					// AST REWRITE
					// elements: no, expression, yes
					// token labels: 
					// rule labels: no, yes, retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_no=new RewriteRuleSubtreeStream(adaptor,"rule no",no!=null?no.getTree():null);
					RewriteRuleSubtreeStream stream_yes=new RewriteRuleSubtreeStream(adaptor,"rule yes",yes!=null?yes.getTree():null);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 93:7: -> ^( IF expression $yes $no)
					{
						// While.g:93:10: ^( IF expression $yes $no)
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(IF, "IF"), root_1);
						adaptor.addChild(root_1, stream_expression.nextTree());
						adaptor.addChild(root_1, stream_yes.nextTree());
						adaptor.addChild(root_1, stream_no.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 4 :
					// While.g:95:7: 'if' expression 'then' yes= commands 'fi'
					{
					string_literal27=(Token)match(input,49,FOLLOW_49_in_command650); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_49.add(string_literal27);

					pushFollow(FOLLOW_expression_in_command652);
					expression28=expression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_expression.add(expression28.getTree());
					string_literal29=(Token)match(input,56,FOLLOW_56_in_command654); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_56.add(string_literal29);

					pushFollow(FOLLOW_commands_in_command658);
					yes=commands();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_commands.add(yes.getTree());
					string_literal30=(Token)match(input,44,FOLLOW_44_in_command660); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_44.add(string_literal30);

					// AST REWRITE
					// elements: yes, expression
					// token labels: 
					// rule labels: yes, retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_yes=new RewriteRuleSubtreeStream(adaptor,"rule yes",yes!=null?yes.getTree():null);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 96:7: -> ^( IF expression $yes)
					{
						// While.g:96:10: ^( IF expression $yes)
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(IF, "IF"), root_1);
						adaptor.addChild(root_1, stream_expression.nextTree());
						adaptor.addChild(root_1, stream_yes.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 5 :
					// While.g:98:7: 'while' expression 'do' commands 'od'
					{
					string_literal31=(Token)match(input,58,FOLLOW_58_in_command686); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_58.add(string_literal31);

					pushFollow(FOLLOW_expression_in_command688);
					expression32=expression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_expression.add(expression32.getTree());
					string_literal33=(Token)match(input,42,FOLLOW_42_in_command690); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_42.add(string_literal33);

					pushFollow(FOLLOW_commands_in_command692);
					commands34=commands();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_commands.add(commands34.getTree());
					string_literal35=(Token)match(input,54,FOLLOW_54_in_command694); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_54.add(string_literal35);

					// AST REWRITE
					// elements: expression, commands
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 99:7: -> ^( WHILE expression commands )
					{
						// While.g:99:10: ^( WHILE expression commands )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(WHILE, "WHILE"), root_1);
						adaptor.addChild(root_1, stream_expression.nextTree());
						adaptor.addChild(root_1, stream_commands.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 6 :
					// While.g:101:7: 'for' expression 'do' commands 'od'
					{
					string_literal36=(Token)match(input,45,FOLLOW_45_in_command719); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_45.add(string_literal36);

					pushFollow(FOLLOW_expression_in_command721);
					expression37=expression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_expression.add(expression37.getTree());
					string_literal38=(Token)match(input,42,FOLLOW_42_in_command723); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_42.add(string_literal38);

					pushFollow(FOLLOW_commands_in_command725);
					commands39=commands();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_commands.add(commands39.getTree());
					string_literal40=(Token)match(input,54,FOLLOW_54_in_command727); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_54.add(string_literal40);

					// AST REWRITE
					// elements: expression, commands
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 102:7: -> ^( FOR expression commands )
					{
						// While.g:102:10: ^( FOR expression commands )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FOR, "FOR"), root_1);
						adaptor.addChild(root_1, stream_expression.nextTree());
						adaptor.addChild(root_1, stream_commands.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 7 :
					// While.g:104:7: 'foreach' Variable 'in' expression 'do' commands 'od'
					{
					string_literal41=(Token)match(input,46,FOLLOW_46_in_command752); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_46.add(string_literal41);

					Variable42=(Token)match(input,Variable,FOLLOW_Variable_in_command754); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Variable.add(Variable42);

					string_literal43=(Token)match(input,50,FOLLOW_50_in_command756); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_50.add(string_literal43);

					pushFollow(FOLLOW_expression_in_command758);
					expression44=expression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_expression.add(expression44.getTree());
					string_literal45=(Token)match(input,42,FOLLOW_42_in_command760); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_42.add(string_literal45);

					pushFollow(FOLLOW_commands_in_command762);
					commands46=commands();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_commands.add(commands46.getTree());
					string_literal47=(Token)match(input,54,FOLLOW_54_in_command764); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_54.add(string_literal47);

					// AST REWRITE
					// elements: expression, Variable, commands
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 105:7: -> ^( FOREACH Variable expression commands )
					{
						// While.g:105:10: ^( FOREACH Variable expression commands )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FOREACH, "FOREACH"), root_1);
						adaptor.addChild(root_1, stream_Variable.nextNode());
						adaptor.addChild(root_1, stream_expression.nextTree());
						adaptor.addChild(root_1, stream_commands.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 6, command_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "command"


	public static class vars_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "vars"
	// While.g:109:1: vars : Variable ( ',' Variable )* -> ^( VARS ( Variable )+ ) ;
	public final WhileParser.vars_return vars() throws RecognitionException {
		WhileParser.vars_return retval = new WhileParser.vars_return();
		retval.start = input.LT(1);
		int vars_StartIndex = input.index();

		Object root_0 = null;

		Token Variable48=null;
		Token char_literal49=null;
		Token Variable50=null;

		Object Variable48_tree=null;
		Object char_literal49_tree=null;
		Object Variable50_tree=null;
		RewriteRuleTokenStream stream_36=new RewriteRuleTokenStream(adaptor,"token 36");
		RewriteRuleTokenStream stream_Variable=new RewriteRuleTokenStream(adaptor,"token Variable");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return retval; }

			// While.g:110:5: ( Variable ( ',' Variable )* -> ^( VARS ( Variable )+ ) )
			// While.g:110:7: Variable ( ',' Variable )*
			{
			Variable48=(Token)match(input,Variable,FOLLOW_Variable_in_vars800); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_Variable.add(Variable48);

			// While.g:110:16: ( ',' Variable )*
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( (LA7_0==36) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// While.g:110:17: ',' Variable
					{
					char_literal49=(Token)match(input,36,FOLLOW_36_in_vars803); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_36.add(char_literal49);

					Variable50=(Token)match(input,Variable,FOLLOW_Variable_in_vars805); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Variable.add(Variable50);

					}
					break;

				default :
					break loop7;
				}
			}

			// AST REWRITE
			// elements: Variable
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 111:7: -> ^( VARS ( Variable )+ )
			{
				// While.g:111:10: ^( VARS ( Variable )+ )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(VARS, "VARS"), root_1);
				if ( !(stream_Variable.hasNext()) ) {
					throw new RewriteEarlyExitException();
				}
				while ( stream_Variable.hasNext() ) {
					adaptor.addChild(root_1, stream_Variable.nextNode());
				}
				stream_Variable.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 7, vars_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "vars"


	public static class exprs_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "exprs"
	// While.g:115:1: exprs : expression ( ',' expression )* -> ^( EXPRS ( expression )+ ) ;
	public final WhileParser.exprs_return exprs() throws RecognitionException {
		WhileParser.exprs_return retval = new WhileParser.exprs_return();
		retval.start = input.LT(1);
		int exprs_StartIndex = input.index();

		Object root_0 = null;

		Token char_literal52=null;
		ParserRuleReturnScope expression51 =null;
		ParserRuleReturnScope expression53 =null;

		Object char_literal52_tree=null;
		RewriteRuleTokenStream stream_36=new RewriteRuleTokenStream(adaptor,"token 36");
		RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return retval; }

			// While.g:116:5: ( expression ( ',' expression )* -> ^( EXPRS ( expression )+ ) )
			// While.g:116:7: expression ( ',' expression )*
			{
			pushFollow(FOLLOW_expression_in_exprs840);
			expression51=expression();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_expression.add(expression51.getTree());
			// While.g:116:18: ( ',' expression )*
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( (LA8_0==36) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// While.g:116:19: ',' expression
					{
					char_literal52=(Token)match(input,36,FOLLOW_36_in_exprs843); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_36.add(char_literal52);

					pushFollow(FOLLOW_expression_in_exprs845);
					expression53=expression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_expression.add(expression53.getTree());
					}
					break;

				default :
					break loop8;
				}
			}

			// AST REWRITE
			// elements: expression
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 117:7: -> ^( EXPRS ( expression )+ )
			{
				// While.g:117:10: ^( EXPRS ( expression )+ )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(EXPRS, "EXPRS"), root_1);
				if ( !(stream_expression.hasNext()) ) {
					throw new RewriteEarlyExitException();
				}
				while ( stream_expression.hasNext() ) {
					adaptor.addChild(root_1, stream_expression.nextTree());
				}
				stream_expression.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 8, exprs_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "exprs"


	public static class expression_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "expression"
	// While.g:121:1: expression : (left= exprBase '=?' right= exprBase -> ^( EQ $left $right) | exprBase -> exprBase );
	public final WhileParser.expression_return expression() throws RecognitionException {
		WhileParser.expression_return retval = new WhileParser.expression_return();
		retval.start = input.LT(1);
		int expression_StartIndex = input.index();

		Object root_0 = null;

		Token string_literal54=null;
		ParserRuleReturnScope left =null;
		ParserRuleReturnScope right =null;
		ParserRuleReturnScope exprBase55 =null;

		Object string_literal54_tree=null;
		RewriteRuleTokenStream stream_40=new RewriteRuleTokenStream(adaptor,"token 40");
		RewriteRuleSubtreeStream stream_exprBase=new RewriteRuleSubtreeStream(adaptor,"rule exprBase");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return retval; }

			// While.g:122:5: (left= exprBase '=?' right= exprBase -> ^( EQ $left $right) | exprBase -> exprBase )
			int alt9=2;
			switch ( input.LA(1) ) {
			case 52:
				{
				int LA9_1 = input.LA(2);
				if ( (synpred14_While()) ) {
					alt9=1;
				}
				else if ( (true) ) {
					alt9=2;
				}

				}
				break;
			case Variable:
				{
				int LA9_2 = input.LA(2);
				if ( (synpred14_While()) ) {
					alt9=1;
				}
				else if ( (true) ) {
					alt9=2;
				}

				}
				break;
			case Symbol:
				{
				int LA9_3 = input.LA(2);
				if ( (synpred14_While()) ) {
					alt9=1;
				}
				else if ( (true) ) {
					alt9=2;
				}

				}
				break;
			case 34:
				{
				int LA9_4 = input.LA(2);
				if ( (synpred14_While()) ) {
					alt9=1;
				}
				else if ( (true) ) {
					alt9=2;
				}

				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 9, 0, input);
				throw nvae;
			}
			switch (alt9) {
				case 1 :
					// While.g:122:7: left= exprBase '=?' right= exprBase
					{
					pushFollow(FOLLOW_exprBase_in_expression882);
					left=exprBase();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_exprBase.add(left.getTree());
					string_literal54=(Token)match(input,40,FOLLOW_40_in_expression884); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_40.add(string_literal54);

					pushFollow(FOLLOW_exprBase_in_expression888);
					right=exprBase();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_exprBase.add(right.getTree());
					// AST REWRITE
					// elements: right, left
					// token labels: 
					// rule labels: left, right, retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_left=new RewriteRuleSubtreeStream(adaptor,"rule left",left!=null?left.getTree():null);
					RewriteRuleSubtreeStream stream_right=new RewriteRuleSubtreeStream(adaptor,"rule right",right!=null?right.getTree():null);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 123:7: -> ^( EQ $left $right)
					{
						// While.g:123:10: ^( EQ $left $right)
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(EQ, "EQ"), root_1);
						adaptor.addChild(root_1, stream_left.nextTree());
						adaptor.addChild(root_1, stream_right.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 2 :
					// While.g:125:7: exprBase
					{
					pushFollow(FOLLOW_exprBase_in_expression915);
					exprBase55=exprBase();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_exprBase.add(exprBase55.getTree());
					// AST REWRITE
					// elements: exprBase
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 126:7: -> exprBase
					{
						adaptor.addChild(root_0, stream_exprBase.nextTree());
					}


					retval.tree = root_0;
					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 9, expression_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "expression"


	public static class exprBase_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "exprBase"
	// While.g:130:1: exprBase : ( 'nil' -> NIL | Variable -> ^( VAR Variable ) | Symbol -> ^( ATOM Symbol ) | '(' 'cons' ( exprBase )* ')' -> ^( CONS ( exprBase )* ) | '(' 'list' ( exprBase )* ')' -> ^( LIST ( exprBase )* ) | '(' 'hd' exprBase ')' -> ^( HD exprBase ) | '(' 'tl' exprBase ')' -> ^( TL exprBase ) | '(' functionName= Symbol ( exprBase )* ')' -> ^( CALL $functionName ( exprBase )* ) );
	public final WhileParser.exprBase_return exprBase() throws RecognitionException {
		WhileParser.exprBase_return retval = new WhileParser.exprBase_return();
		retval.start = input.LT(1);
		int exprBase_StartIndex = input.index();

		Object root_0 = null;

		Token functionName=null;
		Token string_literal56=null;
		Token Variable57=null;
		Token Symbol58=null;
		Token char_literal59=null;
		Token string_literal60=null;
		Token char_literal62=null;
		Token char_literal63=null;
		Token string_literal64=null;
		Token char_literal66=null;
		Token char_literal67=null;
		Token string_literal68=null;
		Token char_literal70=null;
		Token char_literal71=null;
		Token string_literal72=null;
		Token char_literal74=null;
		Token char_literal75=null;
		Token char_literal77=null;
		ParserRuleReturnScope exprBase61 =null;
		ParserRuleReturnScope exprBase65 =null;
		ParserRuleReturnScope exprBase69 =null;
		ParserRuleReturnScope exprBase73 =null;
		ParserRuleReturnScope exprBase76 =null;

		Object functionName_tree=null;
		Object string_literal56_tree=null;
		Object Variable57_tree=null;
		Object Symbol58_tree=null;
		Object char_literal59_tree=null;
		Object string_literal60_tree=null;
		Object char_literal62_tree=null;
		Object char_literal63_tree=null;
		Object string_literal64_tree=null;
		Object char_literal66_tree=null;
		Object char_literal67_tree=null;
		Object string_literal68_tree=null;
		Object char_literal70_tree=null;
		Object char_literal71_tree=null;
		Object string_literal72_tree=null;
		Object char_literal74_tree=null;
		Object char_literal75_tree=null;
		Object char_literal77_tree=null;
		RewriteRuleTokenStream stream_34=new RewriteRuleTokenStream(adaptor,"token 34");
		RewriteRuleTokenStream stream_35=new RewriteRuleTokenStream(adaptor,"token 35");
		RewriteRuleTokenStream stream_57=new RewriteRuleTokenStream(adaptor,"token 57");
		RewriteRuleTokenStream stream_Variable=new RewriteRuleTokenStream(adaptor,"token Variable");
		RewriteRuleTokenStream stream_48=new RewriteRuleTokenStream(adaptor,"token 48");
		RewriteRuleTokenStream stream_Symbol=new RewriteRuleTokenStream(adaptor,"token Symbol");
		RewriteRuleTokenStream stream_51=new RewriteRuleTokenStream(adaptor,"token 51");
		RewriteRuleTokenStream stream_52=new RewriteRuleTokenStream(adaptor,"token 52");
		RewriteRuleTokenStream stream_41=new RewriteRuleTokenStream(adaptor,"token 41");
		RewriteRuleSubtreeStream stream_exprBase=new RewriteRuleSubtreeStream(adaptor,"rule exprBase");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return retval; }

			// While.g:131:5: ( 'nil' -> NIL | Variable -> ^( VAR Variable ) | Symbol -> ^( ATOM Symbol ) | '(' 'cons' ( exprBase )* ')' -> ^( CONS ( exprBase )* ) | '(' 'list' ( exprBase )* ')' -> ^( LIST ( exprBase )* ) | '(' 'hd' exprBase ')' -> ^( HD exprBase ) | '(' 'tl' exprBase ')' -> ^( TL exprBase ) | '(' functionName= Symbol ( exprBase )* ')' -> ^( CALL $functionName ( exprBase )* ) )
			int alt13=8;
			switch ( input.LA(1) ) {
			case 52:
				{
				alt13=1;
				}
				break;
			case Variable:
				{
				alt13=2;
				}
				break;
			case Symbol:
				{
				alt13=3;
				}
				break;
			case 34:
				{
				switch ( input.LA(2) ) {
				case 41:
					{
					alt13=4;
					}
					break;
				case 51:
					{
					alt13=5;
					}
					break;
				case 48:
					{
					alt13=6;
					}
					break;
				case 57:
					{
					alt13=7;
					}
					break;
				case Symbol:
					{
					alt13=8;
					}
					break;
				default:
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 13, 4, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 13, 0, input);
				throw nvae;
			}
			switch (alt13) {
				case 1 :
					// While.g:131:7: 'nil'
					{
					string_literal56=(Token)match(input,52,FOLLOW_52_in_exprBase943); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_52.add(string_literal56);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 132:7: -> NIL
					{
						adaptor.addChild(root_0, (Object)adaptor.create(NIL, "NIL"));
					}


					retval.tree = root_0;
					}

					}
					break;
				case 2 :
					// While.g:134:7: Variable
					{
					Variable57=(Token)match(input,Variable,FOLLOW_Variable_in_exprBase962); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Variable.add(Variable57);

					// AST REWRITE
					// elements: Variable
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 135:7: -> ^( VAR Variable )
					{
						// While.g:135:10: ^( VAR Variable )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(VAR, "VAR"), root_1);
						adaptor.addChild(root_1, stream_Variable.nextNode());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 3 :
					// While.g:137:7: Symbol
					{
					Symbol58=(Token)match(input,Symbol,FOLLOW_Symbol_in_exprBase985); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Symbol.add(Symbol58);

					// AST REWRITE
					// elements: Symbol
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 138:7: -> ^( ATOM Symbol )
					{
						// While.g:138:10: ^( ATOM Symbol )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ATOM, "ATOM"), root_1);
						adaptor.addChild(root_1, stream_Symbol.nextNode());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 4 :
					// While.g:140:7: '(' 'cons' ( exprBase )* ')'
					{
					char_literal59=(Token)match(input,34,FOLLOW_34_in_exprBase1008); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_34.add(char_literal59);

					string_literal60=(Token)match(input,41,FOLLOW_41_in_exprBase1010); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_41.add(string_literal60);

					// While.g:140:18: ( exprBase )*
					loop10:
					while (true) {
						int alt10=2;
						int LA10_0 = input.LA(1);
						if ( (LA10_0==Symbol||LA10_0==Variable||LA10_0==34||LA10_0==52) ) {
							alt10=1;
						}

						switch (alt10) {
						case 1 :
							// While.g:140:18: exprBase
							{
							pushFollow(FOLLOW_exprBase_in_exprBase1012);
							exprBase61=exprBase();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_exprBase.add(exprBase61.getTree());
							}
							break;

						default :
							break loop10;
						}
					}

					char_literal62=(Token)match(input,35,FOLLOW_35_in_exprBase1015); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_35.add(char_literal62);

					// AST REWRITE
					// elements: exprBase
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 141:7: -> ^( CONS ( exprBase )* )
					{
						// While.g:141:10: ^( CONS ( exprBase )* )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(CONS, "CONS"), root_1);
						// While.g:141:17: ( exprBase )*
						while ( stream_exprBase.hasNext() ) {
							adaptor.addChild(root_1, stream_exprBase.nextTree());
						}
						stream_exprBase.reset();

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 5 :
					// While.g:143:7: '(' 'list' ( exprBase )* ')'
					{
					char_literal63=(Token)match(input,34,FOLLOW_34_in_exprBase1039); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_34.add(char_literal63);

					string_literal64=(Token)match(input,51,FOLLOW_51_in_exprBase1041); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_51.add(string_literal64);

					// While.g:143:18: ( exprBase )*
					loop11:
					while (true) {
						int alt11=2;
						int LA11_0 = input.LA(1);
						if ( (LA11_0==Symbol||LA11_0==Variable||LA11_0==34||LA11_0==52) ) {
							alt11=1;
						}

						switch (alt11) {
						case 1 :
							// While.g:143:18: exprBase
							{
							pushFollow(FOLLOW_exprBase_in_exprBase1043);
							exprBase65=exprBase();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_exprBase.add(exprBase65.getTree());
							}
							break;

						default :
							break loop11;
						}
					}

					char_literal66=(Token)match(input,35,FOLLOW_35_in_exprBase1046); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_35.add(char_literal66);

					// AST REWRITE
					// elements: exprBase
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 144:7: -> ^( LIST ( exprBase )* )
					{
						// While.g:144:10: ^( LIST ( exprBase )* )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(LIST, "LIST"), root_1);
						// While.g:144:17: ( exprBase )*
						while ( stream_exprBase.hasNext() ) {
							adaptor.addChild(root_1, stream_exprBase.nextTree());
						}
						stream_exprBase.reset();

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 6 :
					// While.g:146:7: '(' 'hd' exprBase ')'
					{
					char_literal67=(Token)match(input,34,FOLLOW_34_in_exprBase1070); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_34.add(char_literal67);

					string_literal68=(Token)match(input,48,FOLLOW_48_in_exprBase1072); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_48.add(string_literal68);

					pushFollow(FOLLOW_exprBase_in_exprBase1074);
					exprBase69=exprBase();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_exprBase.add(exprBase69.getTree());
					char_literal70=(Token)match(input,35,FOLLOW_35_in_exprBase1076); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_35.add(char_literal70);

					// AST REWRITE
					// elements: exprBase
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 147:7: -> ^( HD exprBase )
					{
						// While.g:147:10: ^( HD exprBase )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(HD, "HD"), root_1);
						adaptor.addChild(root_1, stream_exprBase.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 7 :
					// While.g:149:7: '(' 'tl' exprBase ')'
					{
					char_literal71=(Token)match(input,34,FOLLOW_34_in_exprBase1099); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_34.add(char_literal71);

					string_literal72=(Token)match(input,57,FOLLOW_57_in_exprBase1101); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_57.add(string_literal72);

					pushFollow(FOLLOW_exprBase_in_exprBase1103);
					exprBase73=exprBase();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_exprBase.add(exprBase73.getTree());
					char_literal74=(Token)match(input,35,FOLLOW_35_in_exprBase1105); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_35.add(char_literal74);

					// AST REWRITE
					// elements: exprBase
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 150:7: -> ^( TL exprBase )
					{
						// While.g:150:10: ^( TL exprBase )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(TL, "TL"), root_1);
						adaptor.addChild(root_1, stream_exprBase.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 8 :
					// While.g:152:7: '(' functionName= Symbol ( exprBase )* ')'
					{
					char_literal75=(Token)match(input,34,FOLLOW_34_in_exprBase1128); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_34.add(char_literal75);

					functionName=(Token)match(input,Symbol,FOLLOW_Symbol_in_exprBase1132); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Symbol.add(functionName);

					// While.g:152:31: ( exprBase )*
					loop12:
					while (true) {
						int alt12=2;
						int LA12_0 = input.LA(1);
						if ( (LA12_0==Symbol||LA12_0==Variable||LA12_0==34||LA12_0==52) ) {
							alt12=1;
						}

						switch (alt12) {
						case 1 :
							// While.g:152:31: exprBase
							{
							pushFollow(FOLLOW_exprBase_in_exprBase1134);
							exprBase76=exprBase();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_exprBase.add(exprBase76.getTree());
							}
							break;

						default :
							break loop12;
						}
					}

					char_literal77=(Token)match(input,35,FOLLOW_35_in_exprBase1137); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_35.add(char_literal77);

					// AST REWRITE
					// elements: exprBase, functionName
					// token labels: functionName
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleTokenStream stream_functionName=new RewriteRuleTokenStream(adaptor,"token functionName",functionName);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 153:7: -> ^( CALL $functionName ( exprBase )* )
					{
						// While.g:153:10: ^( CALL $functionName ( exprBase )* )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(CALL, "CALL"), root_1);
						adaptor.addChild(root_1, stream_functionName.nextNode());
						// While.g:153:31: ( exprBase )*
						while ( stream_exprBase.hasNext() ) {
							adaptor.addChild(root_1, stream_exprBase.nextTree());
						}
						stream_exprBase.reset();

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 10, exprBase_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "exprBase"

	// $ANTLR start synpred8_While
	public final void synpred8_While_fragment() throws RecognitionException {
		ParserRuleReturnScope yes =null;
		ParserRuleReturnScope no =null;


		// While.g:92:7: ( 'if' expression 'then' yes= commands 'else' no= commands 'fi' )
		// While.g:92:7: 'if' expression 'then' yes= commands 'else' no= commands 'fi'
		{
		match(input,49,FOLLOW_49_in_synpred8_While605); if (state.failed) return;

		pushFollow(FOLLOW_expression_in_synpred8_While607);
		expression();
		state._fsp--;
		if (state.failed) return;

		match(input,56,FOLLOW_56_in_synpred8_While609); if (state.failed) return;

		pushFollow(FOLLOW_commands_in_synpred8_While613);
		yes=commands();
		state._fsp--;
		if (state.failed) return;

		match(input,43,FOLLOW_43_in_synpred8_While615); if (state.failed) return;

		pushFollow(FOLLOW_commands_in_synpred8_While619);
		no=commands();
		state._fsp--;
		if (state.failed) return;

		match(input,44,FOLLOW_44_in_synpred8_While621); if (state.failed) return;

		}

	}
	// $ANTLR end synpred8_While

	// $ANTLR start synpred9_While
	public final void synpred9_While_fragment() throws RecognitionException {
		ParserRuleReturnScope yes =null;


		// While.g:95:7: ( 'if' expression 'then' yes= commands 'fi' )
		// While.g:95:7: 'if' expression 'then' yes= commands 'fi'
		{
		match(input,49,FOLLOW_49_in_synpred9_While650); if (state.failed) return;

		pushFollow(FOLLOW_expression_in_synpred9_While652);
		expression();
		state._fsp--;
		if (state.failed) return;

		match(input,56,FOLLOW_56_in_synpred9_While654); if (state.failed) return;

		pushFollow(FOLLOW_commands_in_synpred9_While658);
		yes=commands();
		state._fsp--;
		if (state.failed) return;

		match(input,44,FOLLOW_44_in_synpred9_While660); if (state.failed) return;

		}

	}
	// $ANTLR end synpred9_While

	// $ANTLR start synpred14_While
	public final void synpred14_While_fragment() throws RecognitionException {
		ParserRuleReturnScope left =null;
		ParserRuleReturnScope right =null;


		// While.g:122:7: (left= exprBase '=?' right= exprBase )
		// While.g:122:7: left= exprBase '=?' right= exprBase
		{
		pushFollow(FOLLOW_exprBase_in_synpred14_While882);
		left=exprBase();
		state._fsp--;
		if (state.failed) return;

		match(input,40,FOLLOW_40_in_synpred14_While884); if (state.failed) return;

		pushFollow(FOLLOW_exprBase_in_synpred14_While888);
		right=exprBase();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred14_While

	// Delegated rules

	public final boolean synpred8_While() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred8_While_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred9_While() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred9_While_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred14_While() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred14_While_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}



	public static final BitSet FOLLOW_function_in_program330 = new BitSet(new long[]{0x0000800000000000L});
	public static final BitSet FOLLOW_EOF_in_program333 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_47_in_function360 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_Symbol_in_function364 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_37_in_function366 = new BitSet(new long[]{0x0080000000000000L});
	public static final BitSet FOLLOW_55_in_function368 = new BitSet(new long[]{0x0000000240000000L});
	public static final BitSet FOLLOW_inputs_in_function378 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_33_in_function380 = new BitSet(new long[]{0x0422600040000000L});
	public static final BitSet FOLLOW_commands_in_function384 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_33_in_function386 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_59_in_function388 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_outputs_in_function392 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Variable_in_inputs435 = new BitSet(new long[]{0x0000001000000002L});
	public static final BitSet FOLLOW_36_in_inputs438 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_Variable_in_inputs440 = new BitSet(new long[]{0x0000001000000002L});
	public static final BitSet FOLLOW_Variable_in_outputs477 = new BitSet(new long[]{0x0000001000000002L});
	public static final BitSet FOLLOW_36_in_outputs480 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_Variable_in_outputs482 = new BitSet(new long[]{0x0000001000000002L});
	public static final BitSet FOLLOW_command_in_commands517 = new BitSet(new long[]{0x0000008000000002L});
	public static final BitSet FOLLOW_39_in_commands520 = new BitSet(new long[]{0x0422600040000000L});
	public static final BitSet FOLLOW_command_in_commands522 = new BitSet(new long[]{0x0000008000000002L});
	public static final BitSet FOLLOW_53_in_command557 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_vars_in_command576 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_38_in_command578 = new BitSet(new long[]{0x0010000444000000L});
	public static final BitSet FOLLOW_exprs_in_command580 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_49_in_command605 = new BitSet(new long[]{0x0010000444000000L});
	public static final BitSet FOLLOW_expression_in_command607 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_56_in_command609 = new BitSet(new long[]{0x0422600040000000L});
	public static final BitSet FOLLOW_commands_in_command613 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_43_in_command615 = new BitSet(new long[]{0x0422600040000000L});
	public static final BitSet FOLLOW_commands_in_command619 = new BitSet(new long[]{0x0000100000000000L});
	public static final BitSet FOLLOW_44_in_command621 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_49_in_command650 = new BitSet(new long[]{0x0010000444000000L});
	public static final BitSet FOLLOW_expression_in_command652 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_56_in_command654 = new BitSet(new long[]{0x0422600040000000L});
	public static final BitSet FOLLOW_commands_in_command658 = new BitSet(new long[]{0x0000100000000000L});
	public static final BitSet FOLLOW_44_in_command660 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_58_in_command686 = new BitSet(new long[]{0x0010000444000000L});
	public static final BitSet FOLLOW_expression_in_command688 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_42_in_command690 = new BitSet(new long[]{0x0422600040000000L});
	public static final BitSet FOLLOW_commands_in_command692 = new BitSet(new long[]{0x0040000000000000L});
	public static final BitSet FOLLOW_54_in_command694 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_45_in_command719 = new BitSet(new long[]{0x0010000444000000L});
	public static final BitSet FOLLOW_expression_in_command721 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_42_in_command723 = new BitSet(new long[]{0x0422600040000000L});
	public static final BitSet FOLLOW_commands_in_command725 = new BitSet(new long[]{0x0040000000000000L});
	public static final BitSet FOLLOW_54_in_command727 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_46_in_command752 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_Variable_in_command754 = new BitSet(new long[]{0x0004000000000000L});
	public static final BitSet FOLLOW_50_in_command756 = new BitSet(new long[]{0x0010000444000000L});
	public static final BitSet FOLLOW_expression_in_command758 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_42_in_command760 = new BitSet(new long[]{0x0422600040000000L});
	public static final BitSet FOLLOW_commands_in_command762 = new BitSet(new long[]{0x0040000000000000L});
	public static final BitSet FOLLOW_54_in_command764 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Variable_in_vars800 = new BitSet(new long[]{0x0000001000000002L});
	public static final BitSet FOLLOW_36_in_vars803 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_Variable_in_vars805 = new BitSet(new long[]{0x0000001000000002L});
	public static final BitSet FOLLOW_expression_in_exprs840 = new BitSet(new long[]{0x0000001000000002L});
	public static final BitSet FOLLOW_36_in_exprs843 = new BitSet(new long[]{0x0010000444000000L});
	public static final BitSet FOLLOW_expression_in_exprs845 = new BitSet(new long[]{0x0000001000000002L});
	public static final BitSet FOLLOW_exprBase_in_expression882 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_40_in_expression884 = new BitSet(new long[]{0x0010000444000000L});
	public static final BitSet FOLLOW_exprBase_in_expression888 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_exprBase_in_expression915 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_52_in_exprBase943 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Variable_in_exprBase962 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Symbol_in_exprBase985 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_34_in_exprBase1008 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_41_in_exprBase1010 = new BitSet(new long[]{0x0010000C44000000L});
	public static final BitSet FOLLOW_exprBase_in_exprBase1012 = new BitSet(new long[]{0x0010000C44000000L});
	public static final BitSet FOLLOW_35_in_exprBase1015 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_34_in_exprBase1039 = new BitSet(new long[]{0x0008000000000000L});
	public static final BitSet FOLLOW_51_in_exprBase1041 = new BitSet(new long[]{0x0010000C44000000L});
	public static final BitSet FOLLOW_exprBase_in_exprBase1043 = new BitSet(new long[]{0x0010000C44000000L});
	public static final BitSet FOLLOW_35_in_exprBase1046 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_34_in_exprBase1070 = new BitSet(new long[]{0x0001000000000000L});
	public static final BitSet FOLLOW_48_in_exprBase1072 = new BitSet(new long[]{0x0010000444000000L});
	public static final BitSet FOLLOW_exprBase_in_exprBase1074 = new BitSet(new long[]{0x0000000800000000L});
	public static final BitSet FOLLOW_35_in_exprBase1076 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_34_in_exprBase1099 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_57_in_exprBase1101 = new BitSet(new long[]{0x0010000444000000L});
	public static final BitSet FOLLOW_exprBase_in_exprBase1103 = new BitSet(new long[]{0x0000000800000000L});
	public static final BitSet FOLLOW_35_in_exprBase1105 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_34_in_exprBase1128 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_Symbol_in_exprBase1132 = new BitSet(new long[]{0x0010000C44000000L});
	public static final BitSet FOLLOW_exprBase_in_exprBase1134 = new BitSet(new long[]{0x0010000C44000000L});
	public static final BitSet FOLLOW_35_in_exprBase1137 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_49_in_synpred8_While605 = new BitSet(new long[]{0x0010000444000000L});
	public static final BitSet FOLLOW_expression_in_synpred8_While607 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_56_in_synpred8_While609 = new BitSet(new long[]{0x0422600040000000L});
	public static final BitSet FOLLOW_commands_in_synpred8_While613 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_43_in_synpred8_While615 = new BitSet(new long[]{0x0422600040000000L});
	public static final BitSet FOLLOW_commands_in_synpred8_While619 = new BitSet(new long[]{0x0000100000000000L});
	public static final BitSet FOLLOW_44_in_synpred8_While621 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_49_in_synpred9_While650 = new BitSet(new long[]{0x0010000444000000L});
	public static final BitSet FOLLOW_expression_in_synpred9_While652 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_56_in_synpred9_While654 = new BitSet(new long[]{0x0422600040000000L});
	public static final BitSet FOLLOW_commands_in_synpred9_While658 = new BitSet(new long[]{0x0000100000000000L});
	public static final BitSet FOLLOW_44_in_synpred9_While660 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_exprBase_in_synpred14_While882 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_40_in_synpred14_While884 = new BitSet(new long[]{0x0010000444000000L});
	public static final BitSet FOLLOW_exprBase_in_synpred14_While888 = new BitSet(new long[]{0x0000000000000002L});
}
