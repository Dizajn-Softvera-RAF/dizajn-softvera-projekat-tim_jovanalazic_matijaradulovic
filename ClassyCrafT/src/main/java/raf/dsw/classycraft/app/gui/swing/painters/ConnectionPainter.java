package raf.dsw.classycraft.app.gui.swing.painters;

import raf.dsw.classycraft.app.core.treemodel.nodes.diagramNodes.DiagramElement;
import raf.dsw.classycraft.app.core.treemodel.nodes.diagramNodes.connections.Connection;
import raf.dsw.classycraft.app.core.treemodel.nodes.diagramNodes.entities.Interclass;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

public abstract class ConnectionPainter extends ElementPainter{

    Point endPoint;
    Point begPoint;
    Shape line;
    Shape specShape;
    protected Stroke stroc;

    public ConnectionPainter(Connection con) {
        isSelected=false;
        element=con;
        //Rectangle r1=new Rectangle(((Connection)element).getSource().getPos(),((Connection)element).getSource().getDim());
        //begPoint=Geom.Cent(r1);
        begPoint=((Connection)element).getSource().getPos();
        endPoint= ((Point) begPoint.clone());
        MakeShape();
    }


    public Connection getElement() {
        return ((Connection) super.getElement());
    }

    protected static class Geom{
        protected static Point getPointAt(Point a,Point b,double t){
            return Geom.add(a,Geom.scale(Geom.getVect(a,b),t));

        }
        protected static Point add(Point p1, Point p2){
            return new Point(p1.x+p2.x,p1.y+p2.y);
        }
        protected static Point scale(Point p,double l){
            return new Point((int)(p.x*l),(int)(p.y*l));
        }
        protected static Point getVect(Point a, Point b){
            return new Point(b.x-a.x,b.y-a.y);
        }
        protected static Point2D normalize(Point a){
            return new Point2D.Double((a.x/norm(a)),(a.y/norm(a)));
        }
        protected static Point scaleNor(Point2D a,double d){
            return new Point((int)(a.getX()*d),(int)(a.getY()*d));
        }
        protected static double norm(Point a){
            return Math.sqrt(a.x*a.x+a.y*a.y);
        }
        protected static Point2D rotate(Point2D a, double fi){

            double nx=(Math.cos(fi)*a.getX() -Math.sin(fi)*a.getY());
            double ny=(Math.sin(fi)*a.getX() +Math.cos(fi)*a.getY());
            return new Point2D.Double(nx,ny);
        }
        protected static Point Cent(Rectangle r){
            return new Point((int)r.getCenterX(),(int)r.getCenterY());
        }
        protected static Point interRectLine(Rectangle r,Point p,  Point q){

            int tx,ty;
            tx=r.x;
            ty=r.y;
            Point d=new Point(tx,ty);
            Point a= new Point(tx,ty+r.height);
            Point b= new Point(tx+r.width,ty+r.height);
            Point c= new Point(tx+r.width,ty);
            Point x;

            if((x=interLline(p,q,a,b))!=null){
                return x;
            }
            else if((x=interLline(p,q,b,c))!=null){
                return x;
            }
            else if((x=interLline(p,q,c,d))!=null){
                return x;
            }
            else if((x=interLline(p,q,d,a))!=null){
                return x;
            }
            return null;
        }
        protected static Point interLline(Point a, Point b, Point ap, Point bp){
            Point v1=new Point(b.x-a.x,b.y-a.y);
            Point v2=new Point(bp.x-ap.x,bp.y-ap.y);
            Point v=new Point(ap.x-a.x,ap.y-a.y);
            var xx=VectorProdIntens(v1,v2);
            if(Math.abs(xx)<=1e-5) {
                return null;
            }
            double t= VectorProdIntens(v,v2)/xx;
            double s= VectorProdIntens(v,v1)/xx;

            if(t>=0&&t<=1 && s>=0&&s<=1)
                    return new Point((int)(a.x+t*v1.x),(int)(a.y+t*v1.y));
            return null;
        }
        protected static double VectorProdIntens(Point v1, Point v2){
            return -((v1.x*v2.y)-(v1.y*v2.x));
        }
    }
    public void getPoints(){
        Point clbusta=((Connection)element).getSource().getPos();
        Dimension dima=((Connection)element).getSource().getDim();
        Point tlbusta= new Point(clbusta.x-dima.width/2,clbusta.y-dima.height/2);
        Rectangle r1=new Rectangle(tlbusta,dima);
        Rectangle r2=new Rectangle();
        if(isCompleted()) {
            Point cl2 = ((Connection) element).getDestination().getPos();
            Dimension dima2 = ((Connection) element).getDestination().getDim();
            Point tl2=new Point(cl2.x-dima2.width / 2, cl2.y-dima2.height / 2);
            r2 = new Rectangle(tl2, dima2);
            endPoint=Geom.interRectLine(r2,Geom.Cent(r1),Geom.Cent(r2));
            begPoint=Geom.interRectLine(r1,Geom.Cent(r1),Geom.Cent(r2));;

        }
        else{
            var x=Geom.interRectLine(r1,clbusta,endPoint);
            if (x != null) {
                begPoint=x;
            }

        }
    }
    public void setEndPoint(Point p){
        endPoint=p;
    }
    @Override
    public boolean elementAt(Point pos) {
        int prec=5;
        Rectangle c=new Rectangle(pos.x-prec/2,pos.y-prec/2,prec,prec);
        return line.intersects(c);
    }

    @Override
    public  void paint(Graphics2D g){

        MakeShape();
        g.setColor(Color.BLACK);
        g.setStroke(stroc);
        g.draw(line);

        if(isSelected){
            drawSelRect(g,line.getBounds2D());
        }

    }

    @Override
    public Rectangle getBounds() {
        return line.getBounds();
    }

    public abstract void MakeShape();

    public boolean isCompleted(){
        return ((Connection) element).getDestination()!=null;
    }
}
