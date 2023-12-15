package raf.dsw.classycraft.app.controller.events;

public class ClassyEvent {
    Object source;

    public ClassyEvent(Object source) {
        this.source = source;
    }

    public ClassyEvent() {
    }

    public Object getSource() {
        return source;
    }
}
