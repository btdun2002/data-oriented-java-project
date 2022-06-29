package test;

import javax.swing.*;
import javax.swing.plaf.LayerUI;

public class Wallpaper {
    public static void main(String[] args) {
        new Wallpaper();
    }

    public static void createUI() {
        JFrame f = new JFrame();

        JPanel p = new JPanel();
        JLabel locaLabel = new JLabel("Hello");
        p.add(locaLabel);

        LayerUI<JComponent> layerUI = new WallpaperLayerUI();

        JLayer<JComponent> jlayer = new JLayer<JComponent>(p, layerUI);

        f.add(jlayer);

        f.setSize(300, 200);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}
