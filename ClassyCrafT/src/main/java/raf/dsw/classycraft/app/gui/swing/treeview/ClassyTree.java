package raf.dsw.classycraft.app.gui.swing.treeview;

import raf.dsw.classycraft.app.core.treemodel.nodes.abstractNodes.ClassyNode;
import raf.dsw.classycraft.app.core.treemodel.nodes.abstractNodes.ClassyNodeComposite;
import raf.dsw.classycraft.app.core.treemodel.nodes.projNodes.ProjectExplorer;
import raf.dsw.classycraft.app.gui.swing.treeview.view.ClassyTreeView;

public interface ClassyTree {
    ClassyTreeView generateTree(ProjectExplorer pe);
    ClassyNode CreateNode(ClassyNodeComposite parent,String type);
    boolean RenameSel(String name);
    boolean AppendChild(String type);
    boolean RemoveSel();





}
