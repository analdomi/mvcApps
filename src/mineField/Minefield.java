package mineField;

import mvc.*;

public class Minefield extends Model {

    public static Integer WORLD_SIZE = 20;

    private boolean activeGame = true;

    private int x = 0;
    private int y = 0;

    private Grid grid = new Grid(WORLD_SIZE);

    public Grid getGrid() {
        return grid;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void moveUp() {
        try {
            y--;
            changed();
        } catch(Exception e) {
            Utilities.error("Can't move off the board");
        }
    }

    public void moveDown() {
        try {
            y++;
            changed();
        } catch(Exception e) {
            Utilities.error("Can't move off the board");
        }
    }

    public void moveLeft() {
        try {
            x--;
            changed();
        } catch(Exception e) {
            Utilities.error("Can't move off the board");
        }
    }

    public void moveRight() {
        try {
            x++;
            changed();
        } catch(Exception e) {
            Utilities.error("Can't move off the board");
        }
    }
    // public String toString() { return "stopLight.color = " + color; }
}
