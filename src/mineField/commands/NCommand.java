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
        if(!minefield.activeGame) {
            Utilities.inform("Game is Over");
            return;
        }
        int curY = ((Minefield) model).getY();
        if(curY == 0) {
            Utilities.error("You cannot move off the board");
        }
        else {
            ((Minefield) model).setY(curY - 1);

            int newX = ((Minefield) model).getX();
            int newY = ((Minefield) model).getY();

             Cell newCell =((Minefield) model).getGrid().getGrid()[newX][newY];
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