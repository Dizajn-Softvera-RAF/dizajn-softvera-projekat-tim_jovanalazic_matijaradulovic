package raf.dsw.classycraft.app.gui.swing.painters;

import java.awt.*;

public class ConnectionPainter extends ElementPainter{
    @Override
    public boolean elementAt(Point pos) {
        int prec=5;
        Rectangle c=new Rectangle(pos.x-prec/2,pos.y-prec/2,prec,prec);
        return shape.intersects(c);
    }

    @Override
    public void paint(Graphics2D g) {

    }
}
