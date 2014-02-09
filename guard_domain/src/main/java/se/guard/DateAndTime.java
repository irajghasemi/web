package se.guard;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.core.style.ToStringCreator;

@Entity
@Table(name = "DATE_TIME")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class DateAndTime
{
	@Id
	@Column(name = "DATEANDTIME_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@XmlElement
	private int dateAndTime_id;
	
	@Column(name = "START_DATE")
	@XmlElement
	private String startDate;
	
	@Column(name = "START_TIME")
	@XmlElement
	private String startTime;
	
	@Column(name = "START_WEK_DAY")
	@XmlElement
	private String startWeekDay;
	
	@Column(name = "END_DATE")
	@XmlElement
	private String endDate;

	@Column(name = "END_TIME")
	@XmlElement
	private String endTime;
	
	@Column(name = "END_WEEK_DAY")
	@XmlElement
	private String endWeekDay;
	
	@Column(name = "SERVICE_AVAILABLE")
	@XmlElement
	private boolean serviceAvailable;

	@Column(name = "NUMBER_OF_GUARDS")
	@XmlElement
	private int numberOfGuards;
	
	@Column(name = "START_YEAR_ONLY")
	@XmlElement
	private String startYearOnly;
	
	@Column(name = "START_MONTH_NAME")
	@XmlElement
	private String startMontName;
	
	@Column(name = "START_DAY_NUMBER")
	@XmlElement
	private String startDayNumber;
	
	@Column(name = "END_YEAR_ONLY")
	@XmlElement
	private String endYearOnly;
	
	@Column(name = "END_MONTH_NAME")
	@XmlElement
	private String endMonthName;
	
	@Column(name = "END_DAY_NUMBER")
	@XmlElement
	private String endDayNumber;

	
	public DateAndTime()
	{
	}
	public DateAndTime(int dateAndTime_id)
	{
		this.dateAndTime_id = dateAndTime_id;
	}
	

	public DateAndTime( String startWeekDay, String endWeekDay, boolean isServiceAvailable, int numberOfGuards, String startYearOnly,
			String startMontName, String startDayNumber, String endYearOnly, String endMonthName, String endDayNumber)
	{
		this.startWeekDay = startWeekDay;
		this.endWeekDay = endWeekDay;
		this.serviceAvailable = isServiceAvailable;
		this.numberOfGuards = numberOfGuards;
		this.startYearOnly = startYearOnly;
		this.startMontName = startMontName;
		this.startDayNumber = startDayNumber;
		this.endYearOnly = endYearOnly;
		this.endMonthName = endMonthName;
		this.endDayNumber = endDayNumber;
	}
	
	
	public DateAndTime(int dateAndTime_id,String startYearOnly, String startMontName, String startDayNumber, String endYearOnly, String endMonthName, String endDayNumber)
	{
		this.startYearOnly = startYearOnly;
		this.startMontName = startMontName;
		this.startDayNumber = startDayNumber;
		this.endYearOnly = endYearOnly;
		this.endMonthName = endMonthName;
		this.endDayNumber = endDayNumber;
		this.dateAndTime_id = dateAndTime_id;
	}
	public DateAndTime(String startYearOnly, String startMontName, String startDayNumber, String endYearOnly, String endMonthName, String endDayNumber)
	{
		this.startYearOnly = startYearOnly;
		this.startMontName = startMontName;
		this.startDayNumber = startDayNumber;
		this.endYearOnly = endYearOnly;
		this.endMonthName = endMonthName;
		this.endDayNumber = endDayNumber;
	}
	public DateAndTime(int dateAndTime_id, String startDate, String startTime, String startWeekDay, String endDate, String endTime, String endWeekDay,
			boolean isServiceAvailable, int numberOfGuards, String startYearOnly, String startMontName, String startDayNumber, String endYearOnly, String endMonthName,
			String endDayNumber)
	{
		this.dateAndTime_id = dateAndTime_id;
		this.startDate = startDate;
		this.startTime = startTime;
		this.startWeekDay = startWeekDay;
		this.endDate = endDate;
		this.endTime = endTime;
		this.endWeekDay = endWeekDay;
		this.serviceAvailable = isServiceAvailable;
		this.numberOfGuards = numberOfGuards;
		this.startYearOnly = startYearOnly;
		this.startMontName = startMontName;
		this.startDayNumber = startDayNumber;
		this.endYearOnly = endYearOnly;
		this.endMonthName = endMonthName;
		this.endDayNumber = endDayNumber;
	}
	public DateAndTime( String startDate, String startTime, String startWeekDay, String endDate, String endTime, String endWeekDay,
			boolean isServiceAvailable, int numberOfGuards, String startYearOnly, String startMontName, String startDayNumber, String endYearOnly, String endMonthName,
			String endDayNumber)
	{
		this.startDate = startDate;
		this.startTime = startTime;
		this.startWeekDay = startWeekDay;
		this.endDate = endDate;
		this.endTime = endTime;
		this.endWeekDay = endWeekDay;
		this.serviceAvailable = isServiceAvailable;
		this.numberOfGuards = numberOfGuards;
		this.startYearOnly = startYearOnly;
		this.startMontName = startMontName;
		this.startDayNumber = startDayNumber;
		this.endYearOnly = endYearOnly;
		this.endMonthName = endMonthName;
		this.endDayNumber = endDayNumber;
	}
	public DateAndTime(String startDate, String startTime, String startWeekDay, String endDate, String endTime, String endWeekDay, boolean isServiceAvailable,
			int numberOfGuards)
	{
		this.startDate = startDate;
		this.startTime = startTime;
		this.startWeekDay = startWeekDay;
		this.endDate = endDate;
		this.endTime = endTime;
		this.endWeekDay = endWeekDay;
		this.serviceAvailable = isServiceAvailable;
		this.numberOfGuards = numberOfGuards;
	}
	public DateAndTime(int dateAndTime_id, String startDate, String startTime, String startWeekDay, String endDate, String endTime, String endWeekDay,
			boolean isServiceAvailable, int numberOfGuards)
	{
		this.dateAndTime_id = dateAndTime_id;
		this.startDate = startDate;
		this.startTime = startTime;
		this.startWeekDay = startWeekDay;
		this.endDate = endDate;
		this.endTime = endTime;
		this.endWeekDay = endWeekDay;
		this.serviceAvailable = isServiceAvailable;
		this.numberOfGuards = numberOfGuards;
	}
	public DateAndTime(int dateAndTime_id, String startDate, String endDate, String startTime, String endTime, boolean isServiceAvailable)
	{
		this.dateAndTime_id = dateAndTime_id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.startTime = startTime;
		this.endTime = endTime;
		this.serviceAvailable = isServiceAvailable;
	}
	public DateAndTime(String startDate, String endDate, String startTime, String endTime, boolean isServiceAvailable)
	{
		this.startDate = startDate;
		this.endDate = endDate;
		this.startTime = startTime;
		this.endTime = endTime;
		this.serviceAvailable = isServiceAvailable;
	}
	public DateAndTime(String startDate, String endDate, String startTime, String endTime, boolean isServiceAvailable, int numberOfGuards)
	{
		this.startDate = startDate;
		this.endDate = endDate;
		this.startTime = startTime;
		this.endTime = endTime;
		this.serviceAvailable = isServiceAvailable;
		this.numberOfGuards = numberOfGuards;
	}
	public DateAndTime(int dateAndTime_id, String startDate, String endDate, String startTime, String endTime, boolean isServiceAvailable, int numberOfGuards)
	{
		this.dateAndTime_id = dateAndTime_id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.startTime = startTime;
		this.endTime = endTime;
		this.serviceAvailable = isServiceAvailable;
		this.numberOfGuards = numberOfGuards;
	}
	
	
	public boolean isServiceAvailable()
	{
		return serviceAvailable;
	}
	public void setServiceAvailable(boolean serviceAvailable)
	{
		this.serviceAvailable = serviceAvailable;
	}
	public int getDateAndTime_id()
	{
		return dateAndTime_id;
	}

	public void setDateAndTime_id(int dateAndTime_id)
	{
		this.dateAndTime_id = dateAndTime_id;
	}

	public String getStartDate()
	{
		return startDate;
	}

	public void setStartDate(String startDate)
	{
		this.startDate = startDate;
	}

	public String getEndDate()
	{
		return endDate;
	}

	public void setEndDate(String endDate)
	{
		this.endDate = endDate;
	}

	public String getStartTime()
	{
		return startTime;
	}

	public void setStartTime(String startTime)
	{
		this.startTime = startTime;
	}

	public String getEndTime()
	{
		return endTime;
	}

	public void setEndTime(String endTime)
	{
		this.endTime = endTime;
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
	public int getNumberOfGuards()
	{
		return numberOfGuards;
	}
	public void setNumberOfGuards(int numberOfGuards)
	{
		this.numberOfGuards = numberOfGuards;
	}
	
	
	public String getStartYearOnly()
	{
		return startYearOnly;
	}
	public void setStartYearOnly(String startYearOnly)
	{
		this.startYearOnly = startYearOnly;
	}
	public String getStartMontName()
	{
		return startMontName;
	}
	public void setStartMontName(String startMontName)
	{
		this.startMontName = startMontName;
	}
	public String getStartDayNumber()
	{
		return startDayNumber;
	}
	public void setStartDayNumber(String startDayNumber)
	{
		this.startDayNumber = startDayNumber;
	}
	public String getEndYearOnly()
	{
		return endYearOnly;
	}
	public void setEndYearOnly(String endYearOnly)
	{
		this.endYearOnly = endYearOnly;
	}
	public String getEndMonthName()
	{
		return endMonthName;
	}
	public void setEndMonthName(String endMonthName)
	{
		this.endMonthName = endMonthName;
	}
	public String getEndDayNumber()
	{
		return endDayNumber;
	}
	public void setEndDayNumber(String endDayNumber)
	{
		this.endDayNumber = endDayNumber;
	}
	
	
	
	@Override
	public int hashCode()
	{
		HashCodeBuilder builder = new HashCodeBuilder();
		builder.append(getDateAndTime_id());
		builder.append(getStartDate());
		builder.append(getStartTime());
		builder.append(getStartWeekDay());
		builder.append(getEndDate());
		builder.append(getEndTime());
		builder.append(getEndWeekDay());
		builder.append(isServiceAvailable());
		builder.append(getNumberOfGuards());
		return builder.toHashCode();
	}

	@Override
	public boolean equals(Object obj)
	{
		if (obj instanceof User)
		{
			DateAndTime other = (DateAndTime) obj;
			EqualsBuilder builder = new EqualsBuilder();
			builder.append(getDateAndTime_id(), other.getDateAndTime_id());
			builder.append(getStartDate(), other.getStartDate());
			builder.append(getStartTime(), other.getStartTime());
			builder.append(getStartWeekDay(), other.getStartWeekDay());
			builder.append(getEndDate(), other.getEndDate());
			builder.append(getEndTime(), other.getEndTime());
			builder.append(getEndWeekDay(), other.getEndWeekDay());
			builder.append(isServiceAvailable(), other.serviceAvailable);
			builder.append(getNumberOfGuards(), other.numberOfGuards);
			return builder.isEquals();
		}
		return false;
	}

	@Override
	public String toString()
	{
		return new ToStringCreator(this)
		.append("DATE_TIME_ID ", this.dateAndTime_id)
		.append("START_DATE ", this.startDate)
		.append("START_WEEK_DAY ", this.startWeekDay)
		.append("END_DATE", this.endDate)
		.append("START_TIME", this.startTime)
		.append("START MONTH NAME", this.startMontName)
		.append("START DAY NUMBER", this.startDayNumber)
		.append("START YEAR ONLY", this.startYearOnly)
		.append("END_TIME", this.endTime)
		.append("END_WEEK_DAY", this.endWeekDay)
		.append("END MONTH NAME", this.endMonthName)
		.append("END DAY NUMBER", this.endDayNumber)
		.append("END YEAR ONLY", this.endYearOnly)
		.append("Is SERVICE AVAILABLE", this.serviceAvailable)
		.append("NUMBER_OF_GUARDS", this.numberOfGuards)
		.toString();
	}

}
