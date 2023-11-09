package raf.dsw.classycraft.app.gui.treeview.model;

import raf.dsw.classycraft.app.core.treemodel.abstraction.ClassyNode;

import javax.swing.tree.DefaultMutableTreeNode;

public class ClassyTreeItem extends DefaultMutableTreeNode {
    ClassyNode node;

    public ClassyTreeItem(ClassyNode node) {
        this.node = node;
    }

    public ClassyNode getNode() {
        return node;
    }

    @Override
    public String toString() {
        return node.getName();
    }

    public void setName(String name) {
        node.setName(name); //ew
    }
}
