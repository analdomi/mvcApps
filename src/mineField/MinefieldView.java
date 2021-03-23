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
    }

    public void paintComponent(Graphics gc) {
        super.paintComponent(gc);
        Minefield minefield = (Minefield)model;
        minefield.getGrid();

        Color oldColor = gc.getColor();
        System.out.print(minefield);
        //gc.setColor(light.getColor());
        for(int i =0; i< minefield.WORLD_SIZE ; i++){
            for(int j =0; j < minefield.WORLD_SIZE; j++){
                Grid grid = minefield.getGrid();
                Cell cell = grid.getCell(i, j);
                if(cell.isTraversed()) {
                    gc.setColor(Color.white);
                    gc.drawString("" + cell.getNeighboringMines(), RECT_X * i, RECT_Y * (j + 1));
                }
                else{
                    gc.setColor(Color.black);
                    gc.drawString("?", RECT_X * i,RECT_Y * (j + 1));
                }
                gc.drawRect(RECT_X * i, RECT_Y * j, RECT_WIDTH , RECT_HEIGHT);
            }

        }


        gc.setColor(oldColor);

    }
}