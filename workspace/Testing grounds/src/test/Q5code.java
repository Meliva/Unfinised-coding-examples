package test;


import java.util.Arrays;

public class Q5code {

	public static void main(String[] args)
	{
		int[]/*the [] indicats the array(class)*/ numberArrayInput /*is the name*/ = new int[10];/* [] can be viewed as the constructor*/
		
		//to manually or auto-system input array
		// note this is stating the first input of the array
		numberArrayInput[1] = 2;
		
		String[] stringArray = {"..." , "..."}; // the string array just lets you words in the slots with a (,) between each word
		
		int[] numberArray  = new int[10]; // 
		
		for(int i = 0; i < numberArray.length; i++)// notice the word before array is 
		{
			numberArray[i] = i ;
			System.out.print( " | " + i);
		}
		
		System.out.print( " | ");
		
		
		System.out.println();
		
		
		System.out.println(numberArray[0]);
		
		System.out.println(numberArray[numberArray.length /2]); // will give you half if odd
		
		System.out.println(numberArray[(numberArray.length / 2) - 1]);// will not work if even
		
		System.out.println(numberArray[numberArray.length-1]);
		
		//int[] replaceArray  = new int[10]; // for replaceing variables
		
		//for(int x = 0; x < replaceArray.length; x++)// notice the word before array is 
		//{
			//replaceArray[x] = (x = 6 * ) ;
			//System..print( " | " + x);
		//}
		
		//System..println();
		
		
		 String dna[] = {"ATCTA"};
		 int i = 0;
		 dna[i] = dna[i].replace('T', 'C');
		 System.out.println(dna[i]);
		
		int[] ArrayCopy = Arrays.copyOf(numberArray, 5); // this just copyers the first 5 values of the numberArray and notice you need a cap O for .copyOf and the libair imported
		
	}

}
