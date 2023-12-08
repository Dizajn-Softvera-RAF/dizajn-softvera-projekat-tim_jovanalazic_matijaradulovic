package raf.dsw.classycraft.app.gui.swing.main.pkgview;

import raf.dsw.classycraft.app.core.msggen.ISubscriber;
import raf.dsw.classycraft.app.core.treemodel.nodes.projNodes.Diagram;

import javax.swing.*;

public class DiagramViewPane extends JPanel implements ISubscriber {
    Diagram diag;
    private final PackageTabbedPane pane;
    public DiagramViewPane(Diagram diagram, PackageTabbedPane p) {
        diagram.addSubscriber(this);
        diag=diagram;
        pane=p;
    }

    @Override
    public void react(Object notification) {
        for (int i = 0; i < pane.getTabCount(); i++) {
            var tab= ((DiagramViewPane) pane.getComponent(i));
            if(tab!=null && tab.diag== notification)
            {
                pane.setTitleAt(i,tab.diag.getName());
                pane.validate();
                return;
            }
        }

    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof DiagramViewPane tab){
            return tab.diag.equals(diag);
        }
        return false;
    }
}
