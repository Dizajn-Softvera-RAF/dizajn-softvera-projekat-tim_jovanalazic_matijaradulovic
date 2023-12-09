package raf.dsw.classycraft.app.gui.swing.painters;

import raf.dsw.classycraft.app.core.treemodel.nodes.diagramNodes.DiagramElement;

import java.awt.*;
import java.awt.geom.GeneralPath;

public abstract class ElementPainter {
    DiagramElement element;
    Shape shape;
    boolean isSelected;


    public DiagramElement getElement() {
        return element;
    }

    public abstract void paint(Graphics2D g);
    public  boolean elementAt(Point pos){
        return shape.contains(pos);

    }
}
