import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;

public class Main {
    public static void main(String[] args) {
        Clock.run();
    }
}
@SuppressWarnings({"CallToPrintStackTrace", "deprecation"})
class Clock {
    public static void run() {
        Runtime r = Runtime.getRuntime();
        var aksam = LocalTime.of(22, 0, 0);
        var sabah = LocalTime.of(7, 0, 0);
        var hourtrue = LocalTime.now().getHour();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH");

        try {
            if (LocalTime.now().isAfter(aksam) || LocalTime.now().isBefore(sabah)) {
                System.out.println("Bilgisayar Kapanıyor..");
                Thread.sleep(3000);

                r.exec("shutdown -s -t 0");
            } else
                System.out.println("geçersiz saat girildi");

        } catch (IOException e) {
            e.printStackTrace();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
    



