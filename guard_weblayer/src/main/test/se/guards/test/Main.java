package se.guards.test;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;

import se.datalayer.guards.service.UserService;
import se.guard.Address;
import se.guard.User;

public class Main
{
	
	public static void main(String[] args)
	{
		
		addNewUser();
//		findAllUsers();
//		updateUser();
//		findUserById();
//		findUserByUserName();
		
	}
	
	@Autowired
	private static EntityManagerFactory entityManagerfactory = Persistence.createEntityManagerFactory("guards");
	@PersistenceContext(unitName="UserService")
	public static UserService us= new UserService();
	
	public static void addNewUser(){
		
		Calendar cal= Calendar.getInstance();
		cal.set(Calendar.DATE, 13);
		Date d= cal.getTime();
		System.out.println(d);
		
		Address ad1= new Address("Dvärglinsgränd 80 ", "165 77", "Stockholm");
		User user1= new User("iraj", "ghasemi",ad1);
		
		Address ad2= new Address("Dvärglinsgränd 80 ", "165 77", "Stockholm");
		User user2= new User("pappo", "ghasemi",ad2);
		
		Address ad3= new Address("Dvärglinsgränd 80 ", "165 77", "Stockholm");
		User user3= new User("sabo", "ghasemi",ad3);
		
		Address ad4= new Address("Maltesholmsvägen 139 ", "165 78", "Stockholm");
		User user4= new User("azi", "ghasemi",ad4);
		
		Address ad5= new Address("Dvärglinsgränd 124 ", "165 77", "Stockholm");
		User user5= new User("nasrin", "ghasemi",ad5);
		
		Address ad6= new Address("Kapriflovägen 60 ", "155 77", "Stockholm");
		User user6= new User("Gino", "ghasemi",ad6);
		Address ad7= new Address("kalifornia ", "155 77", "USA");
		User user7= new User("Roberto", "De Niro",ad7);
		
//		us.addNewUser(user1);
//		us.addNewUser(user2);
//		us.addNewUser(user3);
//		us.addNewUser(user4);
//		us.addNewUser(user5);
//		us.addNewUser(user6);
		us.addNewUser(user7);
	}
	
	
	public static void findUserById(){
		System.out.println(us.findUserById(2));
		
	}
	
	public static void findAllUsers(){
		
		System.out.println(us.findAllUsers());
		
	}
	
	public static void findUserByUserName(){
		
		String userfound="Iraj";
		Collection<User> uss=us.findUserByName(userfound);
		System.out.println(uss);
	}
	
	
	public static void updateUser(){
		Address address= new Address("Dvärglinsgränd", "16577", "Letland");
		User user= new User(2,"Iraj","ghasemi",address);
		us.updateUser(user);
	}

}
