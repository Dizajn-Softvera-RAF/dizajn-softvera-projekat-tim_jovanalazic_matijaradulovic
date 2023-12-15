package raf.dsw.classycraft.app.gui.swing.main.pkgview;

import raf.dsw.classycraft.app.controller.events.NodeChildrenClassyEvent;
import raf.dsw.classycraft.app.controller.events.NodeChangedClassyEvent;
import raf.dsw.classycraft.app.core.msggen.ISubscriber;
import raf.dsw.classycraft.app.core.treemodel.nodes.projNodes.Diagram;
import raf.dsw.classycraft.app.core.treemodel.nodes.projNodes.Package;

import javax.swing.*;
import java.awt.*;

public class PackageTabbedPane extends JTabbedPane implements ISubscriber {
    Package packaged;
    public PackageTabbedPane(Package pack) {
        packaged=pack;
        Initialize();
    }

    private void InitializeTabs() {
        if(packaged!=null)
            for (Diagram dig:packaged.getDiagrams()) {
                addTab(dig);
            }
    }
    private void RemoveAllTabs(){
        while (this.getTabCount()>0){
            removeTab(0);
        }
    }
    private void addTab(Diagram d){
        d.addSubscriber(this);
        this.addTab(d.getName(),new DiagramView(d));
    }

    private void removeTab(int ind){
        var dv=((DiagramView) this.getComponentAt(ind));
        if(dv!=null) {
            var d=dv.getModel().getDiag();
            dv.Clean();
            d.removeSubscriber(this);
        }
        this.remove(ind);

    }
    private void removeTab(Diagram d){
        int ind=findTab(d);
        removeTab(ind);
    }
    @Override
    public void react(Object notification) { //diagram after name changed for tab title change, package after children changed for tab addition/removal
        if(notification instanceof NodeChangedClassyEvent edat && edat.getNode() instanceof Diagram d){
            //Diagram d= ((Diagram) edat.getSource());
            int ind=findTab(d);
            this.setTitleAt(ind,edat.getNode().getName());

        }
        else if(notification instanceof NodeChildrenClassyEvent cdat){
            Diagram child;
            while (cdat.hasNextRemoved()){
                child= ((Diagram) cdat.getNextRemoved());
                removeTab(child);
            }
            while (cdat.hasNextAdded()){
                if(cdat.getNextAdded() instanceof Diagram){
                child= ((Diagram) cdat.getNextAdded());
                addTab(child);
                }
            }
        }
    }

    public int findTab(Diagram d){
        for (int i=0;i<this.getTabCount();i++) {
            Component c=this.getComponentAt(i);
            if(((DiagramView) c).getModel().diag==d)
                return i;
        }
        return -1;
    }
    public DiagramView getDiagView() {
        return ((DiagramView) getSelectedComponent());
    }

    public void Clean(){
        RemoveAllTabs();
        if(packaged!=null){
            packaged.removeSubscriber(this);
        }
    }
    public void Initialize(){
        if(packaged!=null){
            InitializeTabs();
            packaged.addSubscriber(this);
        }
    }
}
