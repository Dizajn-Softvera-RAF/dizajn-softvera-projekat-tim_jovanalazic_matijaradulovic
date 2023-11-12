package raf.dsw.classycraft.app.core.msggen.generator;

import raf.dsw.classycraft.app.core.msggen.msg.Message;
import raf.dsw.classycraft.app.core.msggen.msg.MessageType;

import java.util.ArrayList;
import java.util.List;

public class MessageGeneratorImplementation implements IPublisher, MessageGenerator {
    List<ISubscriber> subscribers;

    public MessageGeneratorImplementation() {
        this.subscribers = new ArrayList<>();
    }

    @Override
    public void addSubscriber(ISubscriber subscr) {
        subscribers.add(subscr);
    }
    @Override
    public void removeSubscriber(ISubscriber subscr) {
        subscribers.remove(subscr);
    }
    @Override
    public void notifySubscribers(Object notification) {
        for (ISubscriber sub:subscribers) {
            sub.react(notification);
        }
    }

    @Override
    public void generateMessage(String text, MessageType type) {
        notifySubscribers(new Message(text,type));
    }

    @Override
    public void generateErrorMessage(String text) {
        generateMessage(text, MessageType.ERROR);
    }

    @Override
    public void generateWarningMessage(String text) {
        generateMessage(text, MessageType.WARNING);
    }

    @Override
    public void generateInfoMessage(String text) {
        generateMessage(text, MessageType.INFO);
    }

    @Override
    public void generateLogMessage(String text) {
        generateMessage(text, MessageType.LOG);
    }
}
