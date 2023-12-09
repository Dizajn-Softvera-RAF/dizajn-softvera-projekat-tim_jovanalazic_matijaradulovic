package raf.dsw.classycraft.app.controller;

import raf.dsw.classycraft.app.core.state.states.GeneralizationState;
import raf.dsw.classycraft.app.gui.swing.main.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class GeneralizationAction extends AbstractClassyAction{
    public GeneralizationAction(){
    Icon icon=this.loadIcon("/images/gen.png");
    putValue(SMALL_ICON, icon);
    putValue(NAME, "Add generalization relation");
    putValue(SHORT_DESCRIPTION, "Generalization");
}

    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getPkgpane().StartGeneralization();
    }
}
