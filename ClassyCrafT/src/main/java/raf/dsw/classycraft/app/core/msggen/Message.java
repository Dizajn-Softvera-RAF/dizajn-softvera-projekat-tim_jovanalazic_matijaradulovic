
package raf.dsw.classycraft.app.core.msggen;

import raf.dsw.classycraft.app.controller.events.ClassyEvent;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Message extends ClassyEvent {

    public MessageType getType() {
        return type;
    }

    public String getText() {
        return text;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    MessageType type;
    String text;
    LocalDateTime timestamp;

    public Message(Object source,String text, MessageType type, LocalDateTime timestamp) {
        super(source);
        this.type = type;
        this.text = text;
        this.timestamp = timestamp;
    }

    public Message(String text,MessageType type) {
        this(null,text,type,LocalDateTime.now());
    }


    @Override
    public String toString() {
        return String.format("[%s][%s] %s",type.name(),timestamp.format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm")),text);
    }
}

