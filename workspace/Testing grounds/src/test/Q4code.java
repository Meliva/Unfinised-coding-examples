package test;

public class Q4code 
{
	
	private String word = "ChcSVPddcDDDcCCC";
	public String TheWord;
	
	

	// maybe: constructors look  like they dont give information they either they orginisi it in the class
	//( return focuses on giving informatin to the main page or where it is called)
	// mainly return is the disider got the methods sumerised fanal value
	// this. notice the dot (.) just resets the values at the top values
	
	public int countdc()
	{
		
		int countD = 0;
		String countDword;
		
		for(int x = 0 ; x < word.length () ; x++) // you start at 0 becuase the chart starts at 0
		{
			if(word.charAt(x)=='c' || word.charAt(x)=='C' || word.charAt(x)=='d' || word.charAt(x)=='D')
			{
				countD++;
			}
			
			
		}		
		return countD;	
	}
	
	
	public String countDcWord()// this is wrong, if you want to make a int == string you need to make a to string method and after its return put everything in there with "" around each word(not method) and + after and befor mothods and veriables 
	{
		
		int countD = 0;
		
		
		for(int x = 0 ; x < word.length () ; x++) // you start at 0 becuase the chart starts at 0
		{
			if(word.charAt(x)=='c' || word.charAt(x)=='C' || word.charAt(x)=='d' || word.charAt(x)=='D')
			{
				countD++;
			}
			
			
		}
		
		String Stringword = null;

		String countDword = Stringword.substring(countD);
	
		return Stringword;	
	
	}

	public static void main(String[] args)
	{
		System.out.print("the number of C and D's in ChcSVPddcDDDcCCC is " + countdc() );
	}
}

