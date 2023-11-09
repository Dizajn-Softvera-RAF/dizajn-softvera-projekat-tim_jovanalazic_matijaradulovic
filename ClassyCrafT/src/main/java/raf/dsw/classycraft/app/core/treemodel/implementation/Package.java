package raf.dsw.classycraft.app.core.treemodel.implementation;

import raf.dsw.classycraft.app.core.treemodel.abstraction.ClassyNode;
import raf.dsw.classycraft.app.core.treemodel.abstraction.ClassyNodeComposite;

public class Package extends ClassyNodeComposite {

    static int pkgcount=1;//per project.......



    public Package(String name, ClassyNode parent) {
        super(name, parent);
    }



    public Package(ClassyNode parent){//????????????????
        this("package"+pkgcount++,parent);
    }

    @Override
    public ClassyNode genChild() {
        return new Package(this);
    }

    @Override
    public ClassyNode genChild(String name) {
        return new Package(name,this);
    }

}
