package raf.dsw.classycraft.app.core.msggen.generator;

import raf.dsw.classycraft.app.core.msggen.msg.Message;
import raf.dsw.classycraft.app.core.msggen.msg.MessageType;

import java.util.ArrayList;
import java.util.List;

public class MessageGenerator implements IPublisher, IMessageGenerator{
    List<ISubscriber> subscribers;

    public MessageGenerator() {
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
}
