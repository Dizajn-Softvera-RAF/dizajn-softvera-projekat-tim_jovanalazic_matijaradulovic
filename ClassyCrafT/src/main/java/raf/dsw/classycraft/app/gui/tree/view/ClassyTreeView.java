package raf.dsw.classycraft.app.gui.tree.view;

import raf.dsw.classycraft.app.gui.tree.controller.ClassyTreeCellEditor;
import raf.dsw.classycraft.app.gui.tree.controller.ClassyTreeSelectionListener;

import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;

public class ClassyTreeView extends JTree {
    public ClassyTreeView(DefaultTreeModel tm) {
        setModel(tm);
        ClassyTreeCellRenderer tcr = new ClassyTreeCellRenderer();
        setCellRenderer(tcr);
        setCellEditor(new ClassyTreeCellEditor(this, tcr));
        addTreeSelectionListener(new ClassyTreeSelectionListener());
        setEditable(true);
    }
}
