package test;

import java.util.List;

import tech.tablesaw.api.*;
import tech.tablesaw.columns.*;

public class tableTest {
    public static Table covidTable = Table.read().csv("assets/data/output_covid_data.csv");
    public static Column<?> entitiesColumns = covidTable.column("location").unique();

    public static void main(String[] args) throws Exception {
        entitiesColumns.sortAscending();
        List<?> entites = entitiesColumns.asList();
        String countries[] = new String[entites.size()];
        countries = entites.toArray(countries);

        for (int i = 0; i < entites.size(); i++) {
            System.out.println(countries[i]);
        }
    }
}
