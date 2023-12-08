package raf.dsw.classycraft.app.core.msggen.generator;

import raf.dsw.classycraft.app.core.msggen.MessageType;

public interface MessageGenerator {
     void generateMessage(String text, MessageType type);
     void generateErrorMessage(String text);
     void generateWarningMessage(String text);
     void generateInfoMessage(String text);
     void generateLogMessage(String text);

}
