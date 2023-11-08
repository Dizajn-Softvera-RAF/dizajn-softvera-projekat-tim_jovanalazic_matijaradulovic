package raf.dsw.classycraft.app.gui;

import raf.dsw.classycraft.app.controller.ExitAction;
import raf.dsw.classycraft.app.controller.TestAction;

import javax.swing.*;

public class MyToolBar extends JToolBar {
    public MyToolBar() {
        super(HORIZONTAL);
        setFloatable(false);
        ExitAction ea= new ExitAction();
        add(ea);

        TestAction ta=new TestAction();
        add(ta);
    }
}
