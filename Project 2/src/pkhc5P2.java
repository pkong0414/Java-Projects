//Patrick Kong
//cs2261-001

import java.util.Scanner;

public class pkhc5P2{
	/** main method */
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int variables[] = new int[6];
		
		for(int i = 0; i < 6; i++) {
			//prompting for input.
			System.out.println( "Please enter the number for variable " + (i+1) + " (0 - 100): ") ;
			variables[i] = input.nextInt();
		}
		
		//initializing object var that uses class LinearEquation with the entered variables
		LinearEquation var = new LinearEquation( variables[0], variables[1], variables[2], variables[3], variables[4], variables[5] );
		
		//displaying the linear equations for both x and y that are involved.
		System.out.println("for the linear equations of x = (ed - bf) / (ad - bc)" );
		
		System.out.println( "x " + " = (" + var.getE() + "*" + var.getD() + ") - (" + var.getB() + "*" + var.getF() + ") / ("
							+ var.getA() + "*" + var.getD() + ") - (" + var.getB() + "*" + var.getC() + ")" );
		
		System.out.println("for the linear equation of y = (af - ac) / (ad - bc)" );
		
		System.out.println( "y " + " = (" + var.getA() + "*" + var.getF() + ") - (" + var.getA() + "*" + var.getC() + ") / ("
				+ var.getA() + "*" + var.getD() + ") - (" + var.getB() + "*" + var.getC() + ")" );
		
		//if it is solvable it will display output for both X and Y
		//if not there will be an error message
		if( var.isSolvable() ) {
			System.out.println( "The answer to X is: " + var.getX() );
			System.out.println( "The answer to Y is: " + var.getY() );
		}
		
		
		input.close();
	}
}	
	
/** LinearEquation class */
	class LinearEquation{
		//data fields
		private int a, b, c, d, e, f;
		
		//default constructor
		LinearEquation() {
			a = 0;
			b = 0;
			c = 0;
			d = 0;
			e = 0;
			f = 0;
		}
		
		//constructor that takes in arguments.
		LinearEquation(int newA, int newB, int newC, int newD, int newE, int newF){
			//data fields are initialized to function arguments
			a = newA;
			b = newB;
			c = newC;
			d = newD;
			e = newE;
			f = newF;
			
		}
		
		//functions
			
		//this function will return true if a*d - b*c is not 0.
		boolean isSolvable() {
			if( ( a*d ) - ( b*c ) != 0)
				return true;
			else {
				System.out.println("This problem is not solvable since (a*d) - (b*c) = 0");
				return false;
			}
		}
		
		//getter functions
		double getY() {
			double y = 0;
			//calculations for y
			if( isSolvable() )
				y = (double) ( (a*f) - (a*c) ) / ( (a*d) - (b*c) );
			
			return y;
				
		}
		double getX() {
			double x = 0;
			//calculations for x
			if( isSolvable() )
				x = (double) ( (e*d) - (b*f) ) / ( (a*d) - (b*c) );

			return x;
		}
		
		int getA() {
			return a;
		}
		
		int getB() {
			return b;
		}
		
		int getC() {
			return c;
		}
		
		int getD() {
			return d;
		}
		
		int getE() {
			return e;
		}
		
		int getF() {
			return f;
		}
		
		
	}
	