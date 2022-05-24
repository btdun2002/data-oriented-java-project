package view;

import java.awt.*;
import java.io.*;

import javax.swing.*;

import view.Util.*;

public class DataExtract extends JFrame {
    String file = null;
    String line = "";

    public DataExtract(File file) {
        super();
        this.setTitle("Data");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize((int) (ScreenRes.width() * 2 / 3), (int) (ScreenRes.height() * 2 / 3));
        this.setLocationRelativeTo(null);
        this.setLayout(new GridBagLayout());
        this.setResizable(false);

        this.file = file.toString();

        // if (this.file == null) {
        // this.dispose();
        // }

        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                String row[] = line.split(",");
                for (String index : row) {
                    System.out.printf("%-10s", index);
                }
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public void initialize() {
        this.setVisible(true);
    }
}
