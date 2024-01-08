package raf.dsw.classycraft.app.gui.swing.main;

import raf.dsw.classycraft.app.gui.swing.main.pkgview.DiagramViewModel;
import raf.dsw.classycraft.app.gui.swing.painters.InterClassPainter;

public class InterClassAddCommand extends AbstractCommand{

    InterClassPainter ip;
    DiagramViewModel diagviewmodel;

    public InterClassAddCommand(InterClassPainter ip, DiagramViewModel diagviewmodel) {
        this.ip = ip;
        this.diagviewmodel = diagviewmodel;
    }

    @Override
    public void doCommand() {
        diagviewmodel.getDiag().AddChild(ip.getElement());
        diagviewmodel.AddPainter(ip);
    }

    @Override
    public void undoCommand() {
        diagviewmodel.RemovePainter(ip);
    }
}
