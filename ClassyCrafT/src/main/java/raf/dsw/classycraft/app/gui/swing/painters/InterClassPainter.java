package raf.dsw.classycraft.app.gui.swing.painters;

import raf.dsw.classycraft.app.core.treemodel.nodes.diagramNodes.entities.Interclass;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;

public class InterClassPainter extends ElementPainter{

    @Override
    public Interclass getElement() {
        return (Interclass) element;
    }

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
        Color c=element.getCol();
        if(isSelected)
            c=c.darker();

        FitToContent(g);
        float ox=3*contPadd+getTopLeft().x,oy=2*contPadd+getTopLeft().y;
        float w=getDim().width,h=getDim().height;
        float cx=getTopLeft().x+w/2;

        g.setColor(c);
        g.fill(shape);

        g.setColor(textCol);
        g.setFont(font);

        String s=element.toString();
        Dimension d=getStringDim(g,s);
        oy+=d.height;
        g.drawString(s,cx-d.width/2f,oy);
        oy+= contPadd*2;

        for (var ce: getElement().getElements()) {
            oy+=d.height;
            g.drawString(ce.toString(),ox,oy);
            oy+=contPadd;
        }

        g.setColor(c.darker());
        g.setStroke(stroke);
        g.draw(shape);

        if(isSelected)
            drawSelRect(g,shape.getBounds2D());

    }

    private Dimension getStringDim(Graphics2D g, String s){
        if(s==null) return new Dimension();
        FontMetrics fm=g.getFontMetrics(font);
        return new Dimension(fm.stringWidth(s),fm.getHeight());
    }
    static int contPadd=2;
    static Color textCol=Color.BLACK;
    static Stroke stroke=new BasicStroke(3);
    static Font font=new Font(Font.MONOSPACED,Font.PLAIN,10);

    public void FitToContent(Graphics2D g){
        FontMetrics fm= g.getFontMetrics(font);
        int w,h;
        w=fm.stringWidth(element.toString());
        if(getElement().getElements()!=null)
            for (var c: getElement().getElements()) {
                w=Math.max(w,fm.stringWidth(c.toString()));
            }
        w+=6*contPadd;
        h=(fm.getHeight()+contPadd)*(getElement().getElements().size()+1)+6*contPadd;
        //if(getDim().height<h||getDim().width<w) {
            getElement().setDim(new Dimension(w,h));
        //}
        reshape();
    }

    public void reshape(){
        shape=new RoundRectangle2D.Float(getTopLeft().x,getTopLeft().y,getDim().width,getDim().height,10,10);
    }

}
