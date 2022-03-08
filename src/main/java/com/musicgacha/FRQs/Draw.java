package com.social_credit_farming.FRQs;

public class Draw {

    /** Precondition: All parameters are between 0 and 10, inclusive.
     * Draws a line segment in a 10-by-10 xy-coordinate grid.
     * The line segment is drawn from (x1, y1) to (x2, y2).
     */

    public void drawLine(int x1, int y1, int x2, int y2) {
        /* implementation not shown */
    }



    /** Precondition: 0 ≤ x < 10, 0 < y ≤ 10, and len > 0.
     * Draws a square on a 10-by-10 xy-coordinate grid
     * and prints the square’s side length and area.
     * The upper left corner of the square will be located
     * at the coordinate (x, y) and the side length of the
     * square will be len (or as large as will fit in the grid).
     */

    public void drawSquare(int x, int y, int len) {
        if ((x + len <= 10) && (y - len >= 0)) {
            drawLine(x, y, x + len, y);
            drawLine(x + len, y, x + len, y - len);
            drawLine(x + len, y - len, x, y - len);
            drawLine(x, y - len, x, y);
        }
        else if (x + len >= 10) {
            len = 10 - x;
            drawLine(x, y, x + len, y);
            drawLine(x + len, y, x + len, y - len);
            drawLine(x + len, y - len, x, y - len);
            drawLine(x, y - len, x, y);
        }
        else {
            len = y;
            drawLine(x, y, x + len, y);
            drawLine(x + len, y, x + len, 0);
            drawLine(x + len, 0, x, 0);
            drawLine(x, 0, x, y);
        }
        System.out.println("side length = " + len + ", area = " + (len*len));
    }

    public static void main(String[] args) {
        Draw square = new Draw();
        square.drawSquare(1, 4, 3);
    }
}