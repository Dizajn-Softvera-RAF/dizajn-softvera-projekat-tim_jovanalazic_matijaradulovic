package raf.dsw.classycraft.app.gui.swing.main.pkgview;

import raf.dsw.classycraft.app.controller.events.PaintClassyEvent;
import raf.dsw.classycraft.app.core.msggen.ISubscriber;
import raf.dsw.classycraft.app.core.treemodel.nodes.projNodes.Diagram;
import raf.dsw.classycraft.app.gui.swing.main.MainFrame;
import raf.dsw.classycraft.app.gui.swing.painters.ConnectionPainter;
import raf.dsw.classycraft.app.gui.swing.painters.ElementPainter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.geom.AffineTransform;
import java.util.List;

public class DiagramView extends JPanel implements ISubscriber {
    DiagramViewModel model;


    public DiagramViewModel getModel(){
        return model;
    }
    private Diagram getDiag(){
        return model.diag;
    }
    private List<ElementPainter> getPainters(){
        return model.painters;
    }

   private ConnectionPainter getCurrConn(){
        return  model.curConn;
   }
   private AffineTransform getTrans(){
        return model.trans;
   }
   private Rectangle getCurSelRect(){
        return model.curSel;
   }


    public DiagramView(Diagram diagram) {
        diagram.addSubscriber(this);
        var x=new ClassyMouseListener();
        this.addMouseListener(x);
        this.addMouseMotionListener(x);
        this.addMouseWheelListener(x);
        model=new DiagramViewModel(diagram);
        model.addSubscriber(this);
    }

    @Override
    public void react(Object notification) { //reacts to diagram elements/model changed
        if(notification instanceof PaintClassyEvent p){
            if(p.redraw()){
                repaint();
            }
            else{
                repaint(p.getArea());
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d= ((Graphics2D) g);
        RenderingHints rh =
                new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);
        rh.put(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHints(rh);
        g2d.setTransform(getTrans());



        for (var painter:getPainters()) {
            painter.paint(g2d);
        }

        if(getCurrConn()!=null)
            getCurrConn().paint(g2d);
        if(getCurSelRect()!=null){
            final AffineTransform def=new AffineTransform();
            g2d.setTransform(def);
            ElementPainter.drawSelRect(g2d, getCurSelRect());
        }
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof DiagramView tab){
            return tab.getDiag().equals(getDiag());
        }
        return false;
    }





    private static class ClassyMouseListener extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            MainFrame.getInstance().getPkgpane().MousePressed(e,((DiagramView) e.getSource()));
        }
        @Override
        public void mouseDragged(MouseEvent e) {
            MainFrame.getInstance().getPkgpane().MouseDragged(e,(DiagramView) e.getSource());

        }

        @Override
        public void mouseReleased(MouseEvent e) {
            MainFrame.getInstance().getPkgpane().MouseReleased(e,(DiagramView) e.getSource());
        }
        @Override
        public void mouseWheelMoved(MouseWheelEvent e) {
            MainFrame.getInstance().getPkgpane().MouseWheeled(e,(DiagramView) e.getSource());
        }
    }

    public void Clean(){
        getDiag().removeSubscriber(this);
    }



}
