package raf.dsw.classycraft.app.controller;

import raf.dsw.classycraft.app.gui.swing.main.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class FitAction extends AbstractClassyAction{

    public FitAction() {
        Icon icon=this.loadIcon("/images/fit.png");
        putValue(SMALL_ICON, icon);
        putValue(NAME, "Fit to page");
        putValue(SHORT_DESCRIPTION, "Fit");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        var dvp=MainFrame.getInstance().getPkgpane().getActiveDiagramP();
        if(dvp==null) return;
        dvp.getModel().Fit(dvp.getWidth(), dvp.getHeight());
    }
}
