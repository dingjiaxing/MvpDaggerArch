package com.jackting.core.util;

import android.annotation.SuppressLint;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateTimeUtil {

	Date now = new Date();;
	Date date;

	@SuppressLint("SimpleDateFormat")
	public DateTimeUtil(String StDate) {

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// LogUtil.e("DateTimeUtil",StDate);
		try {
			this.date = df.parse(StDate);
		} catch (ParseException e) {

			e.printStackTrace();
		}
	}

	/**
	 * 计算天数
	 * 
	 * @param oldDate
	 * @param nowDate
	 * @return
	 */
	// public int getIntervalDays(Date oldDate, Date nowDate) {
	//
	// if (null == oldDate || null == nowDate) {
	// return -1;
	// }
	//
	// long intervalMilli = nowDate.getTime() - oldDate.getTime();
	//
	// return (int) (intervalMilli / (24 * 60 * 60 * 1000));
	//
	// }

	/**
	 * 计算时间差 ）
	 * 
	 * @return
	 */
	@SuppressWarnings("unused")
	public int getTimeDifference() {
		int diff = (int) (now.getTime() - date.getTime());
		// int min=diff/(1000*60);
		// return Math.abs(diff / (1000 * 60));
		return diff / (24 * 60 * 60 * 1000);
	}

	/* 获得当前时间 */
	// public static String getCurrentTime(){
	// // now = new Date();
	// SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	// String dateString = formatter.format(now);
	// return dateString;
	// }
	/**
	 * 日期格式化 截取时分
	 * 
	 * @param strDat
	 * 
	 * @return
	 */
	public static String date(String strDat) {
		// String strDat="2015.10.18 12:28:38";
		String pat = "yyyy-MM-dd HH:mm:ss";
		String hour = "HH:mm";
		SimpleDateFormat sdf1 = new SimpleDateFormat(pat);
		SimpleDateFormat sdf2 = new SimpleDateFormat(hour);
		Date d = null;

		try {
			d = sdf1.parse(strDat);
		} catch (ParseException e) {

			e.printStackTrace();
		}

		String out = sdf2.format(d);
		return out;
	}

	/**
	 * 获取系统当前的时间
	 */
	public static String DateText() {
		Calendar now = Calendar.getInstance();
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateNowStr = sdf.format(d);
		System.out.println("格式化后的日期：" + dateNowStr);
		return dateNowStr;

	}
	
	/**
     * 获取当前时间
     *
     * @return 返回短时间字符串格式yyyyMMdd
     */
    public static String getStringDateShort() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        String dateString = formatter.format(currentTime);
        return dateString;
    }
    
    /**
     * 将长时间格式字符串转换为时间 yyyyMMddHH:mm
     *
     * @param strDate
     * @return
     */
    public static Date strToDateLong(String strDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHH:mm");
        ParsePosition pos = new ParsePosition(0);
        Date strtodate = formatter.parse(strDate, pos);
        return strtodate;
    }

	/**
	 * 获取指定网站的日期时间
	 * 
	 * @param webUrl
	 * @return
	 * @author SHANHY
	 * @date 2015年11月27日
	 */
	@SuppressWarnings("unused")
	public static String getWebsiteDatetime(String webUrl) {
		try {
			URL url = new URL(webUrl);// 取得资源对象
			URLConnection uc = url.openConnection();// 生成连接对象
			uc.connect();// 发出连接
			long ld = uc.getDate();// 读取网站日期时间
			Date date = new Date(ld);// 转换为标准时间对象
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.CHINA);// 输出北京时间
			return sdf.format(date);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
