package se.guards.calendar;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import se.datalayer.guards.service.AdminCalendarService;
import se.datalayer.guards.service.ChooseGuardDutyService;
import se.datalayer.guards.service.DateTimeUtils;
import se.datalayer.guards.service.UserService;
import se.guard.Calendar;
import se.guard.DateAndTime;

@Controller
@RequestMapping
public class AdminCalendarController
{
	@Autowired
	private static AdminCalendarService dateService = new AdminCalendarService();

	@Autowired
	private static ChooseGuardDutyService guardDutyService = new ChooseGuardDutyService();

	@Autowired
	private static UserService us = new UserService();

	@RequestMapping(value = "/adminCalendar", method = RequestMethod.GET)
	public String getCalendar(ModelMap model, SecurityContextHolderAwareRequestWrapper request)
	{
		model.addAttribute("currentUser", getCurrentUsername());
		model.addAttribute("calendar", new Calendar());
		return "adminCalendar";

	}

	@RequestMapping(value = "/adminCalendar", method = RequestMethod.POST)
	public String addToCalendar(@ModelAttribute("calendar") Calendar calendarAttribute, ModelMap model, HttpServletRequest request, HttpServletResponse response)
	{

		String startTime = calendarAttribute.getStartHour() + ":" + calendarAttribute.getStartMinute();
		String endTime = calendarAttribute.getEndHour() + ":" + calendarAttribute.getEndMinute();

		int numberOfGuards = Integer.parseInt(calendarAttribute.getNumber());

		/* From the beginning, all dates and times are available */
		boolean isServiceAvailable = true;

		String startDate = calendarAttribute.getStartDate();
		String startWeekDay = calendarAttribute.getStartWeekDay();
		String startYearOnly = calendarAttribute.getStartYear();
		String startMontName = calendarAttribute.getStartMonthName();
		String startDayNumber = calendarAttribute.getStartDayNumber();
		String endDate = calendarAttribute.getEndDate();

		String endWeekDay = calendarAttribute.getEndWeekDay();
		String endYearOnly = calendarAttribute.getEndYear();
		String endMonthName = calendarAttribute.getEndMonthName();
		String endDayNumber = calendarAttribute.getEndDayNumber();

		DateAndTime dateAndTime = new DateAndTime(startDate, startTime, startWeekDay, endDate, endTime, endWeekDay, isServiceAvailable, numberOfGuards, startYearOnly,
				startMontName, startDayNumber, endYearOnly, endMonthName, endDayNumber);

		model.addAttribute("calendar", dateAndTime);
		dateService.addService(dateAndTime);

		return "redirect:/adminCalendar";
	}

	@RequestMapping(value = "/availableCalendar", method = RequestMethod.GET)
	public String getSavedCalendar(ModelMap model, HttpServletRequest request, HttpServletResponse response)
	{

		model.addAttribute("currentUser", getCurrentUsername());

		/* Get services only for the current year */
		String todaysdate = DateTimeUtils.getOnlyYear();
		Collection<DateAndTime> activeServices = dateService.getAllServicesFromThisYearAndSoOn(todaysdate);

		Collection<DateAndTime> noAvailableServices = dateService.getAll_Occupied_Services();
		/* Begin sorting the List on fly
		 * Need to sort the dates and times saved in database, maybe the are
		 * unsorted when they have been add. Have to create a List to compare and sort.
		 */
		final List<DateAndTime> sortList = new ArrayList<DateAndTime>(activeServices);

		Collections.sort(sortList, new Comparator<DateAndTime>()
		{
			public int compare(DateAndTime o1, DateAndTime o2)
			{
				if (o1.getStartYearOnly() == null || o2.getStartYearOnly() == null)
					return 0;
				return o1.getStartYearOnly().compareTo(o2.getStartYearOnly());
			}
		});
		/*
		 * End of the sorting on fly
		 */

		model.addAttribute("availableServices", sortList);
		model.addAttribute("noAvailableServices", noAvailableServices);

		return "availableCalendar";
	}


	private static String getCurrentUsername()
	{
		Object obj = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return obj instanceof UserDetails ? ((UserDetails) obj).getUsername() : obj.toString();
	}

}
