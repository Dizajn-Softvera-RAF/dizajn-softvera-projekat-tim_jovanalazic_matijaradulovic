package raf.dsw.classycraft.app.gui.swing.main.pkgview;

import raf.dsw.classycraft.app.gui.swing.main.MainFrame;

import javax.swing.*;

public class SideToolBar extends JToolBar {
    public SideToolBar(){
        super(JToolBar.VERTICAL);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(MainFrame.getInstance().getActions().getSelectAction());
        add(MainFrame.getInstance().getActions().getMoveAction());
        add(MainFrame.getInstance().getActions().getZoomAction());
        add(MainFrame.getInstance().getActions().getClassAction());
        add(MainFrame.getInstance().getActions().getInterfaceAction());
        add(MainFrame.getInstance().getActions().getEnumAction());
        add(MainFrame.getInstance().getActions().getDependencyAction());
        add(MainFrame.getInstance().getActions().getCompositionAction());
        add(MainFrame.getInstance().getActions().getAggregationAction());

    }
}
