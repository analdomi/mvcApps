package mineField;

import mvc.*;
import java.awt.*;

public class MinefieldView extends View {

    public MinefieldView(Minefield light) {
        super(light);
    }

    public void paintComponent(Graphics gc) {
        super.paintComponent(gc);
        Minefield light = (Minefield)model;
        Color oldColor = gc.getColor();
        gc.setColor(light.getColor());
        gc.fillOval(100, 100, 20, 20);
        gc.setColor(oldColor);
    }
}