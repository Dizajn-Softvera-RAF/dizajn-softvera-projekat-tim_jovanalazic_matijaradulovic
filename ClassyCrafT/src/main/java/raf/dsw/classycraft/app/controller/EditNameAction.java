package raf.dsw.classycraft.app.controller;

import raf.dsw.classycraft.app.core.ApplicationFramework;
import raf.dsw.classycraft.app.gui.main.MainFrame;
import raf.dsw.classycraft.app.gui.popups.AddNameDialog;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class EditNameAction extends AbstractClassyAction {
    Icon icon;
    @Override
    public void actionPerformed(ActionEvent e) {
        //MainFrame.getInstance().getTree().
        //(new AddNameDialog()).setVisible(true);
        String s = (String)JOptionPane.showInputDialog(
                MainFrame.getInstance(),
                "Unesi novo ime:\n",
                "Unos imena",
                JOptionPane.PLAIN_MESSAGE,
                icon,
                null,
                null);

        if(s==null || !MainFrame.getInstance().getTree().RenameSel(s))
            ApplicationFramework.getInstance().getMsgGen().generateErrorMessage("Neadekvatno ime");

    }
    public EditNameAction() {
        icon=this.loadIcon("/images/renam.png");
        putValue(SMALL_ICON, icon);
        putValue(NAME, "Change name");
        putValue(SHORT_DESCRIPTION, "Change name");

    }
}
