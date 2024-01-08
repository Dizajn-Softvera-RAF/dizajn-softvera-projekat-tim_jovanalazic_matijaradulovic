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
        add(MainFrame.getInstance().getActions().getSaveAction());
        add(MainFrame.getInstance().getActions().getOpenAction());
        add(MainFrame.getInstance().getActions().getSaveDiagram());
        add(MainFrame.getInstance().getActions().getOpenDiagram());
        //add(new TestAction());

        this.addSeparator();

        add(MainFrame.getInstance().getActions().getCloneAction());
        add(MainFrame.getInstance().getActions().getFitAction());
        add(MainFrame.getInstance().getActions().getUndoAction());
        add(MainFrame.getInstance().getActions().getRedoAction());
        add(MainFrame.getInstance().getActions().getExportAction());
    }
}
