package mineField.commands;
import mvc.*;
import mineField.*;

public class SCommand extends Command {

    public SCommand(Model model) {
        super(model);
    }

    public void execute() {
        Minefield minefield = (Minefield)model;
        int curY = ((Minefield) model).getY();
        if(curY == minefield.WORLD_SIZE - 1) {
            Utilities.error("You cannot move off the board");
        } else {
            ((Minefield) model).setY(curY + 1);
        }
    }

}