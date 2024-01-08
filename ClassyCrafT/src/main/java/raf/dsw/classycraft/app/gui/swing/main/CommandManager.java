package raf.dsw.classycraft.app.gui.swing.main;

import java.util.ArrayList;

public class CommandManager {

    private ArrayList<AbstractCommand> commands = new ArrayList<AbstractCommand>();
    private int currentCommand = 0;

    public void addCommand(AbstractCommand command)
    {
        while(currentCommand < commands.size())
        {
            commands.remove(currentCommand);
        }

        commands.add(command);
        doCommand();
    }

    public void doCommand()
    {
        if(currentCommand < commands.size())
        {
            commands.get(currentCommand++).doCommand();
            //ApplicationFramework.getInstance().getGui().enableUndoAction();
        }

        if(currentCommand == commands.size())
        {
            //ApplicationFramework.getInstance().getGui().disableRedoAction();
        }
    }

    public void undoCommand()
    {
        if(currentCommand > 0)
        {
            //ApplicationFramework.getInstance().getGui().enableRedoAction();
            commands.get(--currentCommand).undoCommand();
        }

        if(currentCommand == 0)
        {
            //ApplicationFramework.getInstance().getGui().disableUndoAction();

        }
    }
}
