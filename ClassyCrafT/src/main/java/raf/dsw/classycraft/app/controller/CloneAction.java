package raf.dsw.classycraft.app.controller;

import raf.dsw.classycraft.app.core.treemodel.nodes.diagramNodes.entities.Interclass;
import raf.dsw.classycraft.app.gui.swing.main.MainFrame;
import raf.dsw.classycraft.app.gui.swing.main.pkgview.DiagramViewPane;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class CloneAction extends AbstractClassyAction{
    public CloneAction() {
        Icon icon=this.loadIcon("/images/dup.png");
        putValue(SMALL_ICON, icon);
        putValue(NAME, "Duplicate element");
        putValue(SHORT_DESCRIPTION, "Duplicate");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        DiagramViewPane dv= MainFrame.getInstance().getPkgpane().getActiveDiagramP();
        if(dv.SingleSel()){
            var x=dv.getSelected().getElement();
            if(x instanceof Interclass i){
                Interclass xp=i.getCopy();
                xp.getPos().translate(xp.getDim().width+10,0);
                dv.AddInterClass(xp);
            }
        }
    }
}
