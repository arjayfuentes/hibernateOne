package com.exercise.hibernate1;

import com.exercise.hibernate1.core.*;
import java.util.Scanner;

public class App{

	public static void main(String [] args){
		Options options = new Options();
		Validation check = new Validation();
		Scanner read= new Scanner(System.in);
		boolean processContinue = true;
		while(processContinue==true){
			options.menu();
		    int choice=check.inputNumber("Choice: ");
			switch(choice){
				case 1:
					options.optionAddPerson();
					break;
				case 2:
					options.optionDeletePerson();
					break;
				case 3:
					options.optionUpdatePerson();
					break;
				case 4:
					options.optionListPerson();
					break;
				case 5:
					options.optionAddContact();
					break;
				case 6:
					options.optionUpdateContact();
					break;
				case 7:
					options.optionDeleteContact();
					break;
				case 8:
					processContinue=false;
					System.exit(0);
					break;
				default:
					System.out.println("Not in the choices. Re-enter choice: ");
					break;
			}
		}
	}
 }