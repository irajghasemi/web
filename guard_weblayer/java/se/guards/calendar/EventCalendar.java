package se.guards.calendar;

import se.datalayer.guards.repository.EventCalendarRepository;

import com.dhtmlx.planner.DHXEv;
import com.dhtmlx.planner.DHXStatus;

public class EventCalendar implements EventCalendarRepository {

	public Iterable<DHXEv> getEvents()
	{
		
		return null;
	}

	public Integer saveEvent(DHXEv event, DHXStatus status)
	{
		return null;
	}

	public DHXEv createEvent(String id, DHXStatus status)
	{
		return null;
	}


}