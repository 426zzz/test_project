package org.lyz.test_project.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTest {
	public static void main(String[] args) throws ParseException {
		// String 与 Date之间相互转换
		Date date = new Date();
		SimpleDateFormat sp = new SimpleDateFormat("一月中的第F个星期");
		String format = sp.format(date); // 2021年11月23日 19:47:54
		Date parse = sp.parse(format); // Tue Nov 23 19:47:54 CST 2021
		System.out.println(format);
		
		// Calendar 与 date相互转换
		Calendar instance = Calendar.getInstance(); // Calendar实例instance用于操作日期，通过Calendar的常量来获取具体参数
		Date time = instance.getTime(); // Calendar转date
		instance.setTime(date); // Date转Calendar
		instance.set(2022, 3, 22, 18, 18, 18); // 设置指定Calendar为指定日期，相当于改变了Calendar的常量值 
		int year = instance.get(Calendar.YEAR); // 当前年
		int month = instance.get(Calendar.MONTH); // 从0开始，需要加1为当前月
		int date2 = instance.get(Calendar.DATE); // 当前日
		int hour = instance.get(Calendar.HOUR_OF_DAY); // HOUR为12小时制，HOUR_OF_DAY为24小时制
		int minute = instance.get(Calendar.MINUTE); // 当前分钟
		int second = instance.get(Calendar.SECOND); // 当前秒
		instance.set(Calendar.YEAR,	2222); // 设置年份
		instance.set(Calendar.YEAR, instance.get(Calendar.YEAR) + 1); // 设置年份为当前年+1
	}
}
