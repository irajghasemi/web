package se.guards.test;

import java.io.*;
import org.apache.commons.io.FileUtils;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.jibble.simpleftp.SimpleFTP;

public class FtpConnectDemo
{
	public static void main(String[] args)
	{
		try {
		    SimpleFTP ftp = new SimpleFTP(null);
		    
		    // Connect to an FTP server on port 21.
		    ftp.connect("www.zas.se", 21, "zas.se", "jjjzagat");
		    
		    // Set binary mode.
		    ftp.bin();
		    
		    // Change to a new working directory on the FTP server.
		    ftp.cwd("web");
		    
		    // Upload some files.
		    ftp.stor(new File("webcam.jpg"));
		    ftp.stor(new File("comicbot-latest.png"));
		    
		    // You can also upload from an InputStream, e.g.
		    ftp.stor(new FileInputStream(new File("test.png")), "test.png");
		    
		    // Quit from the FTP server.
		    ftp.disconnect();
		}
		catch (IOException e) {
		    // Jibble.
		}
	}
}