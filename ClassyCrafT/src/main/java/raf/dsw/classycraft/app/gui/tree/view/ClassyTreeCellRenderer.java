package raf.dsw.classycraft.app.gui.tree.view;

import raf.dsw.classycraft.app.core.treerepo.abstraction.ClassyNode;
import raf.dsw.classycraft.app.core.treerepo.implementation.Diagram;
import raf.dsw.classycraft.app.core.treerepo.implementation.Package;
import raf.dsw.classycraft.app.core.treerepo.implementation.Project;
import raf.dsw.classycraft.app.core.treerepo.implementation.ProjectExplorer;
import raf.dsw.classycraft.app.gui.tree.model.ClassyTreeItem;

import javax.swing.*;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeNode;
import java.awt.*;
import java.net.URL;

public class ClassyTreeCellRenderer extends DefaultTreeCellRenderer {
    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {
        super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);
        URL imageURL=null;
        ClassyNode tn=((ClassyTreeItem)value).getNode();
        if (tn instanceof ProjectExplorer) {
            imageURL = getClass().getResource("/images/explorer.png");
        }
        else if (tn instanceof Project) {
            imageURL = getClass().getResource("/images/project.png");
        }
        else if (tn instanceof Package) {
            imageURL = getClass().getResource("/images/package.png");
        }
        else if (tn instanceof Diagram) {
            imageURL = getClass().getResource("/images/diagram.png");
        }

        if (imageURL != null)
        {
            Image img = new ImageIcon(imageURL).getImage();
            Image newImg = img.getScaledInstance(25,25,Image.SCALE_DEFAULT);
            setIcon(new ImageIcon(newImg));
        }

        return this;
    }
}
