package raf.dsw.classycraft.app.controller;

import raf.dsw.classycraft.app.core.ApplicationFramework;
import raf.dsw.classycraft.app.gui.swing.main.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class RemoveAction extends AbstractClassyAction{
    public RemoveAction() {
        Icon icon=this.loadIcon("/images/rem.png");
        putValue(SMALL_ICON, icon);
        putValue(NAME, "Remove");
        putValue(SHORT_DESCRIPTION, "Delete item");
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_DELETE  , InputEvent.ALT_MASK));

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(MainFrame.getInstance().getTree().getSelectedNode()==null){
            ApplicationFramework.getInstance().getMsgGen().generateInfoMessage("Izaberi stavku za brisanje.");
            return;
        }
        if(MainFrame.getInstance().getTree().isExpSel()){
            ApplicationFramework.getInstance().getMsgGen().generateErrorMessage("Brisanje korena nije dozvoljeno!");
            return;
        }
        MainFrame.getInstance().getTree().RemoveSel();
    }
}
