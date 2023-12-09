package raf.dsw.classycraft.app.controller;

public class ActionManager {
    AboutUsAction aboutUsAction;
    AddDiagramAction addDiagramAction;
    AddDirectoryAction addDirectoryAction;
    EditAuthorAction editAuthorAction;
    ExitAction exitAction;
    RemoveAction removeAction;
    RenameAction renameAction;
    AggregationAction aggregationAction;
    CompositionAction compositionAction;
    DependencyAction dependencyAction;
    EnumAction enumAction;
    ClassAction classAction;
    InterfaceAction interfaceAction;
    ZoomAction zoomAction;
    SelectAction selectAction;
    MoveAction moveAction;
    DeleteElementAction deleteElementAction;
    GeneralizationAction generalizationAction;
    EditContentAction editContentAction;

    public GeneralizationAction getGeneralizationAction() {
        return generalizationAction;
    }

    public AggregationAction getAggregationAction() {
        return aggregationAction;
    }

    public CompositionAction getCompositionAction() {
        return compositionAction;
    }

    public DependencyAction getDependencyAction() {
        return dependencyAction;
    }

    public EnumAction getEnumAction() {
        return enumAction;
    }

    public ClassAction getClassAction() {
        return classAction;
    }

    public InterfaceAction getInterfaceAction() {
        return interfaceAction;
    }

    public ZoomAction getZoomAction() {
        return zoomAction;
    }

    public SelectAction getSelectAction() {
        return selectAction;
    }

    public MoveAction getMoveAction() {
        return moveAction;
    }

    public DeleteElementAction getDeleteElementAction() {
        return deleteElementAction;
    }

    public EditContentAction getEditContentAction() {
        return editContentAction;
    }

    public ActionManager() {
        editContentAction=new EditContentAction();
        generalizationAction=new GeneralizationAction();
        aboutUsAction=new AboutUsAction();
        addDiagramAction=new AddDiagramAction();
        addDirectoryAction=new AddDirectoryAction();
        editAuthorAction=new EditAuthorAction();
        exitAction=new ExitAction();
        removeAction=new RemoveAction();
        selectAction=new SelectAction();
        renameAction=new RenameAction();
        moveAction=new MoveAction();
        enumAction=new EnumAction();
        classAction=new ClassAction();
        dependencyAction=new DependencyAction();
        aggregationAction=new AggregationAction();
        compositionAction=new CompositionAction();
        interfaceAction=new InterfaceAction();
        zoomAction=new ZoomAction();
        deleteElementAction=new DeleteElementAction();
    }

    public AboutUsAction getAboutUsAction() {
        return aboutUsAction;
    }

    public AddDiagramAction getAddDiagramAction() {
        return addDiagramAction;
    }

    public AddDirectoryAction getAddDirectoryAction() {
        return addDirectoryAction;
    }

    public EditAuthorAction getEditAuthorAction() {
        return editAuthorAction;
    }

    public ExitAction getExitAction() {
        return exitAction;
    }

    public RemoveAction getRemoveAction() {
        return removeAction;
    }

    public RenameAction getRenameAction() {
        return renameAction;
    }
}
