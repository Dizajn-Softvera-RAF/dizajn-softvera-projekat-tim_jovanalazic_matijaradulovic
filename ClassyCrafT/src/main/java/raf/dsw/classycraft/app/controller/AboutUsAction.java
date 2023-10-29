package raf.dsw.classycraft.app.controller;

import raf.dsw.classycraft.app.gui.swing.view.AboutUsFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class AboutUsAction extends AbstractClassyAction{

    public AboutUsAction() {
        Icon icon=this.loadIcon("/images/aboutus.png");
        putValue(SMALL_ICON, icon);
        putValue(NAME, "About us");
        putValue(SHORT_DESCRIPTION, "Authors");

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        AboutUsFrame aboutUsFrame=new AboutUsFrame();
        aboutUsFrame.setVisible(true);
    }
}
