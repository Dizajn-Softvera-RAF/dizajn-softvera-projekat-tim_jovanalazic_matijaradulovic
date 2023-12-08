package raf.dsw.classycraft.app.controller;

import raf.dsw.classycraft.app.gui.swing.main.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class InterfaceAction extends AbstractClassyAction{
    public InterfaceAction() {
        Icon icon=this.loadIcon("/images/int.png");
        putValue(SMALL_ICON, icon);
        putValue(NAME, "Add new interface");
        putValue(SHORT_DESCRIPTION, "Interface");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getPkgpane().StartInterfaceState();
    }
}
