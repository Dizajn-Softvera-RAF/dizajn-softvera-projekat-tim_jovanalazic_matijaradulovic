package raf.dsw.classycraft.app.controller;

import raf.dsw.classycraft.app.core.ApplicationFramework;
import raf.dsw.classycraft.app.gui.swing.main.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class RenameAction extends AbstractClassyAction {
    Icon icon;
    @Override
    public void actionPerformed(ActionEvent e) {
        if(MainFrame.getInstance().getTree().getSelectedNode()==null){
            ApplicationFramework.getInstance().getMsgGen().generateInfoMessage("Izaberi stavku za preimenovanje.");
            return;
        }
        if(MainFrame.getInstance().getTree().isExpSel()){
            ApplicationFramework.getInstance().getMsgGen().generateErrorMessage("Izmena korena nije moguca!");
            return;
        }
        String s = (String)JOptionPane.showInputDialog(
                MainFrame.getInstance(),
                "Unesi novo ime:\n",
                "Unos imena",
                JOptionPane.PLAIN_MESSAGE,
                icon,
                null,
                null);
        if(s==null||s.isEmpty()) return;
        if(!MainFrame.getInstance().getTree().RenameSel(s))
            ApplicationFramework.getInstance().getMsgGen().generateErrorMessage("Neispravno ime");

    }
    public RenameAction() {
        icon=this.loadIcon("/images/renam.png");
        putValue(SMALL_ICON, icon);
        putValue(NAME, "Change name");
        putValue(SHORT_DESCRIPTION, "Change name");
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_F2  , InputEvent.ALT_MASK));

    }
}
