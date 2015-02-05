/**
This class takes values A, B, and C from the user and uses them as variables in the quadratic equation. This can be done as many times as the user wants. If the
user wants to stop, they can type in "no."
*/

public class Quadratic{
	
	public static void main(String[] args){
		
		boolean again;
		double a, b, c;
		double answer;
		
		while(true){
			
			System.out.println("This program lets you use the quadratic equation.");
			System.out.println("It takes 3 variables: a, b, and c.");
		
			System.out.println("Please type in the value for a:");
			a = TextIO.getDouble();
		
			System.out.println("Please type in the value for b:");
			b = TextIO.getDouble();
		
			System.out.println("Please type in the value for c:");
			c = TextIO.getDouble();
		
			try{
				answer = root(a, b, c);
				System.out.println(answer);
			}
			catch(IllegalArgumentException e){
				System.out.println(e.getMessage());
			}
			
			System.out.println("Would you like to solve another quadratic equation?");
			again = TextIO.getBoolean();
			if(!again)
				return;
			
		}
		
	}
	
	/**
	 * Returns the larger of the two roots of the quadratic equation
	 * A*x*x + B*x + C = 0, provided it has any roots.  If A == 0 or
	 * if the discriminant, B*B - 4*A*C, is negative, then an exception
	 * of type IllegalArgumentException is thrown.
	 */
	static public double root( double A, double B, double C ) 
	                              throws IllegalArgumentException {
	    if (A == 0) {
	      throw new IllegalArgumentException("A can't be zero.");
	    }
	    else {
	       double disc = B*B - 4*A*C;
	       if (disc < 0)
	          throw new IllegalArgumentException("Discriminant < zero.");
	       return  (-B + Math.sqrt(disc)) / (2*A);
	    }
	}
	
}