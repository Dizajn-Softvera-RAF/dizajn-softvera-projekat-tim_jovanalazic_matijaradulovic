package raf.dsw.classycraft.app.core.treemodel.factory;

import raf.dsw.classycraft.app.core.treemodel.nodes.abstractNodes.ClassyNode;
import raf.dsw.classycraft.app.core.treemodel.nodes.projNodes.Diagram;
import raf.dsw.classycraft.app.core.treemodel.nodes.projNodes.Package;

public class PackageFactory extends AbstractNodeFactory {
    @Override
    public ClassyNode createNode(String type) {
        if(type==null || type.equals("package"))
            return new Package();
        else if(type.equals("diagram"))
            return new Diagram();
        return null;
    }
}
