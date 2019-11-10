/* *****************************************************************************
 *  Name:    Alan Turing
 *  NetID:   aturing
 *  Precept: P00
 *
 *  Partner Name:    Ada Lovelace
 *  Partner NetID:   alovelace
 *  Partner Precept: P00
 *
 *  Description:  Prints 'Hello, World' to the terminal window.
 *                By tradition, this is everyone's first program.
 *                Prof. Brian Kernighan initiated this tradition in 1974.
 *
 **************************************************************************** */

import java.awt.Color;

public class CarFinder {
    private boolean[][] after; // boolen matrix after luminance
    private int width;
    private int height;

    public CarFinder(Picture p, double tau) {
        width = p.width();
        height = p.height();
        StdOut.println(width + " " + height);
        after = new boolean[width][height];
        for (int col = 0; col < width; col++) {
            for (int row = 0; row < height; row++) {
                Color c = p.get(col, row);
                double lu = toGray(c);
                if (lu >= tau)
                    after[col][row] = true;

            }
        }
    }


    public int[][] transfer() {
        int[][] a = new int[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (after[i][j])
                    a[i][j] = 1;
            }
        }
        return a;

    }

    private double toGray(Color c) {
        int r = c.getRed();
        int g = c.getGreen();
        int b = c.getBlue();
        double sum = r + g + b;
        return sum / 3;
    }

    public static void main(String[] args) {
        double tau = 100.0;
        Picture p = new Picture(args[0]);
        CarFinder find = new CarFinder(p, tau);
        int[][] a = find.transfer();
        int width = a.length;
        int height = a[0].length;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                StdOut.print(a[i][j] + " ");
            }
            StdOut.println();
        }


    }

}

