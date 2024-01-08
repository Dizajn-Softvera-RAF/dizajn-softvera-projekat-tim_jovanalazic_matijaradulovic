package raf.dsw.classycraft.app.core.treemodel.nodes.diagramNodes.entities;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Getter;
import lombok.Setter;
import raf.dsw.classycraft.app.core.treemodel.nodes.projNodes.Diagram;

import java.awt.*;
@Getter
@Setter
@JsonTypeName("enu")
public class ClassyEnum extends Interclass {
    @Override
    public String toString() {
        return String.format("%s Enum %s",vis.toText(),name);
    }
    public ClassyEnum(Point pos, Diagram d){
        super(pos,d);
        col=new Color(210, 210, 120);

    }

    public ClassyEnum() {
        col=new Color(210, 210, 120);

    }

    @Override
    public Interclass CopyGet() {
        var x= new ClassyEnum(name,vis,new Point(pos),new Dimension(dim), ((Diagram) parent));
        x.setElements(this.getElements());
        return x;
    }

    public ClassyEnum(String name, Visibility vis, Point pos, Dimension dim, Diagram d) {
        super(name, vis, pos, dim,d);
        col=new Color(210, 210, 120);
    }
}
