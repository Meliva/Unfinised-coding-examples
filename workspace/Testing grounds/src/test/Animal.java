package test;

public class Animal
{
	private String name;
	public Animal(String name)
	{
		this.name = name;
	}
	public void greeting()
	{
		System.out.println("Hello. I'm " + name);
	}
}
