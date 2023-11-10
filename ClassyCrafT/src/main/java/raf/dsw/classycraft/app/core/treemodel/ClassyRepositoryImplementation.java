package raf.dsw.classycraft.app.core.treemodel;

import raf.dsw.classycraft.app.core.treemodel.nodes.ProjectExplorer;

public class ClassyRepositoryImplementation implements ClassyRepository {
    ProjectExplorer root;
    @Override
    public ProjectExplorer getRoot() {
        return root;
    }
    public ClassyRepositoryImplementation(ProjectExplorer root) {
        this.root = root;
    }
}
