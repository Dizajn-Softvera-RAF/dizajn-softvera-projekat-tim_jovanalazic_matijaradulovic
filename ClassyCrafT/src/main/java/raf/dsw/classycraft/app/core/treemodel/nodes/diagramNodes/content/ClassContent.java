package raf.dsw.classycraft.app.core.treemodel.nodes.diagramNodes.content;

import raf.dsw.classycraft.app.core.treemodel.nodes.diagramNodes.entities.*;

public abstract class ClassContent {
    protected String name;
    protected Visibility v;
    protected String type;

    public ClassContent(String name, Visibility v, String type) {
        this.name = name;
        this.v = v;
        this.type = type;
    }
}
