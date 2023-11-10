package raf.dsw.classycraft.app.core.treemodel.nodes;

import java.util.ArrayList;
import java.util.List;

public abstract class ClassyNodeComposite extends ClassyNode{
    List<ClassyNode> children=new ArrayList<>();;
    public ClassyNodeComposite(String name, ClassyNode parent) {
        super(name, parent);
    }

    public ClassyNodeComposite() {

    }

    public void AddChild(ClassyNode child){
        children.add(child);
    }
    public void removeChild(ClassyNode child){
        children.remove(child);
    }


    public abstract ClassyNode genChild();
    private ClassyNode genNamedChild(){ //deprecated :)
        int nextNum=0;
        ClassyNode candidate= genChild();
        String classname=candidate.getClass().getSimpleName();
        do {
            nextNum++;
            candidate.setName(classname+nextNum);
        }while (children.contains(candidate));
        return candidate;
    }
    public boolean NameIsAvailable(String name){
        for (ClassyNode nd:children) {
            if(nd.name.equals(name))
                return false;
        }
        return true;
    }
    public boolean isUnique(ClassyNode node){
        if(node.parent!=this)
            return true;
        for (ClassyNode nod:children) {
            if(nod!=node&&nod.getClass()==node.getClass() && nod.name.equals(node.name))
                return false;
        }
        return true;
    }
    public void NameChild(ClassyNode node){
        int num=1;
        do {
            node.setName(node.getClass().getSimpleName()+num++);
        }while (!isUnique(node));
    }
}
