package mineField;

import mvc.*;
import java.util.Random;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;

public class Minefield extends Model {

    public static Integer WORLD_SIZE = 20;
    private int numRows;
    private int numCols;
    private int numMines;
    private boolean[][] mineField;
    private Random generater;
    private boolean activeGame = true;
    private CardLayout cards = new CardLayout();
    private JPanel[] bombPanels = new JPanel[numRows];
    private JButton[] bombButtons = new JButton[numRows];
    private Container gameContainer = new Container();
    private int x = 0;
    private int y = 0;

    private Grid grid = new Grid(WORLD_SIZE);
    private void drawGameGrid()
    {
        for(int i = 0; i < numRows; i++)
        {
            bombPanels[i] = new JPanel(cards);
            bombButtons[i] = new JButton("Click me!");
            bombButtons[i].setBackground(null);
            bombPanels[i].add("card" + i, bombButtons[i]);
            bombPanels[i].setBackground(Color.BLUE);
            gameContainer.add(bombPanels[i]);
           
        }
    }


    public Grid getGrid() {
        return grid;
    }

    public int getX() {
        return x;
    }

    public int getY() {
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
