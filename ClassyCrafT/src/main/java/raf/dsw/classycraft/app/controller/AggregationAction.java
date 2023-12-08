package raf.dsw.classycraft.app.controller;

import com.sun.tools.javac.Main;
import raf.dsw.classycraft.app.gui.swing.main.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class AggregationAction extends AbstractClassyAction{
    public AggregationAction() {
        Icon icon=this.loadIcon("/images/agg.png");
        putValue(SMALL_ICON, icon);
        putValue(NAME, "Add aggregation relation");
        putValue(SHORT_DESCRIPTION, "Aggregation");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getPkgpane().StartAggregationState();
    }
}
