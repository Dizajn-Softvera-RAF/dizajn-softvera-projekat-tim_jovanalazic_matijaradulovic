package raf.dsw.classycraft.app.gui.swing.main.pkgview;

import com.sun.tools.javac.Main;
import raf.dsw.classycraft.app.core.msggen.ISubscriber;
import raf.dsw.classycraft.app.core.treemodel.nodes.diagramNodes.DiagramElement;
import raf.dsw.classycraft.app.core.treemodel.nodes.diagramNodes.connections.Connection;
import raf.dsw.classycraft.app.core.treemodel.nodes.diagramNodes.entities.Interclass;
import raf.dsw.classycraft.app.core.treemodel.nodes.projNodes.Diagram;
import raf.dsw.classycraft.app.gui.swing.main.MainFrame;
import raf.dsw.classycraft.app.gui.swing.painters.ConnectionPainter;
import raf.dsw.classycraft.app.gui.swing.painters.ElementPainter;
import raf.dsw.classycraft.app.gui.swing.painters.InterClassPainter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.NoninvertibleTransformException;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

public class DiagramViewPane extends JPanel implements ISubscriber {
    Diagram diag;
    List<ElementPainter> painters;
    List<ElementPainter> selPainters;
    Rectangle curSel;
    ConnectionPainter curConn;
    AffineTransform trans;

    public void setCurConn(ConnectionPainter curConn) {
        this.curConn = curConn;
        repaint();
    }

    public Diagram getDiag() {
        return diag;
    }

    public void initialize(){
        for (var e:diag.getChildren()) {
            AddInterClass((DiagramElement) e); ;
        }
    }

    public DiagramViewPane(Diagram diagram, PackageTabbedPane p) {
        trans=new AffineTransform();
        diagram.addSubscriber(this);
        diag=diagram;

        var x=new ClassyMouseListener();
        this.addMouseListener(x);
        this.addMouseMotionListener(x);
        this.addMouseWheelListener(x);

        diagram.addSubscriber(this);

        painters = new ArrayList<ElementPainter>();
        selPainters = new ArrayList<ElementPainter>();
        initialize();
    }

    @Override
    public void react(Object notification) {
        repaint();
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
        g2d.setTransform(trans);



        for (var painter:painters) {
            painter.paint(g2d);
        }

        if(curConn!=null)
            curConn.paint(g2d);
        if(curSel!=null){
            final AffineTransform def=new AffineTransform();
            g2d.setTransform(def);
            ElementPainter.drawSelRect(g2d, curSel);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof DiagramViewPane tab){
            return tab.diag.equals(diag);
        }
        return false;
    }



    public void DeleteSelected() {
        while (!selPainters.isEmpty()){
            RemovePainter(selPainters.get(0));
        }
    }

    public void Fit() {
         FitToRect(getBounds2());
         repaint();
    }


