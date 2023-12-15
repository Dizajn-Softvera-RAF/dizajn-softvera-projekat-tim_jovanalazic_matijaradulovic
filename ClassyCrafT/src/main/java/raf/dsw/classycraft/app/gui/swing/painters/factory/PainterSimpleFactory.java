package raf.dsw.classycraft.app.gui.swing.painters.factory;

import raf.dsw.classycraft.app.core.treemodel.nodes.diagramNodes.DiagramElement;
import raf.dsw.classycraft.app.core.treemodel.nodes.diagramNodes.connections.*;
import raf.dsw.classycraft.app.core.treemodel.nodes.diagramNodes.entities.ClassyClass;
import raf.dsw.classycraft.app.core.treemodel.nodes.diagramNodes.entities.ClassyEnum;
import raf.dsw.classycraft.app.core.treemodel.nodes.diagramNodes.entities.ClassyInterface;
import raf.dsw.classycraft.app.core.treemodel.nodes.diagramNodes.entities.Interclass;
import raf.dsw.classycraft.app.gui.swing.painters.*;

public class PainterSimpleFactory {
    public static ElementPainter makePainter(DiagramElement d){
        if(d instanceof Interclass i){
            return new InterClassPainter(i);
        }
        else if(d instanceof Connection c){
            if(c instanceof Aggregation){
                return new AggregationPainter(c);
            }
            if(c instanceof Composition){
                return new CompositionPainter(c);
            }
            if(c instanceof Dependency){
                return new DependencyPainter(c);
            }
            if(c instanceof Generalization){
                return new GeneralizationPainter(c);
            }
        }
        return null;
    }
}
