package Customize;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

/**
 * Created by zengyouzu on 2019/8/20.
 */
public class DataGenerate {

    public static String RandomStringNo() {
        Random random = new Random();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 1; i <= 23; i++) {
            int randomNum = random.nextInt(9);
            String num = randomNum + "";
            stringBuffer = stringBuffer.append(num);
        }

        String str = String.valueOf(stringBuffer);
        return str;
    }

    public static String TraceLogId() {
        String traceLogId = UUID.randomUUID().toString().replace("-", "");
        return traceLogId;
    }

    public static Date StartEnd = Date.from(LocalDateTime.now(ZoneOffset.ofHours(8)).minusDays(8).withHour(23).withMinute(59).withSecond(59).toInstant(ZoneOffset.ofHours(8)));
    public static Date EndStart = Date.from(LocalDateTime.now(ZoneOffset.ofHours(8)).plusDays(8).withHour(0).withMinute(0).withSecond(0).toInstant(ZoneOffset.ofHours(8)));
    public static Date Start = Date.from(LocalDateTime.now(ZoneOffset.ofHours(8)).minusDays(10).withHour(0).withMinute(0).withSecond(0).toInstant(ZoneOffset.ofHours(8)));
    public static Date End = Date.from(LocalDateTime.now(ZoneOffset.ofHours(8)).plusDays(10).withHour(23).withMinute(59).withSecond(59).toInstant(ZoneOffset.ofHours(8)));
    public static String ActivityStart = new SimpleDateFormat("yyyyMMdd").format(Start);
    public static String ActivityEnd = new SimpleDateFormat("yyyyMMdd").format(End);
    public static String DayStart = new SimpleDateFormat("HHmmss").format(Start);
    public static String DayEnd = new SimpleDateFormat("HHmmss").format(End);
    public static String StartTime = new SimpleDateFormat("yyyyMMddHHmmss").format(Start);
    public static String EndTime = new SimpleDateFormat("yyyyMMddHHmmss").format(End);
    public static Date now = new Date();
    public static String sdf = new SimpleDateFormat("yyyyMMddHHmmss").format(now);
}
