package se.guard.test;

import java.io.File;
import java.io.IOException;

import org.apache.maven.plugin.logging.Log;
import org.jibble.simpleftp.SimpleFTP;

public class FTPUpload
{

	public static void main(String[] args)
	{
		Log log =null;
		
		 try {
	            SimpleFTP ftp = new SimpleFTP(log);
	            
	            // Connect to an FTP server on port 21.
	            ftp.connect("zas.se", 21, "zas.se", "jjjzagat");
	            
	            // Set binary mode.
	            ftp.bin();
	            
	            // Change to a new working directory on the FTP server.
	            String web="http://www.zas.se/myfiles";
//	           String webftp= "/myfiles";
	            ftp.cwd(web);
//	            ftp.cwd(webftp);
	            
	            // Upload some files.
	            ftp.stor(new File("/Users/iraj/myfiles/clock/clock.css"));
	            ftp.stor(new File("clock.css"));
	            
	            // You can also upload from an InputStream, e.g.
//	            ftp.stor(new FileInputStream(new File("C:\\workspace\\test\\lars.xls")), "C:\\workspace\\test\\lars.xls");
//	            ftp.stor(someSocket.getInputStream(), "blah.dat");
	            
	            // Quit from the FTP server.
	            ftp.disconnect();
	        }
	        catch (IOException e) {
	            // Jibble.
	        }
	    
	    }        
	
}
