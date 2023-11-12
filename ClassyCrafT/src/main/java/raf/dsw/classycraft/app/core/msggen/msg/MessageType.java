package raf.dsw.classycraft.app.core.msggen.msg;

public enum MessageType {
    ERROR(0),
    INFO(1),
    WARNING(2),
    LOG(3);

    private final int t;
    MessageType(int t){this.t=t;}
}
