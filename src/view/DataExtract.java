package view;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.List;

import javax.swing.*;

import tech.tablesaw.columns.*;
import view.Util.*;

public class DataExtract extends JFrame implements ActionListener {
    private GridBagConstraints gbc = new GridBagConstraints();
    private JLabel selectedCountry = new JLabel("Chọn quốc gia: ");
    private JComboBox<String> countrySelect;

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
        countrySelect = new JComboBox<>(countries);
        countrySelect.addActionListener(this);

        // The container to store the JComboBox
        JPanel countrySelectPanel = new JPanel();
        countrySelectPanel.setLayout(new BorderLayout());
        countrySelectPanel.setPreferredSize(countrySelect.getPreferredSize());
        countrySelectPanel.add(countrySelect);
        countrySelectPanel.setBackground(Color.GREEN);

        // The white JPanel on the left hand side of the screen.
        JPanel whitePanel = new JPanel();
        whitePanel.setLayout(new GridLayout(20, 1));
        whitePanel.add(countrySelectPanel);
        whitePanel.setBackground(Color.WHITE);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        // Note that the side panel should be just enough large to store the JComboBox,
        // therefore it should occupies no extra space.
        gbc.weightx = 0;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.VERTICAL;
        this.add(whitePanel, gbc);

        // The graph, located in the right hand side.
        JPanel redPanel = new JPanel();
        redPanel.setBackground(Color.WHITE);
        redPanel.add(selectedCountry);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        this.add(redPanel, gbc);
    }

    public void initialize() {
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == countrySelect) {
            String selected = countrySelect.getSelectedItem().toString();
            selectedCountry.setText("Đang chọn: " + selected);
        }
    }
}
