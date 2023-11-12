package raf.dsw.classycraft.app.gui.swing.main.pkgview;

import raf.dsw.classycraft.app.core.msggen.generator.ISubscriber;
import raf.dsw.classycraft.app.core.treemodel.nodes.Diagram;
import raf.dsw.classycraft.app.core.treemodel.nodes.Package;

import javax.swing.*;

public class PackageTabbedPane extends JTabbedPane implements ISubscriber {
    Package packaged;
    public PackageTabbedPane(Package pack) {
        packaged=pack;
        if(packaged!=null){
            InitializeTabs();
            pack.addSubscriber(this);
        }
    }

    private void InitializeTabs() {
        if(packaged!=null)
            for (Diagram dig:packaged.getDiagrams()) {
                this.addTab(dig.getName(),new DiagramTab(dig,this));
            }
    }

    @Override
    public void react(Object notification) {
        this.removeAll();
        InitializeTabs();
    }
}
