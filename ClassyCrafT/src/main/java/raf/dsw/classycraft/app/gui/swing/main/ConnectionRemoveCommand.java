package raf.dsw.classycraft.app.gui.swing.main;

import raf.dsw.classycraft.app.gui.swing.main.pkgview.DiagramViewModel;
import raf.dsw.classycraft.app.gui.swing.painters.ConnectionPainter;

public class ConnectionRemoveCommand extends AbstractCommand{

    ConnectionPainter cp;
    DiagramViewModel diagviewmodel;

    public ConnectionRemoveCommand(ConnectionPainter cp, DiagramViewModel diagviewmodel)
    {
        this.cp = cp;
        this.diagviewmodel = diagviewmodel;
    }

    @Override
    public void doCommand() {
        diagviewmodel.RemovePainter(cp);
    }

    @Override
    public void undoCommand() {
        diagviewmodel.getDiag().AddChild(cp.getElement());
        diagviewmodel.AddPainter(cp);
    }
}
