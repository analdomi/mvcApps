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
            model.changed();

            int newX = ((Minefield) model).getX();
            int newY = ((Minefield) model).getY();

             Cell newCell =((Minefield) model).getGrid().getCell(newX, newY);
             newCell.traverse();
             if(newX == ((Minefield) model).WORLD_SIZE - 1 && newY == ((Minefield) model).WORLD_SIZE - 1) {
                Utilities.inform("Game Over: You Won!");
             } if (newCell.isMined()){
                 Utilities.inform("Game Over: You Stepped on a Mine and were Exploded");
                 minefield.activeGame = false;
             }
        }
    }

}