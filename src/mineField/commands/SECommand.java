package mineField.commands;
import mvc.*;
import mineField.*;

public class SECommand extends Command {

    public SECommand(Model model) {
        super(model);
    }

    public void execute() {
        Minefield minefield = (Minefield)model;
        int curX = ((Minefield) model).getX();
        int curY = ((Minefield) model).getY();
        if(curX == minefield.WORLD_SIZE - 1 || curY == minefield.WORLD_SIZE - 1) {
            Utilities.error("You cannot move off the board");
        } else {
            ((Minefield) model).setX(curX + 1);
            ((Minefield) model).setY(curY + 1);
        }
    }

}