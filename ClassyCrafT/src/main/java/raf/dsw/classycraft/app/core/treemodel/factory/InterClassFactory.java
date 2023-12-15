package raf.dsw.classycraft.app.core.treemodel.factory;

import raf.dsw.classycraft.app.core.treemodel.nodes.abstractNodes.ClassyNode;
import raf.dsw.classycraft.app.core.treemodel.nodes.diagramNodes.entities.ClassyClass;
import raf.dsw.classycraft.app.core.treemodel.nodes.diagramNodes.entities.ClassyEnum;
import raf.dsw.classycraft.app.core.treemodel.nodes.diagramNodes.entities.ClassyInterface;

public class InterClassFactory extends AbstractNodeFactory{
    @Override
    public ClassyNode createNode(String type) {
        return switch (type){
            case "Enum"-> new ClassyEnum();
            case "Class"-> new ClassyClass();
            case "Interface"-> new ClassyInterface();
            default -> null;
        };
    }
}
