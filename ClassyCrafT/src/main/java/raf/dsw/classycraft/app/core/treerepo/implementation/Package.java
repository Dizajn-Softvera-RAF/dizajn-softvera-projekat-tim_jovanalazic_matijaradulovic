package raf.dsw.classycraft.app.core.treerepo.implementation;

import raf.dsw.classycraft.app.core.treerepo.abstraction.ClassyNode;
import raf.dsw.classycraft.app.core.treerepo.abstraction.ClassyNodeComposite;

public class Package extends ClassyNodeComposite {

    public Package(String name, ClassyNode parent) {
        super(name, parent);
    }

    public Package(String name) {
        super(name);
    }
}
