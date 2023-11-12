package raf.dsw.classycraft.app.gui.swing.treeview.controller;

import raf.dsw.classycraft.app.core.ApplicationFramework;
import raf.dsw.classycraft.app.core.treemodel.nodes.Project;
import raf.dsw.classycraft.app.core.treemodel.nodes.ProjectExplorer;
import raf.dsw.classycraft.app.gui.swing.main.MainFrame;
import raf.dsw.classycraft.app.gui.swing.treeview.model.ClassyTreeItem;
import raf.dsw.classycraft.app.gui.swing.treeview.view.ClassyTreeView;

import javax.swing.*;
import javax.swing.tree.DefaultTreeCellEditor;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.EventObject;

public class ClassyTreeCellEditor extends DefaultTreeCellEditor implements ActionListener {
    public Component getTreeCellEditorComponent(JTree arg0, Object arg1, boolean arg2, boolean arg3, boolean arg4, int arg5) {
        JTextField nametf=new JTextField();
        nametf.addActionListener(this);
        nametf.setPreferredSize(new Dimension(50,20));
        return nametf;

    }

    @Override
    public boolean isCellEditable(EventObject event) {
        if  (event instanceof KeyEvent ke && ke.getKeyCode()==KeyEvent.VK_R) return true;
        if(event==null) return false;
        ClassyTreeItem selitem= (ClassyTreeItem) ((ClassyTreeView) event.getSource()).getLastSelectedPathComponent();
        if(selitem!=null&& selitem.getNode() instanceof ProjectExplorer)return false;
        return  (event instanceof MouseEvent && ((MouseEvent)event).getClickCount()==3);
    }

    public ClassyTreeCellEditor(JTree tree, DefaultTreeCellRenderer renderer) {
        super(tree, renderer);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
          if(!MainFrame.getInstance().getTree().RenameSel( e.getActionCommand()))
              ApplicationFramework.getInstance().getMsgGen().generateErrorMessage("Neispravno ime");
    }
}
