package raf.dsw.classycraft.app.controller;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class AddAggregationAction extends AbstractClassyAction{
    public AddAggregationAction() {
        Icon icon=this.loadIcon("/images/agg.png");
        putValue(SMALL_ICON, icon);
        putValue(NAME, "Add aggregation relation");
        putValue(SHORT_DESCRIPTION, "Aggregation");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
