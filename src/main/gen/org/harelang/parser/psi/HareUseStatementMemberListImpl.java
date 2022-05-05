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

public class HareUseStatementMemberListImpl extends ASTWrapperPsiElement implements HareUseStatementMemberList {

  public HareUseStatementMemberListImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull HareVisitor visitor) {
    visitor.visitUseStatementMemberList(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof HareVisitor) accept((HareVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<HareImportAlias> getImportAliasList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, HareImportAlias.class);
  }

  @Override
  @NotNull
  public HareImportPath getImportPath() {
    return findNotNullChildByClass(HareImportPath.class);
  }

  @Override
  @NotNull
  public HareMemberList getMemberList() {
    return findNotNullChildByClass(HareMemberList.class);
  }

}
