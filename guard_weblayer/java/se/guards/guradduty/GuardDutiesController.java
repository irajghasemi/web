package se.guards.guradduty;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import se.datalayer.guards.service.AdminCalendarService;
import se.datalayer.guards.service.ChooseGuardDutyService;
import se.datalayer.guards.service.UserService;
import se.guard.ChooseGuardDuty;
import se.guard.DateAndTime;
import se.guard.User;

@Controller
@RequestMapping
public class GuardDutiesController
{
	@Autowired
	private static AdminCalendarService dateService = new AdminCalendarService();

	@Autowired
	private static ChooseGuardDutyService guardDutyService = new ChooseGuardDutyService();

	@Autowired
	private static UserService us = new UserService();

	@RequestMapping(value = "/singleService", method = RequestMethod.GET)
	public String getOneSingelService(@RequestParam("dateAndTime_id") String dateAndTime_id, Model model, HttpServletRequest requet)
	{
		model.addAttribute("currentUser", getCurrentUsername());
		int parseServiceIdToInt = Integer.parseInt(dateAndTime_id);
		DateAndTime getSingelService = dateService.getSingelServiceById(parseServiceIdToInt);

		if (getSingelService.isServiceAvailable() != true)
		{

			return "redirect:/availableCalendar";
		}

		model.addAttribute("singleService", getSingelService);
		model.addAttribute("currentUser", getCurrentUsername());

		return "singleService";
	}

	@RequestMapping(value = "/singleService", method = RequestMethod.POST)
	public String addUserGuardDutyToDB(@RequestParam("dateAndTime_id") int dateAndTime_id, Model model, HttpServletRequest request)
	{
		DateAndTime date = dateService.getSingelServiceById(dateAndTime_id);
		Collection<ChooseGuardDuty> list = guardDutyService.getAllPickedServiceByDateAndTime_id(dateAndTime_id);
		User user = us.findUserByUsername(getCurrentUsername());
		if (list.isEmpty())
		{
			ChooseGuardDuty addserv = new ChooseGuardDuty(dateAndTime_id, user, null, date);
			updateNumberOfGuardsAndAvailability(dateAndTime_id);
			guardDutyService.addPickedService(addserv);
			System.out.println("1: "+ addserv);
			return "mybookedServices";
		}
		for (ChooseGuardDuty info : list)
		{

			
			if (info.getDateAndTime().getDateAndTime_id() == dateAndTime_id && (info.getUserOne()!=user && info.getUserTwo() ==null))
			{
				ChooseGuardDuty addserv = new ChooseGuardDuty(info.getPickedService_id(), info.getUserOne(), user, date);
				updateNumberOfGuardsAndAvailability(dateAndTime_id);
				guardDutyService.updatePickedService(addserv);
				return "mybookedServices";
			}
			if (info.getDateAndTime().getDateAndTime_id() == dateAndTime_id && (info.getUserOne()!=user || info.getUserTwo()!=user))
			{
				model.addAttribute("error", "error");
				return "singleService";
			}
			if (info.getDateAndTime().getDateAndTime_id() == dateAndTime_id && info.getUserOne()!=user )
			{
				model.addAttribute("error", "error");
				 return "singleService";
			}
		}
		model.addAttribute("error", "Service Already Booked Once");
		return "mybookedServices";
	}


	private static DateAndTime updateNumberOfGuardsAndAvailability(int dateAndTime_id)
	{
		DateAndTime date = dateService.getSingelServiceById(dateAndTime_id);
		if (date.getNumberOfGuards() > 0 && date.isServiceAvailable() == true)
		{
			int calendar_id = date.getDateAndTime_id();
			String startDate = date.getStartDate();
			String startTime = date.getStartTime();
			String startWeekDay = date.getEndWeekDay();
			String startYearOnly = date.getStartYearOnly();
			String startMonthName = date.getStartMontName();
			String startDayNumber = date.getStartDayNumber();
			String endDate = date.getEndDate();
			String endTime = date.getEndTime();
			String endWeekDay = date.getEndWeekDay();
			String endYearOnly = date.getEndYearOnly();
			String endMonthName = date.getEndMonthName();
			String endDayNumber = date.getEndDayNumber();
			int numberOfGuard = date.getNumberOfGuards();
			if (numberOfGuard > 1)
			{
				numberOfGuard--;
				date.setNumberOfGuards(numberOfGuard);
				DateAndTime updateDateAndTime = new DateAndTime(calendar_id, startDate, startTime, startWeekDay, endDate, endTime, endWeekDay, true, numberOfGuard,
						startYearOnly, startMonthName, startDayNumber, endYearOnly, endMonthName, endDayNumber);
				DateAndTime updateService = dateService.updateService(updateDateAndTime);
				return updateService;
			}
			else if (numberOfGuard == 1)
			{
				numberOfGuard = 0;
				date.setNumberOfGuards(numberOfGuard);
				date.setServiceAvailable(false);
				DateAndTime updateDateAndTime = new DateAndTime(calendar_id, startDate, startTime, startWeekDay, endDate, endTime, endWeekDay, false, 0, startYearOnly,
						startMonthName, startDayNumber, endYearOnly, endMonthName, endDayNumber);
				DateAndTime updateService = dateService.updateService(updateDateAndTime);
				return updateService;
			}

		}
		return null;

	}

	private static String getCurrentUsername()
	{
		Object obj = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return obj instanceof UserDetails ? ((UserDetails) obj).getUsername() : obj.toString();
	}

}
