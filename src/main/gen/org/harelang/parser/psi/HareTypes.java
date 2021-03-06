// This is a generated file. Not intended for manual editing.
package org.harelang.parser.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;

public interface HareTypes {

  IElementType ALIAS_TYPE = new HareElementType("ALIAS_TYPE");
  IElementType ALLOC_EXPRESSION = new HareElementType("ALLOC_EXPRESSION");
  IElementType APPEND_EXPRESSION = new HareElementType("APPEND_EXPRESSION");
  IElementType ARGUMENT_LIST = new HareElementType("ARGUMENT_LIST");
  IElementType ARRAY_LITERAL = new HareElementType("ARRAY_LITERAL");
  IElementType ARRAY_MEMBERS = new HareElementType("ARRAY_MEMBERS");
  IElementType ASSERTION_EXPRESSION = new HareElementType("ASSERTION_EXPRESSION");
  IElementType ASSIGNMENT = new HareElementType("ASSIGNMENT");
  IElementType ASSIGNMENT_OP = new HareElementType("ASSIGNMENT_OP");
  IElementType BINDING = new HareElementType("BINDING");
  IElementType BINDINGS = new HareElementType("BINDINGS");
  IElementType BINDING_LIST = new HareElementType("BINDING_LIST");
  IElementType CALL_OP = new HareElementType("CALL_OP");
  IElementType CASE_OPTIONS = new HareElementType("CASE_OPTIONS");
  IElementType COMPOUND_EXPRESSION = new HareElementType("COMPOUND_EXPRESSION");
  IElementType CONDITIONAL_BRANCH = new HareElementType("CONDITIONAL_BRANCH");
  IElementType CONSTANT = new HareElementType("CONSTANT");
  IElementType CONSTANT_BINDING = new HareElementType("CONSTANT_BINDING");
  IElementType CONSTANT_BINDINGS = new HareElementType("CONSTANT_BINDINGS");
  IElementType CONSTANT_DECLARATION = new HareElementType("CONSTANT_DECLARATION");
  IElementType CONTROL_EXPRESSION = new HareElementType("CONTROL_EXPRESSION");
  IElementType DECLARATIONS = new HareElementType("DECLARATIONS");
  IElementType DECL_ATTR = new HareElementType("DECL_ATTR");
  IElementType DEFER_EXPRESSION = new HareElementType("DEFER_EXPRESSION");
  IElementType DELETE_EXPRESSION = new HareElementType("DELETE_EXPRESSION");
  IElementType ENUM_LITERAL = new HareElementType("ENUM_LITERAL");
  IElementType ENUM_STORAGE = new HareElementType("ENUM_STORAGE");
  IElementType ENUM_TYPE = new HareElementType("ENUM_TYPE");
  IElementType ENUM_VALUE = new HareElementType("ENUM_VALUE");
  IElementType ENUM_VALUES = new HareElementType("ENUM_VALUES");
  IElementType ERROR_PROPAGATION_OP = new HareElementType("ERROR_PROPAGATION_OP");
  IElementType EXPONENT = new HareElementType("EXPONENT");
  IElementType EXPRESSION = new HareElementType("EXPRESSION");
  IElementType EXPRESSION_LIST = new HareElementType("EXPRESSION_LIST");
  IElementType FIELD_ACCESS_OP = new HareElementType("FIELD_ACCESS_OP");
  IElementType FIELD_VALUE = new HareElementType("FIELD_VALUE");
  IElementType FIELD_VALUES = new HareElementType("FIELD_VALUES");
  IElementType FLOATING_CONSTANT = new HareElementType("FLOATING_CONSTANT");
  IElementType FLOATING_TYPE = new HareElementType("FLOATING_TYPE");
  IElementType FNDEC_ATTR = new HareElementType("FNDEC_ATTR");
  IElementType FNTYPE_ATTR = new HareElementType("FNTYPE_ATTR");
  IElementType FOR_LOOP = new HareElementType("FOR_LOOP");
  IElementType FOR_PREDICATE = new HareElementType("FOR_PREDICATE");
  IElementType FUNCTION_DECLARATION = new HareElementType("FUNCTION_DECLARATION");
  IElementType FUNCTION_TYPE = new HareElementType("FUNCTION_TYPE");
  IElementType GENERAL_DECLARATION = new HareElementType("GENERAL_DECLARATION");
  IElementType GLOBAL_BINDING = new HareElementType("GLOBAL_BINDING");
  IElementType GLOBAL_BINDINGS = new HareElementType("GLOBAL_BINDINGS");
  IElementType GLOBAL_DECLARATION = new HareElementType("GLOBAL_DECLARATION");
  IElementType IDENTIFIER_PATH = new HareElementType("IDENTIFIER_PATH");
  IElementType IF_EXPRESSION = new HareElementType("IF_EXPRESSION");
  IElementType IMPORTS = new HareElementType("IMPORTS");
  IElementType IMPORT_ALIAS = new HareElementType("IMPORT_ALIAS");
  IElementType IMPORT_ID = new HareElementType("IMPORT_ID");
  IElementType IMPORT_PATH = new HareElementType("IMPORT_PATH");
  IElementType INDEXING_OP = new HareElementType("INDEXING_OP");
  IElementType INSERT_EXPRESSION = new HareElementType("INSERT_EXPRESSION");
  IElementType INTEGER_CONSTANT = new HareElementType("INTEGER_CONSTANT");
  IElementType INTEGER_SUFFIX = new HareElementType("INTEGER_SUFFIX");
  IElementType INTEGER_TYPE = new HareElementType("INTEGER_TYPE");
  IElementType LABEL = new HareElementType("LABEL");
  IElementType LENGTH_EXPRESSION = new HareElementType("LENGTH_EXPRESSION");
  IElementType MATCH_CASE = new HareElementType("MATCH_CASE");
  IElementType MATCH_EXPRESSION = new HareElementType("MATCH_EXPRESSION");
  IElementType MEASUREMENT_EXPRESSION = new HareElementType("MEASUREMENT_EXPRESSION");
  IElementType MEMBER = new HareElementType("MEMBER");
  IElementType MEMBER_LIST = new HareElementType("MEMBER_LIST");
  IElementType OBJECT_SELECTOR = new HareElementType("OBJECT_SELECTOR");
  IElementType OFFSET_EXPRESSION = new HareElementType("OFFSET_EXPRESSION");
  IElementType PARAMETER = new HareElementType("PARAMETER");
  IElementType PARAMETERS = new HareElementType("PARAMETERS");
  IElementType PARAMETER_LIST = new HareElementType("PARAMETER_LIST");
  IElementType PLAN_EXPRESSION = new HareElementType("PLAN_EXPRESSION");
  IElementType POINTER_TYPE = new HareElementType("POINTER_TYPE");
  IElementType POSTFIX_OP = new HareElementType("POSTFIX_OP");
  IElementType PROTOTYPE = new HareElementType("PROTOTYPE");
  IElementType RUNE_CONSTANT = new HareElementType("RUNE_CONSTANT");
  IElementType SCALA_TYPE = new HareElementType("SCALA_TYPE");
  IElementType SIZE_EXPRESSION = new HareElementType("SIZE_EXPRESSION");
  IElementType SLICE_ARRAY_TYPE = new HareElementType("SLICE_ARRAY_TYPE");
  IElementType SLICE_MUTATION_EXPRESSION = new HareElementType("SLICE_MUTATION_EXPRESSION");
  IElementType SLICING_EXPRESSION = new HareElementType("SLICING_EXPRESSION");
  IElementType SLICING_OP = new HareElementType("SLICING_OP");
  IElementType STORAGE_CLASS = new HareElementType("STORAGE_CLASS");
  IElementType STRING_CONST = new HareElementType("STRING_CONST");
  IElementType STRUCT_INITIALIZER = new HareElementType("STRUCT_INITIALIZER");
  IElementType STRUCT_LITERAL = new HareElementType("STRUCT_LITERAL");
  IElementType STRUCT_UNION_FIELD = new HareElementType("STRUCT_UNION_FIELD");
  IElementType STRUCT_UNION_FIELDS = new HareElementType("STRUCT_UNION_FIELDS");
  IElementType STRUCT_UNION_TYPE = new HareElementType("STRUCT_UNION_TYPE");
  IElementType SWITCH_CASE = new HareElementType("SWITCH_CASE");
  IElementType SWITCH_EXPRESSION = new HareElementType("SWITCH_EXPRESSION");
  IElementType SYMBOL = new HareElementType("SYMBOL");
  IElementType TAGGED_TYPES = new HareElementType("TAGGED_TYPES");
  IElementType TAGGED_UNION_TYPE = new HareElementType("TAGGED_UNION_TYPE");
  IElementType TUPLE_ITEMS = new HareElementType("TUPLE_ITEMS");
  IElementType TUPLE_TYPE = new HareElementType("TUPLE_TYPE");
  IElementType TUPLE_TYPES = new HareElementType("TUPLE_TYPES");
  IElementType TYPE = new HareElementType("TYPE");
  IElementType TYPE_BINDING = new HareElementType("TYPE_BINDING");
  IElementType TYPE_BINDINGS = new HareElementType("TYPE_BINDINGS");
  IElementType TYPE_DECLARATION = new HareElementType("TYPE_DECLARATION");
  IElementType UNARY_OPERATOR = new HareElementType("UNARY_OPERATOR");
  IElementType UNWRAPPED_ALIAS = new HareElementType("UNWRAPPED_ALIAS");
  IElementType USE_STATEMENT = new HareElementType("USE_STATEMENT");
  IElementType USE_STATEMENT_MEMBER_LIST = new HareElementType("USE_STATEMENT_MEMBER_LIST");
  IElementType VARIADIC_EXPRESSION = new HareElementType("VARIADIC_EXPRESSION");
  IElementType YIELD_EXPRESSION = new HareElementType("YIELD_EXPRESSION");

