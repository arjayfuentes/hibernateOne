package com.exercise.hibernate1;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import org.apache.commons.lang3.StringUtils;

public class CheckInput {
	
	private Scanner read = new Scanner (System.in);
	
	public int inputNumber(String numberType){
		int number=0;		
		System.out.printf("Enter %s: ",numberType);
		while (!read.hasNextInt()) {
			System.out.printf("Not a number! Enter %s: ",numberType);
			read.next();
		}
		number = read.nextInt();
		read.nextLine(); 
		return number;
	}
	
	public int inputNumber(String numberType,int length){
		int number=0;
		do {
			System.out.printf("Enter %s (%d digits): ",numberType,length);
			while (!read.hasNextInt()) {
			  	System.out.printf("Not a number! Enter %s (%d digits): ",numberType,length);
			  	read.next();
			}
			number = read.nextInt();
			read.nextLine(); 
			if(Integer.toString(number).length()!=length) {
				System.out.print("Invalid length of integers. ");
			}
		} while (Integer.toString(number).length()!=length);
		return number;
	}
	
	public long inputContacNumber(String contactType,int length){
		long number=0;
		do {
			System.out.printf("Enter %s (%d digits): ",contactType,length);
			while (!read.hasNextLong()) {
			  	System.out.printf("Not a number! Enter %s (%d digits): ",contactType,length);
			  	read.next();
			}
			number = read.nextLong();
			read.nextLine(); 
			if(Long.toString(number).length()!=length) {
				System.out.print("Invalid length of integers. ");
			}
		} while (Long.toString(number).length()!=length);
		return number;
	}
	
	public String inputString(String stringType){
		System.out.print("Enter "+stringType+": ");
		String string = read.nextLine();
		while (string.length()==0){
		   if(string.length()==0){ 
		   System.out.print("Empty input. Re-enter "+stringType+": ");
		   }
		   string = read.nextLine();
		}
		string=string.trim();
		string=StringUtils.capitalize(string);
		return string;
	}
	
	public float inputGwa(){
		System.out.print("Enter GWA: ");
		int min = 1;
		int max = 5;
		float input=0;
		do {
			 while (!read.hasNextFloat()) {
			  	System.out.print("Not a float number!. Re-enter Gwa: ");
			  	read.next();
			 }
			 input = read.nextFloat();
			 read.nextLine(); 
			 if(input<min || input> max){
				 System.out.print("Invalid input GWA should be from 1-5 ! ");
			 }
		 } while (input<min || input >max);
		 DecimalFormat twoDForm = new DecimalFormat("#.##");
		 return (float) Float.valueOf(twoDForm.format(input));	
	}
	

	public boolean inputEmployed(){
		System.out.print("Employed? (Y/N): ");
		boolean employed = false;
		String input = read.next();
		boolean correct=false;
		while(correct==false){
			if(input.equalsIgnoreCase("Y")){
				correct= true;
				employed=true;
				break;
			}
			else if(input.equalsIgnoreCase("N")){
				correct= true;
				employed=false;
				break;
			}
			else{
			System.out.print("Invalid input. Re-enter if employed (Y/N): ");
			}
			input = read.next();
		}
		return employed;
	}

	public Date inputDate(String dateType){
		System.out.print("Enter "+dateType+" (MM/DD/YYYY): ");
		String input = read.nextLine();
		while(!input.matches("([0-9]{2})/([0-9]{2})/([0-9]{4})")){
				System.out.print("Invalid date format. Re-enter date: ");
				input = read.next();
		}
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		Date checkDate=null;
		try {
			checkDate = formatter.parse(input);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return checkDate;
	}
}
