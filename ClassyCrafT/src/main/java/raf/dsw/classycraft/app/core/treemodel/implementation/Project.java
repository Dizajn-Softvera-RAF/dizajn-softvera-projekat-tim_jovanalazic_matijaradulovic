package raf.dsw.classycraft.app.core.treemodel.implementation;

import raf.dsw.classycraft.app.core.treemodel.abstraction.ClassyNode;
import raf.dsw.classycraft.app.core.treemodel.abstraction.ClassyNodeComposite;

public class Project extends ClassyNodeComposite {
    static int projcount;
    String author;
    String path;

    public Project(String name, String author, String path, ClassyNode parent) {
        super(name, parent);
        this.author=author;
        this.path=path;
    }

    public Project(String name,ClassyNode parent) {
        super(name,parent);
        this.author="unknown";
        this.path="unknown";
    }

    public Project(ClassyNode parent) {
        this("project"+projcount++,parent);
    }

    @Override
    public ClassyNode genChild() {
        return new Package(this);
    }

    @Override
    public ClassyNode genChild(String name) {
        return new Package(name,this);
    }


}
