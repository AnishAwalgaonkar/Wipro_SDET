package sdet_selenium_day_11;

import java.io.*;

public class IO_File_Handling {
 
	public static void main(String[] args) throws Exception
	{
		try
		{
		FileWriter fw=new FileWriter("anish.txt");
		fw.write("Hello Java IO ");
		fw.write("This file is created by java program");
		
		fw.close();
		System.out.println("File written successfully");
		}catch(IOException e)
		{
		System.out.println("Error occurred: " + e.getMessage());
		
		}
}
}
