package raf.dsw.classycraft.app.core.treemodel;

import raf.dsw.classycraft.app.core.treemodel.factory.AbstractNodeFactory;
import raf.dsw.classycraft.app.core.treemodel.factory.ExplorerFactory;
import raf.dsw.classycraft.app.core.treemodel.factory.PackageFactory;
import raf.dsw.classycraft.app.core.treemodel.factory.ProjectFactory;
import raf.dsw.classycraft.app.core.treemodel.nodes.*;
import raf.dsw.classycraft.app.core.treemodel.nodes.Package;

public interface ClassyRepository {
    ClassyNodeComposite getRoot();

     static AbstractNodeFactory getFactoryOf(String name) {
        String pkg = Package.class.getSimpleName();
        String proj = Project.class.getSimpleName();
        String exp = ProjectExplorer.class.getSimpleName();

        if (name.equals(pkg))
            return new PackageFactory();
        else if (name.equals(proj))
            return new ProjectFactory();
        if (name.equals(exp))
            return new ExplorerFactory();
        return null;
    }

}
