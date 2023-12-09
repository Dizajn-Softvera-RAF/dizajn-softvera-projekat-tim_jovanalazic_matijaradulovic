package raf.dsw.classycraft.app.core.treemodel.nodes.diagramNodes.connections;

import raf.dsw.classycraft.app.core.treemodel.nodes.diagramNodes.DiagramElement;
import raf.dsw.classycraft.app.core.treemodel.nodes.diagramNodes.entities.Interclass;

public abstract class Connection extends DiagramElement {
    Interclass source;
    Interclass destination;

    public Connection(Interclass source,String name) {
        super(name);
        this.source = source;
    }

    public void setDestination(Interclass destination) {
        this.destination = destination;
    }
}
