package raf.dsw.classycraft.app.controller;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class AddDependencyAction extends AbstractClassyAction{
    public AddDependencyAction() {
        Icon icon=this.loadIcon("/images/dep.png");
        putValue(SMALL_ICON, icon);
        putValue(NAME, "Add dependency relation");
        putValue(SHORT_DESCRIPTION, "Dependency");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
