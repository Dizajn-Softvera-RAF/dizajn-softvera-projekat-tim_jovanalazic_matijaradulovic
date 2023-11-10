package raf.dsw.classycraft.app.controller;

import raf.dsw.classycraft.app.gui.main.MainFrame;

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
        //....
        MainFrame.getInstance().getTree().AppendChild(null);
    }
}
