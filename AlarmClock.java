import java.time.LocalTime;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.util.Scanner;

public class AlarmClock implements Runnable {

    private final LocalTime alarmTime;
    private final String filePath;
    private final Scanner scanner;

    
    public AlarmClock(LocalTime alarmTime, String filePath, Scanner scanner) {
        this.alarmTime = alarmTime;
        this.filePath = filePath;
        this.scanner = scanner;
    }

    @Override
    public void run() {

        while (true) {
            LocalTime now = LocalTime.now();

            System.out.printf(
                "\r%02d:%02d:%02d",
                now.getHour(),
                now.getMinute(),
                now.getSecond()
            );

            if (!now.isBefore(alarmTime)) {
                break;
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                return;
            }
        }

        System.out.println("\n ALARM RINGING ");
        playSoundUntilEnter();
    }

    private void playSoundUntilEnter() {
        try {
            File audioFile = new File(filePath);

            AudioInputStream audioStream =
                    AudioSystem.getAudioInputStream(audioFile);

            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.loop(Clip.LOOP_CONTINUOUSLY);

            System.out.println(" Press ENTER to stop the alarm");
            scanner.nextLine();

            clip.stop();
            clip.close();
            audioStream.close();

            System.out.println(" Alarm stopped");

        } catch (Exception e) {
            System.out.println("Error playing sound: " + e.getMessage());
        }
    }
}
