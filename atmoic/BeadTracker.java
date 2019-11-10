/*******************************************************************************
 *  Name:    Yufang Lu
 *  NetID:   yufangl
 *  Precept: P14
 *
 *  Partner Name:    /
 *  Partner NetID:   /
 *  Partner Precept: /
 *
 *  Description:  Track the beads in a set of pictures;
 *                To determine how far a bead moves from time t to t+delta t
 *
 ******************************************************************************/

public class BeadTracker {


    public static void main(String[] args) {

        int min = Integer.parseInt(args[0]);
        double tau = Double.parseDouble(args[1]);
        double delta = Double.parseDouble(args[2]);
        int count = args.length - 3;
        String[] files = new String[count];
        for (int i = 0; i < count; i++)
            files[i] = args[i + 3];

        Picture beforePic = new Picture(files[0]);
        BeadFinder finder = new BeadFinder(beforePic, tau);
        Blob[] beforeBlobs = finder.getBeads(min);
        for (int i = 1; i < count; i++) {
            Picture afterPic = new Picture(files[i]);
            BeadFinder find = new BeadFinder(afterPic, tau);
            Blob[] afterBlobs = find.getBeads(min);
            int n = afterBlobs.length;
            int m = beforeBlobs.length;
            for (int j = 0; j < n; j++) {
                double minDistane = delta + 1;
                for (int k = 0; k < m; k++) {
                    double dis = afterBlobs[j].distanceTo(beforeBlobs[k]);
                    if (minDistane > dis)
                        minDistane = dis;
                }
                if (minDistane <= delta)
                    StdOut.println(String.format("%6.4f", minDistane));
            }
            StdOut.println();

            beforeBlobs = find.getBeads(min);
        }


    }
}
