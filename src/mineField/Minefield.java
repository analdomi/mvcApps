package mineField;

import mvc.*;

public class Minefield extends Model {

    public static Integer WORLD_SIZE = 20;

    private boolean activeGame = true;

    private int x = 0;
    private int y = 0;

    private Grid grid = new Grid(WORLD_SIZE);

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void moveUp() {
        try {
            x--;
            changed();
        } catch(Exception e) {
            Utilities.error("Can't move off the board");
        }
    }

    public void moveDown() {
        try {
            x++;
            changed();
        } catch(Exception e) {
            Utilities.error("Can't move off the board");
        }
    }

    public void moveLeft() {
        try {
            y--;
            changed();
        } catch(Exception e) {
            Utilities.error("Can't move off the board");
        }
    }

    public void moveRight() {
        try {
            y++;
            changed();
        } catch(Exception e) {
            Utilities.error("Can't move off the board");
        }
    }
    public void moveSouthEast() {
        try {
            y++;
            x++;
            changed();
        } catch(Exception e) {
            Utilities.error("Can't move off the board");
        }
    }
    public void moveSouthWest() {
        try {
            y--;
            x++;
            changed();
        } catch(Exception e) {
            Utilities.error("Can't move off the board");
        }
    }
    public void moveNorthWest() {
        try {
            y--;
            x--;
            changed();
        } catch(Exception e) {
            Utilities.error("Can't move off the board");
        }
    }
    // public String toString() { return "stopLight.color = " + color; }
}
