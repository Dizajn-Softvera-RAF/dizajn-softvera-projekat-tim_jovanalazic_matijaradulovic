package raf.dsw.classycraft.app.core.msggen.loggers;

import raf.dsw.classycraft.app.core.ApplicationFramework;
import raf.dsw.classycraft.app.core.msggen.msg.Message;

import java.io.*;

public class FileLogger implements Logger{
    File logfile;

    public FileLogger() {
        ApplicationFramework.getInstance().getMsgGen().addSubscriber(this);

        logfile= new File(getClass().getResource("/logs/log.txt").getPath());
    }

    @Override
    public void react(Object notification) {
        log((Message) notification);
    }

    @Override
    public void log(Message msg) {
        try {
            FileWriter fw = new FileWriter(logfile, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(msg.toString());
            bw.newLine();
            bw.close();
        }
        catch (Exception e)
        {

        }

    }
}
