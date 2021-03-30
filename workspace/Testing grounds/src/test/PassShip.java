package test;

public class PassShip {
	
	
	private static final int pCrew = 15; // this vlause haveto be in order with the parrimitors !!!  order is very important   !!!
	private int passengers;
	private String id;
	
	public PassShip( /*String id , int passengers */) // constractors are for setting the variables up top and  getting them though private, cpnstrucots should 
	{
		/*
		this.id = id;
		this.passengers = passengers;
		*/
	}
	
	public void PassengerShip( String id , int passengers) // this is a Accessor or Mutator Method that modifies that has the power of the constructor to modify the values, not is not a constructor and can not be overloaded
	{
		this.id = id;
		this.passengers = passengers;
	}
	
	public String toString()
	{
		return  " you have " +  passengers  + " the passinger ship ID is " + id + " with this ship holds " + pCrew  + " crew members " ; 
	}

}