package raf.dsw.classycraft.app.controller;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class RemoveAction extends AbstractClassyAction{
    public RemoveAction() {
        Icon icon=this.loadIcon("/images/rem.png");
        putValue(SMALL_ICON, icon);
        putValue(NAME, "Remove");
        putValue(SHORT_DESCRIPTION, "Delete item");

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
