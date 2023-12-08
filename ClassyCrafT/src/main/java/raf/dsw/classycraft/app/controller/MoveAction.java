package raf.dsw.classycraft.app.controller;

import raf.dsw.classycraft.app.gui.swing.main.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class MoveAction extends AbstractClassyAction{
    public MoveAction() {
        Icon icon=this.loadIcon("/images/mov.png");
        putValue(SMALL_ICON, icon);
        putValue(NAME, "Move area");
        putValue(SHORT_DESCRIPTION, "Move");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getPkgpane().StartMoveState();
    }
}
