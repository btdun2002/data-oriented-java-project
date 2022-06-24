package test;

import java.awt.*;
import java.time.*;
import java.util.*;
import java.util.Timer;

import javax.swing.*;

import view.Util.*;

public class SplashScreen extends JFrame {
    LocalTime time;
    HUSTPanel hPanel = new HUSTPanel("assets/icons/H_red.png", "assets/icons/H_black.png",
            (int) (ScreenRes.WIDTH * 1 / 8), (int) (ScreenRes.HEIGHT * 1 / 8));
    HUSTPanel uPanel = new HUSTPanel("assets/icons/U_red.png", "assets/icons/U_black.png",
            (int) (ScreenRes.WIDTH * 1 / 8), (int) (ScreenRes.HEIGHT * 1 / 8));
    HUSTPanel sPanel = new HUSTPanel("assets/icons/S_red.png", "assets/icons/S_black.png",
            (int) (ScreenRes.WIDTH * 1 / 8), (int) (ScreenRes.HEIGHT * 1 / 8));
    HUSTPanel tPanel = new HUSTPanel("assets/icons/T_red.png", "assets/icons/T_black.png",
            (int) (ScreenRes.WIDTH * 1 / 8), (int) (ScreenRes.HEIGHT * 1 / 8));

    public SplashScreen() {
        this.setLayout(new GridLayout(1, 4));
        hPanel.setBackground(Color.GREEN);
        uPanel.setBackground(Color.BLUE);
        sPanel.setBackground(Color.CYAN);
        tPanel.setBackground(Color.GRAY);

        this.add(hPanel);
        this.add(uPanel);
        this.add(sPanel);
        this.add(tPanel);

        Timer timer = new Timer();
        TimerTask task = new MyTask();
        timer.schedule(task, 0, 1000);

        this.setTitle("Splash Screen");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize((int) (ScreenRes.WIDTH * 2 / 3), (int) (ScreenRes.HEIGHT * 2 / 3));
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);

    }

    public class MyTask extends TimerTask {
        public void run() {
            time = LocalTime.now(ZoneId.systemDefault());
            hPanel.turnBlack();
            uPanel.turnBlack();
            sPanel.turnBlack();
            tPanel.turnBlack();
            hPanel.turnRed();
            uPanel.turnRed();
            sPanel.turnRed();
            tPanel.turnRed();
        }
    }

    public static void main(String[] args) {
        new SplashScreen();
    }
}