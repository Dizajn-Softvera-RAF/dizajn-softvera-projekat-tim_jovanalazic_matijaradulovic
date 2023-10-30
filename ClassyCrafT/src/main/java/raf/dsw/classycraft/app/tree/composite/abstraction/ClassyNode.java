package raf.dsw.classycraft.app.tree.composite.abstraction;

public abstract class ClassyNode {
    String name;
    private ClassyNode parent;

    public ClassyNode(String name, ClassyNode parent) {
        this.name = name;
        this.parent = parent;
    }

    public ClassyNode(String name) {
        this.name = name;
    }

    public void setParent(ClassyNode parent) {
        this.parent = parent;
    }


}
