package com.musicgacha.Lights;

public class Lights {
    private static final int BOARD_ROWS = 5;
    private static final int BOARD_COLUMNS = 5;

    // Create lights game board
    private final boolean[][] Lights2DArray = new boolean[BOARD_ROWS][BOARD_COLUMNS];

    // Toggles the clicked square, then checks if squares around the click square exist and toggles them
    public boolean squareClicked(int row, int col) {
        this.Lights2DArray[row][col] = !this.Lights2DArray[row][col];
        if (row - 1 > 0) {
            this.Lights2DArray[row - 1][col] = !this.Lights2DArray[row - 1][col];
        }
        if (row + 1 < BOARD_ROWS + 1) {
            this.Lights2DArray[row + 1][col] = !this.Lights2DArray[row + 1][col];
        }
        if (col - 1 > 0) {
            this.Lights2DArray[row][col - 1] = !this.Lights2DArray[row][col - 1];
        }
        if (row + 1 < BOARD_COLUMNS + 1) {
            this.Lights2DArray[row - 1][col] = !this.Lights2DArray[row - 1][col];
        }
        return true;
    }
}