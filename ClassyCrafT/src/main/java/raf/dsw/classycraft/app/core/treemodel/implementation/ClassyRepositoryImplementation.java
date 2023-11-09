package raf.dsw.classycraft.app.core.treemodel.implementation;

public class ClassyRepositoryImplementation implements raf.dsw.classycraft.app.core.treemodel.abstraction.ClassyRepository {
    ProjectExplorer root;
    @Override
    public ProjectExplorer getRoot() {
        return root;
    }

    public ClassyRepositoryImplementation(ProjectExplorer root) {
        this.root = root;
    }
}
