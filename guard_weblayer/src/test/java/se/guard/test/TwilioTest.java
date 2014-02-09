package se.guard.test;

import java.util.*; 
import com.twilio.sdk.*; 
import com.twilio.sdk.resource.factory.*; 
import com.twilio.sdk.resource.instance.*; 
import com.twilio.sdk.resource.list.*; 
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
 
public class TwilioTest { 
 // Find your Account Sid and Token at twilio.com/user/account 
 public static final String ACCOUNT_SID = "ACc255038124339939f38ba44e0621262a"; 
 public static final String AUTH_TOKEN = "257cf1c3475e4973dfda4e45b7da764f"; 
 
 public static void main(String[]args) throws TwilioRestException { 
	TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN); 
 
	 // Build the parameters 
	 List<NameValuePair> params = new ArrayList<NameValuePair>(); 
	 params.add(new BasicNameValuePair("To", "+46707313330")); 
	 params.add(new BasicNameValuePair("From", "+46101388050")); 
	 params.add(new BasicNameValuePair("Body", "Test"));   
 
	 MessageFactory messageFactory = client.getAccount().getMessageFactory(); 
	 Message message = messageFactory.create(params); 
	 System.out.println(message.getSid()); 
 } 
}