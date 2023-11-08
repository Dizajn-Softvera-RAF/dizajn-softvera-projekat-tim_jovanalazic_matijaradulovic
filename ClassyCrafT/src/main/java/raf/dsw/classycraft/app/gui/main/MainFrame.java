package raf.dsw.classycraft.app.gui.main;

import javafx.scene.control.SplitPane;
import raf.dsw.classycraft.app.core.ApplicationFramework;
import raf.dsw.classycraft.app.core.msggen.generator.ISubscriber;
import raf.dsw.classycraft.app.core.msggen.msg.Message;
import raf.dsw.classycraft.app.core.treerepo.implementation.ClassyRepository;
import raf.dsw.classycraft.app.core.treerepo.implementation.ProjectExplorer;
import raf.dsw.classycraft.app.gui.tree.ClassyTree;
import raf.dsw.classycraft.app.gui.tree.view.ClassyTreeView;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame implements ISubscriber {
    private static MainFrame instance;

    public MainFrame() {
        //initialize();
    }

    public static MainFrame getInstance() {
        if (instance == null) {
            instance = new MainFrame();
            instance.initialize();
        }
        return instance;
    }

    private void initialize() {
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
        ClassyTreeView tw=new ClassyTree().generateTree(pe); //...
        JTabbedPane tp=new JTabbedPane();
        tp.add("dij1",new DiagramViewPane());
        tw.setMinimumSize(new Dimension(150,100));
        JPanel jp=new JPanel(new FlowLayout(FlowLayout.LEFT));
        jp.add(tw);
        JSplitPane sp= new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,jp,tp);

        add(sp);
    }

    @Override
    public void react(Object notification) {
        Message msg = ((Message) notification);
        JOptionPane.showMessageDialog(this, msg.getText(),msg.getType().name(), msg.getType().ordinal());

    }
}