package raf.dsw.classycraft.app.core.state.states;

import raf.dsw.classycraft.app.core.state.State;
import raf.dsw.classycraft.app.gui.swing.main.pkgview.DiagramView;

import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

public class ZoomState implements State {

    @Override
    public void mouseDown(MouseEvent pos, DiagramView dview) {

    }

    @Override
    public void mouseUp(MouseEvent pos, DiagramView dview) {

    }

    @Override
    public void mouseDrag(MouseEvent pos, DiagramView dview) {

    }

    @Override
    public void mouseWheeled(MouseEvent e, DiagramView dviewv) {
        var dview=dviewv.getModel();

        var me=((MouseWheelEvent) e);
        double factor=1-0.1*me.getWheelRotation();
        System.out.println(factor);
        dview.zoomView(factor,e.getPoint());
    }
}
