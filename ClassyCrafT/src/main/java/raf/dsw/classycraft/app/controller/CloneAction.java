package raf.dsw.classycraft.app.controller;

import raf.dsw.classycraft.app.core.treemodel.nodes.diagramNodes.entities.Interclass;
import raf.dsw.classycraft.app.gui.swing.main.MainFrame;
import raf.dsw.classycraft.app.gui.swing.main.pkgview.DiagramViewModel;
import raf.dsw.classycraft.app.gui.swing.main.pkgview.DiagramView;
import raf.dsw.classycraft.app.gui.swing.painters.factory.PainterSimpleFactory;

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
        DiagramView dvv= MainFrame.getInstance().getPkgpane().getActiveDiagramP();
        if(dvv==null) return;
        DiagramViewModel dv=dvv.getModel();
        if(dv.SingleSel()){
            var x=dv.getSelected().getElement();
            if(x instanceof Interclass i){
                Interclass xp=i.CopyGet();
                xp.getPos().translate(xp.getDim().width+10,0);
                dv.AddPainter(PainterSimpleFactory.makePainter(xp));
            }
        }
    }
}
