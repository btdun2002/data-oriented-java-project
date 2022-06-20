package test;

import tech.tablesaw.api.*;
import tech.tablesaw.columns.*;
import tech.tablesaw.plotly.Plot;
import tech.tablesaw.plotly.api.TimeSeriesPlot;

public class tableTest {
    public static Table covidTable = Table.read().csv("assets/data/output_covid_data.csv");
    public static Column<?> entitiesColumns = covidTable.column("location").unique();

    public static void main(String[] args) throws Exception {
        Table vie = covidTable.where(covidTable.stringColumn("location").equalsIgnoreCase("Vietnam"));
        Plot.show(TimeSeriesPlot.create("Vietnam new cases", vie, "date", "new_cases"));
    }
}
