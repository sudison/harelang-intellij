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

public class HareImportsImpl extends ASTWrapperPsiElement implements HareImports {

  public HareImportsImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull HareVisitor visitor) {
    visitor.visitImports(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof HareVisitor) accept((HareVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<HareUseStatement> getUseStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, HareUseStatement.class);
  }

  @Override
  @NotNull
  public List<HareUseStatementMemberList> getUseStatementMemberListList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, HareUseStatementMemberList.class);
  }

}
