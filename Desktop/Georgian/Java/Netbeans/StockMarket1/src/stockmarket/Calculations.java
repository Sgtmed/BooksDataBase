/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stockmarket;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.Date;
import java.util.List;

import java.util.Scanner;
import java.util.StringTokenizer;



/**
 *
 * @author Sgtmed
 */
public class Calculations {
 @SuppressWarnings({"UseSpecificCatch", "ConvertToTryWithResources"})
 public static void PrintDateArray()
	{
				System.out.println("\nPrint date Array");
				System.out.println("****************************");
				// .csv file where data is coming from
				String fileName = "C:\\temp\\newBBD.csv";
				// Creates a new file to store date from .csv file
				File file = new File(fileName);
				/****************lookup file******************/ 
				// Headings
				int lineNumber = 0;
				String Heading0 = "Date";
				// prints heading
				System.out.printf("%7s" , Heading0);
				System.out.println();
				System.out.println("-------------------");
			try
			{
				
				//create Scanner to read the file
				Scanner inputStream = new Scanner(file);
				while(inputStream.hasNext()&& lineNumber <20)
				{
					lineNumber++;
					//reads whole line
					String info = inputStream.next();
					// splits each row into columns when a comma is reached
					String[] data = info.split(",");
					// convert to date
					SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
					Date date = sdf.parse(data[0]);
					//List list = new ArrayList(Arrays.asList(sdf.format(date)));
					System.out.println(date);
					double open = Double.parseDouble(data[1]);
				}
				
				inputStream.close();
				
			} catch(Exception e)
			{
				System.out.println("Exception while reading csv file: " + e);			
			}
	}


