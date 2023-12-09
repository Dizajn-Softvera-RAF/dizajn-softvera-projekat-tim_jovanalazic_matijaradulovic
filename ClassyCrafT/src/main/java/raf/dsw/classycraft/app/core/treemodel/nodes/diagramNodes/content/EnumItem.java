package raf.dsw.classycraft.app.core.treemodel.nodes.diagramNodes.content;

public class EnumItem extends ClassContent {
    public EnumItem(String n) {
        super(n,null,null);
        name = n;
    }

    @Override
    public String toString() {
        return name.toUpperCase();
    }
}
