package raf.dsw.classycraft.app.controller;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class AddEnumAction extends AbstractClassyAction{
    public AddEnumAction() {
        Icon icon=this.loadIcon("/images/enu.png");
        putValue(SMALL_ICON, icon);
        putValue(NAME, "Add new enum");
        putValue(SHORT_DESCRIPTION, "Enum");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
