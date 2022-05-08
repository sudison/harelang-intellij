// This is a generated file. Not intended for manual editing.
package org.harelang.parser.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface HareControlExpression extends PsiElement {

  @Nullable
  HareExpression getExpression();

  @Nullable
  HareLabel getLabel();

  @Nullable
  HareYieldExpression getYieldExpression();

}
