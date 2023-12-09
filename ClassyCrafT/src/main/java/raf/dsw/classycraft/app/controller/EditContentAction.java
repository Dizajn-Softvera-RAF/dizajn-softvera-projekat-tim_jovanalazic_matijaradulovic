package raf.dsw.classycraft.app.controller;

import raf.dsw.classycraft.app.gui.swing.main.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class EditContentAction extends AbstractClassyAction{
    public EditContentAction(){
        Icon icon=this.loadIcon("/images/edi.png");
        putValue(SMALL_ICON, icon);
        putValue(NAME, "Edit content");
        putValue(SHORT_DESCRIPTION, "Edit");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getPkgpane().StartEditState();
    }
}
