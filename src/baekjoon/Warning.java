package baekjoon;

import java.sql.Time;
import java.time.LocalTime;
import java.util.Scanner;

public class Warning {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String startTimeString = sc.next();
        String executeTimeString = sc.next();

        Time startTime = Time.valueOf(startTimeString);
        Time executeTime = Time.valueOf(executeTimeString);

        LocalTime startLocalTime = startTime.toLocalTime();
        LocalTime executeLocalTime = executeTime.toLocalTime();

        LocalTime waitTime = executeLocalTime.minusHours(startLocalTime.getHour())
                .minusMinutes(startLocalTime.getMinute())
                .minusSeconds(startLocalTime.getSecond());

        int hour = waitTime.getHour();
        int minute = waitTime.getMinute();
        int second = waitTime.getSecond();

        if (hour == 0 && minute == 0 && second == 0) {
            hour = 24;
        }

        System.out.printf("%02d:%02d:%02d", hour, minute, second);
        sc.close();
    }
}
