package raf.dsw.classycraft.app.gui.swing.treeview.view;

import raf.dsw.classycraft.app.gui.swing.treeview.controller.ClassyTreeCellEditor;
import raf.dsw.classycraft.app.gui.swing.treeview.controller.ClassyTreeSelectionListener;
import raf.dsw.classycraft.app.gui.swing.treeview.controller.MouseController;

import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;

public class ClassyTreeView extends JTree {
    public ClassyTreeView(DefaultTreeModel tm) {
        setModel(tm);
        ClassyTreeCellRenderer tcr = new ClassyTreeCellRenderer();
        setCellRenderer(tcr);
        setCellEditor(new ClassyTreeCellEditor(this, tcr));
        addTreeSelectionListener(new ClassyTreeSelectionListener());
        this.addMouseListener(new MouseController());
        setToggleClickCount(0);
        setEditable(true);
    }
}
