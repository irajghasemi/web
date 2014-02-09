package se.restful.mainforclient;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

public class FileReader
{
	static public String readfile(File file)
	{
		StringBuffer content = new StringBuffer();
		try
		{

			BufferedReader reader = new BufferedReader(new java.io.FileReader(file));
			try
			{

				String line=null;
				while((line= reader.readLine()) !=null){
					content.append(line).append(System.getProperty("line.separator"));
				}
			}
			finally
			{
				reader.close();
			}
		}
		catch (IOException e)
		{
			content.append(e.getMessage());
			e.printStackTrace();
			
		}
		return content.toString();
	}

	public static void main(String[] args)
	{
		File file=new File("/Users/c3l/Desktop/xmlandjson");
		System.out.println(FileReader.readfile(file));

	}

}
