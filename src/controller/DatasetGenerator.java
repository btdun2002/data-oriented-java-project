// This class will be the model of dataset for all graph. It is supposed
// to recieves filters of graph and update the current graph displayed on 
// JFrame.

package controller;

import org.jfree.data.time.*;

import model.DataExtract;

public class DatasetGenerator extends TimeSeriesCollection {
    public DatasetGenerator(String countryName) {
        // Create a TimeSeries instance that store the data of the chart.
        TimeSeries countryTotalCases = new TimeSeries("Total cases");

        // Create two arrays containing dates and data for the graph.
        Day dates[] = DataExtract.extractDay(countryName);
        double data[] = DataExtract.extractFigures(countryName, "total_cases");

        // Since the number of elements of two arrays is equals, run a for loop and add
        // these elements as data for the plot.
        for (int i = 0; i < dates.length; i++) {
            countryTotalCases.add(dates[i], data[i]);
        }

        this.addSeries(countryTotalCases);
    }
}
