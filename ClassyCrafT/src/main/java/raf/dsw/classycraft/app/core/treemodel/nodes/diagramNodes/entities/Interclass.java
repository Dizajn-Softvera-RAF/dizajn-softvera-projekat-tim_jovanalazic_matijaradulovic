package raf.dsw.classycraft.app.core.treemodel.nodes.diagramNodes.entities;

import raf.dsw.classycraft.app.core.treemodel.nodes.diagramNodes.DiagramElement;
import raf.dsw.classycraft.app.core.treemodel.nodes.diagramNodes.content.ClassContent;
import raf.dsw.classycraft.app.core.treemodel.nodes.projNodes.Diagram;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public abstract class Interclass extends DiagramElement {
    Visibility vis;
    List<ClassContent> elements=new ArrayList<>();
    Point pos;
    Dimension dim;


    public Point getPos() {
        return pos;
    }

    public Dimension getDim() {
        return dim;
    }

    public List<ClassContent> getElements() {
        return elements;
    }

    public void setElements(List<ClassContent> elements) {
        this.elements = elements;
        IChanged();
    }

    public Interclass(String n, Visibility vis, Point pos, Dimension dim, Diagram d) {
        super(n,d);
        this.vis = vis;
        this.pos = pos;
        this.dim = dim;
    }

    public String getMaxString(){
        return elements.stream().max(Comparator.comparingInt(x -> x.toString().length())).map(Object::toString).orElse(null);
    }

    public void setDim(Dimension dim) {
        this.dim = dim;
        IChanged();
    }
    public Interclass(Point pos, Diagram d){
        this("", Visibility.DEFAULT,pos,new Dimension(50,30),d);

    }


    public void setPos(Point pos) {
        this.pos = pos;
        IChanged();
    }
    public void trans(int dx,int dy){
        setPos(new Point(pos.x+dx,pos.y+dy) );
    }
}

