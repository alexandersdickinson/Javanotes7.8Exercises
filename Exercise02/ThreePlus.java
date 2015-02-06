/**
This program asks the user for an integer, and uses it for n in the 3n + 1 algorithm. User should enter a blank line to end the program.
*/

import java.math.BigInteger;

public class ThreePlus{
	
	public static void main(String[] args){
		
		BigInteger n;
		String input;
		int count;
		
		System.out.println("This program prints a 3n + 1 sequence, given n, and the number of integers in this sequence.");
		System.out.println("You may end the program at any time by entering a blank line.");
		
		while(true){
			
			System.out.print("n = ");
			input = TextIO.getln();
			count = 0;
			
			if(input.equals(""))
				return;//ends the program if input is a blank line.
			try{
				n = new BigInteger(input);
			}
			catch(NumberFormatException e){
				System.out.println("This is not a valid integer value. Try again.");
				continue;
			}
			
			if(n.signum() != 1){
				System.out.println("N must be a positive integer. Try again.");
				continue;
			}
			
			while(!(n.equals(new BigInteger("1")))){
				if(n.mod(new BigInteger("2")).equals(new BigInteger("0"))){//Even or odd?
					n = n.divide(new BigInteger("2"));
				}
				else{
					n = n.multiply(new BigInteger("3")).add(new BigInteger("1"));
				}
				
				System.out.println(n.toString());
				count++;
				
			}
			
			System.out.println("Sequence has " + count + " integers.");
			
		}
		
	}
	
}