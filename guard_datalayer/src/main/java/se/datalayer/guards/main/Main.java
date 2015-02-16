package se.datalayer.guards.main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import org.joda.time.DateTime;
import org.joda.time.DateTimeFieldType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import se.datalayer.guards.service.AdminCalendarService;
import se.datalayer.guards.service.BlockeeService;
import se.datalayer.guards.service.DateTimeUtils;
import se.datalayer.guards.service.EmailService;
import se.datalayer.guards.service.ImageUploadService;
import se.datalayer.guards.service.ChooseGuardDutyService;
import se.datalayer.guards.service.SendEmailByGmailSMTP;
import se.datalayer.guards.service.UserService;
import se.datalayer.guards.utils.PersonNummer;
import se.guard.Address;
import se.guard.Blockee;
import se.guard.DateAndTime;
import se.guard.Role;
import se.guard.User;
import se.guard.ChooseGuardDuty;

public class Main
{
	@Autowired
	private static EntityManagerFactory entityManagerfactory = Persistence.createEntityManagerFactory("guards");
	@Autowired
	private static EntityManager entityManager = entityManagerfactory.createEntityManager();

	@PersistenceContext(unitName = "UserService")
	public static UserService us = new UserService();
	@PersistenceContext(unitName = "ImageUploadService")
	public static ImageUploadService img = new ImageUploadService();
	@PersistenceContext(unitName = "EmailService")
	public static EmailService em = new EmailService();
	@PersistenceContext(unitName = "BlockeeService")
	public static BlockeeService blockeeService = new BlockeeService();
	@PersistenceContext(unitName = "DateAndTimeService")
	public static AdminCalendarService calendarService = new AdminCalendarService();
	@PersistenceContext(unitName = "SendEmailByGmailSMTP")
	public static SendEmailByGmailSMTP sm = new SendEmailByGmailSMTP();
	@PersistenceContext(unitName = "DateTimeUtils")
	public static DateTimeUtils dateUtils = new DateTimeUtils();

	public static PersonNummer pr;
	private static DateTime d = new DateTime();

	@PersistenceContext(unitName = "PickingDatesAndTimesService")
	public static ChooseGuardDutyService pickingDatesAndTimesService = new ChooseGuardDutyService();

	public static String encodePasswordWithBCrypt(String plainPassword)
	{
		return new BCryptPasswordEncoder().encode(plainPassword);
	}

	public static void hashedPassword()
	{
		String hash = encodePasswordWithBCrypt("iraj");
		String hash1 = encodePasswordWithBCrypt("iraj");
		System.out.println("This is salted and BCrypted password: " + hash);
		System.out.println("This is salted and BCrypted password: " + hash1);
	}

