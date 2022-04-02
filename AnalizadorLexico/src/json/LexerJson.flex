package json;
import java_cup.runtime.Symbol;
%%
%class LexerJson
%type java_cup.runtime.Symbol
%cup
%full
%line
%column
%state STRING

LineTerminator = \r|\n|\r\n
InputCharacter = [^\r\n]
WhiteSpace     = {LineTerminator} | [ \t\f]
/* comments */
Comment = {TraditionalComment} | {EndOfLineComment} | {DocumentationComment}

TraditionalComment   = "/*" [^*] ~"*/" | "/*" "*"+ "/"
// Comment can be the last line of the file, without line terminator.
EndOfLineComment     = "//" {InputCharacter}* {LineTerminator}?
DocumentationComment = "/**" {CommentContent} "*"+ "/"
CommentContent       = ( [^*] | \*+ [^/*] )*


NUMERO = 0 | [1-9][0-9]*
IDENTIFICADOR = [:jletter:] [:jletterdigit:]*

%{
   StringBuffer string = new StringBuffer();
   String lexema = "";

   private Symbol symbol(int type) {
   return new Symbol(type, yyline, yycolumn);
   }
   private Symbol symbol(int type, Object value) {
   return new Symbol(type, yyline, yycolumn, value);
   }
%}
%%


/*PALABRAS RESERVADAS*/

<YYINITIAL>"Clases" {return new Symbol(sym.CLASES, yycolumn, yyline, yytext());}
<YYINITIAL>"Metodos" {return new Symbol(sym.METODOS, yycolumn, yyline, yytext());}
<YYINITIAL>"Variables" {return new Symbol(sym.VARIABLES, yycolumn, yyline, yytext());}
<YYINITIAL>"Nombre" {return new Symbol(sym.NOMBRE, yycolumn, yyline, yytext());}
<YYINITIAL>"Tipo" {return new Symbol(sym.TIPO, yycolumn, yyline, yytext());}
<YYINITIAL>"Funcion" {return new Symbol(sym.FUNCION, yycolumn, yyline, yytext());}
<YYINITIAL>"Parametros" {return new Symbol(sym.PARAMETROS, yycolumn, yyline, yytext());}


<YYINITIAL>{

"{" {return new Symbol(sym.LLAVES_A, yycolumn, yyline, yytext());}
"}" {return new Symbol(sym.LLAVES_C, yycolumn, yyline, yytext());}
":" {return new Symbol(sym.DOS_PUNTOS, yycolumn, yyline, yytext());}
";" {return new Symbol(sym.P_COMA, yycolumn, yyline, yytext());}
"," {return new Symbol(sym.COMA, yycolumn, yyline, yytext());}
\.  {return new Symbol(sym.PUNTO, yycolumn, yyline, yytext());}
"[" {return new Symbol(sym.CORCHETE_A, yycolumn, yyline, yytext());}
"]" {return new Symbol(sym.CORCHETE_C, yycolumn, yyline, yytext());}
"\"" {return new Symbol(sym.COMILLAS, yycolumn, yyline, yytext());}
(\")(.)*(\")  {return new Symbol(sym.CADENA, yycolumn, yyline, yytext());}
{IDENTIFICADOR} {return new Symbol(sym.IDENTIFICADOR, yycolumn, yyline, yytext());}
{NUMERO}  {return new Symbol(sym.NUMERO, yycolumn, yyline, yytext());}
{Comment} {/*ignorarr*/}
{WhiteSpace} {/*ignorarr*/}
}


