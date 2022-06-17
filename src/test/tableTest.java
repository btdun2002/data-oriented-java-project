package test;

import tech.tablesaw.api.DoubleColumn;
import tech.tablesaw.api.Table;

public class tableTest {

    public static void main(String[] args) throws Exception {
        double[] numbers = { 1, 2, 3, 4 };
        try {

            DoubleColumn nc = DoubleColumn.create("nc", numbers);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
