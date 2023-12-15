package raf.dsw.classycraft.app.controller.events;

import java.awt.*;

public class PaintClassyEvent extends ClassyEvent{
    Rectangle area;

    public PaintClassyEvent(Object source) {
        super(source);
        area=null;
    }
    public PaintClassyEvent(Object source, Rectangle area) {
        this.area = area;
    }
    public boolean redraw(){
        return area==null;
    }
    public Rectangle getArea(){
        return  area;
    }
}
