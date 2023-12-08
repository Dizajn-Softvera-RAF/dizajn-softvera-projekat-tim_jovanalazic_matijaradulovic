package raf.dsw.classycraft.app.controller;

import raf.dsw.classycraft.app.gui.swing.main.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class DependencyAction extends AbstractClassyAction{
    public DependencyAction() {
        Icon icon=this.loadIcon("/images/dep.png");
        putValue(SMALL_ICON, icon);
        putValue(NAME, "Add dependency relation");
        putValue(SHORT_DESCRIPTION, "Dependency");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getPkgpane().StartDependencyState();

    }
}
