package raf.dsw.classycraft.app.controller;

import com.sun.tools.javac.Main;
import raf.dsw.classycraft.app.gui.swing.main.MainFrame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;

public class ExportAction extends AbstractClassyAction{
    public ExportAction() {
        Icon icon=this.loadIcon("/images/exp.png");
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.ALT_MASK));
        putValue(SMALL_ICON, icon);
        putValue(NAME, "Export image");
        putValue(SHORT_DESCRIPTION, "Export image");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        BufferedImage bufferedImage = new BufferedImage(800, 800, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = bufferedImage.createGraphics();
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, 800, 800);
        MainFrame.getInstance().getPkgpane().getActiveDiagramP().PAINT(g2d);
        RenderedImage rendImage = bufferedImage;
        g2d.dispose();
        JFileChooser fileChooser = new JFileChooser();
        File fil=null;
        if (fileChooser.showSaveDialog(MainFrame.getInstance()) == JFileChooser.APPROVE_OPTION) {
            fil = fileChooser.getSelectedFile();
        }
        try {
            ImageIO.write(rendImage, "png", fil);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }


    }
}
