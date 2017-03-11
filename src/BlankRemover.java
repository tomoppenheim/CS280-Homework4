//Tom Oppenheim Homework 4 10/14/2016

import java.util.*;
import java.io.*;
import java.io.File;

public class BlankRemover {
	
	public static void main(String args[])
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter the extension and file name of the file"
				+ " you would like to remove the blanks of");
		String extension = keyboard.nextLine();
		Scanner readFile = null;
		
		try {
			readFile = new Scanner(new FileInputStream(extension));
			String tempFileExtension = "temp" + extension;
			File tempFile = new File(tempFileExtension);
			while(tempFile.exists()){
				tempFile = new File(tempFileExtension + "x");
				tempFileExtension += "x";
			}
			PrintWriter outputStream = null;
			outputStream = new PrintWriter(new FileOutputStream(tempFileExtension));
			
			boolean blank = false;
			while(readFile.hasNextLine()){
				String readLine = readFile.nextLine();
				if (!readLine.equals(""))
					blank = false;
				
				if (!blank)
					outputStream.println(readLine);
				
				if(readLine.equals(""))
					blank = true; 
			}
				readFile.close();
				outputStream.close();
			
			
				readFile = new Scanner(new FileInputStream(tempFileExtension));
				outputStream = new PrintWriter(new FileOutputStream(extension));
				while(readFile.hasNextLine()){
					outputStream.println(readFile.nextLine());
				}
				readFile.close();
				outputStream.close();
				tempFile.delete();
				System.out.println("Blanks removed from file");
		}
		catch (FileNotFoundException e){
			System.out.println("File not found.");
		}
		
	}
		
}
