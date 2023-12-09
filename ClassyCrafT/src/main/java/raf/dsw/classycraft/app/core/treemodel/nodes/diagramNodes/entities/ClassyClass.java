package raf.dsw.classycraft.app.core.treemodel.nodes.diagramNodes.entities;

import java.awt.*;

public class ClassyClass extends Interclass {

    @Override
    public String toString() {
        return String.format("%s Class %s",vis.toText(),name);
    }

    public ClassyClass(String name, Visibility vis, Point pos, Dimension dim) {
        super(name, vis, pos, dim);
        col=new Color(110, 180, 220);
    }
}
