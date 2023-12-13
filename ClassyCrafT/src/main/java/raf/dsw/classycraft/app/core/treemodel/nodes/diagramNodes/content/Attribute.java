package raf.dsw.classycraft.app.core.treemodel.nodes.diagramNodes.content;

import raf.dsw.classycraft.app.core.treemodel.nodes.diagramNodes.entities.Visibility;

public class Attribute extends ClassContent {

    public Attribute(String name, Visibility v, String type) {
        super(name, v, type);
    }

    @Override
    public String toString() {
        return v.toString()+" "+ name +": "+type;
    }
}
