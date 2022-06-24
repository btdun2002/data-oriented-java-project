package controller;

import java.util.StringTokenizer;

import org.jfree.data.time.Day;

public class DateGenerator {
    public static Day getDay(String date) {
        StringTokenizer st = new StringTokenizer(date, "-");
        int day = Integer.parseInt(st.nextToken());
        int month = Integer.parseInt(st.nextToken());
        int year = Integer.parseInt(st.nextToken());

        return new Day(day, month, year);
    }
}
