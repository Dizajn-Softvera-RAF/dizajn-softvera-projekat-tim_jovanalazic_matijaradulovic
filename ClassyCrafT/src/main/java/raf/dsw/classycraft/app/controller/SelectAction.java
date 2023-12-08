package raf.dsw.classycraft.app.controller;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class SelectElementAction extends AbstractClassyAction{
    public SelectElementAction() {
        Icon icon=this.loadIcon("/images/sel.png");
        putValue(SMALL_ICON, icon);
        putValue(NAME, "Select element");
        putValue(SHORT_DESCRIPTION, "Select");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
