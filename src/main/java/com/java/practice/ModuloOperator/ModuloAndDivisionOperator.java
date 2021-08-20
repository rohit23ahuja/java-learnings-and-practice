package com.java.practice.ModuloOperator;

import lombok.extern.slf4j.Slf4j;

/**
 * Division operator return quotient in division. Modulo operator returns
 * remainder of division.
 * 
 * @author rohitahuja
 *
 */ 
@Slf4j
public class ModuloAndDivisionOperator {
	public static void main(String[] args) {
		// division operator gives the quotient
		
		log.info("{}",11 / 4);
		log.info("{}",11 / 4.0);

		// modulo gives out the remainder
		log.info("{}",11 % 4);

		// both division and quotient give exception when done by zero
		// log.info("{}",11/0);
		// log.info("{}",11%0);

		// use modulo to determine number is odd or even
		log.info("{}",98 % 2 == 0);
		log.info("{}",97 % 2 == 1);

		// In modulo operation
		// when dividend < divisor. dividend is returned.
		// when dividend == divisor zero
		// dividend > divisor. remainder is returned
		for (int j = 0; j < 100; j++) {
			log.info("{}",j % 5);
		}
	}

}
