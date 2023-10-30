package raf.dsw.classycraft.app.errors.observer;

import java.time.LocalDateTime;

class ErrorMessage {
    ErrorType type;
    String text;
    LocalDateTime timestamp;

    public ErrorMessage(ErrorType type, String text, LocalDateTime timestamp) {
        this.type = type;
        this.text = text;
        this.timestamp = timestamp;
    }

    public ErrorMessage(ErrorType type, String text) {
        this.type = type;
        this.text = text;
        this.timestamp=LocalDateTime.now();
    }
}

enum ErrorType{
    INFO,
    WARNING,
    ERROR
}