	public static void main(String[] args) throws MessagingException, IOException
	{

		// PersonNummer pNo = PersonNummer.personummer("6311228313");
		// System.out.println(pNo.getBirthNumber());
		// System.out.println(pNo.getFull());
		// System.out.println(pNo.getYear());
		// System.out.println(pNo.getShort());
		// String str="mekonomen";
		// System.out.println("The original string is: "+str);
		// reverseString(str);
		// System.out.println("And the reverse of the string is: "+reverseString(str));

		// reverseStringWithFor(str);

		// String originalPassword ="iraj";
		// String generatedSecuredPasswordHash = BCrypt.hashpw(originalPassword,
		// BCrypt.gensalt(12));
		// System.out.println(generatedSecuredPasswordHash);
		//
		// boolean matched = BCrypt.checkpw(originalPassword,
		// generatedSecuredPasswordHash);
		// System.out.println(matched);

		// hashedPassword();

		/******************* USER ***************************************/
		// findSingelUserByEmail();
		// findUserByEmail();
		// finduserbyusername();
		// addNewUser();
		// findAllUsers();
		// updateUser();
		// findUserById();
		// findbyanyparameter();
		// findUserByFirstNameLastName();
		// findUserBySearchString();
		// deleteUser();
		// getTime();
		// findUserByFirstName();
		// findUserByUserName();
		// getUserByParam();

		// findbyanyValue();
		// findbypassword();

		 findUserByCivicRegistraionNumber();

		// sendEmail();
		// doUserExist();
		/********************** BLOCKEE **********************************/
		// addToBlockee();
		// showAllBlockee();
		// findBlockeeByBlockerId();
		// deleteBlockee();
		// findBlockeeByBlockerIdAndBlockedId();
		// containsOnlyNumber();
		// findBlockeeByAnyValue();
		/********************* ADMIN CALENDAR *******************************/
		// addToDateAndTime();
		// doDateExist();
		// getDateAndTimeByRange();
		// getDateAndTimeBetweenTwoDates();
		// updateDateAndTime();
		// removeDateAndTime();
		// getAllDateAndTime();
		// getSingelTimeAndDateById();
		// getAll_Occupied_Services();
		// getAll_Available_Services();
		// testDateAndTime();

		/************************* PICKING CALENDAR *************************/
//		 addPickingDatesAndTimes();
		// dopickedDateExist();
		
//		 getAllPieckeddates();
		
		// getPickingServiceByUserId();
//		 get_SingelPickedServiceById();
		// getPickingService_ByUser_Ids();

		// getPickedServiceByEmail();

		// doesTheUseralreadyExistInDB();
		// checkIfUserAlreadyBookedTheSameService();
		// checkIfUserWantsToBookTheSameService();
//		getAllPickedServiceByDateAndTime_id();

		/************************* Reverse String *************************/
		// reverseString();
		// reverseStringWithFor();

	}

	public static void getAllPickedServiceByDateAndTime_id()
	{

		int dateAndTimeId = 12;
		Collection<ChooseGuardDuty> list = pickingDatesAndTimesService.getAllPickedServiceByDateAndTime_id(dateAndTimeId);
		for (ChooseGuardDuty res : list)
		{
			if(res.getUserTwo()==null){
				System.out.println("Date Id: "+res.getDateAndTime().getDateAndTime_id()+" One CivicNr "+ res.getUserOne().getCivicregnumber());
			}
			else{
				
				System.out.println("Date Id: "+res.getDateAndTime().getDateAndTime_id()+" One CivicNr "+ res.getUserOne().getCivicregnumber()+ " Two CivicNr : "+res.getUserTwo().getCivicregnumber());
			}
		}
	}

	public static void checkIfUserWantsToBookTheSameService()
	{
		int serviceId = 1;
		int userId = 10;
		System.out.println(pickingDatesAndTimesService.checkIfUserWantsToBookTheSameServiceTwise(serviceId, userId));

	}

	public static void checkIfUserAlreadyBookedTheSameService()
	{
		int serviceId = 10;
		int userId = 1;
		Collection<ChooseGuardDuty> list = pickingDatesAndTimesService.checkIfUserAlreadyBookedTheSameService(serviceId, userId);

		for (ChooseGuardDuty user : list)
		{
			System.out.println(user.getPickedService_id());

		}

	}

	public static void doesTheUseralreadyExistForBookingServiceInDB()
	{
		User userOne = us.findUserByMail("***************");
		User userTwo = us.findUserByMail("***************");
		User userThree = us.findUserByMail("person@c.com");
		User userFour = us.findUserByMail("***************");
		// System.out.println("alter 1: "+pickingDatesAndTimesService.doesPickedDateExist(userOne));
		// System.out.println("alter 2: "+pickingDatesAndTimesService.doesPickedDateExist(userTwo));
		// System.out.println("alter 3: "+pickingDatesAndTimesService.doesPickedDateExist(userThree));
		System.out.println("alter 4: " + pickingDatesAndTimesService.doesTheUseralreadyExistForBookingServiceInDB(userFour));

	}

	/*****************************************************************************************************************/

