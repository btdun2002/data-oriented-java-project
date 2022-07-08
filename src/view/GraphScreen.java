package view;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.swing.*;

import controller.*;
import view.Util.*;
import view.components.graphFilter.*;

public class GraphScreen extends JFrame implements ActionListener {
    private GridBagConstraints gbc = new GridBagConstraints();
    private GraphGenerator graph = new GraphGenerator("Vietnam");

    public GraphScreen(File file) {
        super();
        this.setTitle("Data");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize((int) (ScreenRes.WIDTH * 2 / 3), (int) (ScreenRes.HEIGHT * 2 / 3));
        this.setLocationRelativeTo(null);
        this.setLayout(new GridBagLayout());
        this.setResizable(false);

        // The white JPanel on the left hand-side of the screen.
        TimeSeriesFilter2 filterPanel = new TimeSeriesFilter2();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        // Note that the side panel should be just enough large to store the JComboBox,
        // therefore it should occupies no extra space horizontally.
        gbc.weightx = 0;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.VERTICAL;
        this.add(filterPanel, gbc);

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
    }
}
