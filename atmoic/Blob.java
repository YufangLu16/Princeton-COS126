/* *****************************************************************************
 *  Name:    Yufang Lu
 *  NetID:   yufangl
 *  Precept: P14
 *
 *  Partner Name:    /
 *  Partner NetID:   /
 *  Partner Precept: /
 *
 *  Description:  A helper type Blob that help identifies the blobs in the image.
 *
 **************************************************************************** */

public class Blob {

    private int n; // number of pixels
    private double sumx; // sum of x-coordinates
    private double sumy; // sum of y-coordinates


    // create an empty blob
    public Blob() {
        n = 0;
        sumx = 0.0;
        sumy = 0.0;

    }

    // add pixel (x, y) to this blob
    public void add(int x, int y) {
        n++;
        sumx += x;
        sumy += y;

    }

    // number of pixels added to this blob
    public int mass() {
        return n;

    }

    // Euclidean distance between the center of masses of the two blods
    public double distanceTo(Blob that) {
        if (this.n == 0 || that.n == 0)
            return Double.NaN;
        double thiscx = this.sumx / n;
        double thiscy = this.sumy / n;
        double thatcx = that.sumx / that.n;
        double thatcy = that.sumy / that.n;
        double dis = Math.sqrt((thiscx - thatcx) * (thiscx - thatcx) + (thiscy -
                thatcy) * (thiscy - thatcy));
        return dis;

    }

    // String representation of this blob
    public String toString() {
        if (n == 0)
            return " 0 (NaN, NaN)";
        return String.format("%2d (%8.4f, %8.4f)", mass(), sumx / n, sumy / n);

    }


    // test the class by directly calling all instance methods
    public static void main(String[] args) {
        Blob blob1 = new Blob();
        Blob blob2 = new Blob();
        blob1.add(1, 2);
        blob1.add(1, 3);
        blob2.add(3, 4);
        double dis = blob1.distanceTo(blob2);
        StdOut.println(blob1);
        StdOut.println(blob2);
        StdOut.println(blob1.mass());
        StdOut.println(dis);


    }
}
