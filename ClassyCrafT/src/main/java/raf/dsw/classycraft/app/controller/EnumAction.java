package raf.dsw.classycraft.app.controller;

import raf.dsw.classycraft.app.gui.swing.main.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class EnumAction extends AbstractClassyAction{
    public EnumAction() {
        Icon icon=this.loadIcon("/images/enu.png");
        putValue(SMALL_ICON, icon);
        putValue(NAME, "Add new enum");
        putValue(SHORT_DESCRIPTION, "Enum");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getPkgpane().StartEnumState();

    }
}
