package raf.dsw.classycraft.app.core.treemodel.nodes;

public class ProjectExplorer extends ClassyNodeComposite {
    public ProjectExplorer(String name, ClassyNode parent) {
        super(name, parent);
    }

    public ProjectExplorer(String name) {
        super(name,null);
    }

    @Override
    public ClassyNode genChild() {
        return new Project(null,this);
    }
}
