package raf.dsw.classycraft.app.core.treerepo.implementation;

import raf.dsw.classycraft.app.core.treerepo.abstraction.ClassyNode;
import raf.dsw.classycraft.app.core.treerepo.abstraction.ClassyNodeComposite;

public class Project extends ClassyNodeComposite {
    String author;
    String path;

    public Project(String name, String author, String path, ClassyNode parent) {
        super(name, parent);
        this.author=author;
        this.path=path;
    }

    public Project(String name,String author, String path) {
        super(name);
        this.author=author;
        this.path=path;
    }
}
