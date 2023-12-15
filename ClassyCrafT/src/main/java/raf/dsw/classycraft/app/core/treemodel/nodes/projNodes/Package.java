package raf.dsw.classycraft.app.core.treemodel.nodes.projNodes;

import raf.dsw.classycraft.app.controller.events.NodeChildrenClassyEvent;
import raf.dsw.classycraft.app.core.msggen.IPublisher;
import raf.dsw.classycraft.app.core.msggen.ISubscriber;
import raf.dsw.classycraft.app.core.treemodel.nodes.abstractNodes.ClassyNode;
import raf.dsw.classycraft.app.core.treemodel.nodes.abstractNodes.ClassyNodeComposite;

import java.util.ArrayList;
import java.util.List;

public class Package extends ClassyNodeComposite implements IPublisher {

    public Package(String name, ClassyNodeComposite parent) {
        super(name, parent);
    }

    @Override
    public void AddChild(ClassyNode child) {
        super.AddChild(child);
        notifySubscribers(NodeChildrenClassyEvent.childAddedEvent(child));
    }

    @Override
    public void removeChild(ClassyNode child) {
        super.removeChild(child);
        notifySubscribers(NodeChildrenClassyEvent.childRemovedEvent(child));

    }

    public Package() {
    }
    public List<Diagram> getDiagrams(){
        List<Diagram> res=new ArrayList<Diagram>();
        for (ClassyNode child:children) {
            if(child instanceof Diagram d){
                res.add(d);
            }
        }
        return res;
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
    public void notifySubscribers(Object notification) { //notifies package tabbed pane for diagram tab addition/removal
        for (ISubscriber sub:subscribers) {
            sub.react (notification);
        }
    }

    public Project getProject(){
        ClassyNode currper=this;
        while ( !(currper.getParent() instanceof Project)){
            currper=currper.getParent();
        }
        return (Project) currper.getParent();
    }
}
