package raf.dsw.classycraft.app.gui.swing.main.pkgview;

import raf.dsw.classycraft.app.core.msggen.ISubscriber;
import raf.dsw.classycraft.app.core.treemodel.nodes.diagramNodes.connections.Connection;
import raf.dsw.classycraft.app.core.treemodel.nodes.diagramNodes.entities.Interclass;
import raf.dsw.classycraft.app.core.treemodel.nodes.projNodes.Diagram;
import raf.dsw.classycraft.app.gui.swing.main.MainFrame;
import raf.dsw.classycraft.app.gui.swing.painters.ElementPainter;
import raf.dsw.classycraft.app.gui.swing.painters.InterClassPainter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class DiagramViewPane extends JPanel implements ISubscriber {
    Diagram diag;
    List<ElementPainter> painters;
    List<ElementPainter> selPainters;
    ElementPainter curSel;
    ElementPainter curConn;
    public void AddInterClass(Interclass cls){
        ElementPainter clp=new InterClassPainter(cls);
        painters.add(clp);
        repaint();//#!!!!!!!!!!!!!!!!!!!!!!
    }
    private final PackageTabbedPane pane;
    public DiagramViewPane(Diagram diagram, PackageTabbedPane p) {
        diagram.addSubscriber(this);
        diag=diagram;
        pane=p;
        this.addMouseListener(new ClassyMouseListener());

        painters = new ArrayList<ElementPainter>();
        selPainters = new ArrayList<ElementPainter>();
    }

    @Override
    public void react(Object notification) {
        for (int i = 0; i < pane.getTabCount(); i++) {
            var tab= ((DiagramViewPane) pane.getComponent(i));
            if(tab!=null && tab.diag== notification)
            {
                pane.setTitleAt(i,tab.diag.getName());
                pane.validate();
                return;
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
        for (var painter:painters) {
            painter.paint(g2d);
        }
        for (var painter:selPainters) {
            painter.paint(g2d);
        }
        if(curConn!=null)
            curConn.paint(g2d);
        if(curSel!=null){
            curSel.paint(g2d);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof DiagramViewPane tab){
            return tab.diag.equals(diag);
        }
        return false;
    }

    public Interclass getSelectedClass() {
        if(selPainters.size()!=1) return null;
        if(selPainters.get(0).getElement() instanceof Interclass p) return p;
        return null;
    }

    private class ClassyMouseListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            MainFrame.getInstance().getPkgpane().getStateManager().mouseDown(e.getPoint(),(DiagramViewPane) e.getSource());
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            MainFrame.getInstance().getPkgpane().getStateManager().mouseDrag(e.getPoint(),(DiagramViewPane) e.getSource());

        }

        @Override
        public void mouseReleased(MouseEvent e) {
            MainFrame.getInstance().getPkgpane().getStateManager().mouseUp(e.getPoint(),(DiagramViewPane) e.getSource());

        }

    }
}
