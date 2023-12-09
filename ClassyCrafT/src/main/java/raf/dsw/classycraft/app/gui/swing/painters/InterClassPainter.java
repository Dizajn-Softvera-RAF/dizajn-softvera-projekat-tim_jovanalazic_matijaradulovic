package raf.dsw.classycraft.app.gui.swing.painters;

import raf.dsw.classycraft.app.core.treemodel.nodes.diagramNodes.DiagramElement;
import raf.dsw.classycraft.app.core.treemodel.nodes.diagramNodes.entities.Interclass;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class InterClassPainter extends ElementPainter{

    Interclass element;
    public Point getCentar(){
        return ((Interclass) element).getPos();
    }
    public Dimension getDim(){
        return ((Interclass) element).getDim();
    }

    public Point getTopLeft(){
        return   new Point(getCentar().x-getDim().width/2,getCentar().y-getDim().height/2);
    }
    public InterClassPainter(Interclass cls){
        this.element= cls;
        shape=new RoundRectangle2D.Float(getTopLeft().x,getTopLeft().y,getDim().width,getDim().height,10,10);

    }
    @Override
    public void paint(Graphics2D g) {
        FitToContent(g);
        float ox=3*contPadd+getTopLeft().x,oy=2*contPadd+getTopLeft().y;
        float w=getDim().width,h=getDim().height;
        float cx=getTopLeft().x+w/2;

        g.setColor(element.getCol());
        g.fill(shape);
        g.setColor(textCol);
        g.setFont(font);

        String s=element.toString();
        Dimension d=getStringDim(g,s);
        oy+=d.height;
        g.drawString(s,cx-d.width/2f,oy);
        oy+= contPadd*2;

        for (var c: element.getElements()) {
            oy+=d.height;
            g.drawString(c.toString(),ox,oy);
            oy+=contPadd;
        }


    }

    private Dimension getStringDim(Graphics2D g, String s){
        if(s==null) return new Dimension();
        FontMetrics fm=g.getFontMetrics(font);
        return new Dimension(fm.stringWidth(s),fm.getHeight());
    }
    static int contPadd=3;
    static Color textCol=Color.BLACK;
    //static Stroke stroke=new BasicStroke(2,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND);
    static Font font=new Font(Font.MONOSPACED,Font.PLAIN,12);

    public void FitToContent(Graphics2D g){
        FontMetrics fm= g.getFontMetrics(font);
        int w,h;
        w=fm.stringWidth(element.toString());
        if(element.getElements()!=null)
            for (var c: element.getElements()) {
                w=Math.max(w,fm.stringWidth(c.toString()));
            }
        w+=6*contPadd;
        h=(fm.getHeight()+contPadd)*(element.getElements().size()+1)+6*contPadd;
        if(getDim().height<h||getDim().width<w) {
            element.setDim(new Dimension(w,h));
            resize();
        }
    }
    public void resize(){
        shape=new RoundRectangle2D.Float(getTopLeft().x,getTopLeft().y,getDim().width,getDim().height,10,10);

    }

}
