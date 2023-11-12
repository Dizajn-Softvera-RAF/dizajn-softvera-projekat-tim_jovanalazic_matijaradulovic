package raf.dsw.classycraft.app.core.msggen.loggers;

import raf.dsw.classycraft.app.core.ApplicationFramework;
import raf.dsw.classycraft.app.core.msggen.msg.Message;
import raf.dsw.classycraft.app.core.msggen.msg.MessageType;

public class ConsoleLogger implements Logger{
    @Override
    public void react(Object notification) {
        log((Message) notification);
    }

    public ConsoleLogger() {
        ApplicationFramework.getInstance().getMsgGen().addSubscriber(this);
    }

    @Override
    public void log(Message msg) {
        System.out.println(msg);
    }
    public void log(String text) {
        log(new Message(text,MessageType.INFO));
    }
}
