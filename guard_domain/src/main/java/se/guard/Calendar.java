package se.guard;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.core.style.ToStringCreator;

@Entity
@Table(name = "CALENDAR")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD) 
public class Calendar
{
	@Id
	private int calendar_id;
	private String startDate;
	private String startHour;
	private String startMinute;
	private String startWeekDay;
	private String startYearOnly;
	private String startMonthName;
	private String startDayNumber;
	private String endDate;
	private String endHour;
	private String endMinute;
	private String endWeekDay;
	private String endYearOnly;
	private String endMonthName;
	private String endDayNumber;
	private boolean serviceAvailable;
	private String number;

	public Calendar()
	{
	}
	
	
	

	public Calendar(String startWeekDay, String startYearOnly, String startMonthName, String startDayNumber, String endWeekDay, String endYearOnly, String endMonthName,
			String endDayNumber, boolean isServiceAvailable)
	{
		this.startWeekDay = startWeekDay;
		this.startYearOnly = startYearOnly;
		this.startMonthName = startMonthName;
		this.startDayNumber = startDayNumber;
		this.endWeekDay = endWeekDay;
		this.endYearOnly = endYearOnly;
		this.endMonthName = endMonthName;
		this.endDayNumber = endDayNumber;
		this.serviceAvailable = isServiceAvailable;
	}
	public Calendar(String startWeekDay, String startYearOnly, String startMonthName, String startDayNumber, String endWeekDay, String endYearOnly, String endMonthName,
			String endDayNumber, boolean isServiceAvailable, String number)
	{
		this.startWeekDay = startWeekDay;
		this.startYearOnly = startYearOnly;
		this.startMonthName = startMonthName;
		this.startDayNumber = startDayNumber;
		this.endWeekDay = endWeekDay;
		this.endYearOnly = endYearOnly;
		this.endMonthName = endMonthName;
		this.endDayNumber = endDayNumber;
		this.serviceAvailable = isServiceAvailable;
		this.number = number;
	}




	public Calendar(int calendar_id, String startDate, String startHour, String startMinute, String startWeekDay, String startYearOnly, String startMonthName,
			String startDayNumber, String endDate, String endHour, String endMinute, String endWeekDay, String endYearOnly, String endMonthName, String endDayNumber,
			boolean isServiceAvailable, String number)
	{
		this.calendar_id = calendar_id;
		this.startDate = startDate;
		this.startHour = startHour;
		this.startMinute = startMinute;
		this.startWeekDay = startWeekDay;
		this.startYearOnly = startYearOnly;
		this.startMonthName = startMonthName;
		this.startDayNumber = startDayNumber;
		this.endDate = endDate;
		this.endHour = endHour;
		this.endMinute = endMinute;
		this.endWeekDay = endWeekDay;
		this.endYearOnly = endYearOnly;
		this.endMonthName = endMonthName;
		this.endDayNumber = endDayNumber;
		this.serviceAvailable = isServiceAvailable;
		this.number = number;
	}




	public Calendar(int calendar_id, String startWeekDay, String startYearOnly, String startMontName, String startDayNumber, String endWeekDay, String endYearOnly,
			String endMonthName, String endDayNumber)
	{
		this.calendar_id = calendar_id;
		this.startWeekDay = startWeekDay;
		this.startYearOnly = startYearOnly;
		this.startMonthName = startMontName;
		this.startDayNumber = startDayNumber;
		this.endWeekDay = endWeekDay;
		this.endYearOnly = endYearOnly;
		this.endMonthName = endMonthName;
		this.endDayNumber = endDayNumber;
	}




	public Calendar(String startWeekDay, String startYearOnly, String startMontName, String startDayNumber, String endWeekDay, String endYear, String endMontName,
			String endDayNumber)
	{
		this.startWeekDay = startWeekDay;
		this.startYearOnly = startYearOnly;
		this.startMonthName = startMontName;
		this.startDayNumber = startDayNumber;
		this.endWeekDay = endWeekDay;
		this.endYearOnly = endYear;
		this.endMonthName = endMontName;
		this.endDayNumber = endDayNumber;
	}




