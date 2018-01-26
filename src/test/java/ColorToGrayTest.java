import org.junit.*;

import java.awt.*;

import static org.junit.Assert.assertEquals;
/**
 * Created by Vol4onka on 23.01.2018.
 */
public class ColorToGrayTest {
    @Test
    public void TestColorToGray() throws Exception {
        int redToGray = 133;
        int c = ColorToGray.colorToGray(255,0,0);
        assertEquals("Wrong color", redToGray, c);
    }

    @Test
    public void TestBlackToGray() throws Exception {
        int black = 0;
        int c = ColorToGray.colorToGray(0,0,0);
        assertEquals("Wrong color", black, c);
    }

    @Test
    public void TestWhiteToGray() throws Exception {
        int white = 255;
        int c = ColorToGray.colorToGray(255,255,255);
        assertEquals("Wrong color", white, c);
    }

    @Test
    public void TestGrayToGray() throws Exception {
        int gray = 195;
        int c = ColorToGray.colorToGray(195,195,195);
        assertEquals("Wrong color", gray, c);
    }
}
