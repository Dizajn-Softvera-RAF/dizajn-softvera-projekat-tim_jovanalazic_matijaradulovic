package raf.dsw.classycraft.app.core.state;

import raf.dsw.classycraft.app.gui.swing.main.pkgview.DiagramViewPane;

import java.awt.event.MouseEvent;

public abstract class State {
    public abstract void mouseDown(MouseEvent pos, DiagramViewPane dview);
    public abstract void mouseUp(MouseEvent pos, DiagramViewPane dview);
    public abstract void mouseDrag(MouseEvent pos, DiagramViewPane dview);

    public abstract void mouseWheeled(MouseEvent e, DiagramViewPane source);
}
