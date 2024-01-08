package raf.dsw.classycraft.app.core.treemodel.nodes.diagramNodes.connections;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.sun.tools.jconsole.JConsoleContext;
import lombok.Getter;
import lombok.Setter;
import raf.dsw.classycraft.app.core.treemodel.nodes.diagramNodes.DiagramElement;
import raf.dsw.classycraft.app.core.treemodel.nodes.diagramNodes.entities.ClassyClass;
import raf.dsw.classycraft.app.core.treemodel.nodes.diagramNodes.entities.ClassyEnum;
import raf.dsw.classycraft.app.core.treemodel.nodes.diagramNodes.entities.ClassyInterface;
import raf.dsw.classycraft.app.core.treemodel.nodes.diagramNodes.entities.Interclass;
import raf.dsw.classycraft.app.core.treemodel.nodes.projNodes.Diagram;
import raf.dsw.classycraft.app.core.treemodel.nodes.projNodes.Package;
import raf.dsw.classycraft.app.core.treemodel.nodes.projNodes.Project;

@Getter
@Setter
public abstract class Connection extends DiagramElement {
    @JsonTypeInfo(
            use = JsonTypeInfo.Id.NAME,
            include = JsonTypeInfo.As.PROPERTY,
            property = "type")
    @JsonSubTypes({
            @JsonSubTypes.Type(value = ClassyClass.class, name = "cls"),
            @JsonSubTypes.Type(value = ClassyInterface.class, name = "inf"),
            @JsonSubTypes.Type(value = ClassyEnum.class, name = "enu"),


    })
    Interclass source;
    @JsonTypeInfo(
            use = JsonTypeInfo.Id.NAME,
            include = JsonTypeInfo.As.PROPERTY,
            property = "type")
    @JsonSubTypes({
            @JsonSubTypes.Type(value = ClassyClass.class, name = "cls"),
            @JsonSubTypes.Type(value = ClassyInterface.class, name = "inf"),
            @JsonSubTypes.Type(value = ClassyEnum.class, name = "enu"),


    })
    Interclass destination;

    protected Connection() {

    }


    public void setSource(Interclass source) {
        this.source = source;
    }

    public Interclass getSource() {
        return source;
    }


    public Interclass getDestination() {
        return destination;
    }

    public Connection(Interclass source, String name, Diagram d) {
        super(name,d);
        this.source = source;
    }


    public void setDestination(Interclass destination) {
        this.destination = destination;
        if(name==null){
            name=getSource().getName()+"->"+getDestination().getName();
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
