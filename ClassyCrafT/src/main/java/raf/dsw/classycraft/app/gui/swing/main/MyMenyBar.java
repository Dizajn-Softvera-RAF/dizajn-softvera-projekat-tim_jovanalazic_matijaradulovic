package raf.dsw.classycraft.app.gui.swing.main;

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
        editMenu.add(new RenameAction());
        editMenu.add(new RemoveAction());
        add(editMenu);

        JMenu addMenu=new JMenu("Add");
        addMenu.setMnemonic(KeyEvent.VK_A);
        addMenu.add(new AddDirectoryAction());
        addMenu.add(new AddDiagramAction());
        add(addMenu);

        JMenu infoMenu=new JMenu("Info");
        infoMenu.setMnemonic(KeyEvent.VK_I);
        AboutUsAction aua = new AboutUsAction();
        infoMenu.add(aua);
        add(infoMenu);

    }
}
