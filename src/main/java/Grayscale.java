import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.File;
import java.io.IOException;

/**
 * Created by Vol4onka on 23.01.2018.
 */
public class Grayscale {
    public static void grayscale(String pathIn,String pathOut) throws IOException {
        BufferedImage img = ImageIO.read(new File(pathIn));
        final int width = img.getWidth();
        final int height = img.getHeight();
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Color c = new Color(img.getRGB(i,j));
                int a = (c.getAlpha());
                int r = (c.getRed());
                int g = (c.getGreen());
                int b = (c.getBlue());
                int color = ColorToGray.colorToGray(r,g,b);
                //int color = (r+g+b)/3;
                Color newColor = new Color(color,color,color,a);
                img.setRGB(i,j,newColor.getRGB());
            }
        }
        File f = new File(pathOut);
        ImageIO.write(img, "jpg", f);
    }
}
