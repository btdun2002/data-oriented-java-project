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
        GridBagLayout gbl = new GridBagLayout();
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

        JPanel whitePanel = new JPanel();
        whitePanel.setBackground(Palette.WHITE);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.25;
        gbc.weighty = 1;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        whitePanel.add(countrySelect);
        this.add(whitePanel, gbc);

        // Temporary panel to put components.
        JPanel tempPanel = new JPanel();
        tempPanel.setBackground(Palette.HUST_RED);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 0.75;
        gbc.weighty = 1;
        this.add(tempPanel, gbc);

        // // Building essential panels
        // JPanel countrySelectPanel = new JPanel();
        // countrySelectPanel.setLayout(new BorderLayout());
        // countrySelectPanel.add(countrySelect);

        // JPanel whitePanel = new JPanel();
        // whitePanel.setBackground(Color.WHITE);

        // JPanel redPanel = new JPanel();
        // redPanel.setBackground(Color.RED);

        // // Set up the layout for the JFrame
        // AddPanel(countrySelectPanel, 0, 0, 1, 1, 0.0, 0.0);
        // AddPanel(whitePanel, 0, 1, 1, 1, 0.0, 0.0);
        // AddPanel(redPanel, 1, 0, 2, 2, 0.0, 0.0);

        // // Tuning the layout for the JFrame
        // gbl.columnWeights = new double[] { 0.33, 0.33, 0.66 };
        // gbl.rowWeights = new double[] { 0.01, 0.99, 1 };
    }

    public void AddPanel(JPanel panel, int gridx, int gridy, int gridwidth, int gridheight, double weightx,
            double weighty) {
        gbc.gridx = gridx;
        gbc.gridy = gridy;
        gbc.gridwidth = gridwidth;
        gbc.gridheight = gridheight;
        gbc.weightx = weightx;
        gbc.weighty = weighty;
        gbc.fill = GridBagConstraints.BOTH;
        this.add(panel, gbc);
    }

    public void initialize() {
        this.setVisible(true);
    }
}
