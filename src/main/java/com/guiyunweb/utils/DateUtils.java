package com.guiyunweb.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {

    /**
     * 得到任意天数后的日期
     *
     * @param date
     * @param day
     * @return
     */
    public static Date getAfterDaysTime(Date date, int day) {
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(date);
        rightNow.add(Calendar.DAY_OF_YEAR, day);
        return rightNow.getTime();
    }

    /**
     * 得到任意天数后的日期
     *
     * @param date 时间
     * @param mon  月数
     * @return
     */
    public static Date getAfterMonsTime(Date date, int mon) {
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(date);
        rightNow.add(Calendar.MONTH, mon);
        return rightNow.getTime();
    }

    /**
     * 时间格式化输出 精确到天
     *
     * @param date
     * @return
     */
    public static String getDateStringAccurateDay(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }

    /**
     * 时间格式化输出 精确到秒
     *
     * @param date
     * @return
     */
    public static String getDateStringAccurateSec(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }

    /**
     * 时间格式化输出 自定义
     *
     * @param date
     * @return
     */
    public static String getDateString(Date date,String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    /**
     * 自定义时间格式化输出
     *
     * @param date
     * @return
     */
    public static String format(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    /**
     * 计算本月共多少天
     *
     * @param year
     * @param month
     * @return
     */
    public static int getCountDayForMonth(int year, int month) {
        if (month > 12) {
            return 0;
        }
        int[] monDays = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (((year) % 4 == 0 && (year) % 100 != 0) || (year) % 400 == 0) {
            monDays[2]++;
        }
        return monDays[month];
    }


    /**
     * 返回时间的毫秒值
     *
     * @return
     */
    public static long nowTimeInMillis() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());

        return cal.getTimeInMillis();

    }

    /**
     * 得到当天 零点
     *
     * @param date
     * @return
     */
    public static Date getZero(Date date) {
        SimpleDateFormat formatter_f = new SimpleDateFormat("yyyy-MM-dd");
        // 将日期时间格式化
        String new_date_f = formatter_f.format(date);
        new_date_f = new_date_f + " 00:00:00";
        return parseDate(null, new_date_f);
    }

    /**
     * 得到当天 深夜(午夜12点)
     *
     * @param date
     * @return
     */
    public static Date getMidnight(Date date) {
        SimpleDateFormat formatter_f = new SimpleDateFormat("yyyy-MM-dd");

        String new_date_f = formatter_f.format(date);
        new_date_f = new_date_f + " 23:59:59";
        return parseDate(null, new_date_f);
    }

    /**
     * 获取指定日期月份的最后一天
     *
     * @param date 日期对象
     * @return
     */
    public static Date getLastDay(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int value = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        cal.set(Calendar.DAY_OF_MONTH, value);
        return cal.getTime();
    }

    /**
     * 根据字符串返回指定时间
     *
     * @param strFormat
     * @param dateValue
     * @return
     * @throws ParseException
     * @throws Exception
     */
    public static Date parseDate(String strFormat, String dateValue) {
        if (dateValue == null)
            return null;

        if (strFormat == null) {
            strFormat = "yyyy-MM-dd HH:mm:ss";
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat(strFormat);
        Date newDate = null;

        try {
            newDate = dateFormat.parse(dateValue);
        } catch (ParseException pe) {
            newDate = null;
        }

        return newDate;
    }

    /**
     * 计算两个时间相差的天数
     *
     * @param beginTime 开始时间
     * @param endTime   结束时间
     * @author wangbh
     */
    public static Long getDays(String beginTime, String endTime) {
        DateFormat df = new SimpleDateFormat("yyyyMMdd");
        long day = 0L;
        try {
            Date beginDate = df.parse(beginTime);
            Date endDate = df.parse(endTime);
            long diff = endDate.getTime() - beginDate.getTime();
            day = diff / (1000 * 60 * 60 * 24);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return day;
    }

    /**
     * 计算两个日期之间相差的天数,只关心天
     *
     * @return
     */
    public static long daysOfTwo(Date fDate, Date oDate) {

        Calendar aCalendar = Calendar.getInstance();

        aCalendar.setTime(fDate);
        Calendar bCalendar = Calendar.getInstance();
        bCalendar.setTime(oDate);

        long atimeInMillis = aCalendar.getTimeInMillis();
        long btimeInMillis = bCalendar.getTimeInMillis();
        long day = (btimeInMillis - atimeInMillis) / (24 * 60 * 60 * 1000);
        return day;
    }

    /**
     * 时间是否为同一天
     *
     * @param date1
     * @param date2
     * @return
     */
    public static boolean isEqual(Date date1, Date date2) {
        //将Date类型转换为LocalDate类型
        LocalDate localDate1 = date1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate localDate2 = date2.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        //判断是否时间是否相等
        if (localDate1.isEqual(localDate2)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 比较日期先后,并摆正顺序
     */
    public static Date[] exchangeDate(Date startDate, Date endDate) {
        Date datetemp;
        if (startDate.after(endDate)) {
            datetemp = endDate;
            endDate = startDate;
            startDate = datetemp;
        }
        return new Date[]{startDate, endDate};
    }

    /**
     * 获得昨天时间，格式自定义
     *
     * @param format
     * @return
     */
    public static String getYesterdayDate(String format) {
        Calendar day = Calendar.getInstance();
        day.add(Calendar.DATE, -1);
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        String date = sdf.format(day.getTime());
        return date;
    }

    /**
     * 按年加,指定日期
     *
     * @param date
     * @param value
     * @return
     */
    public static Date addYear(Date date, int value) {
        Calendar now = Calendar.getInstance();
        now.setTime(date);
        now.add(Calendar.YEAR, value);
        return now.getTime();
    }

    /**
     * 按小时加,指定日期
     *
     * @param date
     * @param value
     * @return
     */
    public static Date addHour(Date date, int value) {
        Calendar now = Calendar.getInstance();
        now.setTime(date);
        now.add(Calendar.HOUR_OF_DAY, value);
        return now.getTime();
    }

    /**
     * 按分钟加,指定日期
     *
     * @param date
     * @param value
     * @return
     */
    public static Date addMinute(Date date, int value) {
        Calendar now = Calendar.getInstance();
        now.setTime(date);
        now.add(Calendar.MINUTE, value);
        return now.getTime();
    }
}
