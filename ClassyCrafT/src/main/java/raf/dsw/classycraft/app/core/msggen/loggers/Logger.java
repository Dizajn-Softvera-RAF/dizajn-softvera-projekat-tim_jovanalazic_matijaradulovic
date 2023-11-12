package raf.dsw.classycraft.app.core.msggen.loggers;

import raf.dsw.classycraft.app.core.msggen.generator.ISubscriber;
import raf.dsw.classycraft.app.core.msggen.msg.Message;

public interface Logger extends ISubscriber {
    void log(Message msg);
}
