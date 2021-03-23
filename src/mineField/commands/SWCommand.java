package mineField.commands;
import mvc.*;
import mineField.*;

public class SWCommand extends Command {

    public SWCommand(Model model) {
        super(model);
    }

    public void execute() {
        Minefield minefield = (Minefield)model;
        if(!minefield.activeGame) {
            Utilities.inform("Game is Over");
            return;
        }
        if(!minefield.activeGame) {
            Utilities.inform("Game is Over");
            return;
        }
        int curX = ((Minefield) model).getX();
        int curY = ((Minefield) model).getY();
        if(curX == 0 || curY == minefield.WORLD_SIZE - 1) {
            Utilities.error("You cannot move off the board");
        } else {
            ((Minefield) model).setX(curX - 1);
            ((Minefield) model).setY(curY + 1);
            model.changed();


            int newX = ((Minefield) model).getX();
            int newY = ((Minefield) model).getY();

            Cell newCell = ((Minefield) model).getGrid().getCell(newX, newY);
            newCell.traverse();
            if (newX == ((Minefield) model).WORLD_SIZE - 1 && newY == ((Minefield) model).WORLD_SIZE - 1) {
                Utilities.inform("Game Over: You Won!");
                minefield.activeGame = false;
            } else if (newCell.isMined()) {
                Utilities.inform("Game Over: You Stepped on a Mine and were Exploded");
                minefield.activeGame = false;
            }
        }
    }

}