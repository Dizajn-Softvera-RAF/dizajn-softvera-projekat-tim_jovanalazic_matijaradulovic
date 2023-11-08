package raf.dsw.classycraft.app.gui.tree;

import raf.dsw.classycraft.app.core.treerepo.implementation.ProjectExplorer;

import javax.swing.*;

public interface IClassyTree {
    JTree generateTree(ProjectExplorer pe);
}
