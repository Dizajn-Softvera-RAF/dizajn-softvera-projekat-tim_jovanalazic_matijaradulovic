package raf.dsw.classycraft.app.core.serializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import raf.dsw.classycraft.app.core.treemodel.nodes.projNodes.Diagram;
import raf.dsw.classycraft.app.core.treemodel.nodes.projNodes.Project;

import java.io.File;
import java.io.IOException;

public class JacksonUtil {
    public static Project loadProject(File file) throws IOException {
        ObjectMapper objmapper=new ObjectMapper();
        return objmapper.readValue(file, Project.class);
    }
    public static void saveProject(File file, Project proj) throws IOException {
        ObjectMapper objmapper=new ObjectMapper();
        objmapper.writeValue(file,proj);
    }
    public static Diagram loadDiagram(File file) throws IOException {

        ObjectMapper objmapper=new ObjectMapper();
        return objmapper.readValue(file, Diagram.class);
    }
    public static void saveDiagram(File file, Diagram diag) throws IOException {
        ObjectMapper objmapper=new ObjectMapper();
        objmapper.writeValue(file,diag);
    }

}
