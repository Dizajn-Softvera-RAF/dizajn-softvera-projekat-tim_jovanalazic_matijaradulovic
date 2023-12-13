package raf.dsw.classycraft.app.core.state.states;

import raf.dsw.classycraft.app.core.state.State;
import raf.dsw.classycraft.app.core.treemodel.nodes.diagramNodes.connections.Dependency;
import raf.dsw.classycraft.app.core.treemodel.nodes.diagramNodes.connections.Generalization;
import raf.dsw.classycraft.app.core.treemodel.nodes.diagramNodes.entities.Interclass;
import raf.dsw.classycraft.app.gui.swing.main.pkgview.DiagramViewPane;
import raf.dsw.classycraft.app.gui.swing.painters.ConnectionPainter;
import raf.dsw.classycraft.app.gui.swing.painters.DependencyPainter;
import raf.dsw.classycraft.app.gui.swing.painters.GeneralizationPainter;

import java.awt.event.MouseEvent;

public class DependencyState extends State {

    boolean exi;
    @Override
    public void mouseDown(MouseEvent pos, DiagramViewPane dview) {
        var x=dview.underPointer(pos.getPoint());
        if(x!=null){
            exi=true;
            ConnectionPainter c =new DependencyPainter(new Dependency((Interclass) x.getElement(),"veza",dview.getDiag()));
            dview.setCurConn(c);
        }
    }

    @Override
    public void mouseUp(MouseEvent pos, DiagramViewPane dview) {
        if(exi)
            dview.letGo(pos.getPoint());
        exi=false;
    }

    @Override
    public void mouseDrag(MouseEvent pos, DiagramViewPane dview) {
        if(exi){
            dview.setConEnd(pos.getPoint());
        }
    }

    @Override
    public void mouseWheeled(MouseEvent e, DiagramViewPane source) {

    }
}
