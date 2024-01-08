package raf.dsw.classycraft.app.gui.swing.main.pkgview;

import raf.dsw.classycraft.app.core.treemodel.nodes.diagramNodes.entities.Interclass;
import raf.dsw.classycraft.app.gui.swing.main.AbstractCommand;
import raf.dsw.classycraft.app.gui.swing.painters.ElementPainter;

import java.awt.geom.AffineTransform;

public class MoveCommand extends AbstractCommand {

    DiagramViewModel diagviewmodel;
    ElementPainter e;
    int dx;
    int dy;
    AffineTransform trans = new AffineTransform();
    double z = trans.getScaleX();


    public MoveCommand(DiagramViewModel diagviewmodel, ElementPainter e, int dx, int dy, AffineTransform trans) {
        this.diagviewmodel = diagviewmodel;
        this.dx = dx;
        this.dy = dy;
        this.trans = trans;
        this.z = trans.getScaleX();
        this.e = e;
    }

    @Override
    public void doCommand() {
        ((Interclass) e.getElement()).trans((int)(dx/z),(int)(dy/z));
        diagviewmodel.repaint(e.getBounds());
    }

    @Override
    public void undoCommand() {
        ((Interclass) e.getElement()).trans((int)(-dx/z),(int)(-dy/z));
        diagviewmodel.repaint(e.getBounds());
    }
}
