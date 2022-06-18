package view;

import java.awt.*;
import java.io.*;
import java.util.List;

import javax.swing.*;

import tech.tablesaw.columns.*;
import view.Util.*;

public class DataExtract extends JFrame {
    private GridBagConstraints gbc = new GridBagConstraints();

    public DataExtract(File file) {
        super();
        this.setTitle("Data");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize((int) (ScreenRes.WIDTH * 2 / 3), (int) (ScreenRes.HEIGHT * 2 / 3));
        this.setLocationRelativeTo(null);
        this.setLayout(new GridBagLayout());
        this.setResizable(false);

        // Create dropdown box to select country. Get the column containing all
        // geographical entities and sort it based on letters.
        Column<?> entitiesColumns = DataFrame.df.column("location").unique();
        entitiesColumns.sortAscending();
        // Convert the Column to List.
        List<?> entites = entitiesColumns.asList();
        // Allocate memory for a string array and convert the List to array.
        String countries[] = new String[entites.size()];
        countries = entites.toArray(countries);
        // With the created array, use it as elememnts in JComboBox.
        JComboBox<String> countrySelect = new JComboBox<>(countries);
        gbc.gridx = 0;
        gbc.gridy = 0;
        this.add(countrySelect);

        // Temporary panel to put components.
        JPanel tempPanel = new JPanel();
        tempPanel.setBackground(Palette.HUST_RED);
        gbc.gridx = 1;
        gbc.gridy = 0;
        tempPanel.setPreferredSize(new Dimension((int) (ScreenRes.WIDTH * (1 / 6)), (int) (ScreenRes.HEIGHT * 2 / 3)));
        this.add(tempPanel);
    }

    public void initialize() {
        this.setVisible(true);
    }
}
