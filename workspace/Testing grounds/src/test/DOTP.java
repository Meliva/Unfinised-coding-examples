//Ciaran Bishop
//Assignment: Part B Task 4
//Reference: absolute java (6th global edition)
//Date due: 11/04/2017
//Completed date: 02/04/2017
package test;

import java.util.Random;
import java.util.Scanner;

public class DOTP 
{
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		//Scanner called keyboard

		Random randomStart = new Random();
		int randomNumber = randomStart.nextInt(2) + 1;
		//Reference: absolute java (pg 191)
		//Random number between 1 and 2

		Random randomX = new Random();
		int missleX = randomX.nextInt(21) - 10;
		//Missile X location is random between 10 and -10

		int missleY = 0;
		String missle;
		//Missile Y location and string for scanner

		int rockY = 10;
		//Y location of the asteroid

		//random number if even will start on the left and if odd it will start on the right
		if(randomNumber % 2 == 0)
		{
			//Asteroid spawns on the left side
			int leftRockX = -5;	
			System.out.println("> java DOTP");
			System.out.println("Initial Asteroid position is x: "+ leftRockX +" y: "+rockY);
			System.out.println("Initial Missile position is x: "+ missleX +" y: "+ missleY);
			System.out.println(" ");
			System.out.println("Available Missle Commands");
			System.out.println("up");
			System.out.println("down");
			System.out.println("left");
			System.out.println("right");
			System.out.println("left up");
			System.out.println("left down");
			System.out.println("right up");
			System.out.println("right down");
			System.out.print("Enter command >> ");
			missle = keyboard.nextLine();
			//Allows the user to enter a string that is interpreted as a command

			while(rockY != 0)
				//while loop, Asteroid is not equal to 0
			{
				if(missle.equalsIgnoreCase("up"))
				{
					missleY = missleY +2;
					//Adds 2 to the Y value for the missile, X value unaffected
					leftRockX = leftRockX +1;
					rockY = rockY -1;
					//Adds 1 to the X value and removes 1 from the Y value both for the Asteroid
				}
				else if(missle.equalsIgnoreCase("down"))
				{
					missleY = missleY -2;
					//Removes 2 from the Y value for the missile, X value unaffected
					leftRockX = leftRockX +1;
					rockY = rockY -1;
					//Adds 1 to the X value and removes 1 from the Y value both for the Asteroid
				}
				else if(missle.equalsIgnoreCase("left"))
				{
					missleX = missleX -2;
					//Removes 2 from the X value for the missile, Y value unaffected
					leftRockX = leftRockX +1;
					rockY = rockY -1;
					//Adds 1 to the X value and removes 1 from the Y value both for the Asteroid
				}
				else if(missle.equalsIgnoreCase("right"))
				{
					missleX = missleX +2;
					//Adds 2 to the X value for the missile, Y value unaffected
					leftRockX = leftRockX +1;
					rockY = rockY -1;
					//Adds 1 to the X value and removes 1 from the Y value both for the Asteroid
				}
				else if(missle.equalsIgnoreCase("left up"))
				{
					missleX = missleX -1;
					missleY = missleY +1;
					//Removes 1 from the X value and adds 1 to the Y value both for the Missile
					leftRockX = leftRockX +1;
					rockY = rockY -1;
					//Adds 1 to the X value and removes 1 from the Y value both for the Asteroid
				}
				else if(missle.equalsIgnoreCase("left down"))
				{
					missleX = missleX -1;
					missleY = missleY -1;
					//Removes 1 from the X value and removes 1 from the Y value both for the Missile
					leftRockX = leftRockX +1;
					rockY = rockY -1;
					//Adds 1 to the X value and removes 1 from the Y value both for the Asteroid
				}
				else if(missle.equalsIgnoreCase("right up"))
				{
					missleX = missleX +1;
					missleY = missleY +1;
					//Adds 1 to the X value and adds 1 to the Y value both for the Missile
					leftRockX = leftRockX +1;
					rockY = rockY -1;
					//Adds 1 to the X value and removes 1 from the Y value both for the Asteroid
				}
				else if(missle.equalsIgnoreCase("right down"))
				{
					missleX = missleX +1;
					missleY = missleY -1;
					//Adds 1 to the X value and removes 1 from the Y value both for the Missile
					leftRockX = leftRockX +1;
					rockY = rockY -1;
					//Adds 1 to the X value and removes 1 from the Y value both for the Asteroid
				}	
				else if(missle.equalsIgnoreCase("lock on"))
				{
					//NOT IN ASSIGNMENT
					System.out.println("Cheater, cheat, cheat");
					missleX = leftRockX;
					missleY = rockY;
					//NOT IN ASSIGNMENT
				}
				else
				{
					System.out.println("Invalid comand...");
					//If the string does not match any of the given above this will appear, neither the missile or asteroid will move
				}

				if(missleY < 0)
				{
					System.out.println("Initial Asteroid position is x: "+ leftRockX +" y: "+rockY);
					System.out.println("Initial Missile position is x: "+ missleX +" y: "+ missleY);
					System.out.println("The missile has crashed...");
					return;
					//If the Y value of the missile is less then 0 the missile will crash and return the system. It will display the X and Y values of both the missiles and the Asteroids and prints the text 'The missile has crashed'.
					//Considered loss condition
				}

				if(missleX > 10 || missleX < -10 )
				{
					System.out.println("Initial Asteroid position is x: "+ leftRockX +" y: "+rockY);
					System.out.println("Initial Missile position is x: "+ missleX +" y: "+ missleY);
					System.out.println("The missile is out of range...");
					return;
					//If the X value for the missile is greater then 10 or -10 the missile will go out of range and it will return the system. It will display the X and Y values of both the missiles and the Asteroids and prints the text 'the missile is out of range'.
					//Considered loss condition
				}
				
				if(missleX == leftRockX && missleY == rockY)
				{
					System.out.println("Initial Asteroid position is x: "+ leftRockX +" y: "+rockY);
					System.out.println("Initial Missile position is x: "+ missleX +" y: "+ missleY);
					System.out.println("The asteroid has been destroyed!");
					System.out.println("The plant is safe!");
					return;
					//If both missile X and Y are the exact same as the Asteroid the Asteroid will be destroyed it will return the system.  It will display the X and Y values of both the missiles and the Asteroids and prints the  text 'The planet is safe'.
					//Considered victory condition
				}

				if(rockY == 0)
				{
					System.out.println("Initial Asteroid position is x: "+ leftRockX +" y: "+rockY);
					System.out.println("Initial Missile position is x: "+ missleX +" y: "+ missleY);
					System.out.println("The asteroid has hit the planet...");
					return;
					//If the Y value for the Asteroid is equal to 0 the Asteroid will hit the planet and return the system. It will display the X and Y values of both the missiles and the Asteroids and prints the text 'The asteroid has hit the planet'.
					//Considered loss condition
				}
				System.out.println(" ");
				System.out.println("Initial Asteroid position is x: "+ leftRockX +" y: "+rockY);
				System.out.println("Initial Missile position is x: "+ missleX +" y: "+ missleY);
				System.out.println(" ");
				System.out.println("Available Missle Commands");
				System.out.println("up");
				System.out.println("down");
				System.out.println("left");
				System.out.println("right");
				System.out.println("left up");
				System.out.println("left down");
				System.out.println("right up");
				System.out.println("right down");
				System.out.print("Enter command >> ");
				missle = keyboard.nextLine();
				//Allows the user to enter a string that is interpreted as a command this is repeated since it is in the while loop
			}
		}
		else
			// Asteroid spawns on the right side
			// The code is exactly the same as it spawning on the left side except for the variable of the X asteroid is taken instead of added and has a positive 5
		{
			int rightRockX = 5;
			System.out.println("> java DOTP");
			System.out.println("Initial Asteroid position is x: "+ rightRockX +" y: "+rockY);
			System.out.println("Initial Missile position is x: "+ missleX +" y: "+ missleY);
			System.out.println(" ");
			System.out.println("Available Missle Commands");
			System.out.println("up");
			System.out.println("down");
			System.out.println("left");
			System.out.println("right");
			System.out.println("left up");
			System.out.println("left down");
			System.out.println("right up");
			System.out.println("right down");
			System.out.print("Enter command >> ");
			missle = keyboard.nextLine();
			//Allows the user to enter a string that is interpreted as a command

			while(rockY != 0)
			{
				if(missle.equalsIgnoreCase("up"))
				{
					missleY = missleY +2;
					//Adds 2 to the Y value for the missile, X value unaffected
					rightRockX = rightRockX -1;
					rockY = rockY -1;
					//Removes 1 from the X value and removes 1 from the Y value both for the Asteroid
				}
				else if(missle.equalsIgnoreCase("down"))
				{
					missleY = missleY -2;
					//Removes 2 from the Y value for the missile, X value unaffected
					rightRockX = rightRockX -1;
					rockY = rockY -1;
					//Removes 1 from the X value and removes 1 from the Y value both for the Asteroid
				}
				else if(missle.equalsIgnoreCase("left"))
				{
					missleX = missleX -2;
					//Removes 2 from the X value for the missile, Y value unaffected
					rightRockX = rightRockX -1;
					rockY = rockY -1;
					//Removes 1 from the X value and removes 1 from the Y value both for the Asteroid
				}
				else if(missle.equalsIgnoreCase("right"))
				{
					missleX = missleX +2;
					//Adds 2 to the X value for the missile, Y value unaffected
					rightRockX = rightRockX -1;
					rockY = rockY -1;
					//Removes 1 from the X value and removes 1 from the Y value both for the Asteroid
				}
				else if(missle.equalsIgnoreCase("left up"))
				{
					missleX = missleX -1;
					missleY = missleY +1;
					//Removes 1 from the X value and adds 1 to the Y value both for the Missile
					rightRockX = rightRockX -1;
					rockY = rockY -1;
					//Removes 1 from the X value and removes 1 from the Y value both for the Asteroid
				}
				else if(missle.equalsIgnoreCase("left down"))
				{
					missleX = missleX -1;
					missleY = missleY -1;
					//Removes 1 from the X value and remove from 1 the Y value both for the Missile
					rightRockX = rightRockX -1;
					rockY = rockY -1;
					//Removes 1 from the X value and removes 1 from the Y value both for the Asteroid
				}
				else if(missle.equalsIgnoreCase("right up"))
				{
					missleX = missleX +1;
					missleY = missleY +1;
					//Adds 1 to the X value and adds 1 to the Y value both for the Missile
					rightRockX = rightRockX -1;
					rockY = rockY -1;
					//Removes 1 from the X value and removes 1 from the Y value both for the Asteroid
				}
				else if(missle.equalsIgnoreCase("right down"))
				{
					missleX = missleX +1;
					missleY = missleY -1;
					//Adds 1 to the X value and remove from 1 the Y value both for the Missile
					rightRockX = rightRockX -1;
					rockY = rockY -1;
					//Removes 1 from the X value and removes 1 from the Y value both for the Asteroid
				}	
				else if(missle.equalsIgnoreCase("lock on"))
				{
					//NOT IN ASSIGNMENT
					System.out.println("Cheater, cheat, cheat");
					missleX = rightRockX;
					missleY = rockY;
					//NOT IN ASSIGNMENT
				}
				else
				{
					System.out.println("Invalid comand...");
					//If the string does not match any of the given above this will appear, neither the missile or asteroid will move
				}

				if(missleY < 0)
				{
					System.out.println("Initial Asteroid position is x: "+ rightRockX +" y: "+rockY);
					System.out.println("Initial Missile position is x: "+ missleX +" y: "+ missleY);
					System.out.println("The missile has crashed...");
					return;
					//If the Y value of the missile is less then 0 the missile will crash and return the system. It will display the X and Y values of both the missiles and the Asteroids and prints the text 'The missile has crashed'.
					//Considered loss condition
				}

				if(missleX > 10 || missleX < -10)
				{
					System.out.println("Initial Asteroid position is x: "+ rightRockX +" y: "+rockY);
					System.out.println("Initial Missile position is x: "+ missleX +" y: "+ missleY);
					System.out.println("The missile is out of range...");
					return;
					//If the X value for the missile is greater then 10 or -10 the missile will go out of range and it will return the system. It will display the X and Y values of both the missiles and the Asteroids and prints the text.
				}

				if(missleX == rightRockX && missleY == rockY)
				{
					System.out.println("Initial Asteroid position is x: "+ rightRockX +" y: "+rockY);
					System.out.println("Initial Missile position is x: "+ missleX +" y: "+ missleY);
					System.out.println("The asteroid has been destroyed!");
					System.out.println("The plant is safe!");
					return;
					//If both missile X and Y are the exact same as the Asteroid the Asteroid will be destroyed it will return the system.  It will display the X and Y values of both the missiles and the Asteroids and prints the text.
				}

				if(rockY == 0)
				{
					System.out.println("Initial Asteroid position is x: "+ rightRockX +" y: "+rockY);
					System.out.println("Initial Missile position is x: "+ missleX +" y: "+ missleY);
					System.out.println("The asteroid has hit the planet...");
					return;
					//If the Y value for the Asteroid is equal to 0 the Asteroid will hit the planet and return the system. It will display the X and Y values of both the missiles and the Asteroids and prints the text.
				}	
				System.out.println(" ");
				System.out.println("Initial Asteroid position is x: "+ rightRockX +" y: "+rockY);
				System.out.println("Initial Missile position is x: "+ missleX +" y: "+ missleY);
				System.out.println(" ");
				System.out.println("Available Missle Commands");
				System.out.println("up");
				System.out.println("down");
				System.out.println("left");
				System.out.println("right");
				System.out.println("left up");
				System.out.println("left down");
				System.out.println("right up");
				System.out.println("right down");
				System.out.print("Enter command >> ");
				missle = keyboard.nextLine();	
				//Allows the user to enter a string that is interpreted as a command this is repeated since it is in the while loop
			}
		}
	}
}
