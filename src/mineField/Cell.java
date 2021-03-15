package mineField;

import java.io.Serializable;
import java.util.Random;

public class Cell implements Serializable{

    private int neighboringMines;
    private boolean mined;

    public Cell(float minedChance) {
        mined = Math.random() < minedChance;
    }
}