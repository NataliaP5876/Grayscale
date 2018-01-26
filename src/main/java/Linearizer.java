/**
 * Created by Vol4onka on 23.01.2018.
 */
public class Linearizer {
    public static double linearize(int srgb) {
        double Dsrgb = srgb;
        double cLinear;
        if (Dsrgb <= 0.04045) {
            cLinear = Dsrgb / 12.92;
        } else {
            double c = (Dsrgb + 0.055) / 1.055;
            cLinear = Math.pow(c,2.4);
        }
        return cLinear;
    }
}
