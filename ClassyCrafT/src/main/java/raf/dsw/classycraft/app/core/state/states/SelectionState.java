package raf.dsw.classycraft.app.core.state.states;

import raf.dsw.classycraft.app.core.state.State;
import raf.dsw.classycraft.app.gui.swing.main.pkgview.DiagramViewPane;

import java.awt.*;
import java.awt.event.MouseEvent;

public class SelectionState extends State {

    Point origin;
   @Override
    public void mouseDown(MouseEvent pos, DiagramViewPane dview) {
       var s=dview.underPointer(pos.getPoint());
       if(s!=null ){
           if(s.isSelected()){
               if(dview.SingleSel()||pos.isControlDown()){
                   dview.DeselectElement(s);
               }
               else{
                   dview.resetSelection();
                    dview.SelectElement(s);
               }
           }
           else{
               if(!pos.isControlDown())
                    dview.resetSelection();
               dview.SelectElement(s);
           }
       }
       else if(!pos.isControlDown())
        dview.resetSelection();
    }

    @Override
    public void mouseUp(MouseEvent epos, DiagramViewPane dview) {
        Point pos=epos.getPoint();
       origin=null;
        dview.setSelect(null);
    }

    @Override
    public void mouseDrag(MouseEvent epos, DiagramViewPane dview) {
        Point pos=epos.getPoint();

        if(origin==null){
            origin=pos;
        }
        Rectangle r = dview.getCurSel();
        if (r == null) r = new Rectangle(pos.x, pos.y, 0, 0);
        int w, h;
        Point p1 = origin;

        w = (pos.x - p1.x);
        h = (pos.y - p1.y);
        int ny = Math.min(p1.y, pos.y);
        int nx = Math.min(p1.x, pos.x);
        if(!epos.isControlDown())
            dview.resetSelection();
        dview.setSelect(new Rectangle(nx, ny, Math.abs(w), Math.abs(h)));

    }

    @Override
    public void mouseWheeled(MouseEvent e, DiagramViewPane source) {

    }
}
