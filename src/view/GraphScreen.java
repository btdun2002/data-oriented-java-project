package view;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.List;

import javax.swing.*;

import controller.*;
import model.DataExtract;
import model.DataFrame;
import tech.tablesaw.columns.*;
import view.Util.*;

public class GraphScreen extends JFrame implements ActionListener {
    private GridBagConstraints gbc = new GridBagConstraints();
    private JComboBox<String> countrySelect;
    private GraphGenerator graph = new GraphGenerator("Vietnam");

    public GraphScreen(File file) {
        super();
        this.setTitle("Data");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize((int) (ScreenRes.WIDTH * 2 / 3), (int) (ScreenRes.HEIGHT * 2 / 3));
        this.setLocationRelativeTo(null);
        this.setLayout(new GridBagLayout());
        this.setResizable(false);

        // Create dropdown box to select country. Get the list of all countries by
        // calling the DataExtract class.
        String[] countries = DataExtract.extractCountry();
        // With the created array, use it as elememnts in JComboBox.
        countrySelect = new JComboBox<>(countries);
        countrySelect.addActionListener(this);

        // The container to store the JComboBox
        JPanel countrySelectPanel = new JPanel();
        countrySelectPanel.setLayout(new BorderLayout());
        countrySelectPanel.setPreferredSize(countrySelect.getPreferredSize());
        countrySelectPanel.add(countrySelect);
        countrySelectPanel.setBackground(Color.GREEN);

        // The white JPanel on the left hand-side of the screen.
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

        // The graph on the right-hand side of the screen.
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        this.add(graph, gbc);
    }

    public void initialize() {
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == countrySelect) {
            String selected = countrySelect.getSelectedItem().toString();
        }
    }
}
