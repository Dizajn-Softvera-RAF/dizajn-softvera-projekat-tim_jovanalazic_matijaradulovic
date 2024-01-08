package raf.dsw.classycraft.app.controller;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class RedoAction extends AbstractClassyAction{
    public RedoAction() {
        Icon icon=this.loadIcon("/images/redo.png");
        putValue(SMALL_ICON, icon);
        putValue(NAME, "Redo last action");
        putValue(SHORT_DESCRIPTION, "Redo");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //
    }
}