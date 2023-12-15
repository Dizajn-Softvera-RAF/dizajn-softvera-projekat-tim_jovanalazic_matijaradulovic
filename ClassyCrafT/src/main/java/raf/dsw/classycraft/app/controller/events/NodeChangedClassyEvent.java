package raf.dsw.classycraft.app.controller.events;

import raf.dsw.classycraft.app.core.treemodel.nodes.abstractNodes.ClassyNode;

public class NodeChangedClassyEvent extends ClassyEvent {
    public ClassyNode getNode(){
        return ((ClassyNode) source);
    }
    public NodeChangedClassyEvent(ClassyNode node){
        super(node);
    }
}
