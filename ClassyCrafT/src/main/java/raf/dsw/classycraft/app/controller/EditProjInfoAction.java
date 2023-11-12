package raf.dsw.classycraft.app.controller;

import raf.dsw.classycraft.app.core.ApplicationFramework;
import raf.dsw.classycraft.app.core.treemodel.nodes.Project;
import raf.dsw.classycraft.app.gui.swing.main.MainFrame;
import raf.dsw.classycraft.app.gui.swing.treeview.model.ClassyTreeItem;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class EditProjInfoAction extends AbstractClassyAction{
    Icon icon;
    @Override
    public void actionPerformed(ActionEvent e) {

        ClassyTreeItem item= MainFrame.getInstance().getTree().getSelectedNode();
        if (item==null){
            ApplicationFramework.getInstance().getMsgGen().generateInfoMessage("Izaberi projekat.");
            return;
        }
        if( ! (item.getNode() instanceof Project p)) {
            ApplicationFramework.getInstance().getMsgGen().generateErrorMessage("Autori se dodaju na nivou projekta!");
            return;
        }
        String s = (String)JOptionPane.showInputDialog(
                MainFrame.getInstance(),
                "Unesi novog autora:\n",
                "Unos autora",
                JOptionPane.PLAIN_MESSAGE,
                icon,
                null,
                null);
        p.setAuthor(s);

    }
    public EditProjInfoAction() {
        icon=this.loadIcon("/images/addauth.png");
        putValue(SMALL_ICON, icon);
        putValue(NAME, "Add info");
        putValue(SHORT_DESCRIPTION, "Add author info");

    }
}
