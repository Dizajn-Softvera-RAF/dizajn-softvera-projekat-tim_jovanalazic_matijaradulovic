package raf.dsw.classycraft.app.controller;

import raf.dsw.classycraft.app.gui.swing.main.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ZoomAction extends AbstractClassyAction{
    public ZoomAction() {
        Icon icon=this.loadIcon("/images/zom.png");
        putValue(SMALL_ICON, icon);
        putValue(NAME, "Zoom in/out");
        putValue(SHORT_DESCRIPTION, "Zoom");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getPkgpane().StartZoomState();
    }
}
