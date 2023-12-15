package raf.dsw.classycraft.app.core.treemodel.nodes.diagramNodes.entities;

import raf.dsw.classycraft.app.core.treemodel.nodes.projNodes.Diagram;
import raf.dsw.classycraft.app.core.treemodel.nodes.projNodes.ProjectExplorer;

import java.awt.*;
import java.awt.event.MouseEvent;

public class ClassyClass extends Interclass {

    @Override
    public String toString() {
        return String.format("%s Class %s",vis.toText(),name);
    }

    public ClassyClass(Point pos, Diagram d) {
        super(pos,d);
        col=new Color(110, 180, 220);

    }
    public ClassyClass(){
        super();
    }

    @Override
    public Interclass getCopy() {
        var x= new ClassyClass(name,vis,new Point(pos),new Dimension(dim), ((Diagram) parent));
        x.setElements(this.getElements());
        return x;
    }

    public ClassyClass(String name, Visibility vis, Point pos, Dimension dim, Diagram d) {
        super(name, vis, pos, dim,d);
        col=new Color(110, 180, 220);
    }
}
