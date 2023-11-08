package raf.dsw.classycraft.app.gui.tree.model;

import raf.dsw.classycraft.app.core.treerepo.abstraction.ClassyNode;

import javax.swing.tree.DefaultMutableTreeNode;

public class ClassyTreeItem extends DefaultMutableTreeNode {
    ClassyNode node;

    public ClassyTreeItem(ClassyNode node) {
        this.node = node;
    }

    public ClassyNode getNode() {
        return node;
    }

    public void setName(String name) {
        node.setName(name);
    }
}
