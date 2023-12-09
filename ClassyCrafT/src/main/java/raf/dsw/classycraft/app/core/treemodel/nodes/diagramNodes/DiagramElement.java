package raf.dsw.classycraft.app.core.treemodel.nodes.diagramNodes;

import raf.dsw.classycraft.app.core.treemodel.nodes.abstractNodes.ClassyNode;
import raf.dsw.classycraft.app.core.treemodel.nodes.abstractNodes.ClassyNodeComposite;

import java.awt.*;

public abstract class DiagramElement extends ClassyNode {
    protected Color col;

    public Color getCol() {
        return col;
    }
    public DiagramElement(String n){
        name=n;
    }

}
