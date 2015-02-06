/**
This class represents roman numerals. Two constructors allow for creating a RomanNumeral object from an integer or a String. The upper limit of a
RomanNumeral object is 3999.
*/

public class RomanNumeral{
	
	private int intRep;
	private String stringRep;
	
	private final int M = 1000;
	private final int D = 500;
	private final int C = 100;
	private final int L = 50;
	private final int X = 10;
	private final int I = 1;

	public RomanNumeral(int num){
		
		if(num > 3999 || num < 1)
			throw new NumberFormatException("This number is not in the range of 1-3999.");
		intRep = num;
		
	}
	
	public RomanNumeral(String num){
		
		//Figure out if num is a valid string.
		//num.toUppercase()
		//for charAt(i), find if it is M, D, C, L, X, or I.
		//for charAt(i when i >= 1)
			//find if it is a Roman Numeral
			//if so:
				//find if it is the same as the last char.
				//if so:
					//find if it is the fourth in a chain of numerals.
					//if so, NumberFormatException.
				//if not:
					//find if it is either one less than the last numeral, or greater.
					//
		//Then find if the following char is the same or different
			//if not a 
			//if the same, count.
			//if a valid numeral value, find if the following char is one value lower or higher.
		//if not, throw NumberFormatException
		
	}
	
	public int toInt(){
		
		
		
	}
	
	public String toString(){
		
		
		
	}

}