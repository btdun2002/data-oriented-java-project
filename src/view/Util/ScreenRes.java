// This class is used to get the screen resolution.
package view.Util;

import java.awt.*;

public class ScreenRes {
    // Get the screen's resolution.
    static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public static double WIDTH = screenSize.getWidth();
    public static double HEIGHT = screenSize.getHeight();
}
