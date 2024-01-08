package raf.dsw.classycraft.app.core.state.states;

import raf.dsw.classycraft.app.core.state.State;
import raf.dsw.classycraft.app.gui.swing.main.ConnectionRemoveCommand;
import raf.dsw.classycraft.app.gui.swing.main.InterClassRemoveCommand;
import raf.dsw.classycraft.app.gui.swing.main.MainFrame;
import raf.dsw.classycraft.app.gui.swing.main.pkgview.DiagramView;
import raf.dsw.classycraft.app.gui.swing.painters.ConnectionPainter;
import raf.dsw.classycraft.app.gui.swing.painters.InterClassPainter;

import java.awt.event.MouseEvent;

public class DeleteState implements State {

    @Override
    public void mouseDown(MouseEvent pos, DiagramView dviewv) {
        var dview=dviewv.getModel();

        var x=dview.underPointer(pos.getPoint());
        if (x==null)return;
        if(x.isSelected())
            dview.DeleteSelected();
        else{
            if(x instanceof InterClassPainter ip){
                MainFrame.getInstance().getPkgpane().getActiveDiagramP().getModel().ManagerGet().addCommand(new InterClassRemoveCommand( ip,dview));

            }
            else if(x instanceof ConnectionPainter cp){
                MainFrame.getInstance().getPkgpane().getActiveDiagramP().getModel().ManagerGet().addCommand(new ConnectionRemoveCommand(cp,dview));
            }
        }
    }

    @Override
    public void mouseUp(MouseEvent pos, DiagramView dviewv) {

//        if(dview.isUnder(pos)){
//            var s=dview.underPointer(pos);
//            if(s.isSelected())
//                dview.DeleteSelected();
//            else
//                dview.RemovePainter(s);
//        }
    }

    @Override
    public void mouseDrag(MouseEvent pos, DiagramView dview) {

    }

    @Override
    public void mouseWheeled(MouseEvent e, DiagramView source) {

    }
}
