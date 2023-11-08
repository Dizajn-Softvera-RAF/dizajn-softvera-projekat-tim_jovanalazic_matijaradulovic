package raf.dsw.classycraft.app.controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class AddDirectoryAction extends AbstractClassyAction{

    public AddDirectoryAction() {
        Icon icon=this.loadIcon("/images/addir.png");
        putValue(SMALL_ICON, icon);
        putValue(NAME, "Add directory");
        putValue(SHORT_DESCRIPTION, "Add directory");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //#TODO
    }
}
