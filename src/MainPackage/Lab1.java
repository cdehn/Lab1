package MainPackage;

//Christina Dehn & Melanie Steiger

import java.util.Scanner;
  
public class Lab1 {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		System.out.println("Enter the numbers of years you plan to work");
		double years_working = input.nextInt();

		System.out.println("Enter expected annual return while working");
		double working_return = input.nextInt();

		System.out.println("Enter the number of years of your retirement");
		double years_retired = input.nextInt();

		System.out.println("Enter required monthly income for retirement");
		double retirement_income = input.nextInt();

		System.out.println("Enter the annual return during retirement");
		double retirement_return = input.nextInt();

		double social_security = 2642;
		
		double monthly_return = (working_return / 1200);
		
		double pv = pv((retirement_return / 1200),years_retired * 12,retirement_income - social_security, 0, false);

		double pmt = pmt((monthly_return), years_working * 12, 0, pv, false);

		
		System.out.println("You should save" + " " + "$" + pmt + " "
				+ "every month for the next" + " " + years_working + " "
				+ "years");

	}

	   public static double pv(double r, double n, double y, double f, boolean t) {
	        double retval = 0;
	        if (r == 0) {
	            retval = -1*((n*y)+f);
	        }
	        else {
	            double r1 = r + 1;
	            retval =(( ( 1 - Math.pow(r1, n) ) / r ) * (t ? r1 : 1)  * y - f)
	                     /
	                    Math.pow(r1, n);
	        }
	        return retval;
	    }

public static double pmt(double r, double n, double p, double f, boolean t) {
    double retval = 0;
    if (r == 0) {
        retval = -1*(f+p)/n;
    }
    else {
    double r1 = r + 1;
    retval = ( f + p * Math.pow(r1, n) ) * r 
              / 
           ((t ? r1 : 1) * (1 - Math.pow(r1, n)));
    }
    return retval;
}
}