package raf.dsw.classycraft.app.gui.swing.treeview.controller;

import raf.dsw.classycraft.app.gui.swing.main.MainFrame;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreePath;

public class ClassyTreeSelectionListener implements TreeSelectionListener {

    @Override
    public void valueChanged(TreeSelectionEvent e) {
        System.out.println ("Path of clicked item: "+e.getPath());

        TreePath path = e.getNewLeadSelectionPath();
        if (path != null) {
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    MainFrame.getInstance().getTree().getView().startEditingAtPath(path);
                }
            });
        }
    }
}