    private static class ClassyMouseListener extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            MainFrame.getInstance().getPkgpane().MousePressed(e,(DiagramViewPane) e.getSource());
        }
        @Override
        public void mouseDragged(MouseEvent e) {
            MainFrame.getInstance().getPkgpane().MouseDragged(e,(DiagramViewPane) e.getSource());

        }

        @Override
        public void mouseReleased(MouseEvent e) {
            MainFrame.getInstance().getPkgpane().MouseReleased(e,(DiagramViewPane) e.getSource());
        }
        @Override
        public void mouseWheelMoved(MouseWheelEvent e) {
            MainFrame.getInstance().getPkgpane().MouseWheeled(e,(DiagramViewPane) e.getSource());
        }
    }
    public void SelectElement(ElementPainter e){
        if(selPainters.contains(e))return;
        e.setSelected(true);
        selPainters.add(e);
        repaint();
    }
    public void DeselectElement(ElementPainter e){
        e.setSelected(false);
        selPainters.remove(e);
        repaint();
    }
    public void resetSelection(){
        while(!selPainters.isEmpty()) {
            DeselectElement(selPainters.get(0));
        }
    }
    public void AddPainter(ElementPainter p){
        painters.add(p);
        repaint();
    }
    public void AddInterClass(DiagramElement cls){
        if(cls instanceof Interclass i) {
            Point pos=i.getPos();
            pos= tWorldCoords(pos);
            i.setPos(pos);
            ElementPainter clp = new InterClassPainter(i);
            painters.add(clp);
            repaint();
        }
    }
    public void RemovePainter(ElementPainter p){
        RemoveAffilConn(p);
        painters.remove(p);
        selPainters.remove(p);
        p.getElement().removeSelf();
    }
    public void RemoveAffilConn(ElementPainter p){
        for (int i = 0; i < painters.size(); i++) {
            if(painters.get(i) instanceof ConnectionPainter cp){
                if(cp.getElement().getSource()==p.getElement() ||cp.getElement().getDestination()==p.getElement()){
                    RemovePainter(cp);
                    break;
                }
            }
        }
    }
    public ElementPainter underPointer(Point p){
        p=tWorldCoords(p);
        for (var pp:painters) {
            if(pp.elementAt(p)){
                return pp;
            }
        }
        return null;
    }
    public void setSelect(Rectangle r){

        curSel=r;
        Shape rt=null;
        if(r!=null){

            try {
                rt= trans.createInverse().createTransformedShape(r);
            } catch (NoninvertibleTransformException e) {
                throw new RuntimeException(e);
            }

            for (ElementPainter e : painters) {
                if (rt.intersects(e.getBounds())) {
                    //if(e.isSelected())//additve
                      //  DeselectElement(e);
                    //else
                        SelectElement(e);
                } //else if (e.isSelected()&&!additve) {
                   // DeselectElement(e);
                //}
            }
        }

        repaint();  // :)
    }
    public void Touch(Point pos){
        pos=tWorldCoords(pos);
        var s=underPointer(pos);
        if(s!=null){
            if(!s.isSelected()){
                resetSelection();
                SelectElement(s);
            }
        }
        else
            resetSelection();

    }
    public boolean isUnder(Point p){
        return underPointer(p)!=null;
    }
    public Rectangle getCurSel() {
        return curSel;
    }
    public void transEl(ElementPainter e, int dx, int dy){
        double z=trans.getScaleX();
        ((Interclass) e.getElement()).trans((int)(dx/z),(int)(dy/z));
        repaint();
    }
    public void transSel(int dx,int dy){
        for (var e:selPainters) {
            if(e instanceof InterClassPainter)
                transEl(e,dx,dy);
        }
    }
    public boolean SingleSel(){
        return selPainters.size()==1;
    }
    public void transView(int dx,int dy){
        trans.translate(dx,dy);
        repaint();
    }
    public Point toViewCoords(Point pos){
        Point2D p= trans.transform(pos,null);
        return new Point((int)p.getX(),(int)p.getY());
    }
    public Point tWorldCoords(Point pos){
        Point2D p= null;
        try {
            p = trans.inverseTransform(pos,null);
        } catch (NoninvertibleTransformException e) {
            throw new RuntimeException(e);
        }
        return new Point((int)p.getX(),(int)p.getY());
    }
    public void zoomView(double factor, Point pos){
        double currscale=trans.getScaleX();
        if(currscale>4&&factor>1||currscale<0.5&&factor<1) return;
        pos=tWorldCoords(pos);
        var newt=new AffineTransform();
        newt.translate((pos).x, (pos).y);
        double nsx=factor;
        newt.scale(nsx,nsx);
       // System.out.println(factor+" x "+currscale+" -> "+nsx);
        newt.translate(-(pos).x,-(pos).y);

        //newt.translate(trans.getTranslateX(),trans.getTranslateY());
        trans.concatenate(newt);
        repaint();
    }

    public void setConEnd(Point pos){
        pos=tWorldCoords(pos);
        ((ConnectionPainter) curConn).setEndPoint(pos);
        repaint();
    }
    public void letGo(Point pos) {
        var x=this.underPointer(pos);
        if(x!=null && x.getElement()!= ((Connection)curConn.getElement()).getSource()) {

            ((Connection) curConn.getElement()).setDestination(((Interclass) x.getElement()));
            this.getDiag().AddChild(curConn.getElement());
            this.AddPainter(curConn);
        }
        this.setCurConn(null);
    }
    public ElementPainter getSelected(){
        return selPainters.get(0);
    }

    public Rectangle getBounds2(){
        if(painters.isEmpty()) return null;
        Rectangle r= new Rectangle(painters.get(0).getBounds());
        for (var e:painters) {
            r=addRect(r,e.getBounds());
        }
        return r;
    }
    private Rectangle addRect(Rectangle r1,Rectangle r2){
        int minx,miny,maxx,maxy;
        minx=Math.min(r1.x,r2.x);
        miny=Math.min(r1.y,r2.y);
        maxx= (int)Math.max(r1.getMaxX(),r2.getMaxX());
        maxy= (int)Math.max(r1.getMaxY(),r2.getMaxY());

        int w=maxx-minx;
        int h=maxy-miny;
        return new Rectangle(minx,miny,w,h);
    }

    public void FitToRect(Rectangle r){
        if(r==null)return;
        double scw=(double)this.getWidth()/r.width;
        double sch=(double)this.getHeight()/r.height;
        double scfact = Math.min(scw,sch);
        scfact=Math.max(scfact,0.2);
        scfact=Math.min(scfact,5);
        System.out.println("zooooom "+scfact);
        int dx1=(int)r.getCenterX();
        int dy1=(int)r.getCenterY();
        int dx2=this.getWidth()/2;
        int dy2=this.getHeight()/2;

        AffineTransform ntrans=new AffineTransform();
        ntrans.translate(+dx2,+dy2);
        ntrans.scale(scfact,scfact);
        ntrans.translate(-dx1,-dy1);
        trans=ntrans;


    }
}
