package raf.dsw.classycraft.app.core.msggen.loggers;

public class LoggerFactory {

    public Logger getLogger(String type){
        if(type.equals("console"))
            return new ConsoleLogger();
        else if(type.equals("file"))
            return new FileLogger();
        return null;
    }
}
