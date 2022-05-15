package com.time;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

/**
 * @author dongwei
 * 2018/8/22 9:28
 **/
public class TimeTest {

    public static long generateSpecifyTime(int days, int hour, int minute, int second, int millisecond) {
        Calendar calendar = new GregorianCalendar();
        // reset seconds and millis
        calendar.add(Calendar.DAY_OF_MONTH, days);
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);
        calendar.set(Calendar.SECOND, second);
        calendar.set(Calendar.MILLISECOND, millisecond);
        return calendar.getTimeInMillis();
    }

    /*
     * 将时间转换为时间戳
     */
    public static String dateToStamp(String s) throws ParseException {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = simpleDateFormat.parse(s);
        long ts = date.getTime();
        res = String.valueOf(ts);
        return res;
    }
    public static long dateToStamp2(String s) throws ParseException {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = simpleDateFormat.parse(s);
        long ts = date.getTime();
        return ts;
    }

    /*
     * 将时间戳转换为时间
     */
    public static String stampToDate(String s){
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long lt = new Long(s);
        Date date = new Date(lt);
        res = simpleDateFormat.format(date);
        return res;
    }

    @Test
    public void getHourAndMinute() throws Exception{
        Calendar calendar = new GregorianCalendar();


        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        calendar.setTime(simpleDateFormat.parse("2021-08-23 09:20:20"));

        System.out.println(calendar.get(Calendar.HOUR_OF_DAY));
        System.out.println(calendar.get(Calendar.MINUTE));

    }

    @Test
    public void getStartTime() {
        String dateFormat = "HHmm";
        String originTime = "01" + (new Random().nextInt(59 - 10) + 10);
        Duration period = Duration.ofDays(1);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
        long startTime = 0;
        try {
            startTime = simpleDateFormat.parse(originTime).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println("currentTime:"+ System.currentTimeMillis() +", startTime:" + startTime);
        if (System.currentTimeMillis() > startTime) {
            startTime = startTime + (((System.currentTimeMillis() - startTime) / period.toMillis() + 1) * period.toMillis());
        }
        System.out.println("delay time:"+Duration.ofMillis(startTime - System.currentTimeMillis()).toMillis());
    }

    public static void main(String[] args) throws ParseException{
//        long time1 = dateToStamp2("2018-08-22 09:20:20");
//        long time2 = dateToStamp2("2018-08-22 09:22:20");
//        Long s = (time2 - time1) / (1000 * 60);
//        System.out.println(s);
//
//        String resultStamp=stampToDate("150512533500");
//        System.out.println(resultStamp);
//
//        System.out.println("current stamp:"+System.currentTimeMillis());
//
//        System.out.println("require stamp:"+dateToStamp2("2018-08-23 11:40:20"));
        System.out.println(generateSpecifyTime(-12, 0,0,0,0));

    }
}
