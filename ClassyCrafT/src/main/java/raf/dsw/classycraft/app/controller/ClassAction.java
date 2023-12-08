package raf.dsw.classycraft.app.controller;

import raf.dsw.classycraft.app.gui.swing.main.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ClassAction extends AbstractClassyAction{
    public ClassAction() {
        Icon icon=this.loadIcon("/images/cla.png");
        putValue(SMALL_ICON, icon);
        putValue(NAME, "Add new class");
        putValue(SHORT_DESCRIPTION, "Class");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getPkgpane().StartClassState();

    }
}
