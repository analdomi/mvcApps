package mineField.commands;
import mvc.*;
import mineField.*;

public class NWCommand extends Command {

    public NWCommand(Model model) {
        super(model);
    }

    public void execute() {
        Minefield minefield = (Minefield)model;
        int curX = ((Minefield) model).getX();
        int curY = ((Minefield) model).getY();
        if(curX == 0 || curY == 0) {
            Utilities.error("You cannot move off the board");
        } else {
            ((Minefield) model).setX(curX - 1);
            ((Minefield) model).setY(curY - 1);
        }
    }

}