package com.lixuan.rems.util;

import java.security.MessageDigest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/************************************************************************************
 * @Title        : DateUtil.java
 * @Description : 
 * @Author       : BianWeiqing
 * @DateTime     : 2015年3月27日 下午1:54:15
 * @Copyright    : 2015 Moutum All Rights Reserved
 * @version      : V1.0
 ************************************************************************************/
public class DateUtil
{
    public static String YYYY_MM_DD = "yyyy-MM-dd";
    public static String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    public static String YYYYMMDD = "yyyyMMdd";
    public static final String DATE_PATTERN_SS = "yyyyMMddHHmmssSS";
    private static final String INIT_DATE_TIME = "1900-01-01 00:00:00";
    
    public static String format(Date date)
    {
        SimpleDateFormat sdf = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);
        return sdf.format(date);
    }
    
    public static Date parse(String str) 
    {
        SimpleDateFormat sdf = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);
        try 
        {
            if(str.length() < INIT_DATE_TIME.length())
            {
                str += INIT_DATE_TIME.substring(str.length() + 1);
            }
            return sdf.parse(str);
        }
        catch (ParseException e) 
        {
            return null;
        }
    }
    
    public static Date stringToDate(String source, String format)
    {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        
        try
        {
            if(format.equals(YYYY_MM_DD_HH_MM_SS) || format.equals(DATE_PATTERN_SS))
            {
                if(source.length() < INIT_DATE_TIME.length())
                {
                    source += INIT_DATE_TIME.substring(source.length() + 1);
                }
            }
            return sdf.parse(source);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
            return null;
        }
    }
    
    public static long getDays(Date date1, Date date2)
    {
        return (date2.getTime() - date1.getTime())/1000*60*60*24;
    }
    
    public static Date addDate(Date date, double hours)
    {
        return new Date(date.getTime() + (long)hours*60*60*1000);
    }
    
    public static Date formatNewDate(String format)
    {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try
        {
            return sdf.parse(dateToString(new Date(), format));
        }
        catch (ParseException e)
        {
            e.printStackTrace();
            return null;
        }
    }
    
    public static String dateToString(Date date, String format)
    {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try
        {
            return sdf.format(date);
        }
        catch (Exception e)
        {
            return null;
        }
    }
    

    public static Date stringToDate(Date date, String format)
    {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try
        {
            return sdf.parse(dateToString(new Date(), format));
        }
        catch (Exception e)
        {
            return null;
        }
    }

    /**
     * shortDate 获取短时间格式"yyyyMM"
     * 使用参数Format格式化Date成字符串
     */
    public static String format(Date date, String pattern)
    {
        return date == null ? " " : new SimpleDateFormat(pattern).format(date);
    }
    
    public static String shortDate()
    {
        return format(new Date(), "yyyyMM");
    }
    
    public static String format()
    {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTERN_SS);
        return sdf.format(new Date());
    }
 
    public static void main(String[] args)
    {
        //System.out.println(dateToString(addDate(new Date(), 5), YYYY_MM_DD_HH_MM_SS));
        String initDateTime = "1900-01-01 00:00:00";
        String str = "2015-10-08 9:30";
        if(str.length() < initDateTime.length())
        {
            str += initDateTime.substring(str.length() + 1);
        }
        System.out.println(str);
    }
    
    /**
     * TODO 使用md5对密码加密
     * Parameter:src 加密前原字符串
     * Return:加密后的字符串
     */
    public static String md5(String src)
    {
        try 
        {
            StringBuffer buffer = new StringBuffer();
            char[] chars = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
            byte[] bytes = src.getBytes();
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] targ = md.digest(bytes);
            System.out.println(targ.toString());
            for(byte b:targ){
                buffer.append(chars[(b >> 4) & 0x0F]);
                buffer.append(chars[b & 0x0F]);
            }
            return buffer.toString();
            
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        return null;
    }
}

