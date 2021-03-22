package mineField.commands;
import jdk.jshell.execution.Util;
import mvc.*;
import mineField.*;

public class NCommand extends Command {

    public NCommand(Model model) {
        super(model);
    }

    public void execute() {
        Minefield minefield = (Minefield)model;
        int curY = ((Minefield) model).getY();
        if(curY == 0) {
            Utilities.error("You cannot move off the board");
        }
        else {
            ((Minefield) model).setY(curY - 1);
        }
    }

}