package raf.dsw.classycraft.app.controller.events;

public class SelectionClassyEvent extends ClassyEvent {
    Object selectedEl;

    public Object getSelected() {
        return selectedEl;
    }

    public SelectionClassyEvent(Object source, Object selectedEl) {
        super(source);
        this.selectedEl = selectedEl;
    }
}
