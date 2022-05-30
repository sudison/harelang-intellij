// This is a generated file. Not intended for manual editing.
package org.harelang.parser.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiNameIdentifierOwner;
import org.harelang.reference.HareNamedIdentifier;

public interface HareImportPath extends PsiNameIdentifierOwner, HareNamedIdentifier {

  @NotNull
  List<HareImportId> getImportIdList();

}
