

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Timer;
import java.util.TimerTask;

public class Test4 {
    public static void main(String[] args) {
        LocalDateTime examDateTime = LocalDateTime.of(2023, Month.JULY, 15, 9, 0);
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                LocalDateTime now = LocalDateTime.now();
                if (now.isAfter(examDateTime)) {
                    System.out.println("考试时间到！");
                    timer.cancel();
                } else {
                    long days = java.time.temporal.ChronoUnit.DAYS.between(now, examDateTime);
                    long hours = java.time.temporal.ChronoUnit.HOURS.between(now, examDateTime) % 24;
                    long minutes = java.time.temporal.ChronoUnit.MINUTES.between(now, examDateTime) % 60;
                    long seconds = java.time.temporal.ChronoUnit.SECONDS.between(now, examDateTime) % 60;
                    System.out.println("距离高考还有 " + days + " 天 " + hours + " 小时 " + minutes + " 分钟 " + seconds + " 秒");
                }
            }
        }, 0, 1000);
    }
}
