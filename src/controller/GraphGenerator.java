// The class used for plotting graph. Currently only plot for new positive cases 
// in countries is graphed. Internally it will be a JPanel that holds the graph 
// and will be placed in different JFrames.

package controller;

import javax.swing.*;

import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;

import java.awt.*;

import view.Util.*;

public class GraphGenerator extends JPanel {
    private GridBagConstraints gbc = new GridBagConstraints();

    public GraphGenerator(String[] countryName, String category) {
        super();
        this.setLayout(new GridBagLayout());

        // BELOW IS THE DEMO VERSION FROM INTERNET. REPLACE WITH THE REAL LATER.
        // Create dataset
        TimeSeriesCollection dataset = new DatasetGenerator(countryName, category);
        // Create chart
        JFreeChart chart = ChartFactory.createTimeSeriesChart(
                category, // Chart
                "Date", // X-Axis Label
                "Number", // Y-Axis Label
                dataset, true, true, false);

        // Changes background color
        XYPlot plot = (XYPlot) chart.getPlot();
        plot.setBackgroundPaint(Palette.LIGHT_GRAY);
        // Vertical grid color
        plot.setDomainGridlinePaint(Palette.WHITE);
        // Horizontal grid color
        plot.setRangeGridlinePaint(Palette.WHITE);

        // Renders line graph
        XYLineAndShapeRenderer r1 = new XYLineAndShapeRenderer();
        // Changes line color
        r1.setSeriesPaint(0, Palette.NINE_LINE_COLOR[8]);
        // Hide the square dots
        r1.setSeriesShapesVisible(0, false);
        // Strokes line
        r1.setSeriesStroke(0, new BasicStroke(1.5f));
        plot.setRenderer(0, r1);

        ChartPanel panel = new ChartPanel(chart);
        this.setBackground(Color.GREEN);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1;
        gbc.weighty = 1;
        this.add(panel, gbc);
    }
}
