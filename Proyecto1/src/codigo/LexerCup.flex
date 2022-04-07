package codigo;
import java_cup.runtime.Symbol;
%%
%class LexerCup
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


L=[a-zA-Z_]+
IDENTIFICADOR = [:jletter:] [:jletterdigit:]*
NUMERO = 0 | [1-9][0-9]*
DOUBLE = [0-9]+\.[0-9]+
D=[0-9]+

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


<YYINITIAL>"import" {return new Symbol(sym.IMPORT, yycolumn, yyline, yytext());}
<YYINITIAL>"class" {return new Symbol(sym.CLASE, yycolumn, yyline, yytext());}
<YYINITIAL>"void" {return new Symbol(sym.VOID, yycolumn, yyline, yytext());}
<YYINITIAL>"public" {return new Symbol(sym.PUBLIC, yycolumn, yyline, yytext());}
<YYINITIAL>"private" {return new Symbol(sym.PRIVATE, yycolumn, yyline, yytext());}
<YYINITIAL>"protected" {return new Symbol(sym.PROTECTED, yycolumn, yyline, yytext());}
<YYINITIAL>"final" {return new Symbol(sym.FINAL, yycolumn, yyline, yytext());}
<YYINITIAL>"int" {return new Symbol(sym.INT, yycolumn, yyline, yytext());}
<YYINITIAL>"String" {return new Symbol(sym.STRING, yycolumn, yyline, yytext());}
<YYINITIAL>"boolean" {return new Symbol(sym.BOOLEAN, yycolumn, yyline, yytext());}
<YYINITIAL>"char" {return new Symbol(sym.CHAR, yycolumn, yyline, yytext());}
<YYINITIAL>"double" {return new Symbol(sym.DOUBLE, yycolumn, yyline, yytext());}
<YYINITIAL>"if" {return new Symbol(sym.IF, yycolumn, yyline, yytext());}
<YYINITIAL>"else" {return new Symbol(sym.ELSE, yycolumn, yyline, yytext());}
<YYINITIAL>"switch" {return new Symbol(sym.SWITCH, yycolumn, yyline, yytext());}
<YYINITIAL>"case" {return new Symbol(sym.CASE, yycolumn, yyline, yytext());}
<YYINITIAL>"break" {return new Symbol(sym.BREAK, yycolumn, yyline, yytext());}
<YYINITIAL>"for" {return new Symbol(sym.FOR, yycolumn, yyline, yytext());}
<YYINITIAL>"while" {return new Symbol(sym.WHILE, yycolumn, yyline, yytext());}
<YYINITIAL>"do" {return new Symbol(sym.DO, yycolumn, yyline, yytext());}
<YYINITIAL>"return" {return new Symbol(sym.RETURN, yycolumn, yyline, yytext());}

<YYINITIAL>{

"(" {return new Symbol(sym.PARENTESIS_A, yycolumn, yyline, yytext());}
")" {return new Symbol(sym.PARENTESIS_C, yycolumn, yyline, yytext());}
"{" {return new Symbol(sym.LLAVES_A, yycolumn, yyline, yytext());}
"}" {return new Symbol(sym.LLAVES_C, yycolumn, yyline, yytext());}
":" {return new Symbol(sym.DOS_PUNTOS, yycolumn, yyline, yytext());}
";" {return new Symbol(sym.P_COMA, yycolumn, yyline, yytext());}
"," {return new Symbol(sym.COMA, yycolumn, yyline, yytext());}
\.  {return new Symbol(sym.PUNTO, yycolumn, yyline, yytext());}
"[" {return new Symbol(sym.CORCHETE_A, yycolumn, yyline, yytext());}
"]" {return new Symbol(sym.CORCHETE_C, yycolumn, yyline, yytext());}
"=" {return new Symbol(sym.IGUAL, yycolumn, yyline, yytext());}
"+" {return new Symbol(sym.MAS, yycolumn, yyline, yytext());}
"-" {return new Symbol(sym.MENOS, yycolumn, yyline, yytext());}
"/" {return new Symbol(sym.DIVISION, yycolumn, yyline, yytext());}
"*" {return new Symbol(sym.MULTIPLICACION, yycolumn, yyline, yytext());}
"!" {return new Symbol(sym.NEGACION, yycolumn, yyline, yytext());}
"<" {return new Symbol(sym.MENOR, yycolumn, yyline, yytext());}
">" {return new Symbol(sym.MAYOR, yycolumn, yyline, yytext());}

{IDENTIFICADOR} {return new Symbol(sym.IDENTIFICADOR, yycolumn, yyline, yytext());}
{DOUBLE} {return new Symbol(sym.DECIMAL, yycolumn, yyline, yytext());}
{NUMERO} {return new Symbol(sym.NUMERO, yycolumn, yyline, yytext());}  
(\")(.)*(\")  {return new Symbol(sym.CADENA, yycolumn, yyline, yytext());}
{Comment} {/*ignorarr*/}
{WhiteSpace} {/*ignorarr*/}
}


