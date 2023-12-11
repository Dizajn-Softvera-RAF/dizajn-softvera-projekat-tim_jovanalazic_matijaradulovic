package raf.dsw.classycraft.app.core.state.states;

import raf.dsw.classycraft.app.core.state.State;
import raf.dsw.classycraft.app.core.treemodel.nodes.diagramNodes.entities.Interclass;
import raf.dsw.classycraft.app.gui.swing.main.MainFrame;
import raf.dsw.classycraft.app.gui.swing.main.pkgview.DiagramViewPane;
import raf.dsw.classycraft.app.gui.swing.popups.EditEntDialog;

import java.awt.event.MouseEvent;

public class EditContentState extends State {

    @Override
    public void mouseDown(MouseEvent pos, DiagramViewPane dview) {
        //dview.resetSelection();
        var e=dview.underPointer(pos.getPoint());
        if(e==null)return;
        Interclass ic= ((Interclass) e.getElement());
        EditEntDialog d=EditEntDialog.getDialog(ic);
        d.ShowDialog(MainFrame.getInstance());
        
    }

    @Override
    public void mouseUp(MouseEvent pos, DiagramViewPane dview) {

    }

    @Override
    public void mouseDrag(MouseEvent pos, DiagramViewPane dview) {

    }

    @Override
    public void mouseWheeled(MouseEvent e, DiagramViewPane source) {

    }
}
