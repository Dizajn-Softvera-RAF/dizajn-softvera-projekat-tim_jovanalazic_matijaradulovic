package raf.dsw.classycraft.app.controller;

import raf.dsw.classycraft.app.gui.swing.main.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class SelectAction extends AbstractClassyAction{
    public SelectAction() {
        Icon icon=this.loadIcon("/images/sel.png");
        putValue(SMALL_ICON, icon);
        putValue(NAME, "Select element");
        putValue(SHORT_DESCRIPTION, "Select");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getPkgpane().StartSelectionState();
    }
}
