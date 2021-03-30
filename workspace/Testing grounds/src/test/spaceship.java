package test;

import java.util.Scanner;
	
	public class spaceship 
	{
		private String id;
		private int crew;
		private int passangers;
		
		Scanner kb = new Scanner(System.in);
				
		public spaceship()
		{
			this.id = id;
			this.crew = crew;
			this.passangers = passangers;
		}
		
		public spaceship(String id, int passangers) 
		{
			id = kb.nextLine();
			crew = 15;
			passangers = kb.nextInt();
		}

		public String toString()
		{
		return "Passenger Ship " + id + " has " + crew + " members and " + passangers  + " passangers";
		}
		
		public static void main(String[] args) 
		{
			spaceship SS = new spaceship( );
			System.out.println(SS.toString());
		}
	}	

