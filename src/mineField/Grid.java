package mineField;

import java.io.Serializable;

public class Grid implements Serializable {

    private Cell[][] field;
    int size = 20;


    public Grid(int size) {
        field = new Cell[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Cell curCell = new Cell();
                field[i][i] = curCell;
            }
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Cell curCell = field[i][i];
                if (curCell.isMined()) {
                    for (int x = i - 1; x <= i + 1; x++) {
                        for (int y = j - 1; y <= j + 1; y++) {
                            if (x != i || y != j) { // Does not increment for itself
                                try {
                                    field[x][y].incrementNeighboringMines();
                                } catch (Exception e) {
                                    ;
                                }
                            }
                        }
                    }
                }
            }
        }
        field[0][0].traverse();
    }

    public Cell[][] getGrid() {
        return field;
    }
}