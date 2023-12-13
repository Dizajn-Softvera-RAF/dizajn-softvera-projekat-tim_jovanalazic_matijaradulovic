package raf.dsw.classycraft.app.gui.swing.popups;

import raf.dsw.classycraft.app.core.treemodel.nodes.diagramNodes.content.ClassContent;
import raf.dsw.classycraft.app.core.treemodel.nodes.diagramNodes.content.Method;
import raf.dsw.classycraft.app.core.treemodel.nodes.diagramNodes.entities.Visibility;

import javax.swing.*;
import java.awt.*;

public class AddMethodPanel extends JPanel {
    JComboBox<Visibility> cmb=new JComboBox<>(Visibility.values());
    JTextField jt1=new JTextField("povratni_tip");
    JTextField jt2=new JTextField("naziv_metode");
    JTextField jt3=new JTextField("tip_arg1, tip2...");

    public AddMethodPanel() {
        this.setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
        add(cmb);
        add(jt1);
        //add(Box.createHorizontalStrut(3));
        add(jt2);
        //add(new JLabel("("));
        add(jt3);
        //add(new JLabel(")"));

    }
    public ClassContent getContent(){
        return new Method(jt2.getText(),(Visibility) cmb.getSelectedItem(),jt1.getText(),jt3.getText().split(","));
    }
}
