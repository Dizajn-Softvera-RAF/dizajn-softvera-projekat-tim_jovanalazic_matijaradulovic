package raf.dsw.classycraft.app.core.treemodel.nodes.abstractNodes;

import java.util.Objects;

public abstract class ClassyNode implements Cloneable {

    protected String name;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name=name;
    }

    protected ClassyNodeComposite parent;

    public void setParent(ClassyNodeComposite parent) {
        this.parent=parent;
    }

    public ClassyNode getParent() {
        return parent;
    }

    public ClassyNode(String name, ClassyNodeComposite parent) {
        this.name = name;
        this.parent = parent;
    }

    public ClassyNode() {
    }

    public String getFullName() {
        return parent!=null? parent.getFullName()+name+"/" : "/";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClassyNode that = (ClassyNode) o;
        return this.getFullName().equals(that.getFullName());
    }
    public void removeSelf(){
        parent.removeChild(this);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, parent);
    }
}