	public static void getPickedServiceByEmail()
	{
		String email = "***************";
		String email1 = "***************";
		String email2 = "***************";

		Collection<ChooseGuardDuty> userPickingDate = pickingDatesAndTimesService.getPickedServiceByEmail(email);

		for (ChooseGuardDuty res : userPickingDate)
		{

			System.out.println("picked date Id" + res.getPickedService_id() + " date and time id: " + res.getDateAndTime().getDateAndTime_id());
		}

	}

	public static void getPickingService_ByUser_Ids()
	{

		Collection<ChooseGuardDuty> userPickingDate = pickingDatesAndTimesService.getPickingService_ByUser_Ids(1, 2);
		for (ChooseGuardDuty out : userPickingDate)
		{
			System.out.println("service Id: " + out.getPickedService_id() + "\nuser one id: " + out.getUserOne().getUserid() + "\nuser tow id: "
					+ out.getUserTwo().getUserid() + "\ndate and time id: " + out.getDateAndTime().getDateAndTime_id());

		}
	}

	public static void get_SingelPickedServiceById()
	{

		System.out.println(pickingDatesAndTimesService.get_SingelPickedServiceById(1));
	}

	public static void getAllPieckeddates()
	{
		Collection<ChooseGuardDuty> list = pickingDatesAndTimesService.getAllPickedDates();
		for (ChooseGuardDuty result : list)
		{
			System.out.println(result.getDateAndTime());
			// System.out.println(pickingDatesAndTimesService.getAllPickedDates());
		}
	}

	public static void getPickingServiceByUserId()
	{

		System.out.println(pickingDatesAndTimesService.getPickingServiceByUserId(1));
	}

	/*********************************************************************************************************************************************/
	/******************************************************* REVERSE A STRING **************************************************************************************/
	/*
	 * This how you can reverse a string in java
	 */
	public static String reverseString()
	{
		String str = "Golestan";
		System.out.println(reverseString(str));
		return str;
	}

	public static String reverseString(String str)
	{
		if ((null == str) || (str.length() <= 1))
		{
			return str;
		}
		return reverseString(str.substring(1)) + str.charAt(0);
	}

	/*************************** METHOD 2 ***************************************/

	public static String reverseStringWithFor(String original)
	{
		String reverse = "";
		for (int i = original.length() - 1; i >= 0; i--)
		{
			reverse = reverse + original.charAt(i);
		}
		return reverse;
	}

	public static String reverseStringWithFor()
	{
		String original = "KERMANSHAH";
		System.out.println(reverseStringWithFor(original));
		return original;
	}

	/*********************************************************************************************************************************************/
	/****************************************************** EMAIL ***************************************************************************************/
	public static void findUserByEmail()
	{
		Collection<User> user = us.findUserByEmail("***************");
		for (User user2 : user)
		{
			System.out.println("from collection: " + user2);
		}
	}

	public static void findSingelUserByEmail()
	{
		String email = "***************";
		User user = us.findUserByMail(email);
		System.out.println(user);
	}

	/**************************************************************** USER *****************************************************************************/
	public static void finduserbyusername()
	{
		User user = us.findUserByUsername("iraj");
		System.out.println(user);
	}

	public static void doUserExist()
	{
		User user = us.findUserById(1);
		System.out.println(us.doUserExist(user));

	}

	/**************************************************** PickingDatesAndTimes ******************************************/

