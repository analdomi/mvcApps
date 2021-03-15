package mineField;

import java.io.Serializable;
import java.util.Random;

public class Cell implements Serializable{

    private int neighboringMines;
    private boolean mined;
    private boolean traversed;

    public Cell(float minedChance) {
        mined = Math.random() < minedChance;
        traversed = false;
    }
}