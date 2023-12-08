package raf.dsw.classycraft.app.controller;

import raf.dsw.classycraft.app.gui.swing.main.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;


public class CompositionAction extends AbstractClassyAction{
    public CompositionAction() {
        Icon icon=this.loadIcon("/images/com.png");
        putValue(SMALL_ICON, icon);
        putValue(NAME, "Add composition relation");
        putValue(SHORT_DESCRIPTION, "Composition");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getPkgpane().StartCompostionState();

    }
}
