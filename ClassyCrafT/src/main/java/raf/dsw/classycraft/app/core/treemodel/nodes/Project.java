package raf.dsw.classycraft.app.core.treemodel.nodes;

public class Project extends ClassyNodeComposite {
    static int projcount;
    String author;

    public void setAuthor(String author) {
        this.author = author;
    }

    String path;

    public Project(String name, String author, String path, ClassyNode parent) {
        super(name, parent);
        this.author=author;
        this.path=path;
    }

    public Project() {
    }

    public Project(String name, ClassyNode parent) {
        super(name,parent);
        this.author="unknown";
        this.path="unknown";
    }

    public Project(ClassyNode parent) {
        this("project"+projcount++,parent);
    }


    @Override
    public ClassyNode genChild() {
        return new Package(null,this);
    }


}
