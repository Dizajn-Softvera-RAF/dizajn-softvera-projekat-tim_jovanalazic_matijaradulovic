package raf.dsw.classycraft.app.tree.composite.implementation;

import raf.dsw.classycraft.app.tree.composite.abstraction.ClassyNode;
import raf.dsw.classycraft.app.tree.composite.abstraction.ClassyNodeComposite;

public class Package extends ClassyNodeComposite {

    public Package(String name, ClassyNode parent) {
        super(name, parent);
    }

    public Package(String name) {
        super(name);
    }
}
