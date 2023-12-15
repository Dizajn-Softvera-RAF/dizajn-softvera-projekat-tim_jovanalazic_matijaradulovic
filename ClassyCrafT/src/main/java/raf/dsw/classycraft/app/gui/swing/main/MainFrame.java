package raf.dsw.classycraft.app.gui.swing.main;

import raf.dsw.classycraft.app.controller.ActionManager;
import raf.dsw.classycraft.app.core.ApplicationFramework;
import raf.dsw.classycraft.app.core.msggen.ISubscriber;
import raf.dsw.classycraft.app.core.msggen.Message;
import raf.dsw.classycraft.app.core.msggen.MessageType;
import raf.dsw.classycraft.app.core.treemodel.nodes.diagramNodes.content.Attribute;
import raf.dsw.classycraft.app.core.treemodel.nodes.diagramNodes.content.EnumItem;
import raf.dsw.classycraft.app.core.treemodel.nodes.diagramNodes.content.Method;
import raf.dsw.classycraft.app.core.treemodel.nodes.diagramNodes.entities.ClassyClass;
import raf.dsw.classycraft.app.core.treemodel.nodes.diagramNodes.entities.ClassyEnum;
import raf.dsw.classycraft.app.core.treemodel.nodes.diagramNodes.entities.ClassyInterface;
import raf.dsw.classycraft.app.core.treemodel.nodes.diagramNodes.entities.Visibility;
import raf.dsw.classycraft.app.core.treemodel.nodes.projNodes.Diagram;
import raf.dsw.classycraft.app.core.treemodel.nodes.projNodes.ProjectExplorer;
import raf.dsw.classycraft.app.gui.swing.main.pkgview.PackageViewPane;
import raf.dsw.classycraft.app.gui.swing.treeview.ClassyTreeI;
import raf.dsw.classycraft.app.gui.swing.treeview.model.ClassyTreeItem;
import raf.dsw.classycraft.app.gui.swing.treeview.view.ClassyTreeView;

import javax.swing.*;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Arrays;

public class MainFrame extends JFrame implements ISubscriber {
    private static MainFrame instance;
    ClassyTreeI tree;


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
        tree.setOpenedItem(((ClassyTreeItem) parent.getParent()));

        Diagram d= ((Diagram) parent.getNode());
        var c=new ClassyClass("Klasa1",Visibility.PUBLIC,new Point(130,70),new Dimension(),d);
        var a1=new Attribute("polje1", Visibility.PROTECTED,"String");
        var a2=new Attribute("polje2", Visibility.PRIVATE,"int");
        var a3=new Attribute("polje3", Visibility.PRIVATE,"double");
        var m1=new Method("Metod1",Visibility.PUBLIC,"void",new String[0]);
        var m2=new Method("Metod2",Visibility.PUBLIC,"Object[]", new String[]{"Object","int"});
        var m3=new Method("Metod3",Visibility.PRIVATE,"String",new String[]{"Point","float","float"});
        var e1=new EnumItem("stavka1");
        var e2=new EnumItem("stavka2");
        var e3=new EnumItem("stavka3");
        var e4=new EnumItem("stavka4");

        c.setElements(Arrays.asList(m1,m2,a1,a2,a3));
        var e=new ClassyEnum("Enum1",Visibility.PUBLIC,new Point(150,220),new Dimension(),d);
        e.setElements(Arrays.asList(e1,e2,e3,e4));
        var i=new ClassyInterface("Interfejs1",Visibility.PUBLIC,new Point(380,160),new Dimension(),d);
        i.setElements(Arrays.asList(m1,m2,m3));
        d.AddChild(c);
        d.AddChild(e);
        d.AddChild(i);
        
        tree.setOpenedItem(((ClassyTreeItem) parent.getParent()));

    }

    public ClassyTreeI getTree() {
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
        setSize(screenWidth / 2, (int)(screenHeight / 1.7));
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
        ClassyTreeView tw=(tree = new ClassyTreeI()).generateTree(pe);
        pkgpane=new PackageViewPane();
        JPanel jp=new JPanel(new FlowLayout(FlowLayout.LEFT));
        jp.add(tw);
        JSplitPane sp= new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,jp,pkgpane);
        sp.setDividerLocation(180);
        add(sp);
        revalidate();

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                Test();
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        pkgpane.getActiveDiagramP().repaint();
                    }
                });
            }
        });
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