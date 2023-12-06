package raf.dsw.classycraft.app.core.treemodel.nodes;

import raf.dsw.classycraft.app.core.msggen.generator.IPublisher;
import raf.dsw.classycraft.app.core.msggen.generator.ISubscriber;

import java.util.ArrayList;
import java.util.List;

public class Diagram extends ClassyNodeComposite implements IPublisher {
    public Diagram(String name, ClassyNode parent) {
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
        notifySubscribers(this);
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
}
