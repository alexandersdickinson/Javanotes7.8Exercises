/**
This class represents roman numerals. Two constructors allow for creating a RomanNumeral object from an integer or a String. The upper limit of a
RomanNumeral object is 3999.
*/

public class RomanNumeral{
	
	private int intRep;
	private String stringRep;
	
	public enum Numeral{//Are there hashes in Java?
		I(1),
		V(5),
		X(10),
		L(50),
		C(100),
		D(500),
		M(1000);
		
		private final int value;
		Numeral(int val){
			this.value = val;
		}
		
		public int getValue(){
			return value;
		}
	}

	public RomanNumeral(int num){
		
		if(num > 3999 || num < 1)
			throw new NumberFormatException("This number is not in the range of 1-3999.");
		intRep = num;
		
		this.toString(num);
		
	}
	
	public RomanNumeral(String num){
		
		//Figure out if num is a valid string.
		char c;//current char in the String.
		char nextC;
		int count = 1;//keeps track of how many of the same roman numerals are in a row.
		num.toUpperCase();
		for(int i = 0; i < num.length(); i++){
			c = num.charAt(i);
			//for charAt(i), find if it is M, D, C, L, X, or I.
			if(!(c == 'M' || c == 'D' || c == 'C' || c == 'L' || c == 'X' || c == 'V' || c == 'I'))//there must be a better way to do this.
				throw new NumberFormatException("Character is not a valid roman numeral.");
			if(i < num.length() - 1){
				nextC = num.charAt(i + 1);
				//if next letter is the same
				if(nextC == c){
					count++;
					if(count > 3)
						throw new NumberFormatException("More than three of the same numerals are in a row.");
				}
				//if current character / 2 is one less than next character ordinal + 1 / 2
				else if(Numeral.valueOf(Character.toString(c)).ordinal() < Numeral.valueOf(Character.toString(nextC)).ordinal()){
					if(Numeral.valueOf(Character.toString(c)).ordinal() / 2 == (Numeral.valueOf(Character.toString(nextC)).ordinal() + 1) / 2 - 1 &&
				       Numeral.valueOf(Character.toString(c)).ordinal() % 2 == 0){
						//preceding numeral is less than proceeding but not less than is appropriate, i.e.
						//preceding numeral of L can be X and not I.
						if(count > 1)
							throw new NumberFormatException("More than one of the same numeral precedes a numeral of greater value.");
						count = 1;
					}
					else{
						throw new NumberFormatException("Illegal value for preceding numeral.");
					}
				}
				if(Numeral.valueOf(Character.toString(nextC)).ordinal() < Numeral.valueOf(Character.toString(c)).ordinal()){ //next letter is smaller
					count = 1;
				}
			}
		}
		
		stringRep = num;
		
		//find IntRep
		this.toInt(num);
		
	}
	
	public void toString(int num){
		
		stringRep = "";
		while(num >= 1000){
			num -= 1000;
			stringRep += 'M';
		}
		if(num >= 900){
			num -= 900;
			stringRep += "CM";
		}
		if(num >= 500){
			num -= 500;
			stringRep += "D";
		}
		if(num >= 400){
			num -= 400;
			stringRep += "CD";
		}
		while(num >= 100){
			num -= 100;
			stringRep += "C";
		}
		if(num >= 90){
			num -= 90;
			stringRep += "XC";
		}
		if(num >= 50){
			num -= 50;
			stringRep += "L";
		}
		if(num >= 40){
			num -= 40;
			stringRep += "XL";
		}
		while(num >= 10){
			num -= 10;
			stringRep += "C";
		}
		if(num >= 9){
			num -= 9;
			stringRep += "IX";
		}
		if(num >= 5){
			num -= 5;
			stringRep += "V";
		}
		if(num >= 4){
			num -= 4;
			stringRep += "IV";
		}
		while(num >= 1){
			num -= 1;
			stringRep += "I";
		}
		
	}
	
	public void toInt(String num){
		
		char c;//current char in the String.
		char nextC;
		
		intRep = 0;
		for(int i = 0; i < num.length(); i++){
			c = num.charAt(i);
			if(i < num.length() - 1){
				nextC = num.charAt(i + 1);
				if(Numeral.valueOf(Character.toString(nextC)).ordinal() > Numeral.valueOf(Character.toString(c)).ordinal()){//if next letter is of greater value.
					intRep -= Numeral.valueOf(Character.toString(c)).getValue();
				}
				else{
					intRep += Numeral.valueOf(Character.toString(c)).getValue();
				}
			}
			else
				intRep += Numeral.valueOf(Character.toString(c)).getValue();
		}
		
	}
	
	public String getStringRep(){
		return stringRep;
	}
	
	public int getIntRep(){
		return intRep;
	}

}