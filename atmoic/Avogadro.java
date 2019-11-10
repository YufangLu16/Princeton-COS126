/* *****************************************************************************
 *  Name:    Yufang Lu
 *  NetID:   yufangl
 *  Precept: P14
 *
 *  Partner Name:    /
 *  Partner NetID:   /
 *  Partner Precept: /
 *
 *  Description:  Calculate the Boltzmann constant and
 *
 ******************************************************************************/

public class Avogadro {
    public static void main(String[] args) {
        double mpp = 0.175e-6; // meter per pixel
        double tem = 297.0; // absolute temperature
        double radius = 0.5e-6; // radius
        double visc = 9.135e-4; // viscosity
        double GAS_CONSTANT = 8.31446; // gas constant
        double deltaT = 0.5; // time interval
        double rpow2 = 0.0;
        int count = 0;
        while (!StdIn.isEmpty()) {
            double a = StdIn.readDouble();
            rpow2 += (a * mpp) * (a * mpp);
            count++;
        }

        double thema = rpow2 / (2 * count);
        double d = thema / (2 * deltaT);
        double k = 6 * Math.PI * visc * radius * d / tem; // Boltzmann constant
        double AVOGADRO_CONSTANT = GAS_CONSTANT / k; // Avogadro constant
        StdOut.printf("Boltzmann = %5.4e", k);
        StdOut.println();
        StdOut.printf("Avogadro  = %5.4e", AVOGADRO_CONSTANT);
        StdOut.println();

    }
}
