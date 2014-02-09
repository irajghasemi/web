package se.datalayer.guards.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import org.joda.time.DateTime;
import org.joda.time.DateTimeFieldType;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import org.joda.time.Period;
import org.joda.time.ReadablePartial;
import org.joda.time.ReadablePeriod;
import org.joda.time.DateTime.Property;

public class DateTimeUtils
{

	@PersistenceContext(unitName = "dateTimeUtils")
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("guards");
	@PersistenceContext(unitName = "dateTimeUtils")
	private static EntityManager entityManager = entityManagerFactory.createEntityManager();

	DateTime dateTime = new DateTime();

	String onlyTime = dateTime.toString("HH:mm:ss");
	String formattedTime = dateTime.toString("yyyy-MM-dd HH:mm:ss");
	String onlyDate = dateTime.toString("yyyy-MM-dd");
	String dateAndTime = dateTime.toString("EEEE dd MMMM yyyy HH:mm:ss");

	public DateTimeUtils()
	{
	}

	public static String getDateNow()
	{
		return new DateTime().toString();
	}

	public static DateTime getDateNowToNextMonths(int numberMonths)
	{
		DateTime now = new DateTime();
		ReadablePeriod noUpdatePeriod = new Period().withMonths(numberMonths);
		return now.plus(noUpdatePeriod);
	}

	public static DateTime getDateNowToNextDays(int numberDays)
	{
		DateTime now = new DateTime();
		ReadablePeriod noUpdatePeriod = new Period().withDays(numberDays);
		return now.plus(noUpdatePeriod);
	}

	public static DateTime getDaysDateBeforeNow(int numberDays)
	{
		DateTime now = new DateTime();
		ReadablePeriod noUpdatePeriod = new Period().withDays(numberDays);
		return now.minus(noUpdatePeriod);
	}

	public static DateTime getDateNowToNextYears(int numberYears)
	{
		DateTime now = new DateTime();
		ReadablePeriod noUpdatePeriod = new Period().withYears(numberYears);
		return now.plus(noUpdatePeriod);
	}

	public static Date getDateFromString(String dateString, String pattern)
	{
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		sdf.setLenient(false);
		Date date = null;
		try
		{
			date = new Date(sdf.parse(dateString).getTime());
		}
		catch (ParseException e)
		{
			e.printStackTrace();
		}
		return date;
	}

	public static ReadablePartial getOnlyDate()
	{
		DateTime now = new DateTime();
		LocalDate date = now.toLocalDate();
		return date;
	}

	public static LocalTime getOnlyTime()
	{
		DateTime now = new DateTime();
		LocalTime date = now.toLocalTime();
		return date;
	}

	public static Property getDayOfTheWeek()
	{
		DateTime now = new DateTime();
		Property dayofweek = now.dayOfWeek();
		return dayofweek;
	}

	public static int weekNumber()
	{
		DateTime now = new DateTime();
		return now.weekOfWeekyear().get();
	}
	
	public static String getNameOfTheMonth(){
		DateTime dt = new DateTime();  // current time
		String  monthName=dt.monthOfYear().getAsText();
		
		return monthName;
	}
	public static int  getNumberOfTheMonth(){
		DateTime dt = new DateTime();  // current time
		
		return dt.monthOfYear().get();
	}
	public static int  getDayNumber(){
		DateTime dt = new DateTime();  // current time
		
		return dt.getDayOfMonth();
	}
	public static String getOnlyYear(){
		int currentYear=DateTimeUtils.getOnlyDate().get(DateTimeFieldType.year());
		return Integer.toString(currentYear);
	}
	
	
	public static boolean dateCompare(){
		
		DateTime dt = new DateTime();  // current time
		
		return dt.isBeforeNow();
		
	}

}