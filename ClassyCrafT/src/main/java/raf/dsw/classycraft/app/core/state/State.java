package raf.dsw.classycraft.app.core.state;

import java.awt.*;

public abstract class State {
    public abstract void mouseDown(Point pos);
    public abstract void mouseUp(Point pos);
    public abstract void mouseDrag(Point pos);
}
