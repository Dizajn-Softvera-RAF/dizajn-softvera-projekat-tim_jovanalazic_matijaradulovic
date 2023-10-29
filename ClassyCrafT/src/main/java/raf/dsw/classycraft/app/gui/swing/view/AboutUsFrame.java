package raf.dsw.classycraft.app.gui.swing.view;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class AboutUsFrame extends JFrame {
    public  AboutUsFrame(){
        Toolkit kit= Toolkit.getDefaultToolkit();
        Dimension screenSize=kit.getScreenSize();
        int screenHeight=screenSize.height;
        int screenWidth=screenSize.width;
        setSize(screenWidth/4,screenHeight/4);
        setLocationRelativeTo(MainFrame.getInstance());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("About us");
        Image img = kit.getImage("images/aboutus.png");
        setIconImage(img);
        Author aut1=new Author("Matija Radulović","/images/matija.jpg");
        Author aut2=new Author("Jovana Lazić","/images/jovana.jpg");
        JPanel jp= new JPanel();
        jp.setLayout(new BoxLayout(jp,BoxLayout.X_AXIS));
        jp.add(Box.createGlue());
        jp.add(aut1);
        jp.add(Box.createHorizontalStrut(50));
        jp.add(aut2);
        jp.add(Box.createGlue());
        add(jp);
    }
    private class Author extends JPanel{
        public Author(String name, String imgPath){
            super();
            JLabel namelb= new JLabel(name);
            namelb.setAlignmentX(JComponent.CENTER_ALIGNMENT);
            ImageIcon imgicon=null;
            JLabel imgiconlb;
            URL imageUrl=getClass().getResource(imgPath);
            if(imageUrl!=null){
                imgicon = new ImageIcon(imageUrl);
            }
            imgiconlb= new JLabel(imgicon);
            imgiconlb.setAlignmentX(JComponent.CENTER_ALIGNMENT);
            setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
            add(imgiconlb);
            add(namelb);
        }
    }
}
