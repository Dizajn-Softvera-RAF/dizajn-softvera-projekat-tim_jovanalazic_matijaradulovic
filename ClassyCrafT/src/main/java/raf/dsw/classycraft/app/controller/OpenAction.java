package raf.dsw.classycraft.app.controller;

import raf.dsw.classycraft.app.core.ApplicationFramework;
import raf.dsw.classycraft.app.core.serializer.JacksonUtil;
import raf.dsw.classycraft.app.core.treemodel.nodes.projNodes.Project;
import raf.dsw.classycraft.app.gui.swing.main.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

public class OpenAction extends AbstractClassyAction {
    public OpenAction() {
        Icon icon=this.loadIcon("/images/ope.png");
        putValue(SMALL_ICON, icon);
        putValue(NAME, "Load project");
        putValue(SHORT_DESCRIPTION, "Load");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser fc=new JFileChooser();
        int result=fc.showOpenDialog(MainFrame.getInstance());
        if(result==JFileChooser.APPROVE_OPTION){
            File selfile = fc.getSelectedFile();
            try {
                Project p=JacksonUtil.loadProject(selfile);
                MainFrame.getInstance().getTree().loadProj(p);
            } catch (IOException ex) {
                ApplicationFramework.getInstance().getMsgGen().generateErrorMessage("Greška prilikom učitavanja fajla!");
                System.err.println(ex.toString());
            }
        }
    }
}
