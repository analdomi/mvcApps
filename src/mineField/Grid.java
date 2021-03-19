package mineField;

public class Grid {

    private Cell field[][];

    public Grid(int size) {
        Cell field[][] = new Cell [size][size];
        setNeighboringMines();
    }

    public Cell[][] getGrid() {
        return field;
    }

    public void setNeighboringMines() {
        for(int i = 0; i < field.length; i++) {
            for(int j = 0; j < field[i].length; j++) {
                if(field[i][j].isMined()) {
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
    }
}
