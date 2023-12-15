package raf.dsw.classycraft.app.core.treemodel.factory;

import raf.dsw.classycraft.app.core.treemodel.nodes.abstractNodes.ClassyNode;
import raf.dsw.classycraft.app.core.treemodel.nodes.diagramNodes.connections.Aggregation;
import raf.dsw.classycraft.app.core.treemodel.nodes.diagramNodes.connections.Composition;
import raf.dsw.classycraft.app.core.treemodel.nodes.diagramNodes.connections.Dependency;
import raf.dsw.classycraft.app.core.treemodel.nodes.diagramNodes.connections.Generalization;

public class ConnectionFactory extends AbstractNodeFactory{
    @Override
    public ClassyNode createNode(String type) {
        return switch (type) {
            case "Aggregation" -> new Aggregation();
            case "Composition" -> new Composition();
            case "Dependency" -> new Dependency();
            case "Generalization" -> new Generalization();
            default -> null;
        };

    }
}
