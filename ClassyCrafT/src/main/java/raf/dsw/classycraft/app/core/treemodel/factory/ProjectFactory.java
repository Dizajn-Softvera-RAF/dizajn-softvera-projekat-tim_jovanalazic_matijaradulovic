package raf.dsw.classycraft.app.core.treemodel.factory;

import raf.dsw.classycraft.app.core.treemodel.nodes.abstractNodes.ClassyNode;
import raf.dsw.classycraft.app.core.treemodel.nodes.projNodes.Package;

public class ProjectFactory extends AbstractNodeFactory {


    @Override
    public ClassyNode createNode(String type) {
        if(type==null ||type.equals("package"))
            return new Package();
        return null;
    }
}
