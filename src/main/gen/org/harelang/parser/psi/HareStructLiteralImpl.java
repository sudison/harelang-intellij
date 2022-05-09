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

public class HareStructLiteralImpl extends ASTWrapperPsiElement implements HareStructLiteral {

  public HareStructLiteralImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull HareVisitor visitor) {
    visitor.visitStructLiteral(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof HareVisitor) accept((HareVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public HareFieldValues getFieldValues() {
    return findChildByClass(HareFieldValues.class);
  }

  @Override
  @Nullable
  public HareIdentifierPath getIdentifierPath() {
    return findChildByClass(HareIdentifierPath.class);
  }

  @Override
  @Nullable
  public HareStructInitializer getStructInitializer() {
    return findChildByClass(HareStructInitializer.class);
  }

}
