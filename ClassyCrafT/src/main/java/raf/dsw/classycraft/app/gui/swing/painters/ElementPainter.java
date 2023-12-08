package raf.dsw.classycraft.app.gui.swing.painters;

import raf.dsw.classycraft.app.core.treemodel.nodes.diagramNodes.DiagramElement;

import java.awt.*;

public abstract class ElementPainter {
    DiagramElement element;
    Shape shape;

    public abstract void paint(Graphics2D g);
    public  boolean elementAt(Point pos){
        return shape.contains(pos);
    }
}
