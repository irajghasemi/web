package se.datalayer.guards.repository;

import java.util.Collection;

import org.springframework.stereotype.Repository;

import se.guard.DateAndTime;

@Repository
public interface AdminCalendarRepsoitory
{

	DateAndTime addService(DateAndTime dateAndTime);

	DateAndTime updateService(DateAndTime dateAndTime);

	boolean removeService(int dateAndTime_id);

	DateAndTime getSingelServiceById(int updatedateAndTime_id);

	Collection<DateAndTime> getAllDateAndTime();

	Collection<DateAndTime> getService_ByRange(String startDate, String endDate);

	Collection<DateAndTime> getService_BetweenTwoDates(String startDate, String endDate);

	Collection<DateAndTime> getAll_Available_Services();

	Collection<DateAndTime> getAll_Occupied_Services();

	boolean doDateAndTimeExist(String startDate, String endDate);
}
