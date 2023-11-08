package raf.dsw.classycraft.app.gui.tree;

import raf.dsw.classycraft.app.core.treerepo.implementation.ProjectExplorer;
import raf.dsw.classycraft.app.gui.tree.model.ClassyTreeItem;
import raf.dsw.classycraft.app.gui.tree.view.ClassyTreeView;

import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;

public class ClassyTree implements IClassyTree{
    @Override
    public JTree generateTree(ProjectExplorer pe) {
        ClassyTreeItem root= new ClassyTreeItem(pe);
        DefaultTreeModel dtm=new DefaultTreeModel(root);
        return new ClassyTreeView(dtm);
    }
}
