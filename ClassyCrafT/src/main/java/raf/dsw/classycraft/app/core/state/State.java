package raf.dsw.classycraft.app.core.state;

import raf.dsw.classycraft.app.gui.swing.main.pkgview.DiagramView;

import java.awt.event.MouseEvent;

public abstract interface State {
    public abstract void mouseDown(MouseEvent pos, DiagramView dview);
    public abstract void mouseUp(MouseEvent pos, DiagramView dview);
    public abstract void mouseDrag(MouseEvent pos, DiagramView dview);

    public abstract void mouseWheeled(MouseEvent e, DiagramView source);
}
