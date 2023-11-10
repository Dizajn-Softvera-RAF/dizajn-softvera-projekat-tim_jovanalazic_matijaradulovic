package raf.dsw.classycraft.app.gui.treeview;

import raf.dsw.classycraft.app.core.treemodel.nodes.ClassyNode;
import raf.dsw.classycraft.app.core.treemodel.nodes.ClassyNodeComposite;
import raf.dsw.classycraft.app.core.treemodel.nodes.ProjectExplorer;
import raf.dsw.classycraft.app.gui.treeview.model.ClassyTreeItem;
import raf.dsw.classycraft.app.gui.treeview.view.ClassyTreeView;

public interface ClassyTree {
    ClassyTreeView generateTree(ProjectExplorer pe);

    boolean AddChild(ClassyTreeItem parent,String type);
    ClassyNode CreateNode(ClassyNodeComposite parent,String type);
    boolean RenameItem( ClassyTreeItem item,String newName);
    boolean RenameSel(String name);
    void RemoveNode(ClassyTreeItem item);
    void AppendChild(String type);
    //void AppendChildSecondary();
    void RemoveSel();
    void RenameAuthSel(String name);
    boolean isProjSel();
    boolean isPackSel();


}
