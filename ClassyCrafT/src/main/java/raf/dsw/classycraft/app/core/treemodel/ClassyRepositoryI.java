package raf.dsw.classycraft.app.core.treemodel;

import raf.dsw.classycraft.app.core.treemodel.nodes.projNodes.ProjectExplorer;

public class ClassyRepositoryI implements ClassyRepository {
    ProjectExplorer root;
    @Override
    public ProjectExplorer getRoot() {
        return root;
    }
    public ClassyRepositoryI(ProjectExplorer root) {
        this.root = root;
    }
}
