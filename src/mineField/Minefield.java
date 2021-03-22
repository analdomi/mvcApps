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

    public void setX(int xInc) {
        x;
    }

    public void setY() {
        return y;
    }

    public void moveNorth() {
        try {
            y--;
            changed();
        } catch(Exception e) {
            Utilities.error("Can't move off the board");
        }
    }

    public void moveSouth() {
        try {
            y++;
            changed();
        } catch(Exception e) {
            Utilities.error("Can't move off the board");
        }
    }

    public void moveWest() {
        try {
            x--;
            changed();
        } catch(Exception e) {
            Utilities.error("Can't move off the board");
        }
    }

    public void moveEast() {
        try {
            x++;
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
            y++;
            x--;
            changed();
        } catch(Exception e) {
            Utilities.error("Can't move off the board");
        }
    }
    public void moveNorthEast() {
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
