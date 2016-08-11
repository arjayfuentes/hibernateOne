package com.exercise.hibernate1;

import java.util.Scanner;

public class App{

	public static void main(String [] args){
		Scanner read = new Scanner(System.in);
		Options options = new Options();
		boolean processContinue = true;
		App app = new App();
		while(processContinue==true){
			app.menu();
			while(!read.hasNextInt()){
				System.out.print("Not an integer. Enter a valid choice! (1-10): ");
				read.next();
			}
			int choice=read.nextInt();
			read.nextLine();
			switch(choice){
				case 1: 
					System.out.println("\nMODE: ADD PERSON");
					options.optionAddPerson();
					break;
				case 2:
					options.optionDeletePerson();
					break;
				case 3:
					System.out.println("\nMODE: UPDATE PERSON");
					options.optionUpdatePerson();
					break;
				case 4:
					//options.listByGwa();
					break;
				case 5:
					//options.listByDateHired();
					break;
				case 6:
					//options.listByLastName();
					break;
				case 7:
					options.optionAddContact();
					break;
				case 8:
					options.optionUpdateContact();
					break;
				case 9:
					//options.optionUpdateAddressL();
					break;
				case 10:
					processContinue=false;
					System.exit(0);
					break;
				default:
					System.out.println("Not in the choices. Re-enter choice: ");
					break;
			}
		}
	}
	
	
	public void menu(){
		System.out.println("\nChoose from the following Options");
		System.out.println("\t[1]-Create Person");
		System.out.println("\t[2]-Delete Person");
		System.out.println("\t[3]-Update Person");
		System.out.println("\t[4]-List Person by GWA");
		System.out.println("\t[5]-List Person by date hired");
		System.out.println("\t[6]-List Person by last name");
		System.out.println("\t[7]-Add Contact");
		System.out.println("\t[8]-Update Contact");
		System.out.println("\t[9]-Delete Contact");
		System.out.println("\t[10]-Exit\n");
		System.out.print("Enter Choice: ");
	}
 }




