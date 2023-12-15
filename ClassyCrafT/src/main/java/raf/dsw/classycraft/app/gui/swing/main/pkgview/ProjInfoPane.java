package raf.dsw.classycraft.app.gui.swing.main.pkgview;

import raf.dsw.classycraft.app.controller.events.NodeChangedClassyEvent;
import raf.dsw.classycraft.app.core.msggen.ISubscriber;
import raf.dsw.classycraft.app.core.treemodel.nodes.projNodes.Project;

import javax.swing.*;
import java.awt.*;

public class ProjInfoPane extends JPanel implements ISubscriber {

    JLabel authLabel;
    JLabel nameLabel;
    Project proj;
    public ProjInfoPane() {

        this.setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
        this.setMaximumSize(new Dimension(2000,50));
        nameLabel=new JLabel();
        nameLabel.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        authLabel=new JLabel();
        authLabel.setAlignmentX(JComponent.LEFT_ALIGNMENT);

        this.add(Box.createGlue());
        this.add(nameLabel);
        this.add(Box.createHorizontalStrut(10));
        this.add(authLabel);
        this.add(Box.createGlue());

    }
    public ProjInfoPane(Project p){
        this();
        Initialize(p);
    }

    @Override
    public void react(Object notification) {  //proj after name or author change
        if(notification instanceof NodeChangedClassyEvent src){
            updateText(((Project) src.getNode()));
        }
    }
    public void updateText(Project p){
        if(p ==null)return;
        nameLabel.setText("Naziv projekta: "+ p.getName());
        authLabel.setText("Ime autora: "+ p.getAuthor());
    }

    public void Initialize(Project p){

        Clean();
        if(p!=null){
            updateText(p);
            p.addSubscriber(this);
            this.proj=p;
        }



    }
    public void Clean(){
        nameLabel.setText("");
        authLabel.setText("");
        if(proj!=null)
            proj.removeSubscriber(this);
    }
}
