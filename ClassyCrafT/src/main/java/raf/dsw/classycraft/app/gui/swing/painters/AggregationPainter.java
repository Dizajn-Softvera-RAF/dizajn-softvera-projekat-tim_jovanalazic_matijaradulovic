package raf.dsw.classycraft.app.gui.swing.painters;

import raf.dsw.classycraft.app.core.treemodel.nodes.diagramNodes.connections.Agreggation;
import raf.dsw.classycraft.app.core.treemodel.nodes.diagramNodes.connections.Connection;

import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

public class AggregationPainter extends ConnectionPainter{
    public AggregationPainter(Connection con) {
        super(con);
        stroc=new BasicStroke(2);

    }

    @Override
    public void paint(Graphics2D g) {
        super.paint(g);
        g.setColor(Color.white);
        g.fill(specShape);
        g.setColor(Color.BLACK);
        g.draw(specShape);
    }


    public void MakeShape(){
        getPoints();



        line=new Line2D.Double(((Point) begPoint.clone()), ((Point) endPoint.clone()));

        Point vp= Geom.getVect(begPoint,endPoint);
        Point2D vpn= Geom.normalize(vp);
        Point2D rrv= Geom.rotate(vpn, Math.toRadians(30));
        Point2D rlv=Geom.rotate(vpn, Math.toRadians(-30));

        Point b=Geom.scaleNor(rlv,+12);
        Point a=Geom.scaleNor(rrv,+12);
        Point pler= Geom.add(b,begPoint);
        Point prer= Geom.add(a,begPoint);

        Point diag=Geom.add(b,prer);

        int[]px={begPoint.x, prer.x,diag.x,pler.x, begPoint.x};
        int[]py={begPoint.y, prer.y,diag.y,pler.y, begPoint.y};
        specShape=new Polygon(px,py,4);

    }

}
