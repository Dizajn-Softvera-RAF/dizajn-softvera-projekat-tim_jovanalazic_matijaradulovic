package raf.dsw.classycraft.app.core.treerepo.implementation;

import raf.dsw.classycraft.app.core.treerepo.abstraction.ClassyNode;

public class Diagram extends ClassyNode {
    public Diagram(String name, ClassyNode parent) {
        super(name, parent);
    }

    public Diagram(String name) {
        super(name);
    }
}
