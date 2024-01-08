package raf.dsw.classycraft.app.gui.swing.main;

import raf.dsw.classycraft.app.gui.swing.main.pkgview.DiagramViewModel;
import raf.dsw.classycraft.app.gui.swing.painters.InterClassPainter;

public class InterClassRemoveCommand extends AbstractCommand{

    InterClassPainter ip;
    DiagramViewModel diagviewmodel;

    public InterClassRemoveCommand(InterClassPainter ip, DiagramViewModel diagview) {
        this.ip = ip;
        this.diagviewmodel = diagview;
    }

    @Override
    public void doCommand() {
        diagviewmodel.RemovePainter(ip);
    }

    @Override
    public void undoCommand() {
        diagviewmodel.getDiag().AddChild(ip.getElement());
        diagviewmodel.AddPainter(ip);
    }
}
