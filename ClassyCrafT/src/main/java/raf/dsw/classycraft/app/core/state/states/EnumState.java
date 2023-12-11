package raf.dsw.classycraft.app.core.state.states;

import raf.dsw.classycraft.app.core.state.State;
import raf.dsw.classycraft.app.core.treemodel.nodes.diagramNodes.entities.ClassyEnum;
import raf.dsw.classycraft.app.gui.swing.main.MainFrame;
import raf.dsw.classycraft.app.gui.swing.main.pkgview.DiagramViewPane;
import raf.dsw.classycraft.app.gui.swing.popups.EditEntDialog;

import java.awt.event.MouseEvent;

public class EnumState extends State {

    @Override
    public void mouseDown(MouseEvent pos, DiagramViewPane dview) {
        //dview.resetSelection();
        ClassyEnum cls=new ClassyEnum(pos.getPoint(),dview.getDiag());
        //ClassPainter clp=new ClassPainter(;
        EditEntDialog d=EditEntDialog.getDialog(cls);
        d.ShowDialog(MainFrame.getInstance());
        if(cls.getName().isEmpty()) cls.removeSelf();
        else
            dview.AddPainter(cls);

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
