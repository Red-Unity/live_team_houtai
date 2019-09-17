package com.live.liveteam.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具类
 *
 * @author NL
 */
public class DateUtils {


    // 日期格式化
    public final static SimpleDateFormat sd = new SimpleDateFormat("yy");
    public final static SimpleDateFormat sdfy = new SimpleDateFormat("yyyy");
    public final static SimpleDateFormat sdfym = new SimpleDateFormat("yyyy-MM");
    public final static SimpleDateFormat sdfymd = new SimpleDateFormat("yyyy-MM-dd");
    public final static SimpleDateFormat sdfymdhms = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public final static SimpleDateFormat sdfymdhms2 = new SimpleDateFormat("yyyyMMddHHmmss");
    public final static SimpleDateFormat sdfymdhms3 = new SimpleDateFormat("yyyyMMdd");
    public final static SimpleDateFormat sdfymd2= new SimpleDateFormat("yyyy.MM.dd");
    public final static SimpleDateFormat sdfymdh4 = new SimpleDateFormat("yyyyMMddHH");
    public final static SimpleDateFormat sdfmdh = new SimpleDateFormat("MM/dd HH:mm");
    public final static SimpleDateFormat sdfhms = new SimpleDateFormat("MM/dd HH:mm:ss");



    /**
     * 时间格式(yyyy-MM-dd)
     */
    public final static String DATE_PATTERN = "yyyy-MM-dd";
    /**
     * 时间格式(yyyy-MM-dd HH:mm:ss)
     */
    public final static String DATE_TIME_PATTERN = "yyyyMMddHHmmss";


    public static String dateFormatStr(Integer longDate){
        Date date = new Date();
        date.setTime(longDate*1000L);
        return DateUtils.sdfymdhms.format(date);
    }


    /**
     * 获取当前秒的时间戳
     *
     * @return
     */
    public static Integer getTimeStamp() {
        Long time = Calendar.getInstance().getTimeInMillis() / 1000;
        return time.intValue();
    }

