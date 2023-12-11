package raf.dsw.classycraft.app.controller;

import raf.dsw.classycraft.app.core.ApplicationFramework;
import raf.dsw.classycraft.app.core.msggen.MessageType;
import raf.dsw.classycraft.app.core.treemodel.nodes.diagramNodes.entities.ClassyClass;
import raf.dsw.classycraft.app.core.treemodel.nodes.diagramNodes.entities.Visibility;
import raf.dsw.classycraft.app.gui.swing.popups.EditEntDialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class TestAction extends AbstractClassyAction{
    public TestAction() {
        Icon icon=this.loadIcon("/images/qmark.png");
        putValue(SMALL_ICON, icon);
        putValue(NAME, "Test");
        putValue(SHORT_DESCRIPTION, "For debugging");

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
