package raf.dsw.classycraft.app.core.state.states;

import raf.dsw.classycraft.app.core.state.State;
import raf.dsw.classycraft.app.core.treemodel.nodes.diagramNodes.entities.ClassyClass;
import raf.dsw.classycraft.app.core.treemodel.nodes.diagramNodes.entities.Interclass;
import raf.dsw.classycraft.app.core.treemodel.nodes.diagramNodes.entities.Visibility;
import raf.dsw.classycraft.app.gui.swing.main.MainFrame;
import raf.dsw.classycraft.app.gui.swing.main.pkgview.DiagramViewPane;
import raf.dsw.classycraft.app.gui.swing.popups.EditEntDialog;

import java.awt.*;

public class EditContentState extends State {

    @Override
    public void mouseDown(Point pos, DiagramViewPane dview) {
        Interclass ic= dview.getSelectedClass();
        if(ic==null) return;
        EditEntDialog d=EditEntDialog.getDialog(ic);
        d.ShowDialog(MainFrame.getInstance());
        
    }

    @Override
    public void mouseUp(Point pos, DiagramViewPane dview) {

    }

    @Override
    public void mouseDrag(Point pos, DiagramViewPane dview) {

    }
}
