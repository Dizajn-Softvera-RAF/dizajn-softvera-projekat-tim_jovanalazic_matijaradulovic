package raf.dsw.classycraft.app.tree.composite.implementation;

import raf.dsw.classycraft.app.tree.composite.abstraction.ClassyNode;
import raf.dsw.classycraft.app.tree.composite.abstraction.ClassyNodeComposite;

public class ProjectExplorer extends ClassyNodeComposite {
    public ProjectExplorer(String name, ClassyNode parent) {
        super(name, parent);
    }

    public ProjectExplorer(String name) {
        super(name);
    }
}
