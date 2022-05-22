// This is a generated file. Not intended for manual editing.
package org.harelang.parser.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface HareFieldValue extends PsiElement {

  @Nullable
  HareExpression getExpression();

  @Nullable
  HareStructLiteral getStructLiteral();

  @Nullable
  HareSymbol getSymbol();

  @Nullable
  HareType getType();

}
