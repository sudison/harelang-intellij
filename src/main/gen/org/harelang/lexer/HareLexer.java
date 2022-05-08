/* The following code was generated by JFlex 1.7.0 tweaked for IntelliJ platform */

package org.harelang.lexer;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import org.harelang.parser.psi.HareTypes;
import org.harelang.parser.psi.HareElementType;
import com.intellij.psi.TokenType;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.7.0
 * from the specification file <tt>harelang.flex</tt>
 */
class HareLexer implements FlexLexer {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0, 0
  };

  /** 
   * Translates characters to character classes
   * Chosen bits are [10, 6, 5]
   * Total runtime size is 4224 bytes
   */
  public static int ZZ_CMAP(int ch) {
    return ZZ_CMAP_A[(ZZ_CMAP_Y[(ZZ_CMAP_Z[ch>>11]<<6)|((ch>>5)&0x3f)]<<5)|(ch&0x1f)];
  }

  /* The ZZ_CMAP_Z table has 544 entries */
  static final char ZZ_CMAP_Z[] = zzUnpackCMap(
    "\1\0\1\1\1\2\1\3\1\4\1\5\1\6\15\5\1\7\1\10\11\5\1\11\1\12\1\5\1\13\1\14\11"+
    "\5\1\15\14\5\1\16\2\5\1\17\u01e2\5");

  /* The ZZ_CMAP_Y table has 1024 entries */
  static final char ZZ_CMAP_Y[] = zzUnpackCMap(
    "\1\0\1\1\1\2\1\3\1\4\1\5\55\6\1\7\3\6\1\10\6\6\1\7\14\6\1\11\3\6\1\11\3\6"+
    "\1\11\3\6\1\11\3\6\1\11\3\6\1\11\3\6\1\11\3\6\1\11\3\6\1\11\3\6\1\11\2\6\1"+
    "\10\3\6\1\10\2\6\1\7\10\6\1\7\1\6\1\10\57\6\1\5\12\6\1\7\1\10\11\6\1\11\3"+
    "\6\1\10\5\6\1\12\5\6\1\10\2\6\1\10\4\6\1\12\35\6\1\13\1\14\1\15\175\6\1\5"+
    "\160\6\1\7\24\6\1\10\1\6\1\7\5\6\2\10\2\6\1\10\14\6\1\10\130\6\1\10\54\6\1"+
    "\7\35\6\1\11\3\6\1\10\1\6\1\16\4\6\1\10\10\6\1\10\12\6\1\10\3\6\1\10\13\6"+
    "\1\10\3\6\1\7\2\6\1\10\15\6\1\7\32\6\1\10\60\6\1\7\6\6\1\10\143\6\1\17\1\20"+
    "\12\6\1\10\65\6");

  /* The ZZ_CMAP_A table has 544 entries */
  static final char ZZ_CMAP_A[] = zzUnpackCMap(
    "\11\0\1\10\1\5\3\7\22\0\1\10\1\27\1\6\2\0\1\14\1\15\1\0\1\32\1\33\1\13\1\16"+
    "\1\25\1\23\1\36\1\4\1\3\1\42\1\45\1\44\1\46\1\3\1\43\1\3\1\41\1\3\1\26\1\24"+
    "\1\21\1\12\1\22\1\37\1\0\32\1\1\30\1\0\1\31\1\17\1\2\1\0\1\63\1\57\1\64\1"+
    "\66\1\54\1\67\1\73\1\65\1\40\2\1\1\61\1\72\1\50\1\60\1\55\1\1\1\56\1\52\1"+
    "\51\1\47\1\62\1\1\1\70\1\71\1\53\1\34\1\20\1\35\7\0\1\7\32\0\1\10\77\0\12"+
    "\11\46\0\12\11\14\0\12\11\20\0\12\11\6\0\12\11\6\0\13\10\35\0\2\7\5\0\1\10"+
    "\57\0\1\10\26\0\12\11\16\0\62\11");

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\1"+
    "\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16"+
    "\1\17\1\20\1\21\1\22\1\23\1\24\1\25\1\26"+
    "\1\27\1\30\1\31\1\32\1\33\1\34\17\2\1\35"+
    "\1\36\1\0\1\37\1\40\1\41\1\42\1\43\1\44"+
    "\1\45\1\46\1\47\1\50\1\51\1\52\1\53\1\54"+
    "\1\55\1\56\1\57\1\60\1\61\1\62\4\2\1\63"+
    "\1\2\1\64\34\2\1\65\3\2\1\35\1\66\1\67"+
    "\1\70\1\71\1\72\1\73\1\74\1\75\1\76\1\77"+
    "\2\2\1\100\1\101\1\102\1\2\1\103\4\2\1\104"+
    "\7\2\1\105\1\106\14\2\1\107\1\110\1\111\1\2"+
    "\1\112\2\2\1\113\1\2\1\114\1\115\1\116\1\117"+
    "\2\2\1\120\1\121\1\2\1\122\1\123\1\2\1\124"+
    "\11\2\1\125\2\2\1\126\3\2\1\127\6\2\1\130"+
    "\1\2\1\131\2\2\1\132\1\133\1\134\1\2\1\135"+
    "\1\136\1\137\2\2\1\140\1\141\1\142\1\143\1\2"+
    "\1\144\1\145\1\146\1\147\1\150\1\2\1\151\1\152";

  private static int [] zzUnpackAction() {
    int [] result = new int[223];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\74\0\170\0\170\0\264\0\360\0\74\0\u012c"+
    "\0\u0168\0\u01a4\0\u01e0\0\u021c\0\u0258\0\u0294\0\u02d0\0\u030c"+
    "\0\u0348\0\u0384\0\74\0\74\0\u03c0\0\u03fc\0\74\0\74"+
    "\0\74\0\74\0\74\0\74\0\u0438\0\74\0\u0474\0\u04b0"+
    "\0\u04ec\0\u0528\0\u0564\0\u05a0\0\u05dc\0\u0618\0\u0654\0\u0690"+
    "\0\u06cc\0\u0708\0\u0744\0\u0780\0\u07bc\0\u07f8\0\74\0\u012c"+
    "\0\u012c\0\74\0\74\0\74\0\74\0\u0834\0\74\0\74"+
    "\0\u0870\0\74\0\u08ac\0\74\0\u08e8\0\74\0\u0924\0\74"+
    "\0\74\0\74\0\u0960\0\170\0\u099c\0\u09d8\0\u0a14\0\u0a50"+
    "\0\170\0\u0a8c\0\170\0\u0ac8\0\u0b04\0\u0b40\0\u0b7c\0\u0bb8"+
    "\0\u0bf4\0\u0c30\0\u0c6c\0\u0ca8\0\u0ce4\0\u0d20\0\u0d5c\0\u0d98"+
    "\0\u0dd4\0\u0e10\0\u0e4c\0\u0e88\0\u0ec4\0\u0f00\0\u0f3c\0\u0f78"+
    "\0\u0fb4\0\u0ff0\0\u102c\0\u1068\0\u10a4\0\u10e0\0\u111c\0\170"+
    "\0\u1158\0\u1194\0\u11d0\0\74\0\74\0\74\0\74\0\74"+
    "\0\74\0\74\0\170\0\170\0\170\0\170\0\u120c\0\u1248"+
    "\0\170\0\170\0\170\0\u1284\0\170\0\u12c0\0\u12fc\0\u1338"+
    "\0\u1374\0\u13b0\0\u13ec\0\u1428\0\u1464\0\u14a0\0\u14dc\0\u1518"+
    "\0\u1554\0\170\0\170\0\u1590\0\u15cc\0\u1608\0\u1644\0\u1680"+
    "\0\u16bc\0\u16f8\0\u1734\0\u1770\0\u17ac\0\u17e8\0\u1824\0\u1860"+
    "\0\170\0\170\0\u189c\0\170\0\u18d8\0\u1914\0\u1950\0\u198c"+
    "\0\u19c8\0\170\0\170\0\170\0\u1a04\0\u1a40\0\170\0\170"+
    "\0\u1a7c\0\170\0\170\0\u1ab8\0\170\0\u1af4\0\u1b30\0\u1b6c"+
    "\0\u1ba8\0\u1be4\0\u1c20\0\u1c5c\0\u1c98\0\u1cd4\0\170\0\u1d10"+
    "\0\u1d4c\0\170\0\u1d88\0\u1dc4\0\u1e00\0\170\0\u1e3c\0\u1e78"+
    "\0\u1eb4\0\u1ef0\0\u1f2c\0\u1f68\0\170\0\u1fa4\0\170\0\u1fe0"+
    "\0\u201c\0\170\0\170\0\170\0\u2058\0\170\0\170\0\170"+
    "\0\u2094\0\u20d0\0\170\0\170\0\170\0\170\0\u210c\0\170"+
    "\0\170\0\170\0\170\0\170\0\u2148\0\170\0\170";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[223];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\1\3\1\4\1\5\1\6\1\7\1\10\2\7"+
    "\1\5\1\11\1\12\1\13\1\14\1\15\1\16\1\17"+
    "\1\20\1\21\1\22\1\23\1\24\1\25\1\26\1\27"+
    "\1\30\1\31\1\32\1\33\1\34\1\35\1\36\1\37"+
    "\6\5\1\40\1\41\1\42\1\43\1\3\1\44\1\3"+
    "\1\45\1\46\1\47\1\50\1\51\1\52\1\53\1\3"+
    "\1\54\1\55\4\3\75\0\3\3\34\0\34\3\3\0"+
    "\1\5\5\0\1\5\27\0\6\5\31\0\1\56\5\0"+
    "\1\57\61\0\5\60\1\0\1\61\1\0\64\60\12\0"+
    "\1\62\73\0\1\63\73\0\1\64\73\0\1\65\2\0"+
    "\1\66\70\0\1\67\73\0\1\70\4\0\1\71\66\0"+
    "\1\72\5\0\1\73\65\0\1\74\6\0\1\75\64\0"+
    "\1\76\7\0\1\77\63\0\1\100\107\0\1\101\57\0"+
    "\1\102\117\0\1\103\36\0\3\3\34\0\1\3\1\104"+
    "\1\105\1\106\1\107\3\3\1\110\16\3\1\111\4\3"+
    "\1\0\3\3\34\0\1\112\1\113\1\114\1\115\1\116"+
    "\3\3\1\117\1\3\1\120\21\3\1\0\3\3\34\0"+
    "\7\3\1\121\24\3\1\0\3\3\34\0\16\3\1\122"+
    "\12\3\1\123\2\3\1\0\3\3\34\0\1\124\10\3"+
    "\1\125\22\3\1\0\3\3\34\0\10\3\1\126\10\3"+
    "\1\127\6\3\1\130\3\3\1\0\3\3\34\0\7\3"+
    "\1\131\24\3\1\0\3\3\34\0\20\3\1\132\13\3"+
    "\1\0\3\3\34\0\27\3\1\133\4\3\1\0\3\3"+
    "\34\0\14\3\1\134\17\3\1\0\3\3\34\0\20\3"+
    "\1\135\2\3\1\136\10\3\1\0\3\3\34\0\12\3"+
    "\1\137\2\3\1\140\1\3\1\141\1\3\1\142\12\3"+
    "\1\0\3\3\34\0\20\3\1\143\4\3\1\144\6\3"+
    "\1\0\3\3\34\0\14\3\1\145\17\3\1\0\3\3"+
    "\34\0\3\3\1\146\1\147\3\3\1\150\5\3\1\151"+
    "\1\3\1\152\2\3\1\153\10\3\5\56\1\154\66\56"+
    "\12\0\1\155\73\0\1\156\73\0\1\157\73\0\1\160"+
    "\73\0\1\161\117\0\1\162\36\0\3\3\34\0\3\3"+
    "\1\163\30\3\1\0\3\3\34\0\6\3\1\164\25\3"+
    "\1\0\3\3\34\0\5\3\1\165\26\3\1\0\3\3"+
    "\34\0\11\3\1\166\1\167\21\3\1\0\3\3\34\0"+
    "\10\3\1\170\23\3\1\0\3\3\34\0\3\3\1\171"+
    "\30\3\1\0\3\3\34\0\6\3\1\172\25\3\1\0"+
    "\3\3\34\0\5\3\1\173\26\3\1\0\3\3\34\0"+
    "\1\174\33\3\1\0\3\3\34\0\14\3\1\175\17\3"+
    "\1\0\3\3\34\0\21\3\1\176\12\3\1\0\3\3"+
    "\34\0\7\3\1\177\24\3\1\0\3\3\34\0\15\3"+
    "\1\200\16\3\1\0\3\3\34\0\13\3\1\201\20\3"+
    "\1\0\3\3\34\0\16\3\1\202\4\3\1\203\10\3"+
    "\1\0\3\3\34\0\7\3\1\204\24\3\1\0\3\3"+
    "\34\0\12\3\1\205\21\3\1\0\3\3\34\0\15\3"+
    "\1\206\16\3\1\0\3\3\34\0\10\3\1\207\23\3"+
    "\1\0\3\3\34\0\20\3\1\210\13\3\1\0\3\3"+
    "\34\0\27\3\1\211\4\3\1\0\3\3\34\0\10\3"+
    "\1\212\1\213\22\3\1\0\3\3\34\0\1\214\33\3"+
    "\1\0\3\3\34\0\12\3\1\215\1\3\1\216\4\3"+
    "\1\217\1\3\1\220\10\3\1\0\3\3\34\0\12\3"+
    "\1\221\21\3\1\0\3\3\34\0\15\3\1\222\16\3"+
    "\1\0\3\3\34\0\20\3\1\223\13\3\1\0\3\3"+
    "\34\0\21\3\1\224\12\3\1\0\3\3\34\0\10\3"+
    "\1\225\23\3\1\0\3\3\34\0\23\3\1\226\10\3"+
    "\1\0\3\3\34\0\21\3\1\227\5\3\1\230\4\3"+
    "\1\0\3\3\34\0\6\3\1\231\25\3\1\0\3\3"+
    "\34\0\5\3\1\232\26\3\1\0\3\3\34\0\14\3"+
    "\1\233\17\3\1\0\3\3\34\0\16\3\1\234\15\3"+
    "\1\0\3\3\34\0\21\3\1\235\12\3\1\0\3\3"+
    "\34\0\14\3\1\236\17\3\1\0\3\3\34\0\11\3"+
    "\1\237\22\3\1\0\3\3\34\0\20\3\1\240\13\3"+
    "\1\0\3\3\34\0\21\3\1\241\12\3\1\0\3\3"+
    "\34\0\14\3\1\242\17\3\1\0\3\3\34\0\14\3"+
    "\1\243\17\3\1\0\3\3\34\0\14\3\1\244\17\3"+
    "\1\0\3\3\34\0\7\3\1\245\24\3\1\0\3\3"+
    "\34\0\11\3\1\246\22\3\1\0\3\3\34\0\32\3"+
    "\1\247\1\3\1\0\3\3\34\0\14\3\1\250\17\3"+
    "\1\0\3\3\34\0\20\3\1\251\13\3\1\0\3\3"+
    "\34\0\14\3\1\252\17\3\1\0\3\3\34\0\21\3"+
    "\1\253\12\3\1\0\3\3\34\0\12\3\1\254\21\3"+
    "\1\0\3\3\34\0\26\3\1\255\5\3\1\0\3\3"+
    "\34\0\11\3\1\256\22\3\1\0\3\3\34\0\10\3"+
    "\1\257\23\3\1\0\3\3\34\0\1\260\33\3\1\0"+
    "\3\3\34\0\16\3\1\261\15\3\1\0\3\3\34\0"+
    "\14\3\1\262\17\3\1\0\3\3\34\0\14\3\1\263"+
    "\17\3\1\0\3\3\34\0\16\3\1\264\15\3\1\0"+
    "\3\3\34\0\20\3\1\265\13\3\1\0\3\3\34\0"+
    "\12\3\1\266\21\3\1\0\3\3\34\0\16\3\1\267"+
    "\15\3\1\0\3\3\34\0\14\3\1\270\17\3\1\0"+
    "\3\3\34\0\14\3\1\271\17\3\1\0\3\3\34\0"+
    "\14\3\1\272\17\3\1\0\3\3\34\0\12\3\1\273"+
    "\21\3\1\0\3\3\34\0\16\3\1\274\15\3\1\0"+
    "\3\3\34\0\15\3\1\275\16\3\1\0\3\3\34\0"+
    "\10\3\1\276\23\3\1\0\3\3\34\0\23\3\1\277"+
    "\10\3\1\0\3\3\34\0\24\3\1\300\7\3\1\0"+
    "\3\3\34\0\1\301\33\3\1\0\3\3\34\0\16\3"+
    "\1\302\15\3\1\0\3\3\34\0\14\3\1\303\17\3"+
    "\1\0\3\3\34\0\23\3\1\304\10\3\1\0\3\3"+
    "\34\0\26\3\1\305\5\3\1\0\3\3\34\0\12\3"+
    "\1\306\21\3\1\0\3\3\34\0\33\3\1\307\1\0"+
    "\3\3\34\0\16\3\1\310\15\3\1\0\3\3\34\0"+
    "\10\3\1\311\23\3\1\0\3\3\34\0\11\3\1\312"+
    "\22\3\1\0\3\3\34\0\24\3\1\313\7\3\1\0"+
    "\3\3\34\0\11\3\1\314\22\3\1\0\3\3\34\0"+
    "\11\3\1\315\22\3\1\0\3\3\34\0\16\3\1\316"+
    "\15\3\1\0\3\3\34\0\14\3\1\317\17\3\1\0"+
    "\3\3\34\0\11\3\1\320\22\3\1\0\3\3\34\0"+
    "\11\3\1\321\22\3\1\0\3\3\34\0\17\3\1\322"+
    "\14\3\1\0\3\3\34\0\11\3\1\323\22\3\1\0"+
    "\3\3\34\0\24\3\1\324\7\3\1\0\3\3\34\0"+
    "\11\3\1\325\22\3\1\0\3\3\34\0\11\3\1\326"+
    "\22\3\1\0\3\3\34\0\16\3\1\327\15\3\1\0"+
    "\3\3\34\0\11\3\1\330\22\3\1\0\3\3\34\0"+
    "\11\3\1\331\22\3\1\0\3\3\34\0\26\3\1\332"+
    "\5\3\1\0\3\3\34\0\14\3\1\333\17\3\1\0"+
    "\3\3\34\0\16\3\1\334\15\3\1\0\3\3\34\0"+
    "\21\3\1\335\12\3\1\0\3\3\34\0\11\3\1\336"+
    "\22\3\1\0\3\3\34\0\14\3\1\337\17\3";

  private static int [] zzUnpackTrans() {
    int [] result = new int[8580];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String[] ZZ_ERROR_MSG = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\1\11\4\1\1\11\13\1\2\11\2\1\6\11"+
    "\1\1\1\11\20\1\1\11\1\0\1\1\4\11\1\1"+
    "\2\11\1\1\1\11\1\1\1\11\1\1\1\11\1\1"+
    "\3\11\51\1\7\11\155\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[223];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private CharSequence zzBuffer = "";

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /**
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  HareLexer(java.io.Reader in) {
    this.zzReader = in;
  }


  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    int size = 0;
    for (int i = 0, length = packed.length(); i < length; i += 2) {
      size += packed.charAt(i);
    }
    char[] map = new char[size];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < packed.length()) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }

  public final int getTokenStart() {
    return zzStartRead;
  }

  public final int getTokenEnd() {
    return getTokenStart() + yylength();
  }

  public void reset(CharSequence buffer, int start, int end, int initialState) {
    zzBuffer = buffer;
    zzCurrentPos = zzMarkedPos = zzStartRead = start;
    zzAtEOF  = false;
    zzAtBOL = true;
    zzEndRead = end;
    yybegin(initialState);
  }

  /**
   * Refills the input buffer.
   *
   * @return      {@code false}, iff there was new input.
   *
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {
    return true;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final CharSequence yytext() {
    return zzBuffer.subSequence(zzStartRead, zzMarkedPos);
  }


  /**
   * Returns the character at position {@code pos} from the
   * matched text.
   *
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch.
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer.charAt(zzStartRead+pos);
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occurred while scanning.
   *
   * In a wellformed scanner (no or only correct usage of
   * yypushback(int) and a match-all fallback rule) this method
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  }


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() {
    if (!zzEOFDone) {
      zzEOFDone = true;
    
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public IElementType advance() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    CharSequence zzBufferL = zzBuffer;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {

          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL/*, zzEndReadL*/);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL/*, zzEndReadL*/);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + ZZ_CMAP(zzInput) ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
        zzDoEOF();
        return null;
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1: 
            { return TokenType.BAD_CHARACTER;
            } 
            // fall through
          case 107: break;
          case 2: 
            { return HareTypes.IDENTIFIER;
            } 
            // fall through
          case 108: break;
          case 3: 
            { return HareTypes.UNDERSCORE;
            } 
            // fall through
          case 109: break;
          case 4: 
            { return HareTypes.DECIMAL_DIGITS;
            } 
            // fall through
          case 110: break;
          case 5: 
            { return HareTypes.DIVIDES;
            } 
            // fall through
          case 111: break;
          case 6: 
            { return TokenType.WHITE_SPACE;
            } 
            // fall through
          case 112: break;
          case 7: 
            { return HareTypes.ASSIGN;
            } 
            // fall through
          case 113: break;
          case 8: 
            { return HareTypes.MULTIPLIES;
            } 
            // fall through
          case 114: break;
          case 9: 
            { return HareTypes.MODULUS;
            } 
            // fall through
          case 115: break;
          case 10: 
            { return HareTypes.AND;
            } 
            // fall through
          case 116: break;
          case 11: 
            { return HareTypes.ADDS;
            } 
            // fall through
          case 117: break;
          case 12: 
            { return HareTypes.EXCLUSIVE_OR;
            } 
            // fall through
          case 118: break;
          case 13: 
            { return HareTypes.INCLUSIVE_OR;
            } 
            // fall through
          case 119: break;
          case 14: 
            { return HareTypes.LESSER_THAN;
            } 
            // fall through
          case 120: break;
          case 15: 
            { return HareTypes.LARGER_THAN;
            } 
            // fall through
          case 121: break;
          case 16: 
            { return HareTypes.SUBSTRACTS;
            } 
            // fall through
          case 122: break;
          case 17: 
            { return HareTypes.EOS;
            } 
            // fall through
          case 123: break;
          case 18: 
            { return HareTypes.COMMA;
            } 
            // fall through
          case 124: break;
          case 19: 
            { return HareTypes.COLON;
            } 
            // fall through
          case 125: break;
          case 20: 
            { return HareTypes.BANG;
            } 
            // fall through
          case 126: break;
          case 21: 
            { return HareTypes.LB;
            } 
            // fall through
          case 127: break;
          case 22: 
            { return HareTypes.RB;
            } 
            // fall through
          case 128: break;
          case 23: 
            { return HareTypes.LP;
            } 
            // fall through
          case 129: break;
          case 24: 
            { return HareTypes.RP;
            } 
            // fall through
          case 130: break;
          case 25: 
            { return HareTypes.LBR;
            } 
            // fall through
          case 131: break;
          case 26: 
            { return HareTypes.RBR;
            } 
            // fall through
          case 132: break;
          case 27: 
            { return HareTypes.DOT;
            } 
            // fall through
          case 133: break;
          case 28: 
            { return HareTypes.QUESTION;
            } 
            // fall through
          case 134: break;
          case 29: 
            { return HareElementType.Companion.getCOMMENT();
            } 
            // fall through
          case 135: break;
          case 30: 
            { return HareTypes.DIVIDES_ASSIGN;
            } 
            // fall through
          case 136: break;
          case 31: 
            { return HareTypes.STRING_LITERAL;
            } 
            // fall through
          case 137: break;
          case 32: 
            { return HareTypes.EQUAL;
            } 
            // fall through
          case 138: break;
          case 33: 
            { return HareTypes.MULTIPLIES_ASSIGN;
            } 
            // fall through
          case 139: break;
          case 34: 
            { return HareTypes.MODULUS_ASSIGN;
            } 
            // fall through
          case 140: break;
          case 35: 
            { return HareTypes.AND_ASSIGN;
            } 
            // fall through
          case 141: break;
          case 36: 
            { return HareTypes.LOGICAL_AND;
            } 
            // fall through
          case 142: break;
          case 37: 
            { return HareTypes.PLUS_ASSIGN;
            } 
            // fall through
          case 143: break;
          case 38: 
            { return HareTypes.XOR_ASSIGN;
            } 
            // fall through
          case 144: break;
          case 39: 
            { return HareTypes.LOGICAL_XOR;
            } 
            // fall through
          case 145: break;
          case 40: 
            { return HareTypes.OR_ASSIGN;
            } 
            // fall through
          case 146: break;
          case 41: 
            { return HareTypes.LOGICAL_OR;
            } 
            // fall through
          case 147: break;
          case 42: 
            { return HareTypes.LESSER_EQUAL;
            } 
            // fall through
          case 148: break;
          case 43: 
            { return HareTypes.LEFT_SHIFT;
            } 
            // fall through
          case 149: break;
          case 44: 
            { return HareTypes.LARGER_EQUAL;
            } 
            // fall through
          case 150: break;
          case 45: 
            { return HareTypes.RIGHT_SHIFT;
            } 
            // fall through
          case 151: break;
          case 46: 
            { return HareTypes.MINUS_ASSIGN;
            } 
            // fall through
          case 152: break;
          case 47: 
            { return HareTypes.SCOPE;
            } 
            // fall through
          case 153: break;
          case 48: 
            { return HareTypes.NOT_EQUAL;
            } 
            // fall through
          case 154: break;
          case 49: 
            { return HareTypes.DOTDOT;
            } 
            // fall through
          case 155: break;
          case 50: 
            { return HareTypes.I8_TYPE;
            } 
            // fall through
          case 156: break;
          case 51: 
            { return HareTypes.IF_KW;
            } 
            // fall through
          case 157: break;
          case 52: 
            { return HareTypes.U8_TYPE;
            } 
            // fall through
          case 158: break;
          case 53: 
            { return HareTypes.FN_KW;
            } 
            // fall through
          case 159: break;
          case 54: 
            { return HareTypes.LOGICAL_AND_ASSIGN;
            } 
            // fall through
          case 160: break;
          case 55: 
            { return HareTypes.LOGICAL_XOR_ASSIGN;
            } 
            // fall through
          case 161: break;
          case 56: 
            { return HareTypes.LOGICAL_OR_ASSIGN;
            } 
            // fall through
          case 162: break;
          case 57: 
            { return HareTypes.LEFT_SHIFT_ASSIGN;
            } 
            // fall through
          case 163: break;
          case 58: 
            { return HareTypes.RIGHT_SHIFT_ASSIGN;
            } 
            // fall through
          case 164: break;
          case 59: 
            { return HareTypes.DOTDOTDOT;
            } 
            // fall through
          case 165: break;
          case 60: 
            { return HareTypes.I16_TYPE;
            } 
            // fall through
          case 166: break;
          case 61: 
            { return HareTypes.I64_TYPE;
            } 
            // fall through
          case 167: break;
          case 62: 
            { return HareTypes.I32_TYPE;
            } 
            // fall through
          case 168: break;
          case 63: 
            { return HareTypes.INT_TYPE;
            } 
            // fall through
          case 169: break;
          case 64: 
            { return HareTypes.U16_TYPE;
            } 
            // fall through
          case 170: break;
          case 65: 
            { return HareTypes.U64_TYPE;
            } 
            // fall through
          case 171: break;
          case 66: 
            { return HareTypes.U32_TYPE;
            } 
            // fall through
          case 172: break;
          case 67: 
            { return HareTypes.USE_KW;
            } 
            // fall through
          case 173: break;
          case 68: 
            { return HareTypes.STR_TYPE;
            } 
            // fall through
          case 174: break;
          case 69: 
            { return HareTypes.LEN_KW;
            } 
            // fall through
          case 175: break;
          case 70: 
            { return HareTypes.LET_KW;
            } 
            // fall through
          case 176: break;
          case 71: 
            { return HareTypes.DEF_KW;
            } 
            // fall through
          case 177: break;
          case 72: 
            { return HareTypes.F64_TYPE;
            } 
            // fall through
          case 178: break;
          case 73: 
            { return HareTypes.F32_TYPE;
            } 
            // fall through
          case 179: break;
          case 74: 
            { return HareTypes.FOR_KW;
            } 
            // fall through
          case 180: break;
          case 75: 
            { return HareTypes.UINT_TYPE;
            } 
            // fall through
          case 181: break;
          case 76: 
            { return HareTypes.NULL_KW;
            } 
            // fall through
          case 182: break;
          case 77: 
            { return HareTypes.TRUE_KW;
            } 
            // fall through
          case 183: break;
          case 78: 
            { return HareTypes.TYPE_KW;
            } 
            // fall through
          case 184: break;
          case 79: 
            { return HareTypes.SIZE_TYPE;
            } 
            // fall through
          case 185: break;
          case 80: 
            { return HareTypes.ENUM_KW;
            } 
            // fall through
          case 186: break;
          case 81: 
            { return HareTypes.ELSE_KW;
            } 
            // fall through
          case 187: break;
          case 82: 
            { return HareTypes.RUNE_KW;
            } 
            // fall through
          case 188: break;
          case 83: 
            { return HareTypes.BOOL_TYPE;
            } 
            // fall through
          case 189: break;
          case 84: 
            { return HareTypes.VOID_TYPE;
            } 
            // fall through
          case 190: break;
          case 85: 
            { return HareTypes.CHAR_TYPE;
            } 
            // fall through
          case 191: break;
          case 86: 
            { return HareTypes.FREE_KW;
            } 
            // fall through
          case 192: break;
          case 87: 
            { return HareTypes.UNION_KW;
            } 
            // fall through
          case 193: break;
          case 88: 
            { return HareTypes.VAEND_KW;
            } 
            // fall through
          case 194: break;
          case 89: 
            { return HareTypes.VAARG_KW;
            } 
            // fall through
          case 195: break;
          case 90: 
            { return HareTypes.ABORT_KW;
            } 
            // fall through
          case 196: break;
          case 91: 
            { return HareTypes.ALLOC_KW;
            } 
            // fall through
          case 197: break;
          case 92: 
            { return HareTypes.CONST_KW;
            } 
            // fall through
          case 198: break;
          case 93: 
            { return HareTypes.DEFER_KW;
            } 
            // fall through
          case 199: break;
          case 94: 
            { return HareTypes.FALSE_KW;
            } 
            // fall through
          case 200: break;
          case 95: 
            { return HareTypes.INSERT_KW;
            } 
            // fall through
          case 201: break;
          case 96: 
            { return HareTypes.STRUCT_KW;
            } 
            // fall through
          case 202: break;
          case 97: 
            { return HareTypes.STATIC_KW;
            } 
            // fall through
          case 203: break;
          case 98: 
            { return HareTypes.EXPORT_KW;
            } 
            // fall through
          case 204: break;
          case 99: 
            { return HareTypes.OFFSET_KW;
            } 
            // fall through
          case 205: break;
          case 100: 
            { return HareTypes.VALIST_TYPE;
            } 
            // fall through
          case 206: break;
          case 101: 
            { return HareTypes.ASSERT_KW;
            } 
            // fall through
          case 207: break;
          case 102: 
            { return HareTypes.APPEND_KW;
            } 
            // fall through
          case 208: break;
          case 103: 
            { return HareTypes.DELETE_KW;
            } 
            // fall through
          case 209: break;
          case 104: 
            { return HareTypes.UINTPTR_TYPE;
            } 
            // fall through
          case 210: break;
          case 105: 
            { return HareTypes.VASTART_KW;
            } 
            // fall through
          case 211: break;
          case 106: 
            { return HareTypes.NULLABLE_KW;
            } 
            // fall through
          case 212: break;
          default:
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
