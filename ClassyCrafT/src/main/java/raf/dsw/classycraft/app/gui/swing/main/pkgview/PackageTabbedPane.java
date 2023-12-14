package raf.dsw.classycraft.app.gui.swing.main.pkgview;

import raf.dsw.classycraft.app.core.msggen.ISubscriber;
import raf.dsw.classycraft.app.core.treemodel.nodes.projNodes.Diagram;
import raf.dsw.classycraft.app.core.treemodel.nodes.projNodes.Package;

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
                var na=dig.getName();
                var dv=new DiagramViewPane(dig,this);
                this.addTab(na,dv);
            }
    }

    @Override
    public void react(Object notification) {
        this.removeAll();
        InitializeTabs();
    }

    public DiagramViewPane getDiagView() {
        return ((DiagramViewPane) getSelectedComponent());
    }
}
