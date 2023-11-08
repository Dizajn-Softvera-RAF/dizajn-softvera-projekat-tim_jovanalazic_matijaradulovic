package raf.dsw.classycraft.app.core.treerepo.abstraction;

import java.util.ArrayList;
import java.util.List;

public abstract class ClassyNodeComposite extends ClassyNode{
    List<ClassyNode> children;

    public ClassyNodeComposite(String name, ClassyNode parent) {
        super(name, parent);
        children=new ArrayList<>();
    }

    public ClassyNodeComposite(String name) {
        super(name);
        children=new ArrayList<>();
    }

    public void AddChild(ClassyNode child){
        children.add(child);
    }
    public void removeChild(ClassyNode child){
        children.remove(child);
    }
}
