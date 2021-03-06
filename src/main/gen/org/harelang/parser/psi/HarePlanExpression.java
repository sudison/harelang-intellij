// This is a generated file. Not intended for manual editing.
package org.harelang.parser.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface HarePlanExpression extends PsiElement {

  @Nullable
  HareArrayLiteral getArrayLiteral();

  @Nullable
  HareConstant getConstant();

  @Nullable
  HareEnumLiteral getEnumLiteral();

  @Nullable
  HareStructLiteral getStructLiteral();

  @Nullable
  HareSymbol getSymbol();

}
