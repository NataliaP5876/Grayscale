/**
 * Created by Vol4onka on 23.01.2018.
 */
public class ColorToGray {
    public static int colorToGray(int R, int G, int B){
        double linR = Linearizer.linearize(R);
        double linG = Linearizer.linearize(G);
        double linB = Linearizer.linearize(B);
        double lin_ysRGB = 0;
        int ysRGB =0;
        lin_ysRGB = 0.2126*linR+0.7152*linG +0.0722*linB;
        if(lin_ysRGB <= 0.0031308){
            lin_ysRGB = (lin_ysRGB * 12.92);
        }
        else {
            lin_ysRGB = (1.055*Math.pow(lin_ysRGB,(1.0/2.4)));
        }
        ysRGB = (int)lin_ysRGB;

        /*if(R+G+B>0)
            System.out.println(R + " " + G + " " + " " + B + lin_ysRGB + " " + ysRGB);*/
        return ysRGB;
    }
}
