package raf.dsw.classycraft.app.core.treerepo.implementation;

import raf.dsw.classycraft.app.core.treerepo.abstraction.ClassyNode;
import raf.dsw.classycraft.app.core.treerepo.abstraction.ClassyNodeComposite;

public class ProjectExplorer extends ClassyNodeComposite {
    public ProjectExplorer(String name, ClassyNode parent) {
        super(name, parent);
    }

    public ProjectExplorer(String name) {
        super(name);
    }
}
