// This is a generated file. Not intended for manual editing.
package org.harelang.parser.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static org.harelang.parser.psi.HareTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;

public class HareAssignmentImpl extends ASTWrapperPsiElement implements HareAssignment {

  public HareAssignmentImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull HareVisitor visitor) {
    visitor.visitAssignment(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof HareVisitor) accept((HareVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public HareAssignmentOp getAssignmentOp() {
    return findNotNullChildByClass(HareAssignmentOp.class);
  }

  @Override
  @NotNull
  public HareExpression getExpression() {
    return findNotNullChildByClass(HareExpression.class);
  }

  @Override
  @NotNull
  public HareObjectSelector getObjectSelector() {
    return findNotNullChildByClass(HareObjectSelector.class);
  }

}
