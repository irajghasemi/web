package se.guard.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.collect.Lists;

import se.datalayer.guards.service.DateTimeUtils;
import se.datalayer.guards.service.DisplayImageService;
import se.datalayer.guards.service.UserService;
import se.guard.Address;
import se.guard.Role;
import se.guard.UploadImage;
import se.guard.User;

public class Main
{
	
	@Autowired
	private static EntityManagerFactory entityManagerfactory = Persistence.createEntityManagerFactory("guards");
	
	@PersistenceContext(unitName="UserService")
	public static UserService us= new UserService();

	@PersistenceContext(unitName="DisplayImageService")
	public static DisplayImageService imgService=new DisplayImageService();
	
	public static DateTimeUtils dateUtils;
	
	
	public static void main(String[] args)
	{
//		getTime();
//		getuser();
//		getImageInfo();
		
		 Scanner scanner = new Scanner( System.in );
         scanner.useDelimiter( "[/\n]" );

         System.out.print( "Birth Date (MM/DD/YYYY) " );
         int birthMonth = scanner.nextInt();
         int birthDay = scanner.nextInt();
         int birthYear = scanner.nextInt();
         scanner.close();

         System.out.printf( "Day(%02d), Month(%02d), Year(%04d)%n", birthDay, birthMonth, birthYear );

			
	}
	
	
	
	public static void  getImageInfo(){
	UploadImage img=	imgService.showImageByUserId(1);
	System.out.println(img);
	}
	
	
	
	
public static void getTime(){
		
	DateTime dd= new DateTime();
		System.out.println("Date is: "+DateTimeUtils.getDateNow());
		System.out.println("Only Time: "+DateTimeUtils.getOnlyTime());
		System.out.println("Only date: "+DateTimeUtils.getOnlyDate());
		System.out.println("Only year: "+dd.getYear());
		
	}


public static void  getuser(){
	
	User user=us.findUserByUsername("iraj");
	System.out.println(user);
	
}




}
