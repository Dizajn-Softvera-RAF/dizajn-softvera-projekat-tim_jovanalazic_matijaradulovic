package raf.dsw.classycraft.app.core.treemodel.nodes.diagramNodes.entities;

public enum Visibility {
    PRIVATE, PUBLIC, PROTECTED, DEFAULT;
//    private int value;
//    Visibility(int t){this.value=t;}

    public static Visibility getEnum(String t){
        switch (t){
            case "+"->{
                return PUBLIC;
            }
            case "-"->{
                return PRIVATE;
            }
            case "#"->{
                return PROTECTED;
            }
            case " "->{
                return DEFAULT;
            }
        }
        return null;
    }
    public String toString(){
        switch (this){
            case PUBLIC -> {
                return "+";
            }
            case PRIVATE -> {
                return "-";
            }
            case PROTECTED -> {
                return "#";
            }
            case DEFAULT -> {
                return "";
            }
        }
        return null;
    }

    public String toText() {
        switch (this){
            case PUBLIC -> {
                return "public";
            }
            case PRIVATE -> {
                return "private";
            }
            case PROTECTED -> {
                return "protected";
            }
            case DEFAULT -> {
                return "";
            }
        }
        return null;
    }
}


