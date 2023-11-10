package raf.dsw.classycraft.app.core.treemodel.nodes;

public class Package extends ClassyNodeComposite {

    static int pkgcount=1;
    public Package(String name, ClassyNode parent) {
        super(name, parent);
    }
    public Package(ClassyNode parent){//????????????????
        this("package"+pkgcount++,parent);
    }

    public Package() {
    }

    @Override
    public ClassyNode genChild() {
        return new Package(null,this);
    }
}
