package test;

public class Test1 
{
    public static void main(String[] args) 
    {
        int[] thisArray = new int[5];
        for(int i = 0; i < thisArray.length; i++)
        {
            thisArray[i] = 6;

            System.out.println(thisArray[i]);
        }
    }
}