package raf.dsw.classycraft.app.core.treemodel.nodes.diagramNodes.entities;

import java.awt.*;

public class ClassyEnum extends Interclass {
    @Override
    public String toString() {
        return String.format("%s Enum %s",vis.toText(),name);
    }

    public ClassyEnum(String name, Visibility vis, Point pos, Dimension dim) {
        super(name, vis, pos, dim);
        col=new Color(210, 210, 120);
    }
}
