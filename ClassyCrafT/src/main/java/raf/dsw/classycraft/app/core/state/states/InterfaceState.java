package raf.dsw.classycraft.app.core.state.states;

import raf.dsw.classycraft.app.core.state.State;
import raf.dsw.classycraft.app.core.treemodel.nodes.diagramNodes.entities.ClassyClass;
import raf.dsw.classycraft.app.core.treemodel.nodes.diagramNodes.entities.ClassyInterface;
import raf.dsw.classycraft.app.core.treemodel.nodes.diagramNodes.entities.Visibility;
import raf.dsw.classycraft.app.gui.swing.main.MainFrame;
import raf.dsw.classycraft.app.gui.swing.main.pkgview.DiagramViewPane;
import raf.dsw.classycraft.app.gui.swing.popups.EditEntDialog;

import java.awt.*;

public class InterfaceState extends State {

    @Override
    public void mouseDown(Point pos, DiagramViewPane dview) {
        ClassyInterface cls=new ClassyInterface("", Visibility.PUBLIC,pos,new Dimension(50,30));
        //ClassPainter clp=new ClassPainter(;
        EditEntDialog d=EditEntDialog.getDialog(cls);
        d.ShowDialog(MainFrame.getInstance());
        dview.AddInterClass(cls);

    }

    @Override
    public void mouseUp(Point pos, DiagramViewPane dview) {

    }

    @Override
    public void mouseDrag(Point pos, DiagramViewPane dview) {

    }
}
