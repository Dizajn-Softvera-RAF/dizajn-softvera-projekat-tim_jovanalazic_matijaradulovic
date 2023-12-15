package raf.dsw.classycraft.app.core.state;

import raf.dsw.classycraft.app.core.state.states.*;
import raf.dsw.classycraft.app.gui.swing.main.pkgview.DiagramView;

import java.awt.event.MouseEvent;

public class StateManager {
    EditContentState edi;

    public StateManager() {
        initStates();
    }
    GeneralizationState gen;
    AggregationState agg;
    CompostionState com;
    DependencyState dep;
    ClassState clas;
    InterfaceState inf;
    DeleteState del;
    SelectionState sel;
    MoveState mov;
    ZoomState zom;
    State currState;
    EnumState enu;
    void initStates(){
        edi=new EditContentState();
        gen=new GeneralizationState();
        enu=new EnumState();
        agg=new AggregationState();
        com=new CompostionState();
        dep=new DependencyState();
        clas=new ClassState();
        inf=new InterfaceState();
        del=new DeleteState();
        mov=new MoveState();
        zom=new ZoomState();
        sel=new SelectionState();
        currState=sel;
    }
    public void setGeneralizationState(){setCurrState(gen);}
    public void setCurrState(State s){
        currState=s;
        System.out.println("State set to: "+s.getClass().getSimpleName());

    }
    public void setClassState(){
        setCurrState(clas);
    }
    public void setIntefaceState(){
        setCurrState(inf);
    }
    public void setDependencyState(){
        setCurrState(dep);
    }
    public void setCompositionState(){
        setCurrState(com);
    }
    public void setAggregationState(){
        setCurrState(agg);
    }
    public void setDeleteState(){
        setCurrState(del);
    }
    public void setSelectState(){
        setCurrState(sel);
    }
    public void setMoveState(){
        setCurrState(mov);
    }
    public void setZoomState(){
        setCurrState(zom);
    }
    public void mouseDown(MouseEvent pos, DiagramView dview){
        currState.mouseDown(pos,dview);
    }
    public void mouseUp(MouseEvent pos, DiagramView dview){
        currState.mouseUp(pos,dview);
    }
    public void mouseDrag(MouseEvent pos, DiagramView dview){
        currState.mouseDrag(pos,dview);
    }
    public void mouseWheeled(MouseEvent e, DiagramView source) {
        currState.mouseWheeled(e,source);
    }

    public void setEnumState() {
        currState=enu;
    }

    public void setEditState() {
        currState=edi;
    }


}
