/* *****************************************************************************
 *  Name:    Yufang Lu
 *  NetID:   yufangl
 *  Precept: P14
 *
 *  Partner Name:    /
 *  Partner NetID:   /
 *  Partner Precept: /
 *
 *  Description:  Find the beads in the picture.
 *                Takes an integer min, a floating-point number tau,
 *                and the name of an image file as command-line arguments;
 *
 *
 ******************************************************************************/

import java.awt.Color;

public class BeadFinder {

    private final boolean[][] after; // boolen matrix after luminance
    private final int width; // width of the picture
    private final int height; // height of the picture

    // find all blobs in the specified picture using luminance threshold tau
    public BeadFinder(Picture picture, double tau) {

        width = picture.width();
        height = picture.height();
        after = new boolean[width][height];

        for (int col = 0; col < width; col++) {
            for (int row = 0; row < height; row++) {
                Color color = picture.get(col, row);

                double lu = Luminance.intensity(color);
                if (lu >= tau)
                    after[col][row] = true;
            }
        }

    }

    // return all beads (blob >= min pixels)
    public Blob[] getBeads(int min) {

        boolean[][] visited = new boolean[width][height];
        boolean[][] isVisited = new boolean[width][height];
        Queue<Blob> blobs = new Queue<Blob>(); // queue for the blobs

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (!after[i][j]) continue;

                int count = countPixel(isVisited, i, j);
                if (count >= min && count > 0) {
                    Blob b = new Blob();
                    dfs(visited, i, j, b);
                    blobs.enqueue(b);
                }

            }
        }
        int n = blobs.size();
        Blob[] blobfind = new Blob[n];
        for (int i = 0; i < n; i++) {
            blobfind[i] = blobs.dequeue();
        }

        return blobfind;
    }


    // using depth first search to find a whole blob
    private void dfs(boolean[][] isVisited, int i, int j, Blob b) {

        if (i >= 0 && i < width && j >= 0 && j < height && after[i][j]
                && !isVisited[i][j]) {
            isVisited[i][j] = true;
            b.add(i, j);
            dfs(isVisited, i, j + 1, b); // right
            dfs(isVisited, i - 1, j, b); // up
            dfs(isVisited, i + 1, j, b); // down
            dfs(isVisited, i, j - 1, b); // left

        }

    }

    // using depth first search to count the bead mass
    private int countPixel(boolean[][] visited, int i, int j) {

        int count = 0;

        if (i >= 0 && i < width && j >= 0 && j < height && after[i][j]
                && !visited[i][j]) {
            visited[i][j] = true;
            count++;
            count += countPixel(visited, i - 1, j);
            count += countPixel(visited, i + 1, j);
            count += countPixel(visited, i, j - 1);
            count += countPixel(visited, i, j + 1);

        }
        return count;

    }


    // test client
    public static void main(String[] args) {
        int min = Integer.parseInt(args[0]);
        double tau = Double.parseDouble(args[1]);
        Picture pic = new Picture(args[2]);
        BeadFinder finder = new BeadFinder(pic, tau);

        Blob[] blobs = finder.getBeads(min);
        int n = blobs.length;
        for (int i = 0; i < n; i++)
            StdOut.println(blobs[i]);

    }
}
