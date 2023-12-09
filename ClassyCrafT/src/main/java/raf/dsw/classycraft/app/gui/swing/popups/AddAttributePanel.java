package raf.dsw.classycraft.app.gui.swing.popups;

import raf.dsw.classycraft.app.core.treemodel.nodes.diagramNodes.content.Attribute;
import raf.dsw.classycraft.app.core.treemodel.nodes.diagramNodes.content.ClassContent;
import raf.dsw.classycraft.app.core.treemodel.nodes.diagramNodes.content.Method;
import raf.dsw.classycraft.app.core.treemodel.nodes.diagramNodes.entities.Visibility;

import javax.swing.*;

public class AddAttributePanel extends JPanel {
    JComboBox<Visibility> cmb=new JComboBox<>(Visibility.values());
    JTextField jt1=new JTextField("tip polja");
    JTextField jt2=new JTextField("naziv polja");

    public AddAttributePanel() {
        add(cmb);
        add(jt1);
        add(jt2);
    }
    public ClassContent getContent(){
        return new Attribute(jt2.getText(),(Visibility)  cmb.getSelectedItem(),jt1.getText());
    }

}
