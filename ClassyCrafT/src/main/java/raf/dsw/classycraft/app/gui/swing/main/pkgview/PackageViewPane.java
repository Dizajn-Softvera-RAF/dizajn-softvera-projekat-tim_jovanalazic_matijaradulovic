package raf.dsw.classycraft.app.gui.swing.main.pkgview;

import raf.dsw.classycraft.app.core.msggen.generator.ISubscriber;
import raf.dsw.classycraft.app.core.treemodel.nodes.projNodes.Package;
import raf.dsw.classycraft.app.core.treemodel.nodes.projNodes.Project;
import raf.dsw.classycraft.app.gui.swing.main.MainFrame;
import raf.dsw.classycraft.app.gui.swing.treeview.model.ClassyTreeItem;

import javax.swing.*;

public class PackagePane extends JPanel implements ISubscriber {
    ProjInfoPane projInfo;
    PackageTabbedPane packTabs;

    public PackagePane(){
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        MainFrame.getInstance().getTree().addSubscriber(this);
    }
    @Override
    public void react(Object notification) {

        if(notification!=null && (((ClassyTreeItem) notification).getNode() instanceof Package currpackage))
        {
            updateView(currpackage);
        }
        else {
            removeAll();
            projInfo=null;
            packTabs=null;
            revalidate();
            repaint();
        }
    }
    public void updateView(Package pack){

        this.removeAll();
        projInfo=null;
        packTabs=null;
        if(pack!=null) {
            Project p = pack.getProject();
            projInfo = new ProjInfoPane(p);
            packTabs = new PackageTabbedPane(pack);
            add(projInfo);
            add(packTabs);
        }
        revalidate();
    }
}
