package raf.dsw.classycraft.app.controller;

import raf.dsw.classycraft.app.core.ApplicationFramework;
import raf.dsw.classycraft.app.gui.swing.main.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class AddDiagramAction extends AbstractClassyAction{
    public AddDiagramAction() {
        Icon icon=this.loadIcon("/images/addia.jpg");
        putValue(SMALL_ICON, icon);
        putValue(NAME, "Add diagram");
        putValue(SHORT_DESCRIPTION, "Add diagram");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(MainFrame.getInstance().getTree().getSelectedNode()==null){
            ApplicationFramework.getInstance().getMsgGen().generateInfoMessage("Prvo izaberi dijagram.");
            return;
        }
        if(!(MainFrame.getInstance().getTree().isPackSel())) {
            ApplicationFramework.getInstance().getMsgGen().generateErrorMessage("Dijagram mora biti u okviru paketa!");
            return;
        }
        MainFrame.getInstance().getTree().AppendChild("diagram");


    }
}
