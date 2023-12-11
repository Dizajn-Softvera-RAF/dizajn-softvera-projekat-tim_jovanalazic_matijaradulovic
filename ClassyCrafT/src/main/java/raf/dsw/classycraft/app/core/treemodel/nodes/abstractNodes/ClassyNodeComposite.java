package raf.dsw.classycraft.app.core.treemodel.nodes.abstractNodes;

import java.util.ArrayList;
import java.util.List;

public abstract class ClassyNodeComposite extends ClassyNode{
    protected List<ClassyNode> children=new ArrayList<>();

    public ClassyNodeComposite(String name, ClassyNodeComposite parent) {
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

    public List<ClassyNode> getChildren() {
        return children;
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
