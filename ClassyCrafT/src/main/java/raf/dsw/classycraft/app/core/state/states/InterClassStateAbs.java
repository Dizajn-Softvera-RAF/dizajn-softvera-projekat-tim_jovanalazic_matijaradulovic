package raf.dsw.classycraft.app.core.state.states;

import raf.dsw.classycraft.app.core.treemodel.nodes.diagramNodes.entities.Interclass;
import raf.dsw.classycraft.app.core.treemodel.nodes.projNodes.Diagram;
import raf.dsw.classycraft.app.gui.swing.main.MainFrame;
import raf.dsw.classycraft.app.gui.swing.main.pkgview.DiagramView;
import raf.dsw.classycraft.app.gui.swing.painters.factory.PainterSimpleFactory;
import raf.dsw.classycraft.app.gui.swing.popups.EditEntDialog;

import java.awt.*;
import java.awt.event.MouseEvent;

public abstract class InterClassStateAbs {

    Interclass prototype;
    public Interclass makeInstance(Point pos, Diagram d){
        var x=prototype.CopyGet();
        x.setPos(pos);
        x.setDiagram(d);
        d.AddChild(x);
        return x;
    }
    public void mouseDown(MouseEvent pos, DiagramView dviewv) {
        //dview.resetSelection();
        var dview=dviewv.getModel();
        Interclass cls=  makeInstance(pos.getPoint(),dview.getDiag());
        EditEntDialog d=EditEntDialog.getDialog(cls);
        d.ShowDialog(MainFrame.getInstance());
        if(cls.getName()==null||cls.getName().isEmpty()) cls.removeSelf();
        else dview.AddPainter(PainterSimpleFactory.makePainter(cls));
    }
}
