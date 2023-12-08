package raf.dsw.classycraft.app.gui.swing.main;

import raf.dsw.classycraft.app.controller.ActionManager;
import raf.dsw.classycraft.app.core.ApplicationFramework;
import raf.dsw.classycraft.app.core.msggen.ISubscriber;
import raf.dsw.classycraft.app.core.msggen.Message;
import raf.dsw.classycraft.app.core.msggen.MessageType;
import raf.dsw.classycraft.app.core.treemodel.nodes.projNodes.ProjectExplorer;
import raf.dsw.classycraft.app.gui.swing.main.pkgview.PackageViewPane;
import raf.dsw.classycraft.app.gui.swing.treeview.ClassyTreeImplementation;
import raf.dsw.classycraft.app.gui.swing.treeview.model.ClassyTreeItem;
import raf.dsw.classycraft.app.gui.swing.treeview.view.ClassyTreeView;

import javax.swing.*;
import javax.swing.tree.TreePath;
import java.awt.*;

public class MainFrame extends JFrame implements ISubscriber {
    private static MainFrame instance;
    ClassyTreeImplementation tree;

    public PackageViewPane getPkgpane() {
        return pkgpane;
    }

    PackageViewPane pkgpane;
    ActionManager actions;


    public void Test(){
        ClassyTreeItem parent=((ClassyTreeItem) tree.getTreeModel().getRoot());
        tree.AddChild(parent,null);
        parent= ((ClassyTreeItem) parent.getLastChild());
        tree.AddChild(parent,null);
        parent= ((ClassyTreeItem) parent.getLastChild());
        tree.AddChild(parent,"diagram");
        parent= ((ClassyTreeItem) parent.getLastChild());
        tree.getView().expandPath(new TreePath(parent.getPath()));
        tree.setSelectedItem(((ClassyTreeItem) parent.getParent()));
        pkgpane.validate();
    }

    public ClassyTreeImplementation getTree() {
        return tree;
    }

    public MainFrame() {
    }

    public static MainFrame getInstance() {
        if (instance == null) {
            instance = new MainFrame();
            instance.initialize();
        }
        return instance;
    }

    private void initialize() {
        actions=new ActionManager();
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        setSize(screenWidth / 2, screenHeight / 2);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("ClassyCrafT");
        Image img = kit.getImage("images/icon.png");
        setIconImage(img);
        MyMenyBar menuBar = new MyMenyBar();
        setJMenuBar(menuBar);
        MyToolBar toolBar = new MyToolBar();
        add(toolBar, BorderLayout.NORTH);
        ApplicationFramework.getInstance().getMsgGen().addSubscriber(this);

        ProjectExplorer pe= ApplicationFramework.getInstance().getTreeRepo().getRoot();
        ClassyTreeView tw=(tree = new ClassyTreeImplementation()).generateTree(pe);
        pkgpane=new PackageViewPane();
        JPanel jp=new JPanel(new FlowLayout(FlowLayout.LEFT));
        jp.add(tw);
        JSplitPane sp= new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,jp,pkgpane);
        sp.setDividerLocation(200);
        add(sp);
        Test();

        setVisible(true);
    }

    public ActionManager getActions() {
        return actions;
    }

    @Override
    public void react(Object notification) {
        Message msg = ((Message) notification);
        if(msg.getType()!= MessageType.LOG)

            JOptionPane.showMessageDialog(this, msg.getText(),msg.getType().name(), msg.getType().ordinal());

    }
}