	public Calendar(int calendar_id, String startDate, String startHour, String startMinute, String startWeekDay, String startYear, String startMontName,
			String startDayNumber, String endDate, String endHour, String endMinute, String endWeekDay, String endYear, String endMontName, String endDayNumber,
			String number)
	{
		this.calendar_id = calendar_id;
		this.startDate = startDate;
		this.startHour = startHour;
		this.startMinute = startMinute;
		this.startWeekDay = startWeekDay;
		this.startYearOnly = startYear;
		this.startMonthName = startMontName;
		this.startDayNumber = startDayNumber;
		this.endDate = endDate;
		this.endHour = endHour;
		this.endMinute = endMinute;
		this.endWeekDay = endWeekDay;
		this.endYearOnly = endYear;
		this.endMonthName = endMontName;
		this.endDayNumber = endDayNumber;
		this.number = number;
	}
	public Calendar( String startDate, String startHour, String startMinute, String startWeekDay, String startYear, String startMontName,
			String startDayNumber, String endDate, String endHour, String endMinute, String endWeekDay, String endYear, String endMontName, String endDayNumber,
			String number)
	{
		this.startDate = startDate;
		this.startHour = startHour;
		this.startMinute = startMinute;
		this.startWeekDay = startWeekDay;
		this.startYearOnly = startYear;
		this.startMonthName = startMontName;
		this.startDayNumber = startDayNumber;
		this.endDate = endDate;
		this.endHour = endHour;
		this.endMinute = endMinute;
		this.endWeekDay = endWeekDay;
		this.endYearOnly = endYear;
		this.endMonthName = endMontName;
		this.endDayNumber = endDayNumber;
		this.number = number;
	}




	public Calendar(int calendar_id, String startDate, String startHour, String startMinute, String startWeekDay, String endDate, String endHour, String endMinute,
			String endWeekDay, String number)
	{
		this.calendar_id = calendar_id;
		this.startDate = startDate;
		this.startHour = startHour;
		this.startMinute = startMinute;
		this.startWeekDay = startWeekDay;
		this.endDate = endDate;
		this.endHour = endHour;
		this.endMinute = endMinute;
		this.endWeekDay = endWeekDay;
		this.number = number;
	}



	public Calendar(String startDate, String startHour, String startMinute, String startWeekDay, String endDate, String endHour, String endMinute, String endWeekDay,
			String number)
	{
		this.startDate = startDate;
		this.startHour = startHour;
		this.startMinute = startMinute;
		this.startWeekDay = startWeekDay;
		this.endDate = endDate;
		this.endHour = endHour;
		this.endMinute = endMinute;
		this.endWeekDay = endWeekDay;
		this.number = number;
	}



	public Calendar(String startDate, String startHour, String startMinute, String endDate, String endHour, String endMinute, String number)
	{
		this.startDate = startDate;
		this.startHour = startHour;
		this.startMinute = startMinute;
		this.endDate = endDate;
		this.endHour = endHour;
		this.endMinute = endMinute;
		this.number = number;
	}

	public Calendar(int calendar_id, String startDate, String startHour, String startMinute, String endDate, String endHour, String endMinute, String number)
	{
		this.calendar_id = calendar_id;
		this.startDate = startDate;
		this.startHour = startHour;
		this.startMinute = startMinute;
		this.endDate = endDate;
		this.endHour = endHour;
		this.endMinute = endMinute;
		this.number = number;
	}
	

	public Calendar(String startDate, String startHour, String startMinute, String endDate, String endHour, String endMinute)
	{
		this.startDate = startDate;
		this.startHour = startHour;
		this.startMinute = startMinute;
		this.endDate = endDate;
		this.endHour = endHour;
		this.endMinute = endMinute;
	}

	public String getNumber()
	{
		return number;
	}

	public void setNumber(String number)
	{
		this.number = number;
	}

	public int getCalendar_id()
	{
		return calendar_id;
	}

