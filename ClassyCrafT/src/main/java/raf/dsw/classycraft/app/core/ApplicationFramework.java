package raf.dsw.classycraft.app.core;


import raf.dsw.classycraft.app.core.msggen.generator.MessageGeneratorImplementation;
import raf.dsw.classycraft.app.core.msggen.loggers.Logger;
import raf.dsw.classycraft.app.core.msggen.loggers.LoggerFactory;
import raf.dsw.classycraft.app.core.treemodel.ClassyRepositoryImplementation;
import raf.dsw.classycraft.app.core.treemodel.nodes.ProjectExplorer;

public class ApplicationFramework {
    ClassyRepositoryImplementation treeRepo;
    Logger clog;
    Logger flog;
    MessageGeneratorImplementation msgGen;

    public MessageGeneratorImplementation getMsgGen() {
        return msgGen;
    }

    public ClassyRepositoryImplementation getTreeRepo() {
        return treeRepo;
    }

    private static ApplicationFramework instance;
    private ApplicationFramework(){
    }
    private void initialize(){
        msgGen=new MessageGeneratorImplementation();
        LoggerFactory logFact=new LoggerFactory();
        clog=logFact.getLogger("console");
        flog=logFact.getLogger("file");
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
