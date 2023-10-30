package raf.dsw.classycraft.app.tree.composite.implementation;

import raf.dsw.classycraft.app.tree.composite.abstraction.ClassyNodeComposite;
import raf.dsw.classycraft.app.tree.composite.abstraction.ClassyRepository;

public class ClassyRepositoryImplementaion implements ClassyRepository {
    ProjectExplorer root;
    @Override
    public ClassyNodeComposite getRoot() {
        return root;
    }

    public ClassyRepositoryImplementaion(ProjectExplorer root) {
        this.root = root;
    }
}
