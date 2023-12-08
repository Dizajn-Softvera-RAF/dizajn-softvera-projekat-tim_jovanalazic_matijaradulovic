package raf.dsw.classycraft.app.core.treemodel.nodes.diagramNodes.entities;

import raf.dsw.classycraft.app.core.treemodel.nodes.diagramNodes.DiagramElement;
import raf.dsw.classycraft.app.core.treemodel.nodes.diagramNodes.content.ClassContent;

import java.awt.*;
import java.util.List;

public abstract class Interclass extends DiagramElement {
    String name;
    Visibility vis;
    List<ClassContent> elements;
    Point pos;
    Dimension dim;

}
enum Visibility{
    PRIVATE,PUBLIC,PROTECTED,DEFAULT
}