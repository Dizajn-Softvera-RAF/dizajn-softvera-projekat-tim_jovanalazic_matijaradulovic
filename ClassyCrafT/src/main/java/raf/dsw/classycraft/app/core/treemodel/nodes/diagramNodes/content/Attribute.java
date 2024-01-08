package raf.dsw.classycraft.app.core.treemodel.nodes.diagramNodes.content;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Getter;
import lombok.Setter;
import raf.dsw.classycraft.app.core.treemodel.nodes.diagramNodes.entities.Visibility;
@Getter
@Setter
@JsonTypeName("atr")
public class Attribute extends ClassContent {
    public Attribute() {
    }

    public Attribute(String name, Visibility v, String type) {
        super(name, v, type);
    }

    @Override
    public String toString() {
        return v.toString()+" "+ name +": "+type;
    }
}