    /**
     * 获取下一个整点剩余秒
     *
     * @return
     */
    public static long getTheNextWholeTimeStamp() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.HOUR_OF_DAY, 1);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        long time = cal.getTimeInMillis()/1000 - Calendar.getInstance().getTimeInMillis()/1000;
        return time;
    }

    /**
     * 获取明天0点剩余秒
     *
     * @return
     */
    public static long getTheRemainingSecondsOfTomorrow() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH,1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        long time = cal.getTimeInMillis()/1000 - Calendar.getInstance().getTimeInMillis()/1000;
        return time;
    }

    /**
     * 获取日期示例
     */
    public static void DateAcquisition() {
        System.out.println("-----时间获取-----");
        Calendar cal = Calendar.getInstance();
        System.out.println("获取当前时间:" + sdfymdhms.format(cal.getTime()));
        System.out.println("获取当前时间戳:" + cal.getTimeInMillis());
        System.out.println("获取当前是一年中第几天:" + cal.get(Calendar.DAY_OF_YEAR));
        System.out.println("获取当前年:" + cal.get(Calendar.YEAR));
        System.out.println("获取当前月:" + (cal.get(Calendar.MONTH) + 1));
        System.out.println("获取当前日:" + cal.get(Calendar.DAY_OF_MONTH));
        System.out.println("获取当前周:" + (cal.get(Calendar.DAY_OF_WEEK) - 1));
        System.out.println("获取当前时:" + cal.get(Calendar.HOUR_OF_DAY));
        System.out.println("获取当前分:" + cal.get(Calendar.MINUTE));
        System.out.println("获取当前秒:" + cal.get(Calendar.SECOND));
        System.out.println("获取当前毫秒:" + cal.get(Calendar.MILLISECOND));
    }

    /**
     * 获取当前周数
     */
    public  static int dayOfWeek(){
        Calendar cal = Calendar.getInstance();
        int tmp=cal.get(Calendar.DAY_OF_WEEK)-1;
        if (0 == tmp) {
            tmp = 7;
        }
        return tmp;
    }
    /**
     * 获取当前小时数
     */
    public  static int hourOfDay(){
        Calendar cal = Calendar.getInstance();
        return cal.get(Calendar.HOUR_OF_DAY);
    }
    /**
     * 时间加减操作
     */
    public static void DateAdditionAndSubtraction() {
        Calendar cal = Calendar.getInstance();
        System.out.println("-----时间加减-----");
        System.out.println("时间加减方法:cal.addAddress(Calendar.函数, 负数/正数);/n例如:");
        cal.add(Calendar.YEAR, 1);
        System.out.println("加一年后的日期:" + sdfymdhms.format(cal.getTime()));
        cal.add(Calendar.YEAR, -1);
        System.out.println("减一年后的日期:" + sdfymdhms.format(cal.getTime()));
        cal.add(Calendar.MONTH, 1);
        System.out.println("加一月后的日期:" + sdfymdhms.format(cal.getTime()));
        cal.add(Calendar.MONTH, -1);
        System.out.println("减一月后的日期:" + sdfymdhms.format(cal.getTime()));
        //加指定天数
        cal.setTimeInMillis(1542889039000L);
        cal.add(Calendar.DAY_OF_MONTH,2);
        System.out.println("加2天后的日期:" + sdfymdhms.format(cal.getTime()));
    }

    /**
     * @Function 时间加减操作
     * @author   likaixuan
     * @Date     2018-11-22 20:29
     * @param    [intTime, day]
     * @return   void
     */
    public static int dateAdditionAndSubtraction(int intTime,int day) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(intTime*1000L);
        cal.add(Calendar.DAY_OF_MONTH,day);
        System.out.println("加2天后的日期:" + sdfymdhms.format(cal.getTime()));
        return (int)(cal.getTimeInMillis()/1000);
    }

    /**
     * 获取某(年/月/周/日)最小或最大日期
     *
     * @param cal  日期:如果为当前填写:Calendar.getInstance()
     * @param ymwd 填写(y:年;m:月;w:周;d:日)
     * @param size 填写(0:最小;1:最大)
     * @return
     */
    public static Date DayMaxTime(Calendar cal, String ymwd, int size) {
        if (ymwd.equals("y")) {
            if (size == 0) {
                cal.set(Calendar.MONTH, 0);
                cal.set(Calendar.DAY_OF_MONTH, 1);
                cal.set(Calendar.HOUR_OF_DAY, 0);
                cal.set(Calendar.MINUTE, 0);
                cal.set(Calendar.SECOND, 0);
            } else {
                cal.set(Calendar.MONTH, 11);
                cal.set(Calendar.DAY_OF_MONTH, 31);
                cal.set(Calendar.HOUR_OF_DAY, 23);
                cal.set(Calendar.MINUTE, 59);
                cal.set(Calendar.SECOND, 59);
            }
        } else if (ymwd.equals("m")) {
            if (size == 0) {
                cal.set(Calendar.DAY_OF_MONTH, 1);
                cal.set(Calendar.HOUR_OF_DAY, 0);
                cal.set(Calendar.MINUTE, 0);
                cal.set(Calendar.SECOND, 0);
            } else {
                cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
                cal.set(Calendar.HOUR_OF_DAY, 23);
                cal.set(Calendar.MINUTE, 59);
                cal.set(Calendar.SECOND, 59);
            }
        } else if (ymwd.equals("w")) {
            if (size == 0) {
                cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
                cal.set(Calendar.HOUR_OF_DAY, 0);
                cal.set(Calendar.MINUTE, 0);
                cal.set(Calendar.SECOND, 0);
            } else {
                cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
                cal.add(Calendar.DAY_OF_MONTH, 6);
                cal.set(Calendar.HOUR_OF_DAY, 23);
                cal.set(Calendar.MINUTE, 59);
                cal.set(Calendar.SECOND, 59);
            }
        } else if (ymwd.equals("d")) {
            if (size == 0) {
                cal.set(Calendar.HOUR_OF_DAY, 0);
                cal.set(Calendar.MINUTE, 0);
                cal.set(Calendar.SECOND, 0);
            } else {
                cal.set(Calendar.HOUR_OF_DAY, 23);
                cal.set(Calendar.MINUTE, 59);
                cal.set(Calendar.SECOND, 59);
            }
        }
        return cal.getTime();
    }

    /**
     *当月第一天 秒
     * @return
     * @throws Exception
     */
    public static Long getMonthFirst() {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        //设置为1号,当前日期既为本月第一天
        c.set(Calendar.DAY_OF_MONTH, 1);
        //将小时至0
        c.set(Calendar.HOUR_OF_DAY, 0);
        //将分钟至0
        c.set(Calendar.MINUTE, 0);
        //将秒至0
        c.set(Calendar.SECOND,0);
        //将毫秒至0
        c.set(Calendar.MILLISECOND, 0);
        // 获取本月第一天的时间戳
        return c.getTimeInMillis()/1000;
    }
    /**
     *次月第一天 秒
     * @return
     * @throws Exception
     */
    public static Long getNextMonthFirst()  {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());

        //设置为1号,当前日期既为当月第一天
        c.set(Calendar.DAY_OF_MONTH, 1);
        //日期加一个月
        c.add(Calendar.MONTH, 1);
        //将小时至0
        c.set(Calendar.HOUR_OF_DAY, 0);
        //将分钟至0
        c.set(Calendar.MINUTE, 0);
        //将秒至0
        c.set(Calendar.SECOND,0);
        //将毫秒至0
        c.set(Calendar.MILLISECOND, 0);
        // 获取本月第一天的时间戳
        return c.getTimeInMillis()/1000;
    }

    /**
     *当月最后一天 秒
     * @return
     * @throws ParseException
     */
    public static Long getMonthLast()  {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        //设置为当月最后一天
        c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
        //将小时至23
        c.set(Calendar.HOUR_OF_DAY, 23);
        //将分钟至59
        c.set(Calendar.MINUTE, 59);
        //将秒至59
        c.set(Calendar.SECOND,59);
        //将毫秒至999
        c.set(Calendar.MILLISECOND, 999);
        // 获取本月最后一天的时间戳
        return c.getTimeInMillis()/1000;
    }

    /**
     *上月第一天 秒
     * @return
     * @throws Exception
     */
    public static Long getPrevMonthFirst() {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());

        //设置为1号,当前日期既为上月第一天
        c.set(Calendar.DAY_OF_MONTH, 1);
        //日期减一个月
        c.add(Calendar.MONTH, -1);
        //将小时至0
        c.set(Calendar.HOUR_OF_DAY, 0);
        //将分钟至0
        c.set(Calendar.MINUTE, 0);
        //将秒至0
        c.set(Calendar.SECOND,0);
        //将毫秒至0
        c.set(Calendar.MILLISECOND, 0);
        // 获取本月第一天的时间戳
        return c.getTimeInMillis()/1000;
    }
    /**
     *今天凌晨时间戳 秒
     * @return
     * @throws Exception
     */
    public static Long getToday() {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        return c.getTimeInMillis()/1000;
    }
    /**
     *明日凌晨时间戳 秒
     * @return
     * @throws Exception
     */
    public static Long getTomorrow() {
        return getToday()+86400;
    }

    /**
     * 计算time2比time1多的天数
     * @param time1
     * @param time2
     * @return
     */
    public static int calculateDifferDays(Integer time1,Integer time2)
    {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(new Date(time1*1000l));
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(new Date(time2*1000l));
        int day1= cal1.get(Calendar.DAY_OF_YEAR);
        int day2 = cal2.get(Calendar.DAY_OF_YEAR);

        int year1 = cal1.get(Calendar.YEAR);
        int year2 = cal2.get(Calendar.YEAR);
        if(year1 != year2)   //同一年
        {
            int timeDistance = 0 ;
            for(int i = year1 ; i < year2 ; i ++)
            {
                if(i%4==0 && i%100!=0 || i%400==0)    //闰年
                {
                    timeDistance += 366;
                }
                else    //不是闰年
                {
                    timeDistance += 365;
                }
            }

            return timeDistance + (day2-day1) ;
        }
        else    //不同年
        {
            return day2-day1;
        }
    }

    public static Integer activityEndTime(Long startTime ,Long endTime, String weekDay, String time){
        Long timeStap = System.currentTimeMillis();
        Long activityEndTime = 0l;
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date(timeStap));
        String weekDayNow = (cal.get(Calendar.DAY_OF_WEEK)-1)==0?"7":(cal.get(Calendar.DAY_OF_WEEK)-1)+"";
        String hourNow = cal.get(Calendar.HOUR_OF_DAY)+"";
        if((timeStap >= startTime || timeStap <= endTime) && weekDay.indexOf(weekDayNow) > -1 && time.indexOf(hourNow) > -1){
            String[] timeArray = time.split(",");
            int baseHour = Integer.parseInt(hourNow);
            for(int i=0;i<timeArray.length;i++){
                if(hourNow.equals(timeArray[i])){
                    for(int y=0;y<timeArray.length-i;y++){
                        if(baseHour+1 == Integer.parseInt(timeArray[i+y])){
                            baseHour++;
                        }
                    }
                }
            }
            cal.set(Calendar.HOUR_OF_DAY, baseHour);
            cal.set(Calendar.MINUTE, 59);
            cal.set(Calendar.SECOND, 59);
            cal.set(Calendar.MILLISECOND, 999);
            activityEndTime = cal.getTimeInMillis()/1000;
            return Integer.parseInt(activityEndTime.toString());
        }else{
            return Integer.parseInt((endTime/1000)+"");
        }
    }


    public static String format(Date date) {
        return format(date, DATE_PATTERN);
    }

    public static String formatSec(Date date) {
        return format(date, DATE_TIME_PATTERN);
    }

    public static String format(Date date, String pattern) {
        if (date != null) {
            SimpleDateFormat df = new SimpleDateFormat(pattern);
            return df.format(date);
        }
        return null;
    }
    
    public static Date parseFromSeconds(Integer seconds) {
    	if(seconds != null) {
	        return new Date(Long.valueOf(seconds+"000"));
    	}
    	return null;
    }

}