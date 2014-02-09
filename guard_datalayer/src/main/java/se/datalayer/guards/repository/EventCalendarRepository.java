package se.datalayer.guards.repository;

import com.dhtmlx.planner.DHXEv;
import com.dhtmlx.planner.DHXStatus;

public interface EventCalendarRepository
{
	public Iterable<DHXEv> getEvents();
	public Integer saveEvent(DHXEv event, DHXStatus status);
	public DHXEv createEvent(String id, DHXStatus status);
}
