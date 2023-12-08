package raf.dsw.classycraft.app.core.state;

import raf.dsw.classycraft.app.core.state.states.*;

import java.awt.*;

public class StateManager {
    public StateManager() {
        initStates();
    }

    AddAggregationState agg;
    AddCompostionState com;
    AddDependencyState dep;
    AddClassState clas;
    AddInterfaceState inf;
    DeleteState del;
    SelectionState sel;
    MoveState mov;
    ZoomState zom;
    State currState;
    EnumState enu;
    void initStates(){
        enu=new EnumState();
        agg=new AddAggregationState();
        com=new AddCompostionState();
        dep=new AddDependencyState();
        clas=new AddClassState();
        inf=new AddInterfaceState();
        del=new DeleteState();
        mov=new MoveState();
        zom=new ZoomState();
        sel=new SelectionState();
        currState=sel;
    }
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
        setCurrState(inf);
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
    public void mouseDown(Point pos){
        currState.mouseDown(pos);
    }
    public void mouseUp(Point pos){
        currState.mouseUp(pos);
    }
    public void mouseDrag(Point pos){
        currState.mouseDrag(pos);
    }

    public void setEnumState() {
        currState=enu;
    }
}
