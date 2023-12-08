package raf.dsw.classycraft.app.gui.swing.treeview;

import raf.dsw.classycraft.app.core.msggen.IPublisher;
import raf.dsw.classycraft.app.core.msggen.ISubscriber;
import raf.dsw.classycraft.app.core.treemodel.ClassyRepository;
import raf.dsw.classycraft.app.core.treemodel.factory.AbstractNodeFactory;
import raf.dsw.classycraft.app.core.treemodel.nodes.abstractNodes.ClassyNode;
import raf.dsw.classycraft.app.core.treemodel.nodes.abstractNodes.ClassyNodeComposite;
import raf.dsw.classycraft.app.core.treemodel.nodes.projNodes.Package;
import raf.dsw.classycraft.app.core.treemodel.nodes.projNodes.ProjectExplorer;
import raf.dsw.classycraft.app.gui.swing.treeview.model.ClassyTreeItem;
import raf.dsw.classycraft.app.gui.swing.treeview.view.ClassyTreeView;

import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;
import java.util.ArrayList;
import java.util.List;

public class ClassyTreeImplementation implements ClassyTree, IPublisher {
    private DefaultTreeModel treeModel;
    private ClassyTreeView treeView;
    public ClassyTreeView getView(){return treeView;}
    public DefaultTreeModel getTreeModel() {
        return treeModel;
    }

    ClassyTreeItem selectedItem;
    public void setSelectedItem(ClassyTreeItem sel){
        selectedItem=sel;
        notifySubscribers(sel);
    }
    @Override
    public ClassyTreeView generateTree(ProjectExplorer pe) {
        ClassyTreeItem root= new ClassyTreeItem(pe);
        treeModel=new DefaultTreeModel(root);

        treeView= new ClassyTreeView(treeModel);
        treeView.setSelectionPath(new TreePath(root));
        treeView.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);

        return treeView;
    }

    public boolean AddChild(ClassyTreeItem parentItem, String type) {
        if(! (parentItem.getNode() instanceof ClassyNodeComposite parentNode) ){
                return false;
        }
        ClassyNode newNode= CreateNode(parentNode,type);
        if(newNode==null){
            return false;
        }
        ClassyTreeItem newItem=new ClassyTreeItem(newNode);
        parentNode.AddChild(newNode);
        parentItem.add(newItem);
        treeView.expandPath(new TreePath(parentItem.getPath()) );
        SwingUtilities.updateComponentTreeUI(treeView);
        return true;
    }

    @Override
    public ClassyNode CreateNode(ClassyNodeComposite parent,String type) {
        AbstractNodeFactory factory= ClassyRepository.getFactoryOf(parent.getClass().getSimpleName());
        ClassyNode res= factory.createNode(type);
        if(res==null)
            return null;
        res.setParent(parent);
        parent.NameChild(res);
        return res;
    }

    private boolean RenameItem( ClassyTreeItem item,String newName) {
        String oldName = item.toString();
        item.setName(newName);
        item.getNode().setName(newName);
        ClassyNodeComposite node=((ClassyNodeComposite) item.getNode().getParent());
        if (node.isUnique(item.getNode())){
            SwingUtilities.updateComponentTreeUI(treeView);
            return true;
        }
        item.setName(oldName);
        item.getNode().setName(oldName);
        return false;
    }
    public  boolean RenameSel(String name){
        if(getSelectedNode()!=null)
            return RenameItem(getSelectedNode(),name);
        return false;
    }
    public ClassyTreeItem getSelectedNode() {
        return (ClassyTreeItem) treeView.getLastSelectedPathComponent();
    }


    private boolean RemoveNode(ClassyTreeItem item) {
        if(item==treeModel.getRoot())
            return false;
        if(item==selectedItem || item.isNodeDescendant(selectedItem))
            setSelectedItem(null);

        treeView.setSelectionPath(treeView.getSelectionPath().getParentPath());

        ClassyNode node= item.getNode();
        ((ClassyNodeComposite) node.getParent()).removeChild(node);

        ((DefaultTreeModel)treeView.getModel()).removeNodeFromParent(item);
        treeView.expandPath(treeView.getSelectionPath());
        SwingUtilities.updateComponentTreeUI(treeView);
        return true;
    }

    @Override
    public boolean AppendChild(String type) {
        if(getSelectedNode()!=null)
            return AddChild(getSelectedNode(),type);
        return false;
    }

    @Override
    public boolean RemoveSel() {

        if(getSelectedNode()!=null)
            return RemoveNode(getSelectedNode());
        return false;
    }




    public boolean isPackSel(){
        return getSelectedNode().getNode() instanceof Package;
    }
    public boolean isExpSel(){
        return getSelectedNode().getNode() instanceof ProjectExplorer;
    }
    public  boolean isSel(){return getSelectedNode()!=null;}

    List<ISubscriber> subscribers=new ArrayList<>();
    @Override
    public void addSubscriber(ISubscriber subscr) {
        subscribers.add(subscr);
    }

    @Override
    public void removeSubscriber(ISubscriber subscr) {
        subscribers.remove(subscr);
    }

    @Override
    public void notifySubscribers(Object notification) {
        for (ISubscriber sub:subscribers) {
            sub.react (this.selectedItem);
        }
    }
}
