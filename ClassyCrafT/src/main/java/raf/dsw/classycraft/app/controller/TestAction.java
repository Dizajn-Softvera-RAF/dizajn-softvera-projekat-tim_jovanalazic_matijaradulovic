package raf.dsw.classycraft.app.controller;

import raf.dsw.classycraft.app.core.ApplicationFramework;
import raf.dsw.classycraft.app.core.msggen.msg.MessageType;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class TestAction extends AbstractClassyAction{
    public TestAction() {
        Icon icon=this.loadIcon("/images/?.png");
        putValue(SMALL_ICON, icon);
        putValue(NAME, "Test");
        putValue(SHORT_DESCRIPTION, "Test");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ApplicationFramework.getInstance().getMsgGen().generateMessage("Da li ovo radi?", MessageType.WARNING);
    }
}
