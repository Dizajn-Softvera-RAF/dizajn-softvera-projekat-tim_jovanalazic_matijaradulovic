package raf.dsw.classycraft.app.controller;

import javax.swing.*;
import java.awt.event.ActionEvent;


public class AddCompositionAction extends AbstractClassyAction{
    public AddCompositionAction() {
        Icon icon=this.loadIcon("/images/com.png");
        putValue(SMALL_ICON, icon);
        putValue(NAME, "Add composition relation");
        putValue(SHORT_DESCRIPTION, "Composition");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
