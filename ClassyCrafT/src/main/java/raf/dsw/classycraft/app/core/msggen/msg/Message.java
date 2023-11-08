
package raf.dsw.classycraft.app.core.msggen.msg;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

public class Message {
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

    public Message( String text, MessageType type, LocalDateTime timestamp) {
        this.type = type;
        this.text = text;
        this.timestamp = timestamp;
    }

    public Message( String text,MessageType type) {
        this.type = type;
        this.text = text;
        this.timestamp=LocalDateTime.now();
    }

    @Override
    public String toString() {
        return String.format("[%s][%s] %s",type.name(),timestamp.format(DateTimeFormatter.ofPattern("dd.MM.YYYY HH:mm")),text);
    }
}

