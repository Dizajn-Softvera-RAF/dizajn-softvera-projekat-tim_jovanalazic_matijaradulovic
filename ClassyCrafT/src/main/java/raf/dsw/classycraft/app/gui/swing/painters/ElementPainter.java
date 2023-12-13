package raf.dsw.classycraft.app.gui.swing.painters;

import raf.dsw.classycraft.app.core.treemodel.nodes.diagramNodes.DiagramElement;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;

public abstract class ElementPainter {
    DiagramElement element;
    Shape shape;
    boolean isSelected;
    //Stroke stroke=new BasicStroke(2,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND);
    public void setSelected(boolean selected) {
        isSelected = selected;
        //element.IChanged();
    }
    public Rectangle getBounds(){
        return shape.getBounds();
    }
    public boolean isSelected() {
        return isSelected;
    }
    public void toggleSel(){
        isSelected=!isSelected;
    }

    public DiagramElement getElement() {
        return element;
    }

    public abstract void paint(Graphics2D g);
    public  boolean elementAt(Point pos){
        return shape.contains(pos);
    }
    public static void drawSelRect(Graphics2D g,Rectangle2D r){
        g.setColor(Color.BLACK);
        final float dash1[] = {10.0f};
         final BasicStroke dashed =
                new BasicStroke(1.0f,
                        BasicStroke.CAP_BUTT,
                        BasicStroke.JOIN_MITER,
                        10.0f, dash1, 0.0f);
         g.setStroke(dashed);
        g.draw(r);
    }
}
