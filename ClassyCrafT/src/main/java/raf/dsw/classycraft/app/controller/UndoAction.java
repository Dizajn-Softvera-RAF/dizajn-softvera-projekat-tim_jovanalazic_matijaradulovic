package raf.dsw.classycraft.app.controller;

import raf.dsw.classycraft.app.gui.swing.main.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class UndoAction extends AbstractClassyAction{
    public UndoAction() {
        Icon icon=this.loadIcon("/images/udo.png");
        putValue(SMALL_ICON, icon);
        putValue(NAME, "Undo last action");
        putValue(SHORT_DESCRIPTION, "Undo");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getPkgpane().getActiveDiagramP().getModel().ManagerGet().undoCommand();
    }
}
