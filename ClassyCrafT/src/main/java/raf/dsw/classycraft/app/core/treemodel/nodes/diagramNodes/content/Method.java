package raf.dsw.classycraft.app.core.treemodel.nodes.diagramNodes.content;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Getter;
import lombok.Setter;
import raf.dsw.classycraft.app.core.treemodel.nodes.diagramNodes.entities.Visibility;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
@Getter
@Setter
@JsonTypeName("met")
public class Method extends ClassContent {

    String[] args;

    public Method() {
    }

    public Method(String name, Visibility v, String type) {
        super(name, v, type);
    }

    public Method(String name, Visibility v, String type, String[] args) {
        super(name, v, type);
        this.args = args;
    }

    private String argString(){
        StringJoiner sj =new StringJoiner(", ");
        for (var arg:args) {
            sj.add(arg);
        }
        return sj.toString();
    }

    @Override
    public String toString() {
        return String.format("%s %s(%s): %s",v.toString(),name,argString(),type);
    }
}
