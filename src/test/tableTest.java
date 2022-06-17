package test;

import tech.tablesaw.api.Table;

public class tableTest {

    public static void main(String[] args) throws Exception {
        Table covidTable = Table.read().csv("assets/data/output_covid_data.csv");
        System.out.println(covidTable.structure());
    }
}
