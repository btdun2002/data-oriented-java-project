// The class used for plotting graph. Currently only plot for new positive cases 
// in countries is graphed. Internally it will be a JPanel that holds the graph 
// and will be placed in different JFrames.

package controller;

import javax.swing.*;

import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import org.jfree.data.time.TimeSeriesCollection;

import java.awt.*;

public class GraphGenerator extends JPanel {
    private GridBagConstraints gbc = new GridBagConstraints();

    public GraphGenerator(String countryName) {
        this.setLayout(new GridBagLayout());

        // BELOW IS THE DEMO VERSION FROM INTERNET. REPLACE WITH THE REAL LATER.
        // Create dataset
        TimeSeriesCollection dataset = new DatasetGenerator(countryName);
        // Create chart
        JFreeChart chart = ChartFactory.createTimeSeriesChart(
                countryName, // Chart
                "Date", // X-Axis Label
                "Number", // Y-Axis Label
                dataset, true, true, false);

        // Changes background color
        XYPlot plot = (XYPlot) chart.getPlot();
        plot.setBackgroundPaint(new Color(255, 228, 196));

        ChartPanel panel = new ChartPanel(chart);
        this.setBackground(Color.GREEN);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1;
        gbc.weighty = 1;
        this.add(panel, gbc);
    }
}
