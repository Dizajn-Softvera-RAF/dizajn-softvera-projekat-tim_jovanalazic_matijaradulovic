package raf.dsw.classycraft.app.gui.swing.main;

import raf.dsw.classycraft.app.gui.swing.main.pkgview.DiagramViewModel;
import raf.dsw.classycraft.app.gui.swing.painters.InterfacePainter;

public class InterfaceRemoveCommand extends AbstractCommand{

    InterfacePainter ip;
    DiagramViewModel diagviewmodel;

    public InterfaceRemoveCommand(InterfacePainter ip, DiagramViewModel diagviewmodel) {
        this.ip = ip;
        this.diagviewmodel = diagviewmodel;
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
