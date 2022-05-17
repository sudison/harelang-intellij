// This is a generated file. Not intended for manual editing.
package org.harelang.parser.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static org.harelang.parser.psi.HareTypes.*;
import org.harelang.reference.GlobalBindingMixin;

public class HareTypeBindingImpl extends GlobalBindingMixin implements HareTypeBinding {

  public HareTypeBindingImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull HareVisitor visitor) {
    visitor.visitTypeBinding(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof HareVisitor) accept((HareVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public HareIdentifierPath getIdentifierPath() {
    return findNotNullChildByClass(HareIdentifierPath.class);
  }

  @Override
  @NotNull
  public HareType getType() {
    return findNotNullChildByClass(HareType.class);
  }

}
