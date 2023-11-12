package raf.dsw.classycraft.app.gui.swing.main.pkgview;

import raf.dsw.classycraft.app.core.msggen.generator.ISubscriber;
import raf.dsw.classycraft.app.core.treemodel.nodes.Project;

import javax.swing.*;
import java.awt.*;

public class ProjInfoPane extends JPanel implements ISubscriber {

    JLabel authLabel;
    JLabel nameLabel;
    public ProjInfoPane() {

        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        this.setMaximumSize(new Dimension(2000,50));
        nameLabel=new JLabel();
        nameLabel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        authLabel=new JLabel();
        authLabel.setAlignmentX(JComponent.CENTER_ALIGNMENT);

        this.add(nameLabel);
        this.add(authLabel);

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
