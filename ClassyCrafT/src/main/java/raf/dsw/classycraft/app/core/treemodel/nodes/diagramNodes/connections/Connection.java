package raf.dsw.classycraft.app.core.treemodel.nodes.diagramNodes.connections;

import com.sun.tools.jconsole.JConsoleContext;
import raf.dsw.classycraft.app.core.treemodel.nodes.diagramNodes.DiagramElement;
import raf.dsw.classycraft.app.core.treemodel.nodes.diagramNodes.entities.Interclass;
import raf.dsw.classycraft.app.core.treemodel.nodes.projNodes.Diagram;

public abstract class Connection extends DiagramElement {
    Interclass source;
    Interclass destination;

    public Interclass getSource() {
        return source;
    }


    public Interclass getDestination() {
        return destination;
    }

    public Connection(Interclass source, String name, Diagram d) {
        super(name,d);
        this.source = source;
        if(name==null){
            name=getSource().getName()+"->"+getDestination().getName();

        }
    }


    public void setDestination(Interclass destination) {
        this.destination = destination;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
