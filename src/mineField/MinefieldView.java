package mineField;

import mvc.*;
import java.awt.*;

public class MinefieldView extends View {

    private static final int RECT_X = 12;
    private static final int RECT_Y = 12;
    private static final int RECT_WIDTH = 10;
    private static final int RECT_HEIGHT = 10;
    public MinefieldView(Minefield light) {
        super(light);
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
                gc.drawRect(RECT_X * i, RECT_Y * j, RECT_WIDTH , RECT_HEIGHT);
                gc.drawString("?", RECT_X,RECT_Y);
                gc.setColor(Color.GRAY);
                gc.fillRect(RECT_X * i, RECT_Y * j, RECT_WIDTH , RECT_HEIGHT);

            }

        }


        gc.setColor(oldColor);

    }
}