// This is a generated file. Not intended for manual editing.
package org.harelang.parser.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;

public interface HareTypes {

  IElementType BUILDIN_TYPE = new HareElementType("BUILDIN_TYPE");
  IElementType FUNCTION_ARGS = new HareElementType("FUNCTION_ARGS");
  IElementType FUNCTION_BLOCK = new HareElementType("FUNCTION_BLOCK");
  IElementType FUNCTION_DEFINITION = new HareElementType("FUNCTION_DEFINITION");
  IElementType IMPORT_DECL = new HareElementType("IMPORT_DECL");
  IElementType IMPORT_PATH = new HareElementType("IMPORT_PATH");
  IElementType TYPE = new HareElementType("TYPE");

  IElementType CHAR = new HareTokenType("char");
  IElementType EOS = new HareTokenType("EOS");
  IElementType EXPORT_KW = new HareTokenType("EXPORT_KW");
  IElementType FN_KW = new HareTokenType("FN_KW");
  IElementType I16 = new HareTokenType("i16");
  IElementType I32 = new HareTokenType("i32");
  IElementType I64 = new HareTokenType("i64");
  IElementType I8 = new HareTokenType("i8");
  IElementType IDENTIFIER = new HareTokenType("IDENTIFIER");
  IElementType INT = new HareTokenType("int");
  IElementType LBR = new HareTokenType("LBR");
  IElementType LP = new HareTokenType("LP");
  IElementType RBR = new HareTokenType("RBR");
  IElementType RP = new HareTokenType("RP");
  IElementType SCOPE = new HareTokenType("SCOPE");
  IElementType SIZE = new HareTokenType("size");
  IElementType U16 = new HareTokenType("u16");
  IElementType U32 = new HareTokenType("u32");
  IElementType U64 = new HareTokenType("u64");
  IElementType U8 = new HareTokenType("u8");
  IElementType UINT = new HareTokenType("uint");
  IElementType UINTPTR = new HareTokenType("uintptr");
  IElementType USE_KW = new HareTokenType("USE_KW");
  IElementType VOID = new HareTokenType("void");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == BUILDIN_TYPE) {
        return new HareBuildinTypeImpl(node);
      }
      else if (type == FUNCTION_ARGS) {
        return new HareFunctionArgsImpl(node);
      }
      else if (type == FUNCTION_BLOCK) {
        return new HareFunctionBlockImpl(node);
      }
      else if (type == FUNCTION_DEFINITION) {
        return new HareFunctionDefinitionImpl(node);
      }
      else if (type == IMPORT_DECL) {
        return new HareImportDeclImpl(node);
      }
      else if (type == IMPORT_PATH) {
        return new HareImportPathImpl(node);
      }
      else if (type == TYPE) {
        return new HareTypeImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
