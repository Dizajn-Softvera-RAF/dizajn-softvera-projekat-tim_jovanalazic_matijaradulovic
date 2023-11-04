package raf.dsw.classycraft.app.classyrepository;
import java.util.List;

public abstract class ClassyNodeComposite {

	private List<ClassyNode> children;
	
	
	public void addChild(ClassyNode newNode)
	{
		this.children.add(newNode);
	}
	
	public void removeChild(ClassyNode node)
	{
		this.children.remove(node);
	}
}
