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
    "\11\0\1\7\1\4\3\6\22\0\1\7\1\34\1\5\2\0\1\13\1\14\1\0\1\30\1\31\1\12\1\15"+
    "\1\24\1\22\1\0\1\3\1\2\1\37\1\42\1\41\1\43\1\2\1\40\1\2\1\36\1\2\1\25\1\23"+
    "\1\20\1\11\1\21\2\0\32\1\1\26\1\0\1\27\1\16\1\1\1\0\1\56\1\1\1\54\1\61\1\51"+
    "\1\62\1\1\1\55\1\35\2\1\1\64\1\1\1\45\1\60\1\52\1\1\1\53\1\47\1\46\1\44\1"+
    "\57\1\1\1\63\1\65\1\50\1\32\1\17\1\33\7\0\1\6\32\0\1\7\77\0\12\10\46\0\12"+
    "\10\14\0\12\10\20\0\12\10\6\0\12\10\6\0\13\7\35\0\2\6\5\0\1\7\57\0\1\7\26"+
    "\0\12\10\16\0\62\10");

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\1\3\1\4\1\5\1\1\1\6"+
    "\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16"+
    "\1\17\1\20\1\21\1\22\1\23\1\24\1\25\1\26"+
    "\1\27\1\30\1\1\13\2\1\31\1\32\1\0\1\33"+
    "\1\34\1\35\1\36\1\37\1\40\1\41\1\42\1\43"+
    "\1\44\1\45\1\46\1\47\1\50\1\51\1\52\1\53"+
    "\1\54\1\55\4\2\1\56\1\2\1\57\17\2\1\60"+
    "\3\2\1\31\1\61\1\62\1\63\1\64\1\65\1\66"+
    "\1\67\1\70\1\71\1\2\1\72\1\73\1\74\1\75"+
    "\12\2\1\76\1\2\1\77\1\100\1\101\1\102\1\103"+
    "\1\104\1\105\2\2\1\106\1\107\1\2\1\110\4\2"+
    "\1\111\1\112\1\2\1\113\1\114\1\115";

  private static int [] zzUnpackAction() {
    int [] result = new int[136];
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
    "\0\0\0\66\0\154\0\242\0\330\0\66\0\u010e\0\u0144"+
    "\0\u017a\0\u01b0\0\u01e6\0\u021c\0\u0252\0\u0288\0\u02be\0\u02f4"+
    "\0\u032a\0\66\0\66\0\u0360\0\66\0\66\0\66\0\66"+
    "\0\66\0\66\0\u0396\0\u03cc\0\u0402\0\u0438\0\u046e\0\u04a4"+
    "\0\u04da\0\u0510\0\u0546\0\u057c\0\u05b2\0\u05e8\0\u061e\0\66"+
    "\0\u010e\0\u010e\0\66\0\66\0\66\0\66\0\u0654\0\66"+
    "\0\66\0\u068a\0\66\0\u06c0\0\66\0\u06f6\0\66\0\u072c"+
    "\0\66\0\66\0\66\0\154\0\u0762\0\u0798\0\u07ce\0\u0804"+
    "\0\154\0\u083a\0\154\0\u0870\0\u08a6\0\u08dc\0\u0912\0\u0948"+
    "\0\u097e\0\u09b4\0\u09ea\0\u0a20\0\u0a56\0\u0a8c\0\u0ac2\0\u0af8"+
    "\0\u0b2e\0\u0b64\0\154\0\u0b9a\0\u0bd0\0\u0c06\0\66\0\66"+
    "\0\66\0\66\0\66\0\66\0\154\0\154\0\154\0\154"+
    "\0\u0c3c\0\154\0\154\0\154\0\154\0\u0c72\0\u0ca8\0\u0cde"+
    "\0\u0d14\0\u0d4a\0\u0d80\0\u0db6\0\u0dec\0\u0e22\0\u0e58\0\154"+
    "\0\u0e8e\0\154\0\154\0\u0ec4\0\154\0\154\0\154\0\154"+
    "\0\u0efa\0\u0f30\0\154\0\154\0\u0f66\0\154\0\u0f9c\0\u0fd2"+
    "\0\u1008\0\u103e\0\154\0\154\0\u1074\0\154\0\154\0\154";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[136];
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
    "\1\2\1\3\1\4\1\5\1\6\1\7\2\6\1\4"+
    "\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\17"+
    "\1\20\1\21\1\22\1\23\1\24\1\25\1\26\1\27"+
    "\1\30\1\31\1\32\1\33\1\34\6\4\1\35\1\36"+
    "\1\37\1\40\1\3\1\41\2\3\1\42\2\3\1\43"+
    "\1\3\1\44\1\45\1\3\1\46\1\3\67\0\2\3"+
    "\32\0\31\3\2\0\1\4\5\0\1\4\25\0\6\4"+
    "\25\0\1\47\5\0\1\50\54\0\4\51\1\0\1\52"+
    "\1\0\57\51\11\0\1\53\65\0\1\54\65\0\1\55"+
    "\65\0\1\56\2\0\1\57\62\0\1\60\65\0\1\61"+
    "\4\0\1\62\60\0\1\63\5\0\1\64\57\0\1\65"+
    "\6\0\1\66\56\0\1\67\7\0\1\70\55\0\1\71"+
    "\101\0\1\72\51\0\1\73\55\0\2\3\32\0\1\3"+
    "\1\74\1\75\1\76\1\77\3\3\1\100\14\3\1\101"+
    "\3\3\1\0\2\3\32\0\1\102\1\103\1\104\1\105"+
    "\1\106\5\3\1\107\16\3\1\0\2\3\32\0\7\3"+
    "\1\110\21\3\1\0\2\3\32\0\16\3\1\111\11\3"+
    "\1\112\1\0\2\3\32\0\1\113\10\3\1\114\17\3"+
    "\1\0\2\3\32\0\26\3\1\115\1\116\1\3\1\0"+
    "\2\3\32\0\20\3\1\117\2\3\1\120\5\3\1\0"+
    "\2\3\32\0\23\3\1\121\5\3\1\0\2\3\32\0"+
    "\14\3\1\122\14\3\1\0\2\3\32\0\10\3\1\123"+
    "\10\3\1\124\1\3\1\125\5\3\1\0\2\3\32\0"+
    "\14\3\1\126\14\3\4\47\1\127\61\47\11\0\1\130"+
    "\65\0\1\131\65\0\1\132\65\0\1\133\65\0\1\134"+
    "\55\0\2\3\32\0\3\3\1\135\25\3\1\0\2\3"+
    "\32\0\6\3\1\136\22\3\1\0\2\3\32\0\5\3"+
    "\1\137\23\3\1\0\2\3\32\0\11\3\1\140\17\3"+
    "\1\0\2\3\32\0\10\3\1\141\20\3\1\0\2\3"+
    "\32\0\3\3\1\142\25\3\1\0\2\3\32\0\6\3"+
    "\1\143\22\3\1\0\2\3\32\0\5\3\1\144\23\3"+
    "\1\0\2\3\32\0\14\3\1\145\14\3\1\0\2\3"+
    "\32\0\27\3\1\146\1\3\1\0\2\3\32\0\7\3"+
    "\1\147\21\3\1\0\2\3\32\0\15\3\1\150\13\3"+
    "\1\0\2\3\32\0\13\3\1\151\15\3\1\0\2\3"+
    "\32\0\21\3\1\152\7\3\1\0\2\3\32\0\15\3"+
    "\1\153\13\3\1\0\2\3\32\0\12\3\1\154\16\3"+
    "\1\0\2\3\32\0\21\3\1\155\7\3\1\0\2\3"+
    "\32\0\10\3\1\156\20\3\1\0\2\3\32\0\1\157"+
    "\30\3\1\0\2\3\32\0\25\3\1\160\3\3\1\0"+
    "\2\3\32\0\27\3\1\161\1\3\1\0\2\3\32\0"+
    "\16\3\1\162\12\3\1\0\2\3\32\0\11\3\1\163"+
    "\17\3\1\0\2\3\32\0\11\3\1\164\17\3\1\0"+
    "\2\3\32\0\27\3\1\165\1\3\1\0\2\3\32\0"+
    "\14\3\1\166\14\3\1\0\2\3\32\0\14\3\1\167"+
    "\14\3\1\0\2\3\32\0\14\3\1\170\14\3\1\0"+
    "\2\3\32\0\11\3\1\171\17\3\1\0\2\3\32\0"+
    "\23\3\1\172\5\3\1\0\2\3\32\0\14\3\1\173"+
    "\14\3\1\0\2\3\32\0\16\3\1\174\12\3\1\0"+
    "\2\3\32\0\12\3\1\175\16\3\1\0\2\3\32\0"+
    "\24\3\1\176\4\3\1\0\2\3\32\0\12\3\1\177"+
    "\16\3\1\0\2\3\32\0\15\3\1\200\13\3\1\0"+
    "\2\3\32\0\1\201\30\3\1\0\2\3\32\0\16\3"+
    "\1\202\12\3\1\0\2\3\32\0\11\3\1\203\17\3"+
    "\1\0\2\3\32\0\14\3\1\204\14\3\1\0\2\3"+
    "\32\0\11\3\1\205\17\3\1\0\2\3\32\0\17\3"+
    "\1\206\11\3\1\0\2\3\32\0\11\3\1\207\17\3"+
    "\1\0\2\3\32\0\16\3\1\210\12\3";

  private static int [] zzUnpackTrans() {
    int [] result = new int[4266];
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
    "\1\0\1\11\3\1\1\11\13\1\2\11\1\1\6\11"+
    "\15\1\1\11\1\0\1\1\4\11\1\1\2\11\1\1"+
    "\1\11\1\1\1\11\1\1\1\11\1\1\3\11\33\1"+
    "\6\11\54\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[136];
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
          case 78: break;
          case 2: 
            { return HareTypes.IDENTIFIER;
            } 
            // fall through
          case 79: break;
          case 3: 
            { return HareTypes.DECIMAL_DIGITS;
            } 
            // fall through
          case 80: break;
          case 4: 
            { return HareTypes.DIVIDES;
            } 
            // fall through
          case 81: break;
          case 5: 
            { return TokenType.WHITE_SPACE;
            } 
            // fall through
          case 82: break;
          case 6: 
            { return HareTypes.ASSIGN;
            } 
            // fall through
          case 83: break;
          case 7: 
            { return HareTypes.MULTIPLIES;
            } 
            // fall through
          case 84: break;
          case 8: 
            { return HareTypes.MODULUS;
            } 
            // fall through
          case 85: break;
          case 9: 
            { return HareTypes.AND;
            } 
            // fall through
          case 86: break;
          case 10: 
            { return HareTypes.ADDS;
            } 
            // fall through
          case 87: break;
          case 11: 
            { return HareTypes.EXCLUSIVE_OR;
            } 
            // fall through
          case 88: break;
          case 12: 
            { return HareTypes.INCLUSIVE_OR;
            } 
            // fall through
          case 89: break;
          case 13: 
            { return HareTypes.LESSER_THAN;
            } 
            // fall through
          case 90: break;
          case 14: 
            { return HareTypes.LARGER_THAN;
            } 
            // fall through
          case 91: break;
          case 15: 
            { return HareTypes.SUBSTRACTS;
            } 
            // fall through
          case 92: break;
          case 16: 
            { return HareTypes.EOS;
            } 
            // fall through
          case 93: break;
          case 17: 
            { return HareTypes.COMMA;
            } 
            // fall through
          case 94: break;
          case 18: 
            { return HareTypes.COLON;
            } 
            // fall through
          case 95: break;
          case 19: 
            { return HareTypes.LB;
            } 
            // fall through
          case 96: break;
          case 20: 
            { return HareTypes.RB;
            } 
            // fall through
          case 97: break;
          case 21: 
            { return HareTypes.LP;
            } 
            // fall through
          case 98: break;
          case 22: 
            { return HareTypes.RP;
            } 
            // fall through
          case 99: break;
          case 23: 
            { return HareTypes.LBR;
            } 
            // fall through
          case 100: break;
          case 24: 
            { return HareTypes.RBR;
            } 
            // fall through
          case 101: break;
          case 25: 
            { return HareElementType.Companion.getCOMMENT();
            } 
            // fall through
          case 102: break;
          case 26: 
            { return HareTypes.DIVIDES_ASSIGN;
            } 
            // fall through
          case 103: break;
          case 27: 
            { return HareTypes.STRING_LITERAL;
            } 
            // fall through
          case 104: break;
          case 28: 
            { return HareTypes.EQUAL;
            } 
            // fall through
          case 105: break;
          case 29: 
            { return HareTypes.MULTIPLIES_ASSIGN;
            } 
            // fall through
          case 106: break;
          case 30: 
            { return HareTypes.MODULUS_ASSIGN;
            } 
            // fall through
          case 107: break;
          case 31: 
            { return HareTypes.AND_ASSIGN;
            } 
            // fall through
          case 108: break;
          case 32: 
            { return HareTypes.LOGICAL_AND;
            } 
            // fall through
          case 109: break;
          case 33: 
            { return HareTypes.PLUS_ASSIGN;
            } 
            // fall through
          case 110: break;
          case 34: 
            { return HareTypes.XOR_ASSIGN;
            } 
            // fall through
          case 111: break;
          case 35: 
            { return HareTypes.LOGICAL_XOR;
            } 
            // fall through
          case 112: break;
          case 36: 
            { return HareTypes.OR_ASSIGN;
            } 
            // fall through
          case 113: break;
          case 37: 
            { return HareTypes.LOGICAL_OR;
            } 
            // fall through
          case 114: break;
          case 38: 
            { return HareTypes.LESSER_EQUAL;
            } 
            // fall through
          case 115: break;
          case 39: 
            { return HareTypes.LEFT_SHIFT;
            } 
            // fall through
          case 116: break;
          case 40: 
            { return HareTypes.LARGER_EQUAL;
            } 
            // fall through
          case 117: break;
          case 41: 
            { return HareTypes.RIGHT_SHIFT;
            } 
            // fall through
          case 118: break;
          case 42: 
            { return HareTypes.MINUS_ASSIGN;
            } 
            // fall through
          case 119: break;
          case 43: 
            { return HareTypes.SCOPE;
            } 
            // fall through
          case 120: break;
          case 44: 
            { return HareTypes.NOT_EQUAL;
            } 
            // fall through
          case 121: break;
          case 45: 
            { return HareTypes.I8_KW;
            } 
            // fall through
          case 122: break;
          case 46: 
            { return HareTypes.IF_KW;
            } 
            // fall through
          case 123: break;
          case 47: 
            { return HareTypes.U8_KW;
            } 
            // fall through
          case 124: break;
          case 48: 
            { return HareTypes.FN_KW;
            } 
            // fall through
          case 125: break;
          case 49: 
            { return HareTypes.LOGICAL_AND_ASSIGN;
            } 
            // fall through
          case 126: break;
          case 50: 
            { return HareTypes.LOGICAL_XOR_ASSIGN;
            } 
            // fall through
          case 127: break;
          case 51: 
            { return HareTypes.LOGICAL_OR_ASSIGN;
            } 
            // fall through
          case 128: break;
          case 52: 
            { return HareTypes.LEFT_SHIFT_ASSIGN;
            } 
            // fall through
          case 129: break;
          case 53: 
            { return HareTypes.RIGHT_SHIFT_ASSIGN;
            } 
            // fall through
          case 130: break;
          case 54: 
            { return HareTypes.I16_KW;
            } 
            // fall through
          case 131: break;
          case 55: 
            { return HareTypes.I64_KW;
            } 
            // fall through
          case 132: break;
          case 56: 
            { return HareTypes.I32_KW;
            } 
            // fall through
          case 133: break;
          case 57: 
            { return HareTypes.INT_KW;
            } 
            // fall through
          case 134: break;
          case 58: 
            { return HareTypes.U16_KW;
            } 
            // fall through
          case 135: break;
          case 59: 
            { return HareTypes.U64_KW;
            } 
            // fall through
          case 136: break;
          case 60: 
            { return HareTypes.U32_KW;
            } 
            // fall through
          case 137: break;
          case 61: 
            { return HareTypes.USE_KW;
            } 
            // fall through
          case 138: break;
          case 62: 
            { return HareTypes.DEF_KW;
            } 
            // fall through
          case 139: break;
          case 63: 
            { return HareTypes.FOR_KW;
            } 
            // fall through
          case 140: break;
          case 64: 
            { return HareTypes.LET_KW;
            } 
            // fall through
          case 141: break;
          case 65: 
            { return HareTypes.UINT_KW;
            } 
            // fall through
          case 142: break;
          case 66: 
            { return HareTypes.NULL_KW;
            } 
            // fall through
          case 143: break;
          case 67: 
            { return HareTypes.TRUE_KW;
            } 
            // fall through
          case 144: break;
          case 68: 
            { return HareTypes.TYPE_KW;
            } 
            // fall through
          case 145: break;
          case 69: 
            { return HareTypes.SIZE_KW;
            } 
            // fall through
          case 146: break;
          case 70: 
            { return HareTypes.ELSE_KW;
            } 
            // fall through
          case 147: break;
          case 71: 
            { return HareTypes.CHAR_KW;
            } 
            // fall through
          case 148: break;
          case 72: 
            { return HareTypes.VOID_KW;
            } 
            // fall through
          case 149: break;
          case 73: 
            { return HareTypes.CONST_KW;
            } 
            // fall through
          case 150: break;
          case 74: 
            { return HareTypes.FALSE_KW;
            } 
            // fall through
          case 151: break;
          case 75: 
            { return HareTypes.STATIC_KW;
            } 
            // fall through
          case 152: break;
          case 76: 
            { return HareTypes.EXPORT_KW;
            } 
            // fall through
          case 153: break;
          case 77: 
            { return HareTypes.UINTPTR_KW;
            } 
            // fall through
          case 154: break;
          default:
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
