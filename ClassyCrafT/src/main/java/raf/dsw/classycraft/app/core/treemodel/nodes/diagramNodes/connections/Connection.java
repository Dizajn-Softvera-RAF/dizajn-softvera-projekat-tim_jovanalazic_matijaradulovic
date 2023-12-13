package raf.dsw.classycraft.app.core.treemodel.nodes.diagramNodes.connections;

import raf.dsw.classycraft.app.core.treemodel.nodes.diagramNodes.DiagramElement;
import raf.dsw.classycraft.app.core.treemodel.nodes.diagramNodes.entities.Interclass;
import raf.dsw.classycraft.app.core.treemodel.nodes.projNodes.Diagram;

public abstract class Connection extends DiagramElement {
    Interclass source;
    Interclass destination;

    public Connection(Interclass source, String name, Diagram d) {
        super(name,d);
        this.source = source;
    }

    public void setDestination(Interclass destination) {
        this.destination = destination;
    }
}
