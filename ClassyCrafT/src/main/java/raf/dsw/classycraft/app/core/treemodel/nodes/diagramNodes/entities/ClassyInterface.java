package raf.dsw.classycraft.app.core.treemodel.nodes.diagramNodes.entities;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Getter;
import lombok.Setter;
import raf.dsw.classycraft.app.core.treemodel.nodes.projNodes.Diagram;

import java.awt.*;
import java.awt.event.MouseEvent;
@Getter
@Setter
@JsonTypeName("inf")
public class ClassyInterface extends Interclass {
    @Override
    public String toString() {
        return String.format("%s Interface %s",vis.toText(),name);
    }

    public ClassyInterface(Point pos, Diagram d) {
        super(pos,d);
        col=new Color(100, 180, 150);

    }

    public ClassyInterface() {
        col=new Color(100, 180, 150);

    }

    @Override
    public Interclass CopyGet() {
        var x= new ClassyInterface(name,vis,new Point(pos),new Dimension(dim), ((Diagram) parent));
        x.setElements(this.getElements());
        return x;
    }

    public ClassyInterface(String name, Visibility vis, Point pos, Dimension dim, Diagram d) {
        super(name, vis, pos, dim,d);
        col=new Color(100, 180, 150);

    }
}
