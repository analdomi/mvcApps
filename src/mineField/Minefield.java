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

    public void setX(int newX) {
        x = newX;
    }

    public void setY(int newY) {
        y = newY;
    }

}
