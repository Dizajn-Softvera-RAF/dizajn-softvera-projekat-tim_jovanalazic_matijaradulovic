package raf.dsw.classycraft.app.core.state.states;

import raf.dsw.classycraft.app.core.treemodel.nodes.diagramNodes.DiagramElement;
import raf.dsw.classycraft.app.core.treemodel.nodes.diagramNodes.connections.Connection;
import raf.dsw.classycraft.app.core.treemodel.nodes.diagramNodes.entities.Interclass;
import raf.dsw.classycraft.app.core.treemodel.nodes.projNodes.Diagram;
import raf.dsw.classycraft.app.gui.swing.main.pkgview.DiagramView;
import raf.dsw.classycraft.app.gui.swing.painters.ConnectionPainter;
import raf.dsw.classycraft.app.gui.swing.painters.ElementPainter;
import raf.dsw.classycraft.app.gui.swing.painters.factory.PainterSimpleFactory;

import java.awt.event.MouseEvent;

public abstract class ConnectionStateAbs {

    boolean exi;

    public abstract Connection makeInstance(Interclass souce, String name, Diagram d);
    public void mouseDown(MouseEvent pos, DiagramView dviewv) {
        var dview=dviewv.getModel();
        var x=dview.underPointer(pos.getPoint());
        if(x!=null){
            exi=true;
            DiagramElement aggr= makeInstance((Interclass) x.getElement(),null,dview.getDiag());
            ElementPainter c = PainterSimpleFactory.makePainter(aggr);
            dview.setCurConn(((ConnectionPainter) c));
        }
    }

    public void mouseUp(MouseEvent pos, DiagramView dviewv) {
        var dview=dviewv.getModel();

        if(exi)
            dview.letGo(pos.getPoint());
        exi=false;
    }

    public void mouseDrag(MouseEvent pos, DiagramView dviewv) {
        var dview=dviewv.getModel();

        if(exi){
            dview.setConEnd(pos.getPoint());
        }
    }
}
