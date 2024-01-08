package raf.dsw.classycraft.app.core.treemodel.nodes.diagramNodes.connections;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Getter;
import lombok.Setter;
import raf.dsw.classycraft.app.core.treemodel.nodes.diagramNodes.entities.Interclass;
import raf.dsw.classycraft.app.core.treemodel.nodes.projNodes.Diagram;
@Getter
@Setter
@JsonTypeName("dep")
public class Dependency extends Connection{
    public Dependency(Interclass source, String name, Diagram d) {
        super(source, name, d);
    }

    public Dependency() {
    }
}
