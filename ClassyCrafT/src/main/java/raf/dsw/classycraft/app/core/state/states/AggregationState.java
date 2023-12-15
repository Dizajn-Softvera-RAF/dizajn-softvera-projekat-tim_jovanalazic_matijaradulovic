package raf.dsw.classycraft.app.core.state.states;

import raf.dsw.classycraft.app.core.state.State;
import raf.dsw.classycraft.app.core.treemodel.nodes.diagramNodes.connections.Aggregation;
import raf.dsw.classycraft.app.core.treemodel.nodes.diagramNodes.connections.Connection;
import raf.dsw.classycraft.app.core.treemodel.nodes.diagramNodes.entities.Interclass;
import raf.dsw.classycraft.app.core.treemodel.nodes.projNodes.Diagram;
import raf.dsw.classycraft.app.gui.swing.main.pkgview.DiagramView;

import java.awt.event.MouseEvent;

public class AggregationState extends ConnectionStateAbs implements State {


    @Override
    public void mouseDown(MouseEvent pos, DiagramView dviewv) {
        super.mouseDown(pos,dviewv);
    }

    @Override
    public void mouseUp(MouseEvent pos, DiagramView dviewv) {
        super.mouseUp(pos,dviewv);
    }

    @Override
    public void mouseDrag(MouseEvent pos, DiagramView dviewv) {
        super.mouseDrag(pos,dviewv);
    }

    @Override
    public void mouseWheeled(MouseEvent e, DiagramView source) {

    }



    @Override
    public Connection makeInstance(Interclass souce, String name, Diagram d) {
        return new Aggregation(souce,name,d);
    }
}
