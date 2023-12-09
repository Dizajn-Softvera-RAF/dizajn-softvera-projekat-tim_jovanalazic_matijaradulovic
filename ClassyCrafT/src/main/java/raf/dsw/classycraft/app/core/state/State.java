package raf.dsw.classycraft.app.core.state;

import raf.dsw.classycraft.app.gui.swing.main.pkgview.DiagramViewPane;

import java.awt.*;

public abstract class State {
    public abstract void mouseDown(Point pos, DiagramViewPane dview);
    public abstract void mouseUp(Point pos,DiagramViewPane dview);
    public abstract void mouseDrag(Point pos,DiagramViewPane dview);
}
