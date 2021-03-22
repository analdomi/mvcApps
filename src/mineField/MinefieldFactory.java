package mineField;


import mvc.*;
import mineField.commands.*;
import mineField.Minefield;
import mineField.MinefieldView;

public class MinefieldFactory implements AppFactory {

    public Model makeModel() { return new Minefield(); }

    public View makeView(Model m) {
        return new MinefieldView((Minefield)m);
    }

    public String[] getEditCommands() { return new String[] {"NW", "N", "NE", "W", "E", "SW", "S", "SE"}; }

    public Command makeEditCommand(Model model, String type) {
        if (type == "NW") {
            return new NWCommand(model);
        } else if (type == "N") {
            return new NCommand(model);
        } else if (type == "NE") {
            return new NECommand(model);
        } else if (type == "W") {
            return new WCommand(model);
        } else if (type == "E") {
            return new ECommand(model);
        } else if (type == "SW") {
            return new SWCommand(model);
        } else if (type == "S") {
            return new SCommand(model);
        } else if (type == "SE") {
            return new SECommand(model);
        }
        return null;
    }

    public String getTitle() { return "MineField Simulator"; }

    public String[] getHelp() {
        return new String[] {"Click the direction in which you want to move.\n" +
            "When you move onto a square it will show how many mines are adjacent to it.\n" +
            "If you step on a mine, the game is over.\n" +
            "You cannot move off of the grid.\n" +
            "Try to make it to the bottom right square without dying to win!"};
    }

    public String about() {
        return "Minefield version 1.0. 2021";
    }

}
