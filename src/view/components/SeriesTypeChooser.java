// The JPanel that hold radio buttons to choose the type of data that will
// be presented on the time series chart.
package view.components;

import javax.swing.*;
import java.awt.*;

import view.components.buttons.*;

public class SeriesTypeChooser extends JPanel {
    private ButtonGroup bg = new ButtonGroup();

    public SeriesTypeChooser(String[] categories) {
        super();
        this.setLayout(new GridLayout(categories.length, 1));

        for (int i = 0; i < categories.length; i++) {
            CustomRadioButton newOption = new CustomRadioButton(categories[i]);
            bg.add(newOption);
            this.add(newOption);
        }
    }
}
