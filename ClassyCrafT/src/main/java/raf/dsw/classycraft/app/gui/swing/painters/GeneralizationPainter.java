package raf.dsw.classycraft.app.gui.swing.painters;

import raf.dsw.classycraft.app.core.treemodel.nodes.diagramNodes.connections.Connection;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

public class GeneralizationPainter extends ConnectionPainter{

    public GeneralizationPainter(Connection con) {
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

        Point vp=Geom.getVect(begPoint,endPoint);
        Point2D vpn=Geom.normalize(vp);
        Point2D rrv=Geom.rotate(vpn, Math.toRadians(30));
        Point2D rlv=Geom.rotate(vpn, Math.toRadians(-30));
        Point pler=Geom.add(Geom.scaleNor(rlv,-12),endPoint);
        Point plev=Geom.add(Geom.scaleNor(rrv,-12),endPoint);

        int[]px={pler.x,plev.x,endPoint.x};
        int[]py={pler.y,plev.y,endPoint.y};
        specShape=new Polygon(px,py,3);

        }



}