  IElementType ABORT_KW = new HareTokenType("ABORT_KW");
  IElementType ADDS = new HareTokenType("ADDS");
  IElementType ALLOC_KW = new HareTokenType("ALLOC_KW");
  IElementType AND = new HareTokenType("AND");
  IElementType AND_ASSIGN = new HareTokenType("AND_ASSIGN");
  IElementType APPEND_KW = new HareTokenType("APPEND_KW");
  IElementType ASSERT_KW = new HareTokenType("ASSERT_KW");
  IElementType ASSIGN = new HareTokenType("ASSIGN");
  IElementType AS_KW = new HareTokenType("AS_KW");
  IElementType BANG = new HareTokenType("BANG");
  IElementType BIN_DIGITS = new HareTokenType("BIN_DIGITS");
  IElementType BOOL_TYPE = new HareTokenType("BOOL_TYPE");
  IElementType BREAK_KW = new HareTokenType("BREAK_KW");
  IElementType CASE_KW = new HareTokenType("CASE_KW");
  IElementType CHAR_TYPE = new HareTokenType("CHAR_TYPE");
  IElementType COLON = new HareTokenType("COLON");
  IElementType COMMA = new HareTokenType("COMMA");
  IElementType CONST_KW = new HareTokenType("CONST_KW");
  IElementType CONTINUE_KW = new HareTokenType("CONTINUE_KW");
  IElementType DECIMAL_DIGITS = new HareTokenType("DECIMAL_DIGITS");
  IElementType DEFER_KW = new HareTokenType("DEFER_KW");
  IElementType DEF_KW = new HareTokenType("DEF_KW");
  IElementType DELETE_KW = new HareTokenType("DELETE_KW");
  IElementType DIVIDES = new HareTokenType("DIVIDES");
  IElementType DIVIDES_ASSIGN = new HareTokenType("DIVIDES_ASSIGN");
  IElementType DOT = new HareTokenType("DOT");
  IElementType DOTDOT = new HareTokenType("DOTDOT");
  IElementType DOTDOTDOT = new HareTokenType("DOTDOTDOT");
  IElementType ELSE_KW = new HareTokenType("ELSE_KW");
  IElementType ENUM_KW = new HareTokenType("ENUM_KW");
  IElementType EOS = new HareTokenType("EOS");
  IElementType EQUAL = new HareTokenType("EQUAL");
  IElementType EXCLUSIVE_OR = new HareTokenType("EXCLUSIVE_OR");
  IElementType EXPORT_KW = new HareTokenType("EXPORT_KW");
  IElementType F32_TYPE = new HareTokenType("F32_TYPE");
  IElementType F64_TYPE = new HareTokenType("F64_TYPE");
  IElementType FALSE_KW = new HareTokenType("FALSE_KW");
  IElementType FINI_ATTR = new HareTokenType("FINI_ATTR");
  IElementType FN_KW = new HareTokenType("FN_KW");
  IElementType FOR_KW = new HareTokenType("FOR_KW");
  IElementType FREE_KW = new HareTokenType("FREE_KW");
  IElementType HEX_DIGITS = new HareTokenType("HEX_DIGITS");
  IElementType I16_TYPE = new HareTokenType("I16_TYPE");
  IElementType I32_TYPE = new HareTokenType("I32_TYPE");
  IElementType I64_TYPE = new HareTokenType("I64_TYPE");
  IElementType I8_TYPE = new HareTokenType("I8_TYPE");
  IElementType IDENTIFIER = new HareTokenType("IDENTIFIER");
  IElementType IF_KW = new HareTokenType("IF_KW");
  IElementType INCLUSIVE_OR = new HareTokenType("INCLUSIVE_OR");
  IElementType INIT_ATTR = new HareTokenType("INIT_ATTR");
  IElementType INSERT_KW = new HareTokenType("INSERT_KW");
  IElementType INT_TYPE = new HareTokenType("INT_TYPE");
  IElementType IS_KW = new HareTokenType("IS_KW");
  IElementType LARGER_EQUAL = new HareTokenType("LARGER_EQUAL");
  IElementType LARGER_THAN = new HareTokenType("LARGER_THAN");
  IElementType LB = new HareTokenType("LB");
  IElementType LBR = new HareTokenType("LBR");
  IElementType LEFT_SHIFT = new HareTokenType("LEFT_SHIFT");
  IElementType LEFT_SHIFT_ASSIGN = new HareTokenType("LEFT_SHIFT_ASSIGN");
  IElementType LEN_KW = new HareTokenType("LEN_KW");
  IElementType LESSER_EQUAL = new HareTokenType("LESSER_EQUAL");
  IElementType LESSER_THAN = new HareTokenType("LESSER_THAN");
  IElementType LET_KW = new HareTokenType("LET_KW");
  IElementType LOGICAL_AND = new HareTokenType("LOGICAL_AND");
  IElementType LOGICAL_AND_ASSIGN = new HareTokenType("LOGICAL_AND_ASSIGN");
  IElementType LOGICAL_OR = new HareTokenType("LOGICAL_OR");
  IElementType LOGICAL_OR_ASSIGN = new HareTokenType("LOGICAL_OR_ASSIGN");
  IElementType LOGICAL_XOR = new HareTokenType("LOGICAL_XOR");
  IElementType LOGICAL_XOR_ASSIGN = new HareTokenType("LOGICAL_XOR_ASSIGN");
  IElementType LP = new HareTokenType("LP");
  IElementType MATCH_KW = new HareTokenType("MATCH_KW");
  IElementType MATCH_OP = new HareTokenType("MATCH_OP");
  IElementType MINUS_ASSIGN = new HareTokenType("MINUS_ASSIGN");
  IElementType MODULUS = new HareTokenType("MODULUS");
  IElementType MODULUS_ASSIGN = new HareTokenType("MODULUS_ASSIGN");
  IElementType MULTIPLIES = new HareTokenType("MULTIPLIES");
  IElementType MULTIPLIES_ASSIGN = new HareTokenType("MULTIPLIES_ASSIGN");
  IElementType NORETURN_ATTR = new HareTokenType("NORETURN_ATTR");
  IElementType NOT = new HareTokenType("NOT");
  IElementType NOT_EQUAL = new HareTokenType("NOT_EQUAL");
  IElementType NULLABLE_KW = new HareTokenType("NULLABLE_KW");
  IElementType NULL_KW = new HareTokenType("NULL_KW");
  IElementType OCTAL_DIGITS = new HareTokenType("OCTAL_DIGITS");
  IElementType OFFSET_KW = new HareTokenType("OFFSET_KW");
  IElementType OR_ASSIGN = new HareTokenType("OR_ASSIGN");
  IElementType PLUS_ASSIGN = new HareTokenType("PLUS_ASSIGN");
  IElementType QUESTION = new HareTokenType("QUESTION");
  IElementType RAWSTRING = new HareTokenType("RAWSTRING");
  IElementType RB = new HareTokenType("RB");
  IElementType RBR = new HareTokenType("RBR");
  IElementType RETURN_KW = new HareTokenType("RETURN_KW");
  IElementType RIGHT_SHIFT = new HareTokenType("RIGHT_SHIFT");
  IElementType RIGHT_SHIFT_ASSIGN = new HareTokenType("RIGHT_SHIFT_ASSIGN");
  IElementType RP = new HareTokenType("RP");
  IElementType RUNE_KW = new HareTokenType("RUNE_KW");
  IElementType RUNE_LITERAL = new HareTokenType("RUNE_LITERAL");
  IElementType SCOPE = new HareTokenType("SCOPE");
  IElementType SIZE_TYPE = new HareTokenType("SIZE_TYPE");
  IElementType STATIC_KW = new HareTokenType("STATIC_KW");
  IElementType STRING_LITERAL = new HareTokenType("STRING_LITERAL");
  IElementType STRUCT_KW = new HareTokenType("STRUCT_KW");
  IElementType STR_TYPE = new HareTokenType("STR_TYPE");
  IElementType SUBSTRACTS = new HareTokenType("SUBSTRACTS");
  IElementType SWITCH_KW = new HareTokenType("SWITCH_KW");
  IElementType SYMBOL_ATTR = new HareTokenType("SYMBOL_ATTR");
  IElementType TEST_ATTR = new HareTokenType("TEST_ATTR");
  IElementType TRUE_KW = new HareTokenType("TRUE_KW");
  IElementType TYPE_KW = new HareTokenType("TYPE_KW");
  IElementType U16_TYPE = new HareTokenType("U16_TYPE");
  IElementType U32_TYPE = new HareTokenType("U32_TYPE");
  IElementType U64_TYPE = new HareTokenType("U64_TYPE");
  IElementType U8_TYPE = new HareTokenType("U8_TYPE");
  IElementType UINTPTR_TYPE = new HareTokenType("UINTPTR_TYPE");
  IElementType UINT_TYPE = new HareTokenType("UINT_TYPE");
  IElementType UNDERSCORE = new HareTokenType("UNDERSCORE");
  IElementType UNION_KW = new HareTokenType("UNION_KW");
  IElementType USE_KW = new HareTokenType("USE_KW");
  IElementType VAARG_KW = new HareTokenType("VAARG_KW");
  IElementType VAEND_KW = new HareTokenType("VAEND_KW");
  IElementType VALIST_TYPE = new HareTokenType("VALIST_TYPE");
  IElementType VASTART_KW = new HareTokenType("VASTART_KW");
  IElementType VOID_TYPE = new HareTokenType("VOID_TYPE");
  IElementType XOR_ASSIGN = new HareTokenType("XOR_ASSIGN");
  IElementType YIELD_KW = new HareTokenType("YIELD_KW");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ALIAS_TYPE) {
        return new HareAliasTypeImpl(node);
      }
      else if (type == ALLOC_EXPRESSION) {
        return new HareAllocExpressionImpl(node);
      }
      else if (type == APPEND_EXPRESSION) {
        return new HareAppendExpressionImpl(node);
      }
      else if (type == ARGUMENT_LIST) {
        return new HareArgumentListImpl(node);
      }
      else if (type == ARRAY_LITERAL) {
        return new HareArrayLiteralImpl(node);
      }
      else if (type == ARRAY_MEMBERS) {
        return new HareArrayMembersImpl(node);
      }
      else if (type == ASSERTION_EXPRESSION) {
        return new HareAssertionExpressionImpl(node);
      }
      else if (type == ASSIGNMENT) {
        return new HareAssignmentImpl(node);
      }
      else if (type == ASSIGNMENT_OP) {
        return new HareAssignmentOpImpl(node);
      }
      else if (type == BINDING) {
        return new HareBindingImpl(node);
      }
      else if (type == BINDINGS) {
        return new HareBindingsImpl(node);
      }
      else if (type == BINDING_LIST) {
        return new HareBindingListImpl(node);
      }
      else if (type == CALL_OP) {
        return new HareCallOpImpl(node);
      }
      else if (type == CASE_OPTIONS) {
        return new HareCaseOptionsImpl(node);
      }
      else if (type == COMPOUND_EXPRESSION) {
        return new HareCompoundExpressionImpl(node);
      }
      else if (type == CONDITIONAL_BRANCH) {
        return new HareConditionalBranchImpl(node);
      }
      else if (type == CONSTANT) {
        return new HareConstantImpl(node);
      }
      else if (type == CONSTANT_BINDING) {
        return new HareConstantBindingImpl(node);
      }
      else if (type == CONSTANT_BINDINGS) {
        return new HareConstantBindingsImpl(node);
      }
      else if (type == CONSTANT_DECLARATION) {
        return new HareConstantDeclarationImpl(node);
      }
      else if (type == CONTROL_EXPRESSION) {
        return new HareControlExpressionImpl(node);
      }
      else if (type == DECLARATIONS) {
        return new HareDeclarationsImpl(node);
      }
      else if (type == DECL_ATTR) {
        return new HareDeclAttrImpl(node);
      }
      else if (type == DEFER_EXPRESSION) {
        return new HareDeferExpressionImpl(node);
      }
      else if (type == DELETE_EXPRESSION) {
        return new HareDeleteExpressionImpl(node);
      }
      else if (type == ENUM_LITERAL) {
        return new HareEnumLiteralImpl(node);
      }
      else if (type == ENUM_STORAGE) {
        return new HareEnumStorageImpl(node);
      }
      else if (type == ENUM_TYPE) {
        return new HareEnumTypeImpl(node);
      }
      else if (type == ENUM_VALUE) {
        return new HareEnumValueImpl(node);
      }
      else if (type == ENUM_VALUES) {
        return new HareEnumValuesImpl(node);
      }
      else if (type == ERROR_PROPAGATION_OP) {
        return new HareErrorPropagationOpImpl(node);
      }
      else if (type == EXPONENT) {
        return new HareExponentImpl(node);
      }
      else if (type == EXPRESSION) {
        return new HareExpressionImpl(node);
      }
      else if (type == EXPRESSION_LIST) {
        return new HareExpressionListImpl(node);
      }
      else if (type == FIELD_ACCESS_OP) {
        return new HareFieldAccessOpImpl(node);
      }
      else if (type == FIELD_VALUE) {
        return new HareFieldValueImpl(node);
      }
      else if (type == FIELD_VALUES) {
        return new HareFieldValuesImpl(node);
      }
      else if (type == FLOATING_CONSTANT) {
        return new HareFloatingConstantImpl(node);
      }
      else if (type == FLOATING_TYPE) {
        return new HareFloatingTypeImpl(node);
      }
      else if (type == FNDEC_ATTR) {
        return new HareFndecAttrImpl(node);
      }
      else if (type == FNTYPE_ATTR) {
        return new HareFntypeAttrImpl(node);
      }
      else if (type == FOR_LOOP) {
        return new HareForLoopImpl(node);
      }
      else if (type == FOR_PREDICATE) {
        return new HareForPredicateImpl(node);
      }
      else if (type == FUNCTION_DECLARATION) {
        return new HareFunctionDeclarationImpl(node);
      }
      else if (type == FUNCTION_TYPE) {
        return new HareFunctionTypeImpl(node);
      }
      else if (type == GENERAL_DECLARATION) {
        return new HareGeneralDeclarationImpl(node);
      }
      else if (type == GLOBAL_BINDING) {
        return new HareGlobalBindingImpl(node);
      }
      else if (type == GLOBAL_BINDINGS) {
        return new HareGlobalBindingsImpl(node);
      }
      else if (type == GLOBAL_DECLARATION) {
        return new HareGlobalDeclarationImpl(node);
      }
      else if (type == IDENTIFIER_PATH) {
        return new HareIdentifierPathImpl(node);
      }
      else if (type == IF_EXPRESSION) {
        return new HareIfExpressionImpl(node);
      }
      else if (type == IMPORTS) {
        return new HareImportsImpl(node);
      }
      else if (type == IMPORT_ALIAS) {
        return new HareImportAliasImpl(node);
      }
      else if (type == IMPORT_ID) {
        return new HareImportIdImpl(node);
      }
      else if (type == IMPORT_PATH) {
        return new HareImportPathImpl(node);
      }
      else if (type == INDEXING_OP) {
        return new HareIndexingOpImpl(node);
      }
      else if (type == INSERT_EXPRESSION) {
        return new HareInsertExpressionImpl(node);
      }
      else if (type == INTEGER_CONSTANT) {
        return new HareIntegerConstantImpl(node);
      }
      else if (type == INTEGER_SUFFIX) {
        return new HareIntegerSuffixImpl(node);
      }
      else if (type == INTEGER_TYPE) {
        return new HareIntegerTypeImpl(node);
      }
      else if (type == LABEL) {
        return new HareLabelImpl(node);
      }
      else if (type == LENGTH_EXPRESSION) {
        return new HareLengthExpressionImpl(node);
      }
      else if (type == MATCH_CASE) {
        return new HareMatchCaseImpl(node);
      }
      else if (type == MATCH_EXPRESSION) {
        return new HareMatchExpressionImpl(node);
      }
      else if (type == MEASUREMENT_EXPRESSION) {
        return new HareMeasurementExpressionImpl(node);
      }
      else if (type == MEMBER) {
        return new HareMemberImpl(node);
      }
      else if (type == MEMBER_LIST) {
        return new HareMemberListImpl(node);
      }
      else if (type == OBJECT_SELECTOR) {
        return new HareObjectSelectorImpl(node);
      }
      else if (type == OFFSET_EXPRESSION) {
        return new HareOffsetExpressionImpl(node);
      }
      else if (type == PARAMETER) {
        return new HareParameterImpl(node);
      }
      else if (type == PARAMETERS) {
        return new HareParametersImpl(node);
      }
      else if (type == PARAMETER_LIST) {
        return new HareParameterListImpl(node);
      }
      else if (type == PLAN_EXPRESSION) {
        return new HarePlanExpressionImpl(node);
      }
      else if (type == POINTER_TYPE) {
        return new HarePointerTypeImpl(node);
      }
      else if (type == POSTFIX_OP) {
        return new HarePostfixOpImpl(node);
      }
      else if (type == PROTOTYPE) {
        return new HarePrototypeImpl(node);
      }
      else if (type == RUNE_CONSTANT) {
        return new HareRuneConstantImpl(node);
      }
      else if (type == SCALA_TYPE) {
        return new HareScalaTypeImpl(node);
      }
      else if (type == SIZE_EXPRESSION) {
        return new HareSizeExpressionImpl(node);
      }
      else if (type == SLICE_ARRAY_TYPE) {
        return new HareSliceArrayTypeImpl(node);
      }
      else if (type == SLICE_MUTATION_EXPRESSION) {
        return new HareSliceMutationExpressionImpl(node);
      }
      else if (type == SLICING_EXPRESSION) {
        return new HareSlicingExpressionImpl(node);
      }
      else if (type == SLICING_OP) {
        return new HareSlicingOpImpl(node);
      }
      else if (type == STORAGE_CLASS) {
        return new HareStorageClassImpl(node);
      }
      else if (type == STRING_CONST) {
        return new HareStringConstImpl(node);
      }
      else if (type == STRUCT_INITIALIZER) {
        return new HareStructInitializerImpl(node);
      }
      else if (type == STRUCT_LITERAL) {
        return new HareStructLiteralImpl(node);
      }
      else if (type == STRUCT_UNION_FIELD) {
        return new HareStructUnionFieldImpl(node);
      }
      else if (type == STRUCT_UNION_FIELDS) {
        return new HareStructUnionFieldsImpl(node);
      }
      else if (type == STRUCT_UNION_TYPE) {
        return new HareStructUnionTypeImpl(node);
      }
      else if (type == SWITCH_CASE) {
        return new HareSwitchCaseImpl(node);
      }
      else if (type == SWITCH_EXPRESSION) {
        return new HareSwitchExpressionImpl(node);
      }
      else if (type == SYMBOL) {
        return new HareSymbolImpl(node);
      }
      else if (type == TAGGED_TYPES) {
        return new HareTaggedTypesImpl(node);
      }
      else if (type == TAGGED_UNION_TYPE) {
        return new HareTaggedUnionTypeImpl(node);
      }
      else if (type == TUPLE_ITEMS) {
        return new HareTupleItemsImpl(node);
      }
      else if (type == TUPLE_TYPE) {
        return new HareTupleTypeImpl(node);
      }
      else if (type == TUPLE_TYPES) {
        return new HareTupleTypesImpl(node);
      }
      else if (type == TYPE) {
        return new HareTypeImpl(node);
      }
      else if (type == TYPE_BINDING) {
        return new HareTypeBindingImpl(node);
      }
      else if (type == TYPE_BINDINGS) {
        return new HareTypeBindingsImpl(node);
      }
      else if (type == TYPE_DECLARATION) {
        return new HareTypeDeclarationImpl(node);
      }
      else if (type == UNARY_OPERATOR) {
        return new HareUnaryOperatorImpl(node);
      }
      else if (type == UNWRAPPED_ALIAS) {
        return new HareUnwrappedAliasImpl(node);
      }
      else if (type == USE_STATEMENT) {
        return new HareUseStatementImpl(node);
      }
      else if (type == USE_STATEMENT_MEMBER_LIST) {
        return new HareUseStatementMemberListImpl(node);
      }
      else if (type == VARIADIC_EXPRESSION) {
        return new HareVariadicExpressionImpl(node);
      }
      else if (type == YIELD_EXPRESSION) {
        return new HareYieldExpressionImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
