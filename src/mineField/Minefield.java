package mineField;

import mvc.*;
import java.awt.Color;

public class Minefield extends Model {
    private Color color = Color.GREEN;
    public int x = 0;
    public int y = 0;

    public Color getColor() {
        return color;
    }

    public String toString() { return "stopLight.color = " + color; }

    public String getLocation(int x, int y){
        this.x = x;
        this.y = y;
        return "The location is" + x + y;
    }

    public void change() {
        if (color.equals(Color.GREEN)) color = Color.YELLOW;
        else if (color.equals(Color.YELLOW)) color = Color.RED;
        else if (color.equals(Color.RED)) color = Color.GREEN;
        changed(); // from Model, sets changed flag and fires changed event
    }
}
