import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    

    
    public static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("hh:mm:ss a", Locale.ENGLISH);

        LocalTime alarmTime = null;

        String filePath =
            "D:\\JAVA_ALARM_CLOCK\\Samsung alarm homecoming  alarmringtone  smartphone  ringtone  samsung  homecoming  alarm - Eshaal Khan The Letter A.wav";

        while (alarmTime == null) {
            try {
                System.out.print("Enter alarm time (hh:mm:ss AM/PM): ");

                String inputTime = SCANNER.nextLine().trim().toUpperCase();
                alarmTime = LocalTime.parse(inputTime, formatter);

                if (alarmTime.isBefore(LocalTime.now())) {
                    alarmTime = alarmTime.plusHours(24);
                }

                System.out.println("Alarm set for " + inputTime);

            } catch (DateTimeParseException e) {
                System.out.println(" Invalid format. Example: 02:12:00 PM");
            }
        }

        AlarmClock alarmClock =
                new AlarmClock(alarmTime, filePath, SCANNER);

        Thread alarmThread = new Thread(alarmClock);
        alarmThread.start();

        try {
            alarmThread.join(); 
        } catch (InterruptedException ignored) {}

        
        SCANNER.close();

    }
}
