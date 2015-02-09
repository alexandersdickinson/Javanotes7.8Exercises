/**
This class allows the user to create an expression and then evaluate the expression with as many values as they want.
The user can also evaluate as many expressions as they want, and will be asked if they would like to continue or move on.
*/

public class Expression{
	
	public static void main(String[] args){
		
		String def;
		Expr exp;
		boolean newExp;
		double x;
		double answer;
		
		System.out.println("This program allows you to evaluate your own expression with any variables you'd like.");
		
		while(true){
			
			while(true){
				System.out.println("Please input an expression:");
				
				try{
					def = TextIO.getln();
					exp = new Expr(def);
					break;
				}
				catch(IllegalArgumentException e){
					System.out.println(e.getMessage());
				}
			}
			
			while(true){
				System.out.println("Please type in a variable.");
				x = TextIO.getlnDouble();
				answer = exp.value(x);
				if(Double.isNaN(answer)){
					System.out.println("The expression is undefined at the given value of x.");
					break;
				}
				System.out.println("You expression evaluated with " + x + " is " + answer + ".");
				System.out.println("Would you like to move on to another expression?");
				newExp = TextIO.getBoolean();
				if(newExp){
					break;
				}
			}
			
		}
		
	}
	
}