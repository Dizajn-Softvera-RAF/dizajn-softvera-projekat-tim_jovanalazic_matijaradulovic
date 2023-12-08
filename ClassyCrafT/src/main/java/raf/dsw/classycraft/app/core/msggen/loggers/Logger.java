package raf.dsw.classycraft.app.core.msggen.loggers;

import raf.dsw.classycraft.app.core.msggen.ISubscriber;
import raf.dsw.classycraft.app.core.msggen.Message;

public interface Logger extends ISubscriber {
    void log(Message msg);
}
