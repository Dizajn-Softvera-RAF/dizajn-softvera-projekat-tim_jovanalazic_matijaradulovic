package raf.dsw.classycraft.app.gui.swing.main.pkgview;

import raf.dsw.classycraft.app.controller.events.SelectionClassyEvent;
import raf.dsw.classycraft.app.core.msggen.ISubscriber;
import raf.dsw.classycraft.app.core.state.StateManager;
import raf.dsw.classycraft.app.core.treemodel.nodes.projNodes.Package;
import raf.dsw.classycraft.app.core.treemodel.nodes.projNodes.Project;
import raf.dsw.classycraft.app.gui.swing.main.MainFrame;
import raf.dsw.classycraft.app.gui.swing.treeview.model.ClassyTreeItem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

public class PackageViewPane extends JPanel implements ISubscriber {
    StateManager stateManager;
    ProjInfoPane projInfo;
    PackageTabbedPane packTabs;
    SideToolBar sidebar;
    public DiagramView getActiveDiagramP(){
        if(packTabs!=null)
            return packTabs.getDiagView();
        return null;
    }

    public void MousePressed(MouseEvent e, DiagramView dview){
        stateManager.mouseDown(e,dview);
    }
    public void MouseReleased(MouseEvent e, DiagramView dview)
    {
        stateManager.mouseUp(e,dview);
    }
    public void MouseDragged(MouseEvent e, DiagramView dview){
        stateManager.mouseDrag(e,dview);
    }
    public void MouseWheeled(MouseEvent e, DiagramView source) {
        stateManager.mouseWheeled(e,source);
    }
    public void StartClassState(){
        stateManager.setClassState();
    }
    public void StartInterfaceState(){stateManager.setIntefaceState();}
    public void StartDependencyState(){stateManager.setDependencyState();}
    public void StartEnumState() {stateManager.setEnumState();}
    public void StartAggregationState(){stateManager.setAggregationState();}
    public void StartCompostionState(){stateManager.setCompositionState();}
    public void StartDeleteState(){stateManager.setDeleteState();}
    public void StartMoveState(){stateManager.setMoveState();}
    public void StartSelectionState(){stateManager.setSelectState();}
    public void StartZoomState(){stateManager.setZoomState();}

    public StateManager getStateManager() {
        return stateManager;
    }

    public void StartGeneralization() {
        stateManager.setGeneralizationState();
    }
    public void StartEditState() {
        stateManager.setEditState();
    }

    public PackageViewPane(){
        setLayout(new BorderLayout());
        MainFrame.getInstance().getTree().addSubscriber(this);
        stateManager=new StateManager();
    }

    @Override
    public void react(Object notification) { // jtree after selection changed
        if(notification instanceof SelectionClassyEvent esel){
            ClassyTreeItem selItem=(ClassyTreeItem) esel.getSelected();
            if(selItem!=null && selItem.getNode() instanceof Package p){
                makeView(p);
            }
            else {
                deleteView();
            }
        }
    }

    //reinit?
    private void deleteView() {
        if(packTabs!=null){
            packTabs.Clean();
        }
        if(projInfo!=null){
            projInfo.Clean();
        }

        removeAll();
        projInfo=null;
        packTabs=null;
        sidebar=null;
        revalidate();
        repaint();
    }
    //public void Clean(){}
    //public void Initialize(){}
    public void makeView(Package pack){

        deleteView();
        if(pack!=null) {
            Project p = pack.projGet();
            projInfo = new ProjInfoPane(p);
            packTabs = new PackageTabbedPane(pack);
            sidebar=new SideToolBar();

            add(projInfo, BorderLayout.NORTH);
            add(packTabs,BorderLayout.CENTER);
            add(sidebar,BorderLayout.EAST);
        }
    }



}
