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

public class HareGeneralDeclarationImpl extends ASTWrapperPsiElement implements HareGeneralDeclaration {

  public HareGeneralDeclarationImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull HareVisitor visitor) {
    visitor.visitGeneralDeclaration(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof HareVisitor) accept((HareVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public HareConstantDeclaration getConstantDeclaration() {
    return findChildByClass(HareConstantDeclaration.class);
  }

  @Override
  @Nullable
  public HareFunctionDeclaration getFunctionDeclaration() {
    return findChildByClass(HareFunctionDeclaration.class);
  }

  @Override
  @Nullable
  public HareGlobalDeclaration getGlobalDeclaration() {
    return findChildByClass(HareGlobalDeclaration.class);
  }

  @Override
  @Nullable
  public HareTypeDeclaration getTypeDeclaration() {
    return findChildByClass(HareTypeDeclaration.class);
  }

}
