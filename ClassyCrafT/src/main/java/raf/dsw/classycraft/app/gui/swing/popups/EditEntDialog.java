package raf.dsw.classycraft.app.gui.swing.popups;

import raf.dsw.classycraft.app.core.treemodel.nodes.diagramNodes.content.ClassContent;
import raf.dsw.classycraft.app.core.treemodel.nodes.diagramNodes.content.EnumItem;
import raf.dsw.classycraft.app.core.treemodel.nodes.diagramNodes.entities.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;

public class EditEntDialog extends JPanel {
    JComboBox<Visibility> cmb=new JComboBox<>(Visibility.values());
    Interclass entity;
    JLabel namel=new JLabel("Naziv:");
    JTextField nametf=new JTextField("naziv_klase");
    DefaultListModel<ClassContent> model = new DefaultListModel<ClassContent>();
    JList<ClassContent> items=new JList<>(model);
    JButton remb=new JButton("<html>ukloni<br>stavku</html>");
    JButton savb=new JButton("Sacuvaj");
    JButton canb=new JButton("Otkazi");
    JButton addb=new JButton("<html>dodaj<br>stavku</html>");
    JButton addmb =new JButton("<html>dodaj<br>metod</html>");
    JButton addab=new JButton("<html>dodaj<br>atribut</html>");

    protected JPanel butp=new JPanel();
    protected void AddItem(ClassContent c){
        model.addElement(c);
    }
    public static EditEntDialog getDialog(Interclass ent){
        var res=new EditEntDialog(ent);
        if(ent instanceof ClassyEnum){
            res.addb.setVisible(true);
        }
        else if(ent instanceof ClassyInterface){
            res.addmb.setVisible(true);
        }
        else{
            res.addmb.setVisible(true);
            res.addab.setVisible(true);
        }

        return res;
    }
    private EditEntDialog(Interclass ent){
        setPreferredSize(new Dimension(350,300));
        butp.setLayout(new BoxLayout(butp,BoxLayout.Y_AXIS));
        addb.setVisible(false);
        addab.setVisible(false);
        addmb.setVisible(false);
        cmb.setSelectedItem(Visibility.PUBLIC);
        cmb.setFocusable(false);
        nametf.requestFocusInWindow();
        //items.setPrototypeCellValue();
        setLayout(new BorderLayout());
        JPanel jp=new JPanel();

        addab.setAlignmentX(Component.CENTER_ALIGNMENT);
        addmb.setAlignmentX(Component.CENTER_ALIGNMENT);
        addb.setAlignmentX(Component.CENTER_ALIGNMENT);
        remb.setAlignmentX(Component.CENTER_ALIGNMENT);
        jp.add(cmb);
        jp.add(nametf);
        nametf.setPreferredSize(new Dimension(100,25));
        entity=ent;
        //items.setPreferredSize(new Dimension(250,200));
        items.setVisibleRowCount(-1);
        items.setLayoutOrientation(JList.VERTICAL);
        items.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane s = new JScrollPane();
        //s.setPreferredSize(new Dimension(260,210));
        s.setViewportView(items);
        butp.add(Box.createGlue());
        butp.add(addb);
        butp.add(Box.createVerticalStrut(5));
        butp.add(addmb);
        butp.add(Box.createVerticalStrut(5));
        butp.add(addab);
        butp.add(Box.createVerticalStrut(5));
        butp.add(remb);
        butp.add(Box.createGlue());


        add(jp,BorderLayout.NORTH);
        add(s,BorderLayout.CENTER);

        add(butp,BorderLayout.EAST);
        JPanel pn=new JPanel();
        pn.add(savb);
        pn.add(canb);
        add(pn,BorderLayout.SOUTH);
        initActions();
        if(ent.getElements()!=null)
            model.addAll(ent.getElements());
        if(ent.getName()!=null && !ent.getName().isEmpty())
            nametf.setText(ent.getName());
        else nametf.selectAll();

    }
    public void ShowDialog(JFrame parent){
         JDialog frame = new JDialog(parent, "Izmena entiteta", true);
         frame.setLocationRelativeTo(parent);
         frame.setSize(500,600);
        frame.getContentPane().add(this);
        frame.pack();
        frame.setVisible(true);

    }
    private void initActions(){
        nametf.addActionListener((ActionEvent e)->{((JTextField)e.getSource()).transferFocus();} );
        addab.addActionListener((ActionEvent e)->{
            AddAttributePanel p=new AddAttributePanel();
            if(JOptionPane.CLOSED_OPTION== JOptionPane.showOptionDialog(this,p,"Dodavanje atributa",JOptionPane.DEFAULT_OPTION,JOptionPane.PLAIN_MESSAGE,null,null,null))
                return;
                AddItem(p.getContent());
        });
        addmb.addActionListener((ActionEvent e)-> {
            AddMethodPanel p=new AddMethodPanel();
            if(JOptionPane.CLOSED_OPTION== JOptionPane.showOptionDialog(this,p,"Dodavanje metoda",JOptionPane.DEFAULT_OPTION,JOptionPane.PLAIN_MESSAGE,null,null,null))
                return;
            AddItem(p.getContent());
        });

        addb.addActionListener((ActionEvent e)-> {
                    String s = (String)JOptionPane.showInputDialog(
                            this,
                            "Unesi stavku:\n",
                            "Unos elemenata",
                            JOptionPane.PLAIN_MESSAGE,
                            null,
                            null,
                            null);
                    if(s!=null&&!s.isEmpty())
                        AddItem(new EnumItem(s));
                }
        );
        savb.addActionListener((ActionEvent e)-> {
                entity.setElements(Collections.list(model.elements()));
                entity.setName2(nametf.getText());

                    SwingUtilities.windowForComponent(this).dispose();

                }
        );
        canb.addActionListener((ActionEvent e)-> {
                setVisible(false);
                SwingUtilities.windowForComponent(this).dispose();
                }
        );
        remb.addActionListener((ActionEvent e)->{
                int ind=items.getSelectedIndex();
                if(ind!=-1)
                    model.remove(ind);
        });
    }

}
