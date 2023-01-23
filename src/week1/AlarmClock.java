// package week1

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AlarmClock {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        // Take in alarm time
        String[] s = in.readLine().split(" ");
        int alarmHour = Integer.parseInt(s[0]);
        int alarmMinute = Integer.parseInt(s[1]);

        // Take in wake up times
        boolean falseAlarm = true;
        int falseAlarmCount = -1;
        while(falseAlarm) {
            s = in.readLine().split(" ");
            int wakeHour = Integer.parseInt(s[0]);
            int wakeMinute = Integer.parseInt(s[1]);

            // Skip bogus numbers
            if(wakeHour > 24 || wakeMinute > 60) continue;

            // Check if the wake time is before the alarm
            if(alarmHour < wakeHour) falseAlarm = false;
            else if(alarmHour == wakeHour && alarmMinute <= wakeMinute) falseAlarm = false;

            // Increase the false alarm count
            falseAlarmCount++;
        }

        System.out.println("false alarms: " + falseAlarmCount);
    }
}