	public static void addPickingDatesAndTimes()
	{
		DateAndTime d = calendarService.getSingelServiceById(12);
		DateAndTime d1 = calendarService.getSingelServiceById(13);
		DateAndTime d2 = calendarService.getSingelServiceById(14);
		// DateAndTime dd= new
		// DateAndTime(d.getDateAndTime_id(),d.getStartDate(), d.getEndDate(),
		// d.getStartTime(), d.getEndTime(),true,true,true,true);
//		System.out.println(d);
		User user1 = us.findUserById(1);
		User user2 = us.findUserById(2);
		User user3 = us.findUserById(3);
		User user4 = us.findUserById(6);
		// User user5 = us.findUserById(2);
		// User user6 = us.findUserById(3);

		ChooseGuardDuty pickingsDates = new ChooseGuardDuty(user4, user3, d);
		ChooseGuardDuty pickingsDates1 = new ChooseGuardDuty(user3, user2, d1);
		ChooseGuardDuty pickingsDates2 = new ChooseGuardDuty(user1, user2, d2);
		pickingDatesAndTimesService.addPickedService(pickingsDates);
		pickingDatesAndTimesService.addPickedService(pickingsDates1);
		pickingDatesAndTimesService.addPickedService(pickingsDates2);
		
		
		
	}

	/**************************************************** DTAE AND TIME ******************************************/

	public static void getAll_Occupied_Services()
	{
		System.out.println(calendarService.getAll_Occupied_Services());
	}

	public static void getAll_Available_Services()
	{
		System.out.println(calendarService.getAll_Available_Services());
	}

	public static void doDateExist()
	{
		System.out.println(calendarService.doDateAndTimeExist("13-09-18", "13-11-27"));
	}

	public static void getDateAndTimeByRange()
	{
		System.out.println(calendarService.getService_ByRange("14-01-20", "14-01-27"));
	}

	public static void getDateAndTimeBetweenTwoDates()
	{
		System.out.println(calendarService.getService_BetweenTwoDates("13-09-18", "14-03-18"));
	}

	public static void addToDateAndTime()
	{
		int numberOfTimes = 2;

		// for (int i = 0; i < numberOfTimes; i++)
		// {
		//
		// DateAndTime dateAndTime2 = new DateAndTime("14-02-24", "14-02-26",
		// "08:00", "12:00", true, numberOfTimes);
		//
		// System.out.println(dateAndTimeService.addService(dateAndTime2));
		// }
		for (int i = 0; i < numberOfTimes; i++)
		{

			DateAndTime dateAndTime2 = new DateAndTime("13-02-28", "13-03-01", "20:00", "04:00", false, numberOfTimes);

			System.out.println(calendarService.addService(dateAndTime2));
		}

	}

	public static void updateDateAndTime()
	{
		DateAndTime date = calendarService.getSingelServiceById(1);

		DateAndTime dateAndTime = new DateAndTime(1, "23-05-13", "13-06-15", "18:00", "02:00", true, date.getNumberOfGuards());
		System.out.println(calendarService.updateService(dateAndTime));

	}

	public static void removeDateAndTime()
	{
		System.out.println(calendarService.removeService(5));
	}

	public static void getAllDateAndTime()
	{
		System.out.println(calendarService.getAllDateAndTime());
	}

	public static void getSingelTimeAndDateById()
	{
		System.out.println(calendarService.getSingelServiceById(12));
	}

	public static void testDateAndTime()
	{

		// DateTimeUtils dt= new DateTimeUtils();
		DateTime dt = new DateTime();
		String monthName = dt.monthOfYear().getAsText();
		System.out.println(monthName);
		String frenchShortName = dt.monthOfYear().getAsShortText(Locale.US);
		System.out.println(frenchShortName);
		boolean isLeapYear = dt.year().isLeap();
		System.out.println(isLeapYear);
		DateTime rounded = dt.dayOfMonth().roundFloorCopy();
		System.out.println(rounded);

	}

	/**************************************************** BLOCKEE ******************************************/

	public static void findBlockeeByAnyValue()
	{
		// The query is wrong and must be fixed(correct) later.
		// System.out.println(blockeeService.findBlockee_ByNayValue("iraj"));
	}

	public static void containsOnlyNumber()
	{
		System.out.println(containsOnlyNumbers("2"));
		System.out.println(containsOnlyNumbers("iraj"));
	}

	public static void findBlockeeByBlockerIdAndBlockedId()
	{
		System.out.println(blockeeService.findBlockee_ByBlockerId_And_BlockedId(3, 6));

	}

