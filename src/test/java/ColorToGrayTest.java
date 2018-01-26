import org.junit.*;

import java.awt.*;

import static org.junit.Assert.assertEquals;
/**
 * Created by Vol4onka on 23.01.2018.
 */
public class ColorToGrayTest {
    @Test
    public void TestColorToGray() throws Exception {
        int r = 133;
        Color newColor1 = new Color(r,r,r);
        int color1 = newColor1.getRGB();
        int c = ColorToGray.colorToGray(255,0,0);
        Color newColor2 = new Color(c,c,c);
        int color2 = newColor2.getRGB();
        assertEquals("Wrong color", color1, color2);
    }
}
