package mineField;


import java.awt.*;
import mvc.*;

public class MinefieldView {


    public  MinefieldView extends View {

        public MinefieldView(MineField light) {
            super(light);
        }

        public void paintComponent(Graphics gc) {
            super.paintComponent(gc);
            Stoplight light = (Stoplight)model;
            Color oldColor = gc.getColor();
            gc.setColor(light.getColor());
            gc.fillOval(100, 100, 20, 20);
            gc.setColor(oldColor);
        }
    }
}
