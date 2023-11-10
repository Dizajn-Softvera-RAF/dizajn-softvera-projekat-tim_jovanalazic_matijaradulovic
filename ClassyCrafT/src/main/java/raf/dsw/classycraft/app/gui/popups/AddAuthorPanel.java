package raf.dsw.classycraft.app.gui.popups;

import javax.swing.*;
import java.awt.*;

public class AddAuthorPanel extends JPanel {
    public AddAuthorPanel() {
        JLabel jl1=new JLabel("Naziv projekta:");
        JTextField projtf=new JTextField("novo ime projekta");
        JLabel jl2=new JLabel("Ime autora:");
        JTextField authtf=new JTextField("novo ime autora");
        add(jl1);
        add(projtf);
        add(jl2);
        add(authtf);
    }

}
