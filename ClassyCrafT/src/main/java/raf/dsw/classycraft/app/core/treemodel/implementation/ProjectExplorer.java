package raf.dsw.classycraft.app.core.treemodel.implementation;

import raf.dsw.classycraft.app.core.treemodel.abstraction.ClassyNode;
import raf.dsw.classycraft.app.core.treemodel.abstraction.ClassyNodeComposite;

public class ProjectExplorer extends ClassyNodeComposite {
    public ProjectExplorer(String name, ClassyNode parent) {
        super(name, parent);
    }

    public ProjectExplorer(String name) {
        super(name);
    }



    @Override
    public ClassyNode genChild() {
        return new Project(this);
    }

    @Override
    public ClassyNode genChild(String name) {
        return new Project(name,this);
    }
}
