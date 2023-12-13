package raf.dsw.classycraft.app.core.state.states;

import raf.dsw.classycraft.app.core.state.State;
import raf.dsw.classycraft.app.gui.swing.main.pkgview.DiagramViewPane;

import javax.swing.event.MenuDragMouseEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

public class ZoomState extends State {

    @Override
    public void mouseDown(MouseEvent pos, DiagramViewPane dview) {

    }

    @Override
    public void mouseUp(MouseEvent pos, DiagramViewPane dview) {

    }

    @Override
    public void mouseDrag(MouseEvent pos, DiagramViewPane dview) {

    }

    @Override
    public void mouseWheeled(MouseEvent e, DiagramViewPane source) {
        var me=((MouseWheelEvent) e);
        double factor=1-0.1*me.getWheelRotation();
        System.out.println(factor);
        source.zoomView(factor,e.getPoint());
    }
}
