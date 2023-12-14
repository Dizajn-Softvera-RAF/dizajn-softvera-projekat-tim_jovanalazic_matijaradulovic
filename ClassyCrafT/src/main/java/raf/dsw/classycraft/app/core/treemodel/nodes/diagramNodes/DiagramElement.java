package raf.dsw.classycraft.app.core.treemodel.nodes.diagramNodes;

import raf.dsw.classycraft.app.core.treemodel.nodes.abstractNodes.ClassyNode;
import raf.dsw.classycraft.app.core.treemodel.nodes.abstractNodes.ClassyNodeComposite;
import raf.dsw.classycraft.app.core.treemodel.nodes.projNodes.Diagram;
import raf.dsw.classycraft.app.core.treemodel.nodes.projNodes.ProjectExplorer;

import java.awt.*;

public abstract class DiagramElement extends ClassyNode implements Cloneable{
    protected Color col;
    int stroke;

    public int getStroke() {
        return stroke;
    }

    public void IChanged(){
        ((Diagram) getParent()).notifySubscribers(getParent());

    }

    public Color getCol() {
        return col;
    }
    public DiagramElement(String n, ClassyNodeComposite parent){
        super(n,parent);
        ((ClassyNodeComposite) parent).AddChild(this);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
