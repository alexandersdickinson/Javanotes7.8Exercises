public class RomanTest{

	public static void main(String[] args){
		
		System.out.println("This program converts integers to Roman numerals and vice versa.");
		System.out.println("You may end the program by typing in a blank line at any time.");
		
		while(true){
			
			System.out.println("Please type in an integer or Roman Numeral.");
			
			String input;
			int intPut;
			char ch;
			ch = TextIO.peek();
			input = TextIO.getln();
			if(input.equals(""))
				return;
			
			if(Character.toUpperCase(ch) >= 'A' && Character.toUpperCase(ch) <= 'Z'){
				try{
					RomanNumeral numeral = new RomanNumeral(input);
					System.out.println(numeral.getIntRep());
				}
				catch(NumberFormatException e){
					System.out.println(e.getMessage());
				}
			}
			else{
				try{
					intPut = Integer.parseInt(input);
					RomanNumeral numeral = new RomanNumeral(intPut);
					System.out.println(numeral.getStringRep());
				}
				catch(NumberFormatException e){
					System.out.println(e.getMessage());
				}
			}
				
		}
	}

}