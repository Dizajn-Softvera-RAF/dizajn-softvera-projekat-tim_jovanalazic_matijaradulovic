package raf.dsw.classycraft.app.core.treemodel.nodes.abstractNodes;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Getter;
import lombok.Setter;
import raf.dsw.classycraft.app.core.treemodel.nodes.diagramNodes.entities.ClassyClass;
import raf.dsw.classycraft.app.core.treemodel.nodes.diagramNodes.entities.ClassyEnum;
import raf.dsw.classycraft.app.core.treemodel.nodes.diagramNodes.entities.ClassyInterface;

@Getter
@Setter

public class ClassyNodeLeaf extends ClassyNode{

    public ClassyNodeLeaf(String name, ClassyNodeComposite parent) {
        super(name, parent);
    }

    public ClassyNodeLeaf() {
    }


}
