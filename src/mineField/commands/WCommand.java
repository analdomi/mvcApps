package mineField.commands;
import mvc.*;
import mineField.*;

public class WCommand extends Command {

    public WCommand(Model model) {
        super(model);
    }

    public void execute() {
        Minefield minefield = (Minefield)model;
        int curX = ((Minefield) model).getX();
        if(curX == 0) {
            Utilities.error("You cannot move off the board");
        }
        else {
            ((Minefield) model).setY(curX - 1);
        }
    }

}