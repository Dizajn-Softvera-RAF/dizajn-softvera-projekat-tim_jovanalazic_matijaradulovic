package raf.dsw.classycraft.app.gui.swing.view;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private static MainFrame instance;
    public MainFrame() {
        //initialize();
    }

    public static MainFrame getInstance() {
        if(instance==null){
            instance=new MainFrame();
            instance.initialize();
        }
        return instance;
    }

    private void initialize() {
        Toolkit kit= Toolkit.getDefaultToolkit();
        Dimension screenSize=kit.getScreenSize();
        int screenHeight=screenSize.height;
        int screenWidth=screenSize.width;
        setSize(screenWidth/2,screenHeight/2);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("ClasstCrafT");
        Image img = kit.getImage("images/ikona.png");
        setIconImage(img);
        MyMenyBar menuBar = new MyMenyBar();
        setJMenuBar(menuBar);
        MyToolBar toolBar= new MyToolBar();
        add(toolBar,BorderLayout.NORTH);
    }
}
