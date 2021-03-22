package mineField.commands;
import mvc.*;
import mineField.*;

public class ECommand extends Command {

    public ECommand(Model model) {
        super(model);
    }

    public void execute() {
        Minefield minefield = (Minefield)model;
        int curX = ((Minefield) model).getX();
        if(curX == minefield.WORLD_SIZE - 1) {
            Utilities.error("You cannot move off the board");
        }
        else {
            ((Minefield) model).setY(curX + 1);
        }
    }

}