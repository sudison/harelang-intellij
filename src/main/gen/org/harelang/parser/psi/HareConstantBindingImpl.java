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

public class HareConstantBindingImpl extends ASTWrapperPsiElement implements HareConstantBinding {

  public HareConstantBindingImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull HareVisitor visitor) {
    visitor.visitConstantBinding(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof HareVisitor) accept((HareVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public HareExpression getExpression() {
    return findChildByClass(HareExpression.class);
  }

  @Override
  @NotNull
  public HareIdentifierPath getIdentifierPath() {
    return findNotNullChildByClass(HareIdentifierPath.class);
  }

  @Override
  @Nullable
  public HareType getType() {
    return findChildByClass(HareType.class);
  }

}
