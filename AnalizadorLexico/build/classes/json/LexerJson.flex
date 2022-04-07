package json;
import java_cup.runtime.*;

%%

%class LexerJson
%unicode
%cup
%line
%column
%public
%caseless

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

LineTerminator = \r|\n|\r\n
WhiteSpace     = {LineTerminator} | [ \t\f]

IDENTIFICADOR = [:jletter:][:jletterdigit:]+
NUMERO = 0 | [1-9][0-9]*
DOUBLE = {NUMERO}"."[0-9]+
%state STRING
%%
<YYINITIAL>"Clases"  {/*System.out.println("CLASES");*/return new Symbol(sym.CLASES, (yyline+1), (yycolumn+1));}
<YYINITIAL>"Score"  {/*System.out.println("SCORE");*/return new Symbol(sym.SCORE, (yyline+1), (yycolumn+1));}
<YYINITIAL>"Variables"  {/*System.out.println("VARIABLES");*/return new Symbol(sym.VARIABLES, (yyline+1), (yycolumn+1));}
<YYINITIAL>"Metodos"  {/*System.out.println("METODOS");*/return new Symbol(sym.METODOS, (yyline+1), (yycolumn+1));}
<YYINITIAL>"Comentarios"  {/*System.out.println("COMENTARIOS");*/return new Symbol(sym.COMENTARIOS, (yyline+1), (yycolumn+1));}
<YYINITIAL>"Nombre"  {/*System.out.println("NOMBRE");*/return new Symbol(sym.NOMBRE, (yyline+1), (yycolumn+1));}
<YYINITIAL>"Tipo"  {/*System.out.println("TIPO");*/return new Symbol(sym.TIPO, (yyline+1), (yycolumn+1));}
<YYINITIAL>"Funcion"  {/*System.out.println("FUNCION");*/return new Symbol(sym.FUNCION, (yyline+1), (yycolumn+1));}
<YYINITIAL>"Parametros"  {/*System.out.println("PARAMETROS");*/return new Symbol(sym.PARAMETROS, (yyline+1), (yycolumn+1));}
<YYINITIAL>"Texto"  {/*System.out.println("TEXTO");*/return new Symbol(sym.TEXTO, (yyline+1), (yycolumn+1));}
<YYINITIAL>":"  {/*System.out.println("COLON");*/return new Symbol(sym.COLON, (yyline+1), (yycolumn+1));}
<YYINITIAL>","  {/*System.out.println("COMA");*/return new Symbol(sym.COMA, (yyline+1), (yycolumn+1));}
<YYINITIAL>"{"  {/*System.out.println("OPENBRACE");*/return new Symbol(sym.OPENBRACE, (yyline+1), (yycolumn+1));}
<YYINITIAL>"}"  {/*System.out.println("CLOSEBRACE");*/return new Symbol(sym.CLOSEBRACE, (yyline+1), (yycolumn+1));}
<YYINITIAL>"["  {/*System.out.println("OPENBRACKET");*/return new Symbol(sym.OPENBRACKET, (yyline+1), (yycolumn+1));}
<YYINITIAL>"]"  {/*System.out.println("CLOSEBRACKET");*/return new Symbol(sym.CLOSEBRACKET, (yyline+1), (yycolumn+1));}
<YYINITIAL>"\""  {/*System.out.println("COMILLA");*/return new Symbol(sym.COMILLA, (yyline+1), (yycolumn+1));}
{NUMERO} {/*System.out.println("NUMERO");*/return new Symbol(sym.NUMERO, yytext());}
{DOUBLE} {/*System.out.println("DECIMAL");*/return new Symbol(sym.DECIMAL, (yyline+1), (yycolumn+1),yytext());}
{IDENTIFICADOR} {/*System.out.println("CADENA");*/return new Symbol(sym.CADENA, (yyline+1), (yycolumn+1),yytext());}
{WhiteSpace} {/*ignorarr*/}

[^] { System.out.println("Caracter ilegal <"+ yytext()+">"); }
