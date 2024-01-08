package raf.dsw.classycraft.app.controller;

import raf.dsw.classycraft.app.core.ApplicationFramework;
import raf.dsw.classycraft.app.core.serializer.JacksonUtil;
import raf.dsw.classycraft.app.core.treemodel.nodes.projNodes.Diagram;
import raf.dsw.classycraft.app.core.treemodel.nodes.projNodes.Project;
import raf.dsw.classycraft.app.gui.swing.main.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

public class OpenDiagram extends AbstractClassyAction{

    public OpenDiagram() {
        Icon icon=this.loadIcon("/images/oped.png");
        putValue(SMALL_ICON, icon);
        putValue(NAME, "Load template");
        putValue(SHORT_DESCRIPTION, "Load template");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(! (MainFrame.getInstance().getTree().getSelectedNode().getNode() instanceof Diagram ))
        {
            ApplicationFramework.getInstance().getMsgGen().generateErrorMessage("Šablon se dodaje u postojeći dijagram!");
        }


        JFileChooser fc=new JFileChooser();
//        URL resource = getClass().getResource("/Templates/");
//        File file;
//        try {
//            file = Paths.get(resource.toURI()).toFile();
//        } catch (URISyntaxException ex) {
//            throw new RuntimeException(ex);
//        }
        File file=new File(".");
        fc.setCurrentDirectory(file);
        int result=fc.showOpenDialog(MainFrame.getInstance());
        if(result==JFileChooser.APPROVE_OPTION){
            File selfile = fc.getSelectedFile();
            try {
                Diagram d= JacksonUtil.loadDiagram(selfile);
                MainFrame.getInstance().getTree().loadDiagram(d);
            } catch (IOException ex) {
                ApplicationFramework.getInstance().getMsgGen().generateErrorMessage("Greška prilikom učitavanja fajla!");
                System.err.println(ex.toString());
            }
        }
    }

}
