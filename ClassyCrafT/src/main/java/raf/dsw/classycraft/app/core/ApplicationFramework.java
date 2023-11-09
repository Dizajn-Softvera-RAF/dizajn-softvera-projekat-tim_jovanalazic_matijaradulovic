package raf.dsw.classycraft.app.core;


import raf.dsw.classycraft.app.core.msggen.generator.MessageGeneratorImplementation;
import raf.dsw.classycraft.app.core.msggen.loggers.ConsoleLogger;
import raf.dsw.classycraft.app.core.msggen.loggers.FileLogger;
import raf.dsw.classycraft.app.core.msggen.loggers.Logger;
import raf.dsw.classycraft.app.core.msggen.loggers.LoggerFactory;
import raf.dsw.classycraft.app.core.treemodel.implementation.ClassyRepositoryImplementation;
import raf.dsw.classycraft.app.core.treemodel.implementation.ProjectExplorer;

public class ApplicationFramework {
    public ConsoleLogger getClog() {
        return (ConsoleLogger) clog;
    }

    Logger clog;
    Logger flog;
    MessageGeneratorImplementation msgGen;

    public MessageGeneratorImplementation getMsgGen() {
        return msgGen;
    }

    ClassyRepositoryImplementation treeRepo;

    public ClassyRepositoryImplementation getTreeRepo() {
        return treeRepo;
    }

    private static ApplicationFramework instance;
    private ApplicationFramework(){
        //initialize();
    }
    private void initialize(){
        msgGen=new MessageGeneratorImplementation();
        LoggerFactory logFact=new LoggerFactory();
        clog=(ConsoleLogger) logFact.getLogger("console");
        flog=(FileLogger) logFact.getLogger("file");
        treeRepo=new ClassyRepositoryImplementation(new ProjectExplorer("Explorer"));
    }
    public static ApplicationFramework getInstance(){
        if(instance==null){
            instance=new ApplicationFramework();
            instance.initialize();
        }
        return instance;
    }
}