	public static void PrintDataArray()
	{
				System.out.println("\nPrint dataArray");
				System.out.println("****************************");
				// .csv file where data is coming from
				String fileName = "C:\\temp\\newBBD.csv";
				// Creates a new file to store date from .csv file
				File file = new File(fileName);
				/****************lookup file******************/ 
				// Headings
				int lineNumber = 0;
				String Heading1 = "Open";
				String Heading2 = "High";
				String Heading3 = "Low";
				String Heading4 = "Close";
				String Heading5 = "sAdj Close";
				String Heading6 = "Volume";
				System.out.printf("|%6s  |%6s  |%6s  |%7s  |%11s | %11s",Heading1, Heading2, Heading3, Heading4, Heading5, Heading6 + " |" + "\n");
				System.out.println("--------------------------------------------------------------");
			try
			{
				
				//create Scanner to read the file
				Scanner inputStream = new Scanner(file);
				while(inputStream.hasNext()&& lineNumber <20)
				{
					lineNumber++;
					//reads whole line
					String info = inputStream.next();
					// splits each row into columns when a comma is reached
					String[] data = info.split(",");
					// convert to float
					double open = Double.parseDouble(data[1]);
					double high = Double.parseDouble(data[2]);
					double low = Double.parseDouble(data[3]);
					double close =Double.parseDouble(data[4]);
					double sAdjClose = Double.parseDouble(data[5]);
					int volume = Integer.parseInt(data[6]);
					//float [][] dataArray = new float[][]{open, high, low, close, sAdjClose, voleume};
			
					
					System.out.println(String.format("| %.3f | %6.3f | %6.3f | %6.4f | %6.7f | %8d |" , open, high, low, close, sAdjClose, volume));
				}
				
				inputStream.close();
				
			} catch(FileNotFoundException | NumberFormatException e)
			{
				System.out.println("Exception while reading csv file: " + e);			
			}
	}
public static void Market()
	{
				System.out.println("\nPrint dataArray");
				System.out.println("****************************");
				// .csv file where data is coming from
				String fileName = "C:\\temp\\newBBD.csv";
				// Creates a new file to store date from .csv file
				File file = new File(fileName);
				/****************lookup file******************/ 
				// Headings
				int lineNumber = 0;
                                String Heading0 = "Date";
				String Heading1 = "Open";
				String Heading2 = "High";
				String Heading3 = "Low";
				String Heading4 = "Close";
				String Heading5 = "sAdj Close";
				String Heading6 = "Volume";
				System.out.printf("|%7s |%6s  |%6s  |%6s  |%7s  |%11s | %11s",Heading0, Heading1, Heading2, Heading3, Heading4, Heading5, Heading6 + " |" + "\n");
				System.out.println("--------------------------------------------------------------");
			try
			{
				
				//create Scanner to read the file
				Scanner inputStream = new Scanner(file);
				while(inputStream.hasNext()&& lineNumber <20)
				{
					lineNumber++;
					//reads whole line
					String info = inputStream.next();
					// splits each row into columns when a comma is reached
					String[] data = info.split(",");
					// convert to float
                                        String date = String.format(data[0]);
					double open = Double.parseDouble(data[1]);
					double high = Double.parseDouble(data[2]);
					double low = Double.parseDouble(data[3]);
					double close =Double.parseDouble(data[4]);
					double sAdjClose = Double.parseDouble(data[5]);
					int volume = Integer.parseInt(data[6]);
					//float [][] dataArray = new float[][]{open, high, low, close, sAdjClose, voleume};
                                        List marketData = new ArrayList<>();
                                        marketData.add(0,date);
                                        marketData.add(1, open);
                                        marketData.add(2,high);
                                        marketData.add(3, low);
                                        marketData.add(4, close);
                                        marketData.add(5, sAdjClose);
                                        marketData.add(6, volume);
                                        
                                        System.out.println(marketData);
					
					//System.out.println(String.format("|%7s %.3f | %6.3f | %6.3f | %6.4f | %6.7f | %8d |" ,date, open, high, low, close, sAdjClose, volume));
				}
				
				inputStream.close();
				
			} catch(FileNotFoundException | NumberFormatException e)
			{
				System.out.println("Exception while reading csv file: " + e);			
			}
	}
 @SuppressWarnings("UseSpecificCatch")
		public static void BasicCalculations()
		{
                    List<Double> highestOpening = new ArrayList<>();
                    List<Double> highestClosing = new ArrayList<>();
                    List<Double> lowestOpening = new ArrayList<>();
                    List<Double> lowestClosing = new ArrayList<>();
                    double maxValue = 0;
                    double minValue = 10000000;
	
			try
			{
				//.csv file where data is coming from
				String csvFile = "C:\\temp\\newBBD.csv";
			
				//create BufferedReader to read the file
				BufferedReader bufferedReader = new BufferedReader( new FileReader(csvFile));
                                @SuppressWarnings("UnusedAssignment")
				String line = "";
				int lineNumber = 0;
				int tokenNumber = 0;
			
				//read file line by line
				while( (line = bufferedReader.readLine()) != null && lineNumber <20)
				{
					lineNumber++;
					// Initializing ArrayList
					ArrayList<String> csvArray = new ArrayList<>();
					// break up data into tokens/ pieces
					StringTokenizer z = new StringTokenizer(line, ","); 
					while(z.hasMoreTokens())
					{
						// assigns token number for each values from csv File
						tokenNumber++;
						String token = z.nextToken();
						//add each token to the Array list
						csvArray.add(token);	
					
					}
						//prints data
                                               // double open = Double.parseDouble(data[1]);
                                              //  double high = Double.parseDouble(data[2]);
                                               // double low = Double.parseDouble(data[3]);
                                               // double close =Double.parseDouble(data[4]);
                                               // double sAdjClose = Double.parseDouble(data[5]);
                                               // int volume = Integer.parseInt(data[6]);
						
						//Highest Opening and Closing
						highestOpening.add(Double.parseDouble(csvArray.get(1)));
						highestClosing.add(Double.parseDouble(csvArray.get(4)));
						//Lowest Opening and Closing
						lowestOpening.add(Double.parseDouble(csvArray.get(1)));
						lowestClosing.add(Double.parseDouble(csvArray.get(4)));
					
						tokenNumber = 0;
				}	
					System.out.println("------------------------------------------------------------");
			}
			catch(Exception e)
			{
				System.out.println("Exception while reading csv file: " + e);			
			}
// Highest opening value
			for(double value: highestOpening) {
				if(value > maxValue) {
					maxValue = value;
				}
			}
			System.out.println("Highest Opening Value: " + maxValue);
			
			// Highest closing value
			for(double value: highestClosing) {
				if(value > maxValue) {
					maxValue = value;
				}
			}
			System.out.println("Highest Closing Value " + maxValue);
			// lowest opening value
			for(double value: lowestOpening) {
				if(value < minValue) {
					minValue = value;
				}
			}
			System.out.println("Lowest Opening Value: " + minValue);
			
			// Highest closing value
			for(double value: lowestClosing) {
				if(value < minValue) {
					minValue = value;
				}
			}
			System.out.println("Lowest Closing Value " + minValue);
                        
	}
}
  
		



// BasicCalculations
/* Highest Opening Value?
 * Highest Closing Value?
 * Lowest Opening Value?
 * Lowest Closing Value?
 * Top 10 dates with the highest Closing Value?(Highest to Lowest)
 * Top 10 dates with the lowest Closing Value?(Lowest to Highest)
 * Add a column difference for all rows (determine by open amount - closing amount); and 
 * write to a new file (saved in your c:\temp). */