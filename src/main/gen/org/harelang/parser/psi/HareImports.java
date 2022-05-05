// This is a generated file. Not intended for manual editing.
package org.harelang.parser.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface HareImports extends PsiElement {

  @NotNull
  List<HareUseStatement> getUseStatementList();

  @NotNull
  List<HareUseStatementMemberList> getUseStatementMemberListList();

}
