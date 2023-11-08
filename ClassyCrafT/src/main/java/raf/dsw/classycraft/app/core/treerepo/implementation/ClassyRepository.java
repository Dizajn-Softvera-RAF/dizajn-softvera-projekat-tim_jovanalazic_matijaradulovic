package raf.dsw.classycraft.app.core.treerepo.implementation;

import raf.dsw.classycraft.app.core.treerepo.abstraction.ClassyNodeComposite;
import raf.dsw.classycraft.app.core.treerepo.abstraction.IClassyRepository;

public class ClassyRepository implements IClassyRepository {
    ProjectExplorer root;
    @Override
    public ClassyNodeComposite getRoot() {
        return root;
    }

    public ClassyRepository(ProjectExplorer root) {
        this.root = root;
    }
}