	public void setCalendar_id(int calendar_id)
	{
		this.calendar_id = calendar_id;
	}

	public String getStartDate()
	{
		return startDate;
	}

	public void setStartDate(String startDate)
	{
		this.startDate = startDate;
	}

	public String getStartHour()
	{
		return startHour;
	}

	public void setStartHour(String startHour)
	{
		this.startHour = startHour;
	}

	public String getStartMinute()
	{
		return startMinute;
	}

	public void setStartMinute(String startMinute)
	{
		this.startMinute = startMinute;
	}

	public String getEndDate()
	{
		return endDate;
	}

	public void setEndDate(String endDate)
	{
		this.endDate = endDate;
	}

	public String getEndHour()
	{
		return endHour;
	}

	public void setEndHour(String endHour)
	{
		this.endHour = endHour;
	}

	public String getEndMinute()
	{
		return endMinute;
	}

	public void setEndMinute(String endMinute)
	{
		this.endMinute = endMinute;
	}
	
	

	public String getStartWeekDay()
	{
		return startWeekDay;
	}

	public void setStartWeekDay(String startWeekDay)
	{
		this.startWeekDay = startWeekDay;
	}

	public String getEndWeekDay()
	{
		return endWeekDay;
	}

	public void setEndWeekDay(String endWeekDay)
	{
		this.endWeekDay = endWeekDay;
	}
	
	
	

	public String getStartYear()
	{
		return startYearOnly;
	}



	public void setStartYear(String startYear)
	{
		this.startYearOnly = startYear;
	}



	public String getStartMonthName()
	{
		return startMonthName;
	}



	public void setStartMonthName(String startMontName)
	{
		this.startMonthName = startMontName;
	}



	public String getStartDayNumber()
	{
		return startDayNumber;
	}



	public void setStartDayNumber(String startDayNumber)
	{
		this.startDayNumber = startDayNumber;
	}



	public String getEndYear()
	{
		return endYearOnly;
	}



	public void setEndYear(String endYear)
	{
		this.endYearOnly = endYear;
	}



	public String getEndMonthName()
	{
		return endMonthName;
	}



	public void setEndMonthName(String endMontName)
	{
		this.endMonthName = endMontName;
	}



	public String getEndDayNumber()
	{
		return endDayNumber;
	}



	public void setEndDayNumber(String endDayNumber)
	{
		this.endDayNumber = endDayNumber;
	}



	public String getStartYearOnly()
	{
		return startYearOnly;
	}




	public void setStartYearOnly(String startYearOnly)
	{
		this.startYearOnly = startYearOnly;
	}




	public String getEndYearOnly()
	{
		return endYearOnly;
	}




	public void setEndYearOnly(String endYearOnly)
	{
		this.endYearOnly = endYearOnly;
	}




	public boolean isServiceAvailable()
	{
		return serviceAvailable;
	}




	public void setServiceAvailable(boolean isServiceAvailable)
	{
		this.serviceAvailable = isServiceAvailable;
	}




	public String tosString()
	{

		return new ToStringCreator(this)
		.append("CALENDAR_ID", this.calendar_id)
		.append("START DATE", this.startDate)
		.append("START HOUR", this.startHour)
		.append("START MINUTE", this.startMinute)
		.append("START WEEKDAY", this.startWeekDay)
		.append("START MONTH NAME", this.startMonthName)
		.append("START DAY NUMBER", this.startDayNumber)
		.append("START YEAR ONLY", this.startYearOnly)
		.append("END DATE", this.endDate)
		.append("END HOUR", this.endHour)
		.append("END MINUTE", this.endMinute)
		.append("END WEEKDAY", this.endWeekDay)
		.append("END MONTH NAME", this.endMonthName)
		.append("END DAY NUMBER", this.endDayNumber)
		.append("END YEAR ONLY", this.endYearOnly)
		.append("NUMBER OF ADDING A DATE", this.number)
		.append("IS SERVICE AVAILABLE", this.serviceAvailable)
		.toString();
	}

}
