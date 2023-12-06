package aoc.day1;

import java.io.*;
import java.util.*;

public class Day1Problem2 {
	HashMap<String, Integer> digits = new HashMap<>();
	
	Day1Problem2() {
		digits.put("one", 1);
		digits.put("two", 2);
		digits.put("three", 3);
		digits.put("four", 4);
		digits.put("five", 5);
		digits.put("six", 6);
		digits.put("seven", 7);
		digits.put("eight", 8);
		digits.put("nine", 9);
		
	}
	
	
	private Integer getDigit(String linePart) {

//		System.out.println("linePart = " + linePart);
		
		for (String key : digits.keySet()) {
			
			if(linePart.contains(key)) {
				System.out.println(key + " matched linePart " + linePart );
				return digits.get(key);
			}
		}
		
		return -1;
	}
	
	private int processLine(String line) {
		char firstChar = ' ' ; 
		char lastChar = ' ';
		int firstCharIndex=0;
		Integer digit;
		
		for (firstCharIndex=0; firstCharIndex<line.length(); firstCharIndex++) {
			if (line.charAt(firstCharIndex) >= '0' && line.charAt(firstCharIndex) <= '9') {
				firstChar = line.charAt(firstCharIndex);
				break;
			}
			
			digit=getDigit(line.substring(0, firstCharIndex+1));
			if(digit != -1) {
				firstChar = digit.toString().charAt(0);
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
			
			digit=getDigit(line.substring(i, line.length()));
			if(digit != -1) {
				lastChar = digit.toString().charAt(0);
				break;
			}
		}
		
		if(lastChar == ' ') {
			lastChar = firstChar;
		}
		
		System.out.println("Last Character = " + lastChar + " char index = " + i);
		
		String val = "" + firstChar + lastChar;
		
		return Integer.parseInt(val);
		
	}
	
	private int readAndProcessFile(String fileName) {
	    int sum=0;
		try {
	        File myObj = new File(fileName);
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

		Day1Problem2 problem = new Day1Problem2();
		int result = problem.readAndProcessFile("input.txt");
		//int result = problem.processLine("five98lqc8");
		System.out.print(" Solution = " + result );

	}

}
