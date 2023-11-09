package raf.dsw.classycraft.app.core.msggen.generator;

import raf.dsw.classycraft.app.core.msggen.msg.MessageType;

public interface MessageGenerator {
    public void generateMessage(String text, MessageType type);
    public void generateErrorMessage(String text);
    public void generateWarningMessage(String text);
    public void generateInfoMessage(String text);
    public void generateLogMessage(String text);

}
