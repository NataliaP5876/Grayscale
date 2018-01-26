/**
 * Created by Vol4onka on 23.01.2018.
 */
public class ColorToGray {
    public static int colorToGray(int r, int g, int b) {
        double linR = Linearizer.linearize(r);
        double linG = Linearizer.linearize(g);
        double linB = Linearizer.linearize(b);
        double lin_ysRGB = 0;
        int ysRGB = 0;
        lin_ysRGB = 0.2126 * linR + 0.7152 * linG + 0.0722 * linB;
        if (lin_ysRGB <= 0.0031308) {
            lin_ysRGB = (lin_ysRGB * 12.92);
        } else {
            lin_ysRGB = (1.055*Math.pow(lin_ysRGB,(1.0/2.4)));
        }
        ysRGB = (int)lin_ysRGB;
        return ysRGB;
    }
}
