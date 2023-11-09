package raf.dsw.classycraft.app.core.treemodel.abstraction;

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

    public abstract ClassyNode genChild();
    public abstract ClassyNode genChild(String name);
    public boolean NameIsAvailable(String name){
        return !children.contains(genChild(name));//opt...
    }
    public ClassyNode genChild2(){//nameisavail..
        int nextNum=0;//Integer.MAX_VALUE;
        ClassyNode candidate=genChild("tmp");
        String classname=candidate.getClass().getSimpleName();
        do {
            nextNum++;
            candidate.setName(classname+nextNum);
        }while (children.contains(candidate));
        return candidate;
    }
}
