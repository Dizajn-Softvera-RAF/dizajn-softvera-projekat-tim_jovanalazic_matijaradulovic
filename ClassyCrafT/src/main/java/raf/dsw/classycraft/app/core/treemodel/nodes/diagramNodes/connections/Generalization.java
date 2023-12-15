package raf.dsw.classycraft.app.core.treemodel.nodes.diagramNodes.connections;

import raf.dsw.classycraft.app.core.treemodel.nodes.diagramNodes.entities.Interclass;
import raf.dsw.classycraft.app.core.treemodel.nodes.projNodes.Diagram;

public class Generalization extends Connection {

    public Generalization(Interclass source, String name, Diagram d) {
        super(source, name, d);
    }

    public Generalization() {
    }
}
