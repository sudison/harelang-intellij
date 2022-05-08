// This is a generated file. Not intended for manual editing.
package org.harelang.parser.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface HareCallExpression extends PsiElement {

  @Nullable
  HareArgumentList getArgumentList();

  @Nullable
  HareExpression getExpression();

  @Nullable
  HarePlanExpression getPlanExpression();

  @NotNull
  List<HarePostfixOp> getPostfixOpList();

  @Nullable
  HareTupleItems getTupleItems();

}
