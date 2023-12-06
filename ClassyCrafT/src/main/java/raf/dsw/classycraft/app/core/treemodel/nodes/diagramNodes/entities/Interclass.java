package raf.dsw.classycraft.app.core.treemodel.nodes.diagramNodes;

public abstract class Interclass extends DiagramElement{
    String name;
    Visibility vis;


}
enum Visibility{
    PRIVATE,PUBLIC,PROTECTED,DEFAULT
}