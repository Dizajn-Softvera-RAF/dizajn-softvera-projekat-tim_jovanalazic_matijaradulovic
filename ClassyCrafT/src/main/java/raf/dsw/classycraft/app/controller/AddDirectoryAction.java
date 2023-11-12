package raf.dsw.classycraft.app.controller;

import raf.dsw.classycraft.app.core.ApplicationFramework;
import raf.dsw.classycraft.app.gui.swing.main.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class AddDirectoryAction extends AbstractClassyAction{

    public AddDirectoryAction() {
        Icon icon=this.loadIcon("/images/addir.png");
        putValue(SMALL_ICON, icon);
        putValue(NAME, "Add directory");
        putValue(SHORT_DESCRIPTION, "Add directory");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(!MainFrame.getInstance().getTree().isSel()) {
            ApplicationFramework.getInstance().getMsgGen().generateInfoMessage("Izaberi lokaciju za dodavanje.");
            return;
        }
        if(! MainFrame.getInstance().getTree().AppendChild(null)){
            ApplicationFramework.getInstance().getMsgGen().generateErrorMessage("Dodavanje nije moguće");

        }
    }
}
