package raf.dsw.classycraft.app.core.treemodel.implementation;

import raf.dsw.classycraft.app.core.treemodel.abstraction.ClassyNode;

public class Diagram extends ClassyNode {
    public Diagram(String name, ClassyNode parent) {
        super(name, parent);
    }

    public Diagram(String name) {
        super(name);
    }
}
