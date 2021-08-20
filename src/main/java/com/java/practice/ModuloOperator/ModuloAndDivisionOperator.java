package com.java.practice.ModuloOperator;

/**
 * Division operator return quotient in division. Modulo operator returns
 * remainder of division.
 * 
 * @author rohitahuja
 *
 */
public class ModuloAndDivisionOperator {
	public static void main(String[] args) {
		// division operator gives the quotient
		System.out.println(11 / 4);
		System.out.println(11 / 4.0);

		// modulo gives out the remainder
		System.out.println(11 % 4);

		// both division and quotient give exception when done by zero
		// System.out.println(11/0);
		// System.out.println(11%0);

		// use modulo to determine number is odd or even
		System.out.println(98 % 2 == 0);
		System.out.println(97 % 2 == 1);

		// In modulo operation
		// when dividend < divisor. dividend is returned.
		// when dividend == divisor zero
		// dividend > divisor. remainder is returned
		for (int j = 0; j < 100; j++) {
			System.out.println(j % 5);
		}
	}

}
