package test;

import java.util.Scanner;

public class SpaceUser {

	
	public static void main(String[] args)
	{

		Scanner SpaceShipUser = new Scanner(System.in);
		
		System.out.print("please enter spaceship id" );
		
		String ID = SpaceShipUser.nextLine(); // memorise this !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		
		System.out.println(" ");
		
		System.out.println("The ID you entered is " + ID);
		
		System.out.println(" ");
		
		spaceship YSpaceship = new spaceship( ID, 0 );// you had to put the ID varible in ther constructor "()"
		
		System.out.println(YSpaceship.toString());// this is where you called your method
		
		System.out.println(" ");
		
		System.out.println("please enter number of passingers" );
		
		System.out.println(" ");
		
		//Scanner SpaceShipPassangers = new Scanner(System.in);
		
		int NoOfPass = SpaceShipUser.nextInt();// memorise this !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		
		System.out.println(" ");
		
		System.out.println("the ammount of passingers you entered " + NoOfPass);
		
		String PSID = "AD5";
		
		PassShip PSpaceship = new PassShip();
		
		PSpaceship.PassengerShip("AD5", NoOfPass); // 
		
		System.out.println(PSpaceship.toString());

	}
	
}
