package test;

public class dog 
{

    String name;
    String breed;
    int age;

    public dog()
    {
        name = null;
        breed = null;
        age = 0;
    }
    public dog(String s)
    {
        name = s;
        breed = null;
        age = 0;
    }
    public dog(String s, int i)
    {
        name = s;
        breed = null;
        age = i;
    }

    public static void main(String[] args) 
    {
        dog Fido = new dog("Fido" , 5);

        System.out.println(Fido);
    }
    /*
    public String toString()
	{
		return name+" "+breed+" "+age;
	}
	*/
}
