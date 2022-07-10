// This class will be the model of dataset for all graph. It is supposed
// to recieves filters of graph and update the current graph displayed on 
// JFrame.

package controller;

import org.jfree.data.time.*;

import model.DataExtract;

public class DatasetGenerator extends TimeSeriesCollection {
    public DatasetGenerator(String[] countryNames, String category) {
        // Get the number of series, which is the number of country the graph should
        // plot.
        int numberOfCountries = countryNames.length;

        // With each country passed in as an array, create a TimeSerie and add data for
        // it.
        for (int i = 0; i < numberOfCountries; i++) {

            // Create a TimeSeries instance that store the data of the chart.
            TimeSeries countryTotalCases = new TimeSeries(countryNames[i]);

            // Create two arrays containing dates and data for the graph.
            Day dates[] = DataExtract.extractDay(countryNames[i]);
            double data[] = DataExtract.extractFigures(countryNames[i], category);

            // Since the number of elements of two arrays is equals, run a for loop and add
            // these elements as data for the plot.
            for (int j = 0; j < dates.length; j++) {
                countryTotalCases.add(dates[j], data[j]);
            }

            this.addSeries(countryTotalCases);
        }
    }
}
