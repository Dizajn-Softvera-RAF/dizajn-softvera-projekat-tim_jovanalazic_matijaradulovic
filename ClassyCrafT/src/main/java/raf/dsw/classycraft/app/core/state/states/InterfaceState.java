package raf.dsw.classycraft.app.core.state.states;

import raf.dsw.classycraft.app.core.state.State;
import raf.dsw.classycraft.app.core.treemodel.nodes.diagramNodes.entities.ClassyInterface;
import raf.dsw.classycraft.app.gui.swing.main.pkgview.DiagramView;

import java.awt.event.MouseEvent;

public class InterfaceState extends InterClassStateAbs implements State {
    {
        prototype=new ClassyInterface();
    }
    @Override
    public void mouseDown(MouseEvent pos, DiagramView dviewv) {
        super.mouseDown(pos,dviewv);
    }

    @Override
    public void mouseUp(MouseEvent pos, DiagramView dview) {

    }

    @Override
    public void mouseDrag(MouseEvent pos, DiagramView dview) {

    }

    @Override
    public void mouseWheeled(MouseEvent e, DiagramView source) {

    }
}
