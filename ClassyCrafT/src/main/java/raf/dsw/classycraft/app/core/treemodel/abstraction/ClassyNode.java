package raf.dsw.classycraft.app.core.treemodel.abstraction;

import java.util.Objects;

public abstract class ClassyNode {
    public String getName() {
        return name;
    }

    protected String name;

    public ClassyNode getParent() {
        return parent;
    }

    protected ClassyNode parent;

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


    public void setName(String name) {
        this.name=name;
    }
    public String getFullName() //hmljmvmlj
    {
        return parent!=null? parent.getFullName()+name+"/" : "/";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClassyNode that = (ClassyNode) o;
        return this.getFullName().equals(that.getFullName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, parent);
    }
}
