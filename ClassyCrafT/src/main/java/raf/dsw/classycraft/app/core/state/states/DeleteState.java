package raf.dsw.classycraft.app.core.state.states;

import raf.dsw.classycraft.app.core.state.State;
import raf.dsw.classycraft.app.gui.swing.main.pkgview.DiagramViewPane;

import java.awt.event.MouseEvent;

public class DeleteState extends State {

    @Override
    public void mouseDown(MouseEvent pos, DiagramViewPane dview) {
        var x=dview.underPointer(pos.getPoint());
        if (x==null)return;
        if(x.isSelected())
            dview.DeleteSelected();
        else
            dview.RemovePainter(x);
    }

    @Override
    public void mouseUp(MouseEvent pos, DiagramViewPane dview) {
//        if(dview.isUnder(pos)){
//            var s=dview.underPointer(pos);
//            if(s.isSelected())
//                dview.DeleteSelected();
//            else
//                dview.RemovePainter(s);
//        }
    }

    @Override
    public void mouseDrag(MouseEvent pos, DiagramViewPane dview) {

    }

    @Override
    public void mouseWheeled(MouseEvent e, DiagramViewPane source) {

    }
}
