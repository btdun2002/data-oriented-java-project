import javax.swing.*;

import view.*;

public class App {
    public static void main(String[] args) throws Exception {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Root root = new Root();
                root.initialize();
            }
        });
    }
}
