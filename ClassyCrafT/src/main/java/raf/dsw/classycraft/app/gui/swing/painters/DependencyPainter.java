package raf.dsw.classycraft.app.gui.swing.painters;

import raf.dsw.classycraft.app.core.treemodel.nodes.diagramNodes.connections.Connection;

import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

public class DependencyPainter extends ConnectionPainter{
    public DependencyPainter(Connection conn) {
        super(conn);
        float[] dash1 = {7.0f};
        stroc=new BasicStroke(2.0f,
                BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_MITER,
                10.0f, dash1, 0.0f);;
    }

    @Override
    public void paint(Graphics2D g) {
        super.paint(g);
        final var stroc2=new BasicStroke(2);
        g.setStroke(stroc2);
        g.setColor(Color.BLACK);
        g.drawPolyline(((Polygon) specShape).xpoints,((Polygon) specShape).ypoints,3);
    }


    public void MakeShape(){
        getPoints();
        line=new Line2D.Double(begPoint,endPoint);

        Point vp= ConnectionPainter.Geom.getVect(begPoint,endPoint);
        Point2D vpn= ConnectionPainter.Geom.normalize(vp);
        Point2D rrv= ConnectionPainter.Geom.rotate(vpn, Math.toRadians(30));
        Point2D rlv= ConnectionPainter.Geom.rotate(vpn, Math.toRadians(-30));
        Point pler= ConnectionPainter.Geom.add(ConnectionPainter.Geom.scaleNor(rlv,-12),endPoint);
        Point plev= ConnectionPainter.Geom.add(ConnectionPainter.Geom.scaleNor(rrv,-12),endPoint);

        int[]px={pler.x,endPoint.x,plev.x};
        int[]py={pler.y,endPoint.y,plev.y};
        specShape=new Polygon(px,py,3);

    }
}
