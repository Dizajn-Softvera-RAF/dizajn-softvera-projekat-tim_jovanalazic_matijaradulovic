package raf.dsw.classycraft.app.controller;

import raf.dsw.classycraft.app.core.ApplicationFramework;
import raf.dsw.classycraft.app.core.msggen.MessageType;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class TestAction extends AbstractClassyAction{
    public TestAction() {
        Icon icon=this.loadIcon("/images/questionmark.png");
        putValue(SMALL_ICON, icon);
        putValue(NAME, "Test");
        putValue(SHORT_DESCRIPTION, "For debugging");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ApplicationFramework.getInstance().getMsgGen().generateMessage("Da li ovo radi?", MessageType.WARNING);
    }
}
