package Day12;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
 
public class Writefiledemo {
public static void main(String[] args)
	{
 
		try {
			FileWriter writer = new FileWriter("teja.txt");
			
			writer.write("Welcome to Java IO Classes");
			writer.write("\nLearning File Handling");
 
			writer.close();
			System.out.println("Data Written Successfully");
			}
 
		catch(IOException e)
            {
            	System.out.println(e);
            }
	}
	}
 
 
