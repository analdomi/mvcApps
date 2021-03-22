package mineField;

import java.io.Serializable;

public class Grid implements Serializable {

    private Cell[][] field;

    public Grid(int size) {
        field = new Cell [size][size];
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                Cell curCell    = new Cell();
                field[i][i] = curCell;
//                System.out.println("New cell: " + i + " " + j);
//                System.out.println("Mined?: " + curCell.isMined());
            }
        }
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                Cell curCell = field[i][i];
//                System.out.println("Cell: " + i + " " + j);
//                System.out.println("Mined?: " + curCell.isMined());
                if(curCell.isMined()) {
                    for(int x = i - 1; x <= i + 1; x++) {
                        for(int y = j - 1; y <= j + 1; y++) {
                            if (x != i && y != j) { // Does not increment for itself
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

        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                Cell curCell    = new Cell();
                field[i][i] = curCell;
//                System.out.println("Neighbors: " + curCell.getNeighboringMines());
            }
        }
    }

    public Cell[][] getGrid() {
        return field;
    }

    public void setNeighboringMines() {
        for(int i = 0; i < this.field[i].length; i++) {
            for(int j = 0; j < this.field[i].length; j++) {
                if(this.field[i][j].isMined()) {
                    for(int x = i - 1; x <= i + 1; x++) {
                        for(int y = j - 1; y <= j + 1; y++) {
                            if (x != i && y != j) { // Does not increment for itself
                                try {
                                    Cell neighboringCell = this.field[x][y];
                                    neighboringCell.incrementNeighboringMines();
                                    System.out.println("Neighbors: " + neighboringCell.getNeighboringMines());
                                } catch (Exception e) {
                                    ;
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
