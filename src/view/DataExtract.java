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

        // JPanel whitePanel = new JPanel();
        // whitePanel.setBackground(Palette.WHITE);
        // gbc.fill = GridBagConstraints.BOTH;
        // gbc.gridx = 0;
        // gbc.gridy = 0;
        // gbc.weightx = 0.25;
        // gbc.weighty = 1;
        // gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        // whitePanel.add(countrySelect);
        // this.add(whitePanel, gbc);

        // // Temporary panel to put components.
        // JPanel tempPanel = new JPanel();
        // tempPanel.setBackground(Palette.HUST_RED);
        // gbc.fill = GridBagConstraints.BOTH;
        // gbc.gridx = 1;
        // gbc.gridy = 0;
        // gbc.weightx = 0.75;
        // gbc.weighty = 1;
        // this.add(tempPanel, gbc);

        // Building essential panels
        JPanel countrySelectPanel = new JPanel();
        countrySelectPanel.setLayout(new BorderLayout());
        countrySelectPanel.add(countrySelect);
        countrySelectPanel.setBackground(Color.GREEN);

        JPanel whitePanel = new JPanel();
        whitePanel.setLayout(new GridLayout(20, 1));
        whitePanel.add(countrySelectPanel);
        whitePanel.add(countrySelectPanel);
        whitePanel.setBackground(Color.WHITE);

        JPanel redPanel = new JPanel();
        redPanel.setBackground(Color.RED);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0.25;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        this.add(whitePanel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0.75;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        this.add(redPanel, gbc);
    }

    public void initialize() {
        this.setVisible(true);
    }
}
