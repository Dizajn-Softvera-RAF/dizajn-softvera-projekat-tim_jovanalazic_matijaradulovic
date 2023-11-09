package raf.dsw.classycraft.app.gui.treeview.controller;

import raf.dsw.classycraft.app.gui.treeview.model.ClassyTreeItem;

import javax.swing.*;
import javax.swing.tree.DefaultTreeCellEditor;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.EventObject;

public class ClassyTreeCellEditor extends DefaultTreeCellEditor implements ActionListener {
    //JTextField nametf;
    ClassyTreeItem selitem;//..
    public Component getTreeCellEditorComponent(JTree arg0, Object arg1, boolean arg2, boolean arg3, boolean arg4, int arg5) {
        JTextField nametf=new JTextField(); //#name hint here?
        nametf.addActionListener(this);
        selitem=(ClassyTreeItem) arg1;
        return nametf;

    }

    @Override
    public boolean isCellEditable(EventObject event) {
        return (event instanceof MouseEvent && ((MouseEvent)event).getClickCount()==3);
    }

    public ClassyTreeCellEditor(JTree tree, DefaultTreeCellRenderer renderer) {
        super(tree, renderer);
    }

    @Override
    public void actionPerformed(ActionEvent e) {///!!!!!!! call from controller...
        selitem.setName(e.getActionCommand());
    }
}
