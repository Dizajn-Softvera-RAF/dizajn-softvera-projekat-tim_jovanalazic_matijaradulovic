package raf.dsw.classycraft.app.controller;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public abstract class AbstractClassyAction extends AbstractAction {
    public Icon loadIcon(String path){
        Icon icon=null;
        URL imageUrl=getClass().getResource(path);
        if(imageUrl!=null){
            Image img = new ImageIcon(imageUrl).getImage();
            Image newImg = img.getScaledInstance(30,30,Image.SCALE_DEFAULT);
            icon=new ImageIcon(newImg);
        }
        else{
            System.err.println("File not found");
        }
        return icon;
    }

}
