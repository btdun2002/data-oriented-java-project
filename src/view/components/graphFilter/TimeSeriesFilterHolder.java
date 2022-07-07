package view.components.graphFilter;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import model.*;
import view.TimeSeriesFilter;
import view.Util.Palette;
import view.components.*;

public class TimeSeriesFilterHolder extends JPanel implements ActionListener {
    private GridBagConstraints gbc = new GridBagConstraints();
    private CheckComboPanel countrySelect;
    private ColoredButton filterBtn = new ColoredButton("Bộ lọc");

    public TimeSeriesFilterHolder() {
        super();
        this.setLayout(new GridBagLayout());
        this.setBackground(Palette.WHITE);

        // Create a Combobox with checkbox by calling the CheckComboPanel class with
        // list of countries obtained from DataExtract class.
        String[] countries = DataExtract.extractCountry();
        this.countrySelect = new CheckComboPanel(countries);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.fill = GridBagConstraints.BOTH;
        this.add(countrySelect, gbc);

        JPanel greenPanel = new JPanel();
        greenPanel.setBackground(Color.GREEN);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        this.add(greenPanel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0;
        gbc.weighty = 0;
        filterBtn.addActionListener(this);
        this.add(filterBtn, gbc);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == filterBtn) {
            TimeSeriesFilter filterScreen = new TimeSeriesFilter();
            filterScreen.initialize();
        }
    }
}
