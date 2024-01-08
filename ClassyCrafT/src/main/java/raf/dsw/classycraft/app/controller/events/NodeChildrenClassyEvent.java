package raf.dsw.classycraft.app.controller.events;

import raf.dsw.classycraft.app.core.treemodel.nodes.abstractNodes.ClassyNode;
import raf.dsw.classycraft.app.core.treemodel.nodes.abstractNodes.ClassyNodeComposite;

import java.util.*;

public class NodeChildrenClassyEvent extends ClassyEvent{
    List<ClassyNode> childrenl;
    ListIterator<ClassyNode> children;

    List<ClassyNode> rchildrenl;
    ListIterator<ClassyNode> rchildren;
    public void reset(){
        children=childrenl.listIterator();
        rchildren=rchildrenl.listIterator();
    }
    public boolean isRemoved(){
        return !rchildrenl.isEmpty();
    }
    public boolean isAdded(){
        return !childrenl.isEmpty();
    }
    public ClassyNode getNextAdded(){
        return children.next();
    }
    public boolean hasNextAdded(){
        return children.hasNext();
    }
    public ClassyNode getNextRemoved(){
        return rchildren.next();
    }
    public boolean hasNextRemoved(){
        return rchildren.hasNext();
    }
    public ClassyNodeComposite getParent(){
        return ((ClassyNodeComposite) source);
    }
    public NodeChildrenClassyEvent(List<ClassyNode> a,List<ClassyNode> r){
        childrenl=a;
        rchildrenl=r;
        children=childrenl.listIterator();
        rchildren=rchildrenl.listIterator();
    }
    public static ClassyEvent childrenAddedEvent(List<ClassyNode> c){
        return new NodeChildrenClassyEvent(c,new ArrayList<ClassyNode>());
    }
    public static ClassyEvent childAddedEvent(ClassyNode c){
        return childrenAddedEvent(Collections.singletonList(c));
    }
    public static ClassyEvent childRemovedEvent(ClassyNode c){
        return childrenRemovedEvent(Collections.singletonList(c));
    }
    public static ClassyEvent childrenRemovedEvent(List<ClassyNode> c){
        return new NodeChildrenClassyEvent(new ArrayList<ClassyNode>(),c);
    }
}
