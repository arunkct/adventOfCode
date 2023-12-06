package aoc.day1;

import java.io.*;
import java.util.*;

public class Day1Problem1 {
	
	private int processLine(String line) {
		char firstChar = ' ' ; 
		char lastChar = ' ';
		int firstCharIndex=0;
		
		for (firstCharIndex=0; firstCharIndex<line.length(); firstCharIndex++) {
			if (line.charAt(firstCharIndex) >= '0' && line.charAt(firstCharIndex) <= '9') {
				firstChar = line.charAt(firstCharIndex);
				break;
			}
		}
		
		System.out.println("First Character = " + firstChar + " char index = " + firstCharIndex );
		int i;
		
		for (i=line.length()-1; i>=firstCharIndex; i--) {
			if (line.charAt(i) >= '0' && line.charAt(i) <= '9') {
				lastChar = line.charAt(i);
				break;
			}
		}
		
		System.out.println("Last Character = " + lastChar + " char index = " + i);
		
		String val = "" + firstChar + lastChar;
		
		return Integer.parseInt(val);
		
	}
	
	private int readAndProcessFile() {
	    int sum=0;
		try {
	        File myObj = new File("input.txt");
	        Scanner myReader = new Scanner(myObj);
	        while (myReader.hasNextLine()) {
	          String data = myReader.nextLine();
	          System.out.println(data);
	          sum = sum + processLine(data);
	        }
	        myReader.close();
	      } catch (FileNotFoundException e) {
	        System.out.println("An error occurred.");
	        e.printStackTrace();
	      }
		
		return sum;
	}

	public static void main(String[] args) {

		Day1Problem1 problem = new Day1Problem1();
		int result = problem.readAndProcessFile();
				

		System.out.print(" Solution = " + result );

	}

}
