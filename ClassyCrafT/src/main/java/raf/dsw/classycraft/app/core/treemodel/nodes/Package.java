package raf.dsw.classycraft.app.core.treemodel.nodes;

import raf.dsw.classycraft.app.core.msggen.generator.IPublisher;
import raf.dsw.classycraft.app.core.msggen.generator.ISubscriber;

import java.util.ArrayList;
import java.util.List;

public class Package extends ClassyNodeComposite implements IPublisher {

    public Package(String name, ClassyNode parent) {
        super(name, parent);
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
    public void notifySubscribers(Object notification) {
        for (ISubscriber sub:subscribers) {
            sub.react (this);
        }
    }

    public Project getProject(){
        ClassyNode currper=this;
        while ( !(currper.parent instanceof Project)){
            currper=currper.parent;
        }
        return (Project) currper.parent;
    }
}
