package raf.dsw.classycraft.app.gui.treeview.controller;

import raf.dsw.classycraft.app.core.ApplicationFramework;
import raf.dsw.classycraft.app.core.msggen.msg.MessageType;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;

public class ClassyTreeSelectionListener implements TreeSelectionListener {
    @Override
    public void valueChanged(TreeSelectionEvent e) {
        //ApplicationFramework.getInstance().getClog().log("Path of clicked item: "+e.getPath());
        ApplicationFramework.getInstance().getMsgGen().generateMessage("Path of clicked item: "+e.getPath(), MessageType.LOG);

    }
}
