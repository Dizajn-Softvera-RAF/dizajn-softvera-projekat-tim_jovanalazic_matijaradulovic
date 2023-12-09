package raf.dsw.classycraft.app.gui.swing.main.pkgview;

import raf.dsw.classycraft.app.core.msggen.ISubscriber;
import raf.dsw.classycraft.app.core.treemodel.nodes.projNodes.Project;

import javax.swing.*;
import java.awt.*;

public class ProjInfoPane extends JPanel implements ISubscriber {

    JLabel authLabel;
    JLabel nameLabel;
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
        if(p!=null){
            updateText(p);
            p.addSubscriber(this);
        }
    }

    @Override
    public void react(Object notification) {
        updateText(((Project) notification));
    }
    public void updateText(Project p){
        if(p ==null)return;
        nameLabel.setText("Naziv projekta: "+ p.getName());
        authLabel.setText("Ime autora: "+ p.getAuthor());
    }
}
