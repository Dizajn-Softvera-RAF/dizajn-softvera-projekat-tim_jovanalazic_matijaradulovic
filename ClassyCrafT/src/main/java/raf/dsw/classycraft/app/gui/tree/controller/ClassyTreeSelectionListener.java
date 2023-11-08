package raf.dsw.classycraft.app.gui.tree.controller;

import raf.dsw.classycraft.app.core.ApplicationFramework;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;

public class ClassyTreeSelectionListener implements TreeSelectionListener {
    @Override
    public void valueChanged(TreeSelectionEvent e) {
        ApplicationFramework.getInstance().getClog().log("Path of clicked item: "+e.getPath());
        //#TODO save selection
    }
}