	public static void findBlockeeByBlockerId()
	{

		System.out.println(blockeeService.findBlockee_ByBlockeeId(1));

	}

	public static void deleteBlockee()
	{

		Blockee blockee = blockeeService.findBlockee_ByBlockeeId(1);
		blockeeService.deleteUserFromBlockee(blockee);

	}

	public static void showAllBlockee()
	{
		System.out.println(blockeeService.showBlockee());

	}

	public static void addToBlockee()
	{
		User user1 = us.findUserByAnyParameter("iraj");
		User user2 = us.findUserByAnyParameter("julia");
		User user3 = us.findUserByAnyParameter("masti");
		User user4 = us.findUserByAnyParameter("sabo");
		// User user5 = us.findUserByAnyParameter("p");

		Blockee b1 = new Blockee(user1, user2);
		Blockee b2 = new Blockee(user3, user4);
		Blockee b3 = new Blockee(user4, user3);
		Blockee b4 = new Blockee(user1, user3);
		// Blockee b5 = new Blockee(user1, user5);
		blockeeService.addUserToBlockee(b1);
		blockeeService.addUserToBlockee(b2);
		blockeeService.addUserToBlockee(b3);
		blockeeService.addUserToBlockee(b4);
		// blockeeService.addUserToBlockee(b5);
		System.out.println(" added to Blockee:" + b1 + "\n" + b2 + "\n" + b3);
	}

	/**************************************************** EMAIL ******************************************/
	public static void sendEmail()
	{
		String email = "***************";
		try
		{
			sm.send(email, "test main", "test main");
			System.out.println("Email has been sended to your email address at : " + email);
		}
		catch (AddressException e)
		{
			e.printStackTrace();
		}
		catch (MessagingException e)
		{
			e.printStackTrace();
		}
	}

	/**************************************************** USER ******************************************/

	public static void findUserByFirstNameLastName()
	{
		String firstname = "iraj";
		String lastname = "ghasemi";

		System.out.println("by first and last name " + us.findUserByFirstNameLastName(firstname, lastname));

	}

	public static void findUserBySearchString()
	{
		String firstname = "***************";

		System.out.println("by first or last name " + us.findUserByASerachString(firstname));

	}

	public static void findbyanyparameter()
	{
		System.out.println("by bayanyparam " + us.findUserByAnyParameter("631122....."));
	}

	public static void findbypassword()
	{
		System.out.println("by password " + us.findUserByPassword("julia"));
	}

	public static void findbyanyValue()
	{
		System.out.println("by anyvalue" + us.findUserByAnyValue("6311........"));
	}

	public static void getTime()
	{

		System.out.println("Date is: " + DateTimeUtils.getDateNow());
		System.out.println("Only Time: " + DateTimeUtils.getOnlyTime());
		System.out.println("Only date: " + DateTimeUtils.getOnlyDate());
		System.out.println("day name : " + DateTimeUtils.getDayOfTheWeek().getAsShortText());
		System.out.println("month name : " + DateTimeUtils.getNameOfTheMonth());
		System.out.println("month number : " + DateTimeUtils.getNumberOfTheMonth());
		System.out.println("day number : " + DateTimeUtils.getDayNumber());
		System.out.println("year :  " + DateTimeUtils.getOnlyDate().get(DateTimeFieldType.year()));

	}

	/*********************************************************************************************/

	public static void findUserByCivicRegistraionNumber()
	{

		User user = us.findUserByCivicRegistraionNumber("6311........");
		System.out.println(user);
	}

