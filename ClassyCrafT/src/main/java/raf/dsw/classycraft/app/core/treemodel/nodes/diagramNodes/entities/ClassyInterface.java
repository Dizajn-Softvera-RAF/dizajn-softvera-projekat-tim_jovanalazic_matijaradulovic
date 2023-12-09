package raf.dsw.classycraft.app.core.treemodel.nodes.diagramNodes.entities;

import java.awt.*;

public class ClassyInterface extends Interclass {
    @Override
    public String toString() {
        return String.format("%s Interface %s",vis.toText(),name);
    }

    public ClassyInterface(String name, Visibility vis, Point pos, Dimension dim) {
        super(name, vis, pos, dim);
        col=new Color(100, 180, 150);

    }
}
