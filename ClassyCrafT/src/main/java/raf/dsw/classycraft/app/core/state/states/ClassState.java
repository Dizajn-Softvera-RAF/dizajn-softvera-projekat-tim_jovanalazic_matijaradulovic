package raf.dsw.classycraft.app.core.state.states;

import raf.dsw.classycraft.app.core.state.State;
import raf.dsw.classycraft.app.core.treemodel.nodes.diagramNodes.entities.ClassyClass;
import raf.dsw.classycraft.app.gui.swing.main.MainFrame;
import raf.dsw.classycraft.app.gui.swing.main.pkgview.DiagramViewPane;
import raf.dsw.classycraft.app.gui.swing.popups.EditEntDialog;

import java.awt.event.MouseEvent;

public class ClassState extends State {

    @Override
    public void mouseDown(MouseEvent pos, DiagramViewPane dview) {
        //dview.resetSelection();
        ClassyClass cls=new ClassyClass(pos.getPoint(),dview.getDiag());
        EditEntDialog d=EditEntDialog.getDialog(cls);
        d.ShowDialog(MainFrame.getInstance());
        if(cls.getName().isEmpty()) cls.removeSelf();
        else dview.AddInterClass(cls);
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
