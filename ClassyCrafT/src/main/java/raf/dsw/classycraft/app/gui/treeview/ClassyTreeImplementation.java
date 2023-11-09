package raf.dsw.classycraft.app.gui.treeview;

import raf.dsw.classycraft.app.core.ApplicationFramework;
import raf.dsw.classycraft.app.core.treemodel.abstraction.ClassyNode;
import raf.dsw.classycraft.app.core.treemodel.abstraction.ClassyNodeComposite;
import raf.dsw.classycraft.app.core.treemodel.implementation.ProjectExplorer;
import raf.dsw.classycraft.app.gui.treeview.model.ClassyTreeItem;
import raf.dsw.classycraft.app.gui.treeview.view.ClassyTreeView;

import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;

public class ClassyTreeImplementation implements ClassyTree {

    private ClassyTreeView treeView;//arghhh



    @Override
    public ClassyTreeView generateTree(ProjectExplorer pe) {
        ClassyTreeItem root= new ClassyTreeItem(pe);
        DefaultTreeModel dtm=new DefaultTreeModel(root);

        return treeView= new ClassyTreeView(dtm);
    }

    @Override
    public boolean AddChild(ClassyTreeItem parentItem) { //named child??
        if(! (parentItem.getNode() instanceof ClassyNodeComposite parentNode) ){
            ApplicationFramework.getInstance().getMsgGen().generateErrorMessage("Dodavanje nije moguće");
            //log..

            return false;
        }
        ClassyNode newNode= CreateNode(parentNode);
        ClassyTreeItem newItem=new ClassyTreeItem(newNode);
        parentNode.AddChild(newNode);
        parentItem.add(newItem);
        treeView.expandPath(treeView.getSelectionPath());
        SwingUtilities.updateComponentTreeUI(treeView);

        return true;
    }

    @Override
    public ClassyNode CreateNode(ClassyNodeComposite parent) {
        //switch...
        //return  parent.genChild();
        return  parent.genChild2();
    }
    ///!!!UPDATE TREE MODEL + view?
    @Override
    public boolean RenameItem(String newName, ClassyTreeItem item) {///....cast cast cast cast error error error error
        //check name conflict...
        if(!((ClassyNodeComposite)item.getParent()).NameIsAvailable(newName))
            return false;
        item.setName(newName);
        item.getNode().setName(newName);
        SwingUtilities.updateComponentTreeUI(treeView);
        return true;
    }
    public ClassyTreeItem getSelectedNode() {//..or? am I?
        return (ClassyTreeItem) treeView.getLastSelectedPathComponent();
    }

    @Override
    public void RemoveNode(ClassyTreeItem item) {
        ClassyNode node= (ClassyNode)item.getNode();
        ((ClassyNodeComposite) node.getParent()).removeChild(node);
        //item.getParent()
        ((DefaultTreeModel)treeView.getModel()).removeNodeFromParent(item);
        treeView.expandPath(treeView.getSelectionPath());
        SwingUtilities.updateComponentTreeUI(treeView);
    }

    @Override
    public void AppendCild() {
        AddChild(getSelectedNode());
    }

    @Override
    public void RemoveSel() {
        RemoveNode(getSelectedNode());
    }
}
