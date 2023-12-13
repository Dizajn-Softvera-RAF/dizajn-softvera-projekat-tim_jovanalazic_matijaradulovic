package raf.dsw.classycraft.app.gui.swing.painters;

import raf.dsw.classycraft.app.core.treemodel.nodes.diagramNodes.connections.Connection;

import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

public class CompositionPainter extends ConnectionPainter{

    public CompositionPainter(Connection con) {
        super(con);
        stroc=new BasicStroke(2);

    }

    @Override
    public void paint(Graphics2D g) {
        super.paint(g);
        g.setColor(Color.BLACK);
        g.fill(specShape);
        g.setColor(Color.BLACK);
        g.draw(specShape);
    }


    public void MakeShape(){
        getPoints();



        line=new Line2D.Double(((Point) begPoint.clone()), ((Point) endPoint.clone()));

        Point vp= ConnectionPainter.Geom.getVect(begPoint,endPoint);
        Point2D vpn= ConnectionPainter.Geom.normalize(vp);
        Point2D rrv= ConnectionPainter.Geom.rotate(vpn, Math.toRadians(30));
        Point2D rlv= ConnectionPainter.Geom.rotate(vpn, Math.toRadians(-30));

        Point b= ConnectionPainter.Geom.scaleNor(rlv,+12);
        Point a= ConnectionPainter.Geom.scaleNor(rrv,+12);
        Point pler= ConnectionPainter.Geom.add(b,begPoint);
        Point prer= ConnectionPainter.Geom.add(a,begPoint);

        Point diag= ConnectionPainter.Geom.add(b,prer);

        int[]px={begPoint.x, prer.x,diag.x,pler.x, begPoint.x};
        int[]py={begPoint.y, prer.y,diag.y,pler.y, begPoint.y};
        specShape=new Polygon(px,py,4);

    }
}
