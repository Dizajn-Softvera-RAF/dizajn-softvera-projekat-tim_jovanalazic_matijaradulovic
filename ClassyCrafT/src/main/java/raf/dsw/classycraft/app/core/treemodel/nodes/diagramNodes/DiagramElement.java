package raf.dsw.classycraft.app.core.treemodel.nodes.diagramNodes;

import raf.dsw.classycraft.app.controller.events.NodeChangedClassyEvent;
import raf.dsw.classycraft.app.core.msggen.IPublisher;
import raf.dsw.classycraft.app.core.msggen.ISubscriber;
import raf.dsw.classycraft.app.core.treemodel.nodes.abstractNodes.ClassyNode;
import raf.dsw.classycraft.app.core.treemodel.nodes.abstractNodes.ClassyNodeComposite;
import raf.dsw.classycraft.app.core.treemodel.nodes.abstractNodes.ClassyNodeLeaf;
import raf.dsw.classycraft.app.core.treemodel.nodes.projNodes.Diagram;
import raf.dsw.classycraft.app.core.treemodel.nodes.projNodes.ProjectExplorer;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public abstract class DiagramElement extends ClassyNodeLeaf implements Cloneable, IPublisher {
    protected Color col;
    int stroke;

    public int getStroke() {
        return stroke;
    }

    public void ParentsNotify(Object notif){
        ((Diagram) getParent()).notifySubscribers(notif);

    }

    public DiagramElement() {

    }

    @Override
    public void setName(String name) {
        super.setName(name);
        ParentsNotify(new NodeChangedClassyEvent(this));
    }

    public void setDiagram(Diagram d) {
        parent=d;

    }
    public Color getCol() {
        return col;
    }
    public DiagramElement(String n, ClassyNodeComposite parent){
        super(n,parent);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    List<ISubscriber> subscribers=new ArrayList<>();
    @Override
    public void addSubscriber(ISubscriber subscr) {
        subscribers.add(subscr);
    }

    @Override
    public void removeSubscriber(ISubscriber subscr) {
        subscribers.remove(subscr);
    }

    @Override
    public void notifySubscribers(Object notification) {
        for (var s:subscribers) {
            s.react(notification);
        }
    }
}
