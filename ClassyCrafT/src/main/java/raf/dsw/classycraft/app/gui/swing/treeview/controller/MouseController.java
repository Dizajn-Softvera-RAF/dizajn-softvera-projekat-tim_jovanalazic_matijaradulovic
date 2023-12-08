package raf.dsw.classycraft.app.gui.swing.treeview.controller;

import raf.dsw.classycraft.app.gui.swing.main.MainFrame;
import raf.dsw.classycraft.app.gui.swing.treeview.model.ClassyTreeItem;

import javax.swing.*;
import javax.swing.tree.TreePath;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseController extends MouseAdapter {
    @Override
    public void mousePressed(MouseEvent e) {
        JTree tree= MainFrame.getInstance().getTree().getView();
        int selRow = tree.getRowForLocation(e.getX(), e.getY());
        TreePath selPath = tree.getPathForLocation(e.getX(), e.getY());
        if(selRow != -1) {
            if(e.getButton()==MouseEvent.BUTTON3){
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        tree.startEditingAtPath(selPath);
                    }
                });
            }
            if(e.getClickCount() == 2) {
                MainFrame.getInstance().getTree().setSelectedItem( (ClassyTreeItem)selPath.getLastPathComponent() );
            }



        }
    }


}
