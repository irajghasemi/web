package se.guards.test;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.net.ftp.FTPClient;

public class FileUploadDemo {
    public static void main(String[] args) {
        FTPClient client = new FTPClient();
        FileInputStream fis = null;
 
        try {
            client.connect("www.zas.se");
            client.login("mail.zas", "jjjzagat");
 
            //
            // Create an InputStream of the file to be uploaded
            //
            String filename = "/Users/iraj/myfiles/apress-metro-revealed-freeman.pdf";
            fis = new FileInputStream(filename);
 
            //
            // Store file to server
            //
            client.pwd();
            client.changeWorkingDirectory("pic");
            client.storeFile(filename, fis);
            client.logout();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
                client.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}