	public static void addNewUser()
	{
		List<Role> roles_user = new ArrayList<Role>();
		List<Role> roles_admin = new ArrayList<Role>();
		List<Role> roles_admin_user = new ArrayList<Role>();

		String role_admin = "ROLE_ADMIN";
		String role_user = "ROLE_USER";

		roles_user.add(new Role(role_admin));
		roles_admin.add(new Role(role_user));
		roles_admin_user.add(new Role(role_user));
		roles_admin_user.add(new Role(role_admin));

		Address ad = new Address("Dvärglinsgränd 80 ", "165 77", "Stockholm");
		User user = new User("iraj", "ghasemi", "iraj", "golestan", "iraj@zas.se", true, ad, roles_admin);

		Address ad1 = new Address("Dvärglinsgränd 80 ", "165 77", "Stockholm");
		User user1 = new User("pappo", "masti", "amanda", "password", "email", true, ad1, roles_user);

		Address ad2 = new Address("Dvärglinsgränd 80 ", "165 77", "Stockholm");
		User user2 = new User("ww", "ghasemi", "sabbo", "pppp", "iraj@zas.se", true, ad2, roles_admin);

		Address ad3 = new Address("Dvärglinsgränd 80 ", "165 77", "Stockholm");
		User user3 = new User("Jessica", "Biel", "iraj", "min", "jessica@biel.se", true, ad3, roles_admin);

		Address ad4 = new Address("Manhatan ", "123 45", "USA");
		User user4 = new User("Rober", "De Niro", "movie", "Maffia", "mail@acter.com", true, ad4, roles_user);

		Address ad5 = new Address("Wall Street ", "54321", "USA");
		User user5 = new User("Badboy", "Bad women", "money", "Real Maffia", "maffia@maffia.com", false, ad5, roles_user);

		Address ad6 = new Address("test ", "test", "test");
		User user6 = new User("test", "test", "test", "test", "test@maffia.com", true, ad5, roles_admin);

		Address ad7 = new Address("test ", "test", "test");
		User user7 = new User("test", "test", "test", "test", "test@maffia.com", true, ad5, roles_admin);

		Address ad8 = new Address("Badboy ", "Badboy", "Badboy");
		User user8 = new User("Badboy", "Badboy", "631", "Badboy", "Badboy", "maffia@maffia.com", false, ad8, roles_user);
		us.addNewUser(user8);
		// us.addNewUser(user1);
		// us.addNewUser(user2);
		// us.addNewUser(user3);
		// us.addNewUser(user4);
		// us.addNewUser(user5);
		// us.addNewUser(user6);
		// us.addNewUser(user7);
		// us.addNewUser(user8);
		// us.addNewUser(user9);
	}

	public static void findUserById()
	{
		System.out.println("by id " + us.findUserById(1));

	}

	public static void findAllUsers()
	{

		System.out.println(us.findAllUsers());

	}

	public static void findUserByUserName()
	{

		String userfound = "shervin";
		Collection<User> uss = us.findUserByUserName(userfound);
		System.out.println("by user name" + uss);
	}

	public static void findUserByFirstName()
	{

		String userfound = "iraj";
		Collection<User> uss = us.findUserByFirstName(userfound);
		System.out.println("by first name" + uss);
	}

	public static void deleteUser()
	{

		System.out.println("user is deleted: " + us.findUserById(5));
		us.deleteUser(us.findUserById(5));

	}

	public static void updateUser()
	{
		List<Role> roles_user = new ArrayList<Role>();

		String role_user = "ROLE_USER";

		roles_user.add(new Role(role_user));

		Address address = new Address("Dvärglinsgränd", "16577", "Letland");

		User user = new User(2, "Iran", "Biston", "kermanshah", "Shahyad", "shah@gmail.com", true, address, roles_user);
		us.updateUser(user);
	}

	public static void getUserByParam()
	{
		System.out.println("by param " + us.findUserByAnyValue("ghasemi"));
	}

	public static boolean containsOnlyNumbers(String str)
	{

		// It can't contain only numbers if it's null or empty...
		if (str == null || str.length() == 0)
			return false;

		for (int i = 0; i < str.length(); i++)
		{

			// If we find a non-digit character we return false.
			if (!Character.isDigit(str.charAt(i)))
				return false;
		}

		return true;
	}

}
