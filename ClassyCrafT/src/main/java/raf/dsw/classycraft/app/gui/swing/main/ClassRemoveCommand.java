package raf.dsw.classycraft.app.gui.swing.main;

import raf.dsw.classycraft.app.gui.swing.main.pkgview.DiagramViewModel;
import raf.dsw.classycraft.app.gui.swing.painters.ClassPainter;

public class ClassRemoveCommand extends AbstractCommand{

   ClassPainter cp;

   DiagramViewModel diagviewmodel;

   public ClassRemoveCommand(ClassPainter cp, DiagramViewModel diagviewmodel) {
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
