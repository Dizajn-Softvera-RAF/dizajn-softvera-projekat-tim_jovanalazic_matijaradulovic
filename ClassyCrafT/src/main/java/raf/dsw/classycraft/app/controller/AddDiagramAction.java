package raf.dsw.classycraft.app.controller;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class AddDiagramAction extends AbstractClassyAction{
    public AddDiagramAction() {
        Icon icon=this.loadIcon("/images/addia.jpg");
        putValue(SMALL_ICON, icon);
        putValue(NAME, "Add diagram");
        putValue(SHORT_DESCRIPTION, "Add diagram");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
}
