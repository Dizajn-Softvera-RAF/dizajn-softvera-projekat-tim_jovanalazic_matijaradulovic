package raf.dsw.classycraft.app.gui.treeview;

import raf.dsw.classycraft.app.core.treemodel.abstraction.ClassyNode;
import raf.dsw.classycraft.app.core.treemodel.abstraction.ClassyNodeComposite;
import raf.dsw.classycraft.app.core.treemodel.implementation.ProjectExplorer;
import raf.dsw.classycraft.app.gui.treeview.model.ClassyTreeItem;
import raf.dsw.classycraft.app.gui.treeview.view.ClassyTreeView;

public interface ClassyTree {
    ClassyTreeView generateTree(ProjectExplorer pe);
    boolean AddChild(ClassyTreeItem parent);
    ClassyNode CreateNode(ClassyNodeComposite parent);
    boolean RenameItem(String newName, ClassyTreeItem item);
    void RemoveNode(ClassyTreeItem item);
    void AppendCild();
    void RemoveSel();

}
