package raf.dsw.classycraft.app.core.msggen.generator;

import raf.dsw.classycraft.app.core.msggen.msg.MessageType;

public interface IMessageGenerator {
    public void generateMessage(String text, MessageType type);
}
