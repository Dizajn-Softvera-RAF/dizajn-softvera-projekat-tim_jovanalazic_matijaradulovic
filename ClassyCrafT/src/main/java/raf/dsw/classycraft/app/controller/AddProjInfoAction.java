package raf.dsw.classycraft.app.controller;

import raf.dsw.classycraft.app.core.ApplicationFramework;
import raf.dsw.classycraft.app.gui.main.MainFrame;
import raf.dsw.classycraft.app.gui.popups.AddAuthorPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class AddProjInfoAction extends AbstractClassyAction{
    Icon icon;
    @Override
    public void actionPerformed(ActionEvent e) {
        if(!MainFrame.getInstance().getTree().isProjSel()) {
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
        MainFrame.getInstance().getTree().RenameAuthSel(s);
    }
    public AddProjInfoAction() {
        icon=this.loadIcon("/images/addauth.png");
        putValue(SMALL_ICON, icon);
        putValue(NAME, "Add info");
        putValue(SHORT_DESCRIPTION, "Add author info");

    }
}
