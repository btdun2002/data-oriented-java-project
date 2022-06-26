package test;

import java.awt.*;

import javax.swing.*;

import view.Util.*;

public class SplashBox extends Box {
    HUSTPanel hPanel = new HUSTPanel("assets/icons/H_red.png", "assets/icons/H_black.png",
            (int) (ScreenRes.WIDTH * 1 / 15), (int) (ScreenRes.HEIGHT * 1 / 15));
    HUSTPanel uPanel = new HUSTPanel("assets/icons/U_red.png", "assets/icons/U_black.png",
            (int) (ScreenRes.WIDTH * 1 / 15), (int) (ScreenRes.HEIGHT * 1 / 15));
    HUSTPanel sPanel = new HUSTPanel("assets/icons/S_red.png", "assets/icons/S_black.png",
            (int) (ScreenRes.WIDTH * 1 / 15), (int) (ScreenRes.HEIGHT * 1 / 15));
    HUSTPanel tPanel = new HUSTPanel("assets/icons/T_red.png", "assets/icons/T_black.png",
            (int) (ScreenRes.WIDTH * 1 / 15), (int) (ScreenRes.HEIGHT * 1 / 15));
    JPanel midPanel = new JPanel();

    public SplashBox() {
        super(BoxLayout.Y_AXIS);
        JPanel tempPanel = new JPanel();

        Dimension expectedDimension = new Dimension((int) (ScreenRes.WIDTH * 3 / 10),
                (int) (ScreenRes.HEIGHT * 3 / 10));
        tempPanel.setPreferredSize(expectedDimension);
        tempPanel.setMaximumSize(expectedDimension);
        tempPanel.setMinimumSize(expectedDimension);
        tempPanel.setLayout(new GridLayout(1, 4));
        tempPanel.add(hPanel);
        tempPanel.add(uPanel);
        tempPanel.add(sPanel);
        tempPanel.add(tPanel);

        this.add(Box.createVerticalGlue());
        this.add(tempPanel);
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
            delay(2000);
            hPanel.turnBlack();
            uPanel.turnBlack();
            sPanel.turnBlack();
            tPanel.turnBlack();
            delay(2000);
            hPanel.turnRed();
            delay(200);
            uPanel.turnRed();
            delay(200);
            sPanel.turnRed();
            delay(200);
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