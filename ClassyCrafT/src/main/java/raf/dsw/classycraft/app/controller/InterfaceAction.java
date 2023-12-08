package raf.dsw.classycraft.app.controller;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class AddInterfaceAction extends AbstractClassyAction{
    public AddInterfaceAction() {
        Icon icon=this.loadIcon("/images/int.png");
        putValue(SMALL_ICON, icon);
        putValue(NAME, "Add new interface");
        putValue(SHORT_DESCRIPTION, "Interface");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
