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

    public void setNeighboringMines(int mines) {
        neighboringMines = mines;
    }

    public int getNeighboringMines() {
        return neighboringMines;
    }

    public void mine() {
        mined = true;
    }

    public boolean isMined() {
        return mined;
    }

    public boolean isTraversed() {
        return traversed;
    }

    public void traverse() {
        traversed = true;
    }
}