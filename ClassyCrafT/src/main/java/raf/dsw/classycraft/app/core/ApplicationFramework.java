package raf.dsw.classycraft.app.core;


public class ApplicationFramework {
    private static ApplicationFramework instance;
    private ApplicationFramework(){
        //initialize();
    }
    private void initialize(){}
    public static ApplicationFramework getInstance(){
        if(instance==null){
            instance=new ApplicationFramework();
            //initialize();
        }
        return instance;
    }
}
