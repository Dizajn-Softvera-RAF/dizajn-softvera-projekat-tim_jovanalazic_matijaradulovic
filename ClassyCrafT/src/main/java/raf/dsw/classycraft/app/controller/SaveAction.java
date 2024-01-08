package raf.dsw.classycraft.app.controller;

import com.sun.tools.javac.Main;
import raf.dsw.classycraft.app.core.ApplicationFramework;
import raf.dsw.classycraft.app.core.serializer.JacksonUtil;
import raf.dsw.classycraft.app.core.treemodel.nodes.projNodes.Diagram;
import raf.dsw.classycraft.app.core.treemodel.nodes.projNodes.Project;
import raf.dsw.classycraft.app.gui.swing.main.MainFrame;
import raf.dsw.classycraft.app.gui.swing.treeview.model.ClassyTreeItem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

public class SaveAction extends AbstractClassyAction{
    public SaveAction() {
        Icon icon=this.loadIcon("/images/sav.png");
        putValue(SMALL_ICON, icon);
        putValue(NAME, "Save project");
        putValue(SHORT_DESCRIPTION, "Save");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        ClassyTreeItem selitem= MainFrame.getInstance().getTree().getSelectedNode();
        if(selitem.getNode() instanceof Project p){
            //if(p.SavedIs();) return;
            File fil=null;
            if(p.PathGet()!=null){
                fil=new File(p.PathGet());
            }
            else{
                JFileChooser fileChooser = new JFileChooser();
                if (fileChooser.showSaveDialog(MainFrame.getInstance()) == JFileChooser.APPROVE_OPTION) {
                    fil = fileChooser.getSelectedFile();
                }
            }
            if(fil==null)return;
            try {
                JacksonUtil.saveProject(fil,p);
                p.Saved();
            } catch (IOException ex) {
                ApplicationFramework.getInstance().getMsgGen().generateErrorMessage("Greška prilikom čuvanja!");
                System.err.println(ex.toString());
            }


        }
        else {
            ApplicationFramework.getInstance().getMsgGen().generateErrorMessage("Greška prilikom čuvanja stavke!");
        }
    }
}
