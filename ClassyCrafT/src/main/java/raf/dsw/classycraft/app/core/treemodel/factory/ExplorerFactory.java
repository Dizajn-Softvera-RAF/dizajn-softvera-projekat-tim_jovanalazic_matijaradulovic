package raf.dsw.classycraft.app.core.treemodel.factory;

import raf.dsw.classycraft.app.core.treemodel.nodes.ClassyNode;
import raf.dsw.classycraft.app.core.treemodel.nodes.Project;

public class ExplorerFactory extends AbstractNodeFactory {

    @Override
    public ClassyNode createNode(String type) {
        if(type==null || type.equals("project"))
            return new Project();
        return null;
    }
}
