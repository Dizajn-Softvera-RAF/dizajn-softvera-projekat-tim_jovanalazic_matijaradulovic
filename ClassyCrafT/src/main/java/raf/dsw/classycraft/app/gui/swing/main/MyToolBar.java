package raf.dsw.classycraft.app.gui.swing.main;

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
        add(new RenameAction());
        add(new EditAuthorAction());
        add(new TestAction());

        this.addSeparator();

        add(MainFrame.getInstance().getActions().getCloneAction());
        add(MainFrame.getInstance().getActions().getFitAction());

    }
}
