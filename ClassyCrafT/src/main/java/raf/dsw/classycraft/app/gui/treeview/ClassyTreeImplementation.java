package raf.dsw.classycraft.app.gui.treeview;

import raf.dsw.classycraft.app.core.ApplicationFramework;
import raf.dsw.classycraft.app.core.treemodel.ClassyRepository;
import raf.dsw.classycraft.app.core.treemodel.factory.AbstractNodeFactory;
import raf.dsw.classycraft.app.core.treemodel.nodes.*;
import raf.dsw.classycraft.app.core.treemodel.nodes.Package;
import raf.dsw.classycraft.app.gui.treeview.model.ClassyTreeItem;
import raf.dsw.classycraft.app.gui.treeview.view.ClassyTreeView;

import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

public class ClassyTreeImplementation implements ClassyTree {

    private ClassyTreeView treeView;



    @Override
    public ClassyTreeView generateTree(ProjectExplorer pe) {
        ClassyTreeItem root= new ClassyTreeItem(pe);
        DefaultTreeModel dtm=new DefaultTreeModel(root);

        treeView= new ClassyTreeView(dtm);
        treeView.setSelectionPath(new TreePath(root));
        treeView.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        return treeView;
    }

    @Override
    public boolean AddChild(ClassyTreeItem parentItem, String type) {
        if(! (parentItem.getNode() instanceof ClassyNodeComposite parentNode) ){
            ApplicationFramework.getInstance().getMsgGen().generateErrorMessage("Dodavanje nije moguće");
                return false;
        }

        ClassyNode newNode= CreateNode(parentNode,type);
        if(newNode==null){
            return false;
        }
        ClassyTreeItem newItem=new ClassyTreeItem(newNode);
        parentNode.AddChild(newNode);
        parentItem.add(newItem);
        treeView.expandPath(treeView.getSelectionPath());
        treeView.setSelectionPath(treeView.getSelectionPath().pathByAddingChild(newItem));
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
    @Override
    public boolean RenameItem( ClassyTreeItem item,String newName) {///....cast cast cast cast error error error error
        String oldName = item.toString();
        item.setName(newName);
        item.getNode().setName(newName);

        if (((ClassyNodeComposite) ((ClassyTreeItem) item.getParent()).getNode()).isUnique(item.getNode())){
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
    public ClassyTreeItem getSelectedNode() {//..or? am I?
        return (ClassyTreeItem) treeView.getLastSelectedPathComponent();
    }

    @Override
    public void RemoveNode(ClassyTreeItem item) {
        treeView.setSelectionPath(treeView.getSelectionPath().getParentPath());

        ClassyNode node= (ClassyNode)item.getNode();
        ((ClassyNodeComposite) node.getParent()).removeChild(node);

        ((DefaultTreeModel)treeView.getModel()).removeNodeFromParent(item);
        treeView.expandPath(treeView.getSelectionPath());
        SwingUtilities.updateComponentTreeUI(treeView);
    }

    @Override
    public void AppendChild(String type) {
        if(getSelectedNode()!=null)
            AddChild(getSelectedNode(),type);
    }

    @Override
    public void RemoveSel() {

        if(getSelectedNode()!=null)
            RemoveNode(getSelectedNode());
    }

    @Override
    public void RenameAuthSel(String name) {
        ClassyTreeItem selitem=getSelectedNode();
        if(selitem!=null&& selitem.getNode() instanceof Project p)
        {
            p.setAuthor(name);
        }
    }

    @Override
    public boolean isProjSel() {
        ClassyTreeItem selitem = getSelectedNode();
        return (selitem != null && selitem.getNode() instanceof Project p);
    }

    @Override
    public boolean isPackSel() {
        ClassyTreeItem selitem = getSelectedNode();
        return (selitem != null && selitem.getNode() instanceof Package);
    }
}
