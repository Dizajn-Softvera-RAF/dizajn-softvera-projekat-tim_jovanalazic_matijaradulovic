package raf.dsw.classycraft.app.gui.main;

import raf.dsw.classycraft.app.controller.*;

import javax.swing.*;

public class MyToolBar extends JToolBar {
    public MyToolBar() {
        super(HORIZONTAL);
        setFloatable(false);
        ExitAction ea= new ExitAction();
        add(ea);

        add(new AddDirectoryAction());
        add(new AddDiagramAction());
        add(new RemoveAction());
        add(new EditNameAction());
        add(new AddProjInfoAction());
        add(new TestAction());

    }
}
