// This class is used to get the screen resolution.
package view.Util;
import java.awt.*;

public class ScreenRes {
    // Get the screen's resolution.
    static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    static double width = screenSize.getWidth();
    static double height = screenSize.getHeight();

    public static double width() {
        return width;
    }

    public static double height() {
        return height;
    }
}
