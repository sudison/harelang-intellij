// This is a generated file. Not intended for manual editing.
package org.harelang.parser.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface HareExpression extends PsiElement {

  @Nullable
  HareBindingList getBindingList();

  @NotNull
  List<HareExpression> getExpressionList();

  @NotNull
  List<HarePlanExpression> getPlanExpressionList();

}
