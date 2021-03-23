package mineField;

import mvc.*;
import java.awt.*;

public class MinefieldView extends View {

    private static final int RECT_X = 20;
    private static final int RECT_Y = 20;
    private static final int RECT_WIDTH = 20;
    private static final int RECT_HEIGHT = 20;
    public MinefieldView(Minefield minefield) {
        super(minefield);
        setBackground(Color.gray);
    }

    public void paintComponent(Graphics gc) {
        super.paintComponent(gc);
        Minefield minefield = (Minefield)model;

        Color oldColor = gc.getColor();
        for(int i =0; i< Minefield.WORLD_SIZE ; i++){
            for(int j =0; j < Minefield.WORLD_SIZE; j++){
                Grid grid = minefield.getGrid();
                Cell cell = grid.getCell(i, j);
                if(cell.isTraversed()) {
                    if (i == minefield.getX() && j == minefield.getY()) {
                        gc.setColor(Color.cyan);
                    } else {
                        gc.setColor(Color.white);
                    }
                    gc.drawString("" + cell.getNeighboringMines(), (RECT_X * i) + (RECT_X / 3),(RECT_Y * (j + 1)) - (RECT_Y / 4));
                                    // Conversion to String
                }
                else{
                    gc.setColor(Color.black);
                    gc.drawString("?", (RECT_X * i) + (RECT_X / 3),(RECT_Y * (j + 1)) - (RECT_Y / 4));
                }

                if (i == Minefield.WORLD_SIZE - 1 && j == Minefield.WORLD_SIZE - 1) {
                    gc.setColor(Color.green);
                }

                gc.drawRect(RECT_X * i, RECT_Y * j, RECT_WIDTH , RECT_HEIGHT);
            }

        }


        gc.setColor(oldColor);

    }
}