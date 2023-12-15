package raf.dsw.classycraft.app.core;


import raf.dsw.classycraft.app.core.msggen.generator.MessageGenerator;
import raf.dsw.classycraft.app.core.msggen.loggers.Logger;
import raf.dsw.classycraft.app.core.msggen.loggers.LoggerFactory;
import raf.dsw.classycraft.app.core.treemodel.ClassyRepositoryI;
import raf.dsw.classycraft.app.core.treemodel.nodes.projNodes.ProjectExplorer;

public class ApplicationFramework {
    ClassyRepositoryI treeRepo;
    Logger clog;
    Logger flog;
    MessageGenerator msgGen;

    public MessageGenerator getMsgGen() {
        return msgGen;
    }

    public ClassyRepositoryI getTreeRepo() {
        return treeRepo;
    }

    private static ApplicationFramework instance;
    private ApplicationFramework(){
    }
    private void initialize(){
        msgGen=new MessageGenerator();
        LoggerFactory logFact=new LoggerFactory();
        clog=logFact.getLogger("console");
        flog=logFact.getLogger("file");
        treeRepo=new ClassyRepositoryI(new ProjectExplorer("Explorer"));
    }
    public static ApplicationFramework getInstance(){
        if(instance==null){
            instance=new ApplicationFramework();
            instance.initialize();
        }
        return instance;
    }
}
