package view;

import java.awt.*;
import javax.swing.*;

import model.DataExtract;
import view.Util.ScreenRes;
import view.components.*;

public class TimeSeriesFilter extends JFrame {
    private GridBagConstraints gbc = new GridBagConstraints();
    private CheckComboPanel countrySelect;

    public TimeSeriesFilter() {
        super();
        this.setTitle("Time series filter");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize((int) (ScreenRes.WIDTH * 2 / 3), (int) (ScreenRes.HEIGHT * 2 / 3));
        this.setLocationRelativeTo(null);
        this.setLayout(new GridBagLayout());
        this.setResizable(false);

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
        gbc.fill = GridBagConstraints.VERTICAL;
        this.add(countrySelect, gbc);
    }

    public void initialize() {
        this.setVisible(true);
    }
}
