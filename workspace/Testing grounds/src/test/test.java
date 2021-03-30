package test;

import java.util.Scanner;

public class test 
{

	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter the duration of the event " +
				"in seconds: ");
		int duration = keyboard.nextInt();
		int days = duration/86400;
		if(days > 0)
		{
			duration = duration - 86400 * days;
		}
		int hours = duration /3600;
		if(hours > 0)
		{
			duration = duration - 3600 * hours;
		}
		int minutes = duration/60;
		if(minutes > 0)
		{
			duration = duration - 60 * minutes;
		}
		int seconds = duration;

		System.out.println(days+" "+hours+" "+minutes+" "+seconds);
	}

}
