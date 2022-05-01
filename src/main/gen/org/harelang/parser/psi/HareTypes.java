// This is a generated file. Not intended for manual editing.
package org.harelang.parser.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;

public interface HareTypes {

  IElementType BUILDIN_TYPE = new HareElementType("BUILDIN_TYPE");
  IElementType CONSTANT = new HareElementType("CONSTANT");
  IElementType EXPRESSION = new HareElementType("EXPRESSION");
  IElementType FUNCTION_ARGS = new HareElementType("FUNCTION_ARGS");
  IElementType FUNCTION_BLOCK = new HareElementType("FUNCTION_BLOCK");
  IElementType FUNCTION_DEFINITION = new HareElementType("FUNCTION_DEFINITION");
  IElementType IMPORT_DECL = new HareElementType("IMPORT_DECL");
  IElementType IMPORT_PATH = new HareElementType("IMPORT_PATH");
  IElementType INTEGER_CONSTANT = new HareElementType("INTEGER_CONSTANT");
  IElementType INTEGER_SUFFIX = new HareElementType("INTEGER_SUFFIX");
  IElementType PARAMETER = new HareElementType("PARAMETER");
  IElementType PARAMETER_LIST = new HareElementType("PARAMETER_LIST");
  IElementType PLAN_EXPRESSION = new HareElementType("PLAN_EXPRESSION");
  IElementType STRING_CONST = new HareElementType("STRING_CONST");
  IElementType TYPE = new HareElementType("TYPE");

  IElementType ADDS = new HareTokenType("ADDS");
  IElementType AND = new HareTokenType("AND");
  IElementType CHAR_KW = new HareTokenType("CHAR_KW");
  IElementType COLON = new HareTokenType("COLON");
  IElementType COMMA = new HareTokenType("COMMA");
  IElementType DECIMAL_DIGITS = new HareTokenType("DECIMAL_DIGITS");
  IElementType DIVIDES = new HareTokenType("DIVIDES");
  IElementType EOS = new HareTokenType("EOS");
  IElementType EQUAL = new HareTokenType("EQUAL");
  IElementType EXCLUSIVE_OR = new HareTokenType("EXCLUSIVE_OR");
  IElementType EXPORT_KW = new HareTokenType("EXPORT_KW");
  IElementType FALSE_KW = new HareTokenType("FALSE_KW");
  IElementType FN_KW = new HareTokenType("FN_KW");
  IElementType I16_KW = new HareTokenType("I16_KW");
  IElementType I32_KW = new HareTokenType("I32_KW");
  IElementType I64_KW = new HareTokenType("I64_KW");
  IElementType I8_KW = new HareTokenType("I8_KW");
  IElementType IDENTIFIER = new HareTokenType("IDENTIFIER");
  IElementType INCLUSIVE_OR = new HareTokenType("INCLUSIVE_OR");
  IElementType INT_KW = new HareTokenType("INT_KW");
  IElementType LARGER_EQUAL = new HareTokenType("LARGER_EQUAL");
  IElementType LARGER_THAN = new HareTokenType("LARGER_THAN");
  IElementType LBR = new HareTokenType("LBR");
  IElementType LEFT_SHIFT = new HareTokenType("LEFT_SHIFT");
  IElementType LESSER_EQUAL = new HareTokenType("LESSER_EQUAL");
  IElementType LESSER_THAN = new HareTokenType("LESSER_THAN");
  IElementType LOGICAL_AND = new HareTokenType("LOGICAL_AND");
  IElementType LOGICAL_OR = new HareTokenType("LOGICAL_OR");
  IElementType LOGICAL_XOR = new HareTokenType("LOGICAL_XOR");
  IElementType LP = new HareTokenType("LP");
  IElementType MODULUS = new HareTokenType("MODULUS");
  IElementType MULTIPLIES = new HareTokenType("MULTIPLIES");
  IElementType NOT_EQUAL = new HareTokenType("NOT_EQUAL");
  IElementType NULL_KW = new HareTokenType("NULL_KW");
  IElementType RBR = new HareTokenType("RBR");
  IElementType RIGHT_SHIFT = new HareTokenType("RIGHT_SHIFT");
  IElementType RP = new HareTokenType("RP");
  IElementType SCOPE = new HareTokenType("SCOPE");
  IElementType SIZE_KW = new HareTokenType("SIZE_KW");
  IElementType STRING_LITERAL = new HareTokenType("STRING_LITERAL");
  IElementType SUBSTRACTS = new HareTokenType("SUBSTRACTS");
  IElementType TRUE_KW = new HareTokenType("TRUE_KW");
  IElementType U16_KW = new HareTokenType("U16_KW");
  IElementType U32_KW = new HareTokenType("U32_KW");
  IElementType U64_KW = new HareTokenType("U64_KW");
  IElementType U8_KW = new HareTokenType("U8_KW");
  IElementType UINTPTR_KW = new HareTokenType("UINTPTR_KW");
  IElementType UINT_KW = new HareTokenType("UINT_KW");
  IElementType USE_KW = new HareTokenType("USE_KW");
  IElementType VOID_KW = new HareTokenType("VOID_KW");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == BUILDIN_TYPE) {
        return new HareBuildinTypeImpl(node);
      }
      else if (type == CONSTANT) {
        return new HareConstantImpl(node);
      }
      else if (type == EXPRESSION) {
        return new HareExpressionImpl(node);
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
      else if (type == INTEGER_CONSTANT) {
        return new HareIntegerConstantImpl(node);
      }
      else if (type == INTEGER_SUFFIX) {
        return new HareIntegerSuffixImpl(node);
      }
      else if (type == PARAMETER) {
        return new HareParameterImpl(node);
      }
      else if (type == PARAMETER_LIST) {
        return new HareParameterListImpl(node);
      }
      else if (type == PLAN_EXPRESSION) {
        return new HarePlanExpressionImpl(node);
      }
      else if (type == STRING_CONST) {
        return new HareStringConstImpl(node);
      }
      else if (type == TYPE) {
        return new HareTypeImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
