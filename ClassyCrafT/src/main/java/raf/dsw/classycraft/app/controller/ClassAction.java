package raf.dsw.classycraft.app.controller;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class AddClassAction extends AbstractClassyAction{
    public AddClassAction() {
        Icon icon=this.loadIcon("/images/cla.png");
        putValue(SMALL_ICON, icon);
        putValue(NAME, "Add new class");
        putValue(SHORT_DESCRIPTION, "Class");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
