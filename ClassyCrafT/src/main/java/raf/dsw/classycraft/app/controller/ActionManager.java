package raf.dsw.classycraft.app.controller;


public class ActionManager {
    OpenAction openAction;
    OpenDiagram openDiagram;
    SaveDiagram saveDiagram;
    UndoAction undoAction;
    RedoAction redoAction;
    ExportAction exportAction;

    public ExportAction getExportAction() {
        return exportAction;
    }

    public void setExportAction(ExportAction exportAction) {
        this.exportAction = exportAction;
    }

    public OpenDiagram getOpenDiagram() {
        return openDiagram;
    }

    public void setOpenDiagram(OpenDiagram openDiagram) {
        this.openDiagram = openDiagram;
    }

    public SaveDiagram getSaveDiagram() {
        return saveDiagram;
    }

    public void setSaveDiagram(SaveDiagram saveDiagram) {
        this.saveDiagram = saveDiagram;
    }

    public UndoAction getUndoAction() {
        return undoAction;
    }

    public void setUndoAction(UndoAction undoAction) {
        this.undoAction = undoAction;
    }

    public RedoAction getRedoAction() {
        return redoAction;
    }

    public void setRedoAction(RedoAction redoAction) {
        this.redoAction = redoAction;
    }

    public OpenAction getOpenAction() {
        return openAction;
    }

    public void setOpenAction(OpenAction openAction) {
        this.openAction = openAction;
    }

    public SaveAction getSaveAction() {
        return saveAction;
    }

    public void setSaveAction(SaveAction saveAction) {
        this.saveAction = saveAction;
    }

    SaveAction saveAction;
    CloneAction cloneAction;
    FitAction fitAction;
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


    public CloneAction getCloneAction() {
        return cloneAction;
    }

    public FitAction getFitAction() {
        return fitAction;
    }

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
        fitAction=new FitAction();
        cloneAction=new CloneAction();
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
        openAction=new OpenAction();
        saveAction=new SaveAction();
        openDiagram=new OpenDiagram();
        saveDiagram=new SaveDiagram();
        undoAction=new UndoAction();
        redoAction=new RedoAction();
        exportAction=new ExportAction();
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
