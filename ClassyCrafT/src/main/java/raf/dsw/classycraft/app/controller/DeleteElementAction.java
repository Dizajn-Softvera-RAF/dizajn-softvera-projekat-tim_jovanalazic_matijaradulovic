package raf.dsw.classycraft.app.controller;

import raf.dsw.classycraft.app.gui.swing.main.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class DeleteElementAction extends AbstractClassyAction{
    public DeleteElementAction() {
        Icon icon=this.loadIcon("/images/del.png");
        putValue(SMALL_ICON, icon);
        putValue(NAME, "Delete element");
        putValue(SHORT_DESCRIPTION, "Delete");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getPkgpane().StartDeleteState();

    }
}
