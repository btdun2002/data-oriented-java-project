// This method will read from the dataframe (Tablesaw Table) and return array as the 
// desired collections of values for graph's axis.
package model;

import java.util.*;

import org.jfree.data.time.*;

import controller.DateGenerator;
import tech.tablesaw.api.*;

public class DataExtract {
    // The extractDay() method returns list of all Day object i.e. all data from the
    // `date` column.
    public static Day[] extractDay(String country) {
        // Parse the sub-table that only contains entries of the specified country.
        Table dateTable = DataFrame.df.where(DataFrame.df.stringColumn("location").equalsIgnoreCase(country));

        // Load dates of a country and store in a String array.
        StringColumn dateCol = (StringColumn) dateTable.column("date");
        String dateArray[] = dateCol.asObjectArray();

        // For each element in the String array, use the DateGenerator.getDay() method
        // to covert it into a Day object and store in an array of objects.
        Day date[] = new Day[dateArray.length];
        for (int i = 0; i < dateArray.length; i++) {
            date[i] = DateGenerator.getDay(dateArray[i]);
        }

        return date;
    }

    // The extractCountry() method returns list of all contries from data i.e. all
    // unique entries of the `location` column.
    public static String[] extractCountry() {
        // Load geographical entities and sort it based on letters by selecting all
        // unique values of the location column.
        StringColumn entitiesColumns = (StringColumn) DataFrame.df.column("location").unique();
        entitiesColumns.sortAscending();

        // Parse the data as an array of String objects.
        String countries[] = entitiesColumns.asObjectArray();

        return countries;
    }

    // The extractFigures() method retruns list of doubles as data for different
    // categories
    // i.e. different columns.
    public static double[] extractFigures(String country, String category) {
        // Parse the sub-table that only contains entries of the specified country.
        Table choosenCountry = DataFrame.df.where(DataFrame.df.stringColumn("location").equalsIgnoreCase(country));

        // Load the column containing data based on the specified category.
        NumberColumn<?, ?> categoryColumn = (NumberColumn<?, ?>) choosenCountry.column(category);

        // Parse the data as an array of doubles. Note that since the
        // JFreeChart requires data to be in double, therefore it will be convert to
        // double.
        double data[] = categoryColumn.asDoubleArray();

        return data;
    }

    // The extractCategories() method returns list of String of all column name that
    // can be used to draw specific graph. This means it exclude columns that
    // required for all graph such as `location` or `date`.
    public static String[] extractCategories() {
        // Get all columns and convert it from List to String array.
        List<String> tempList = DataFrame.df.columnNames();
        String[] columnNames = new String[tempList.size()];
        tempList.toArray(columnNames);

        // Get only last 9 items in the array.
        String[] categories = Arrays.copyOfRange(columnNames, 4, 13);
        return categories;
    }
}
