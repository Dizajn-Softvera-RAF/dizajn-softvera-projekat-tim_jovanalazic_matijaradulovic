package raf.dsw.classycraft.app.core;


import raf.dsw.classycraft.app.core.msggen.generator.MessageGenerator;
import raf.dsw.classycraft.app.core.msggen.loggers.ConsoleLogger;
import raf.dsw.classycraft.app.core.msggen.loggers.FileLogger;
import raf.dsw.classycraft.app.core.msggen.loggers.Logger;
import raf.dsw.classycraft.app.core.msggen.loggers.LoggerFactory;
import raf.dsw.classycraft.app.core.treerepo.implementation.ClassyRepository;
import raf.dsw.classycraft.app.core.treerepo.implementation.ProjectExplorer;

public class ApplicationFramework {
    Logger clog;
    Logger flog;
    MessageGenerator msgGen;

    public MessageGenerator getMsgGen() {
        return msgGen;
    }

    ClassyRepository treeRepo;

    private static ApplicationFramework instance;
    private ApplicationFramework(){
        //initialize();
    }
    private void initialize(){
        msgGen=new MessageGenerator();
        LoggerFactory logFact=new LoggerFactory();
        clog=logFact.getLogger("console");
        flog=logFact.getLogger("file");
        treeRepo=new ClassyRepository(new ProjectExplorer("Tree"));
    }
    public static ApplicationFramework getInstance(){
        if(instance==null){
            instance=new ApplicationFramework();
            instance.initialize();
        }
        return instance;
    }
}
