package view.components.loadingIcon;

import java.awt.*;

import javax.swing.*;

import view.Util.*;

public class SplashBox extends Box {
    HUSTPanel hPanel = new HUSTPanel("assets/icons/H_red.png", "assets/icons/H_black.png",
            (int) (ScreenRes.WIDTH / 35), (int) (ScreenRes.HEIGHT / 35));
    HUSTPanel uPanel = new HUSTPanel("assets/icons/U_red.png", "assets/icons/U_black.png",
            (int) (ScreenRes.WIDTH / 35), (int) (ScreenRes.HEIGHT / 35));
    HUSTPanel sPanel = new HUSTPanel("assets/icons/S_red.png", "assets/icons/S_black.png",
            (int) (ScreenRes.WIDTH / 35), (int) (ScreenRes.HEIGHT / 35));
    HUSTPanel tPanel = new HUSTPanel("assets/icons/T_red.png", "assets/icons/T_black.png",
            (int) (ScreenRes.WIDTH / 35), (int) (ScreenRes.HEIGHT / 35));
    JPanel localPanel = new JPanel();

    public SplashBox() {
        super(BoxLayout.Y_AXIS);

        Dimension expectedDimension = new Dimension((int) (ScreenRes.WIDTH / 8),
                (int) (ScreenRes.HEIGHT / 8));
        localPanel.setPreferredSize(expectedDimension);
        localPanel.setMaximumSize(expectedDimension);
        localPanel.setMinimumSize(expectedDimension);
        localPanel.setLayout(new GridLayout(1, 4));
        localPanel.add(hPanel, 0);
        localPanel.add(uPanel, 1);
        localPanel.add(sPanel, 2);
        localPanel.add(tPanel, 3);

        this.add(Box.createVerticalGlue());
        this.add(localPanel);
        this.add(Box.createVerticalGlue());

        MyTask thread = new MyTask();
        thread.start();

        this.setVisible(true);
    }

    public class MyTask extends Thread {
        @Override
        public void run() {
            while (true)
                loop();
        }

        public void loop() {
            delay(1000);
            hPanel.turnBlack();
            uPanel.turnBlack();
            sPanel.turnBlack();
            tPanel.turnBlack();
            delay(500);
            hPanel.turnRed();
            delay(500);
            uPanel.turnRed();
            delay(500);
            sPanel.turnRed();
            delay(500);
            tPanel.turnRed();
        }

        public void delay(int time) {
            try {
                Thread.sleep(time);

            } catch (InterruptedException e) {
                System.out.print("Stack Trace: ");
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        JFrame SplashScreen = new JFrame();
        SplashBox tempBox = new SplashBox();

        SplashScreen.add(tempBox);

        SplashScreen.setTitle("Splash Screen");
        SplashScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        SplashScreen.setSize((int) (ScreenRes.WIDTH * 2 / 3), (int) (ScreenRes.HEIGHT * 2 / 3));
        SplashScreen.setLocationRelativeTo(null);
        SplashScreen.setResizable(false);
        SplashScreen.setVisible(true);
    }
}