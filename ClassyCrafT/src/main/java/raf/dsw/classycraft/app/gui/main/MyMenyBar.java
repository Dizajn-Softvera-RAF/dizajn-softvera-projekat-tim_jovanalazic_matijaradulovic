package raf.dsw.classycraft.app.gui.main;

import raf.dsw.classycraft.app.controller.*;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class MyMenyBar extends JMenuBar {

    public MyMenyBar() {
        JMenu fileMenu=new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);
        ExitAction ea =new ExitAction();
        fileMenu.add(ea);
        add(fileMenu);

        JMenu editMenu=new JMenu("Edit");
        editMenu.setMnemonic(KeyEvent.VK_E);
        AboutUsAction aua = new AboutUsAction();
        editMenu.add(aua);
        add(editMenu);

        JMenu addMenu=new JMenu("Add");
        addMenu.setMnemonic(KeyEvent.VK_A);
        addMenu.add(new AddDirectoryAction());
        addMenu.add(new AddDiagramAction());

        add(addMenu);
    }
}
