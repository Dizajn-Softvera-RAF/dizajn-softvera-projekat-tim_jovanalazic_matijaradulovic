package raf.dsw.classycraft.app.core.treemodel.nodes.projNodes;

import raf.dsw.classycraft.app.core.msggen.IPublisher;
import raf.dsw.classycraft.app.core.msggen.ISubscriber;
import raf.dsw.classycraft.app.core.treemodel.nodes.abstractNodes.ClassyNode;
import raf.dsw.classycraft.app.core.treemodel.nodes.abstractNodes.ClassyNodeComposite;

import java.util.ArrayList;
import java.util.List;

public class Project extends ClassyNodeComposite implements IPublisher {
    String author;

    public void setAuthor(String author) {
        this.author = author;
        notifySubscribers(this);
    }
    public String getAuthor(){
        return author;
    }
    String path;

    public Project(String name, String author, String path, ClassyNode parent) {
        super(name, parent);
        this.author=author;
        this.path=path;
    }

    public Project() {
        author="nepoznat";
    }

    public Project(String name, ClassyNode parent) {
        super(name,parent);
        this.author="nepoznat";
        this.path="nepoznat";
    }


    @Override
    public void setName(String name) {
        super.setName(name);
        notifySubscribers(this);
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


}
