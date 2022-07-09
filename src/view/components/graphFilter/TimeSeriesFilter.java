// The panel on the left-hand side of the screen serves as the filter to customize 
// the time series chart.
package view.components.graphFilter;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

import model.*;
import view.Util.Palette;
import view.components.buttons.*;

public class TimeSeriesFilter extends JPanel implements ActionListener {
    // Extract data/informations needed for the panel.
    private String[] countries = DataExtract.extractCountry();
    private String[] categories = DataExtract.extractCategories();

    // Components.
    private CheckComboPanel countrySelect;
    private ColoredButton filterBtn = new ColoredButton("Áp dụng");
    private ColoredButton clearFilterBtn = new ColoredButton("Xóa bộ lọc");
    private ButtonGroup bg = new ButtonGroup();
    ArrayList<CustomRadioButton> graphOptions = new ArrayList<CustomRadioButton>(categories.length);

    public TimeSeriesFilter() {
        super();
        this.setLayout(new GridLayout(3 + categories.length, 1));
        this.setBackground(Palette.WHITE);

        // Create a Combobox with checkbox by calling the CheckComboPanel class with
        // list of countries obtained from DataExtract class.
        this.countrySelect = new CheckComboPanel(countries);
        this.add(countrySelect);

        // Create JRadioButton serves as filter for the type of data the graph will
        // represent.
        for (int i = 0; i < categories.length; i++) {
            graphOptions.add(new CustomRadioButton(categories[i]));
            bg.add(graphOptions.get(i));
            this.add(graphOptions.get(i));
        }

        clearFilterBtn.addActionListener(this);
        this.add(clearFilterBtn);

        filterBtn.addActionListener(this);
        this.add(filterBtn);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == filterBtn) {
            countrySelect.updateSelected();
            System.out.println(countrySelect.selectedItems);
            for (int i = 0; i < categories.length; i++) {
                if (graphOptions.get(i).isSelected()) {
                    System.out.println(graphOptions.get(i).getText());
                }
            }
        }

        if (e.getSource() == clearFilterBtn) {
            countrySelect.reset();
            bg.clearSelection();
        }
    }
}