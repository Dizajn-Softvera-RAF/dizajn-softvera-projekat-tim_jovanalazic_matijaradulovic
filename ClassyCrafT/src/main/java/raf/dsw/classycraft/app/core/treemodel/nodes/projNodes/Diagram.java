package raf.dsw.classycraft.app.core.treemodel.nodes.projNodes;

import raf.dsw.classycraft.app.core.msggen.IPublisher;
import raf.dsw.classycraft.app.core.msggen.ISubscriber;
import raf.dsw.classycraft.app.core.treemodel.nodes.abstractNodes.ClassyNode;
import raf.dsw.classycraft.app.core.treemodel.nodes.abstractNodes.ClassyNodeComposite;

import java.util.ArrayList;
import java.util.List;

public class Diagram extends ClassyNodeComposite implements IPublisher {
    public Diagram(String name, ClassyNodeComposite parent) {
        super(name, parent);
    }

    public Diagram() {
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
    public void setName(String name) {
        super.setName(name);
        ((Package) parent).notifySubscribers(parent);
    }

    @Override
    public void notifySubscribers(Object notification) {
        for (ISubscriber sub:subscribers) {
            sub.react (this);
        }
    }

    @Override
    public void AddChild(ClassyNode child) {
        super.AddChild(child);
        notifySubscribers(this);
    }
    @Override
    public void removeChild(ClassyNode child) {
        super.removeChild(child);
        notifySubscribers(this);
    }


}
