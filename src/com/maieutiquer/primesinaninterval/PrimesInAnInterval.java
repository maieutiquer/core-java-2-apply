package com.maieutiquer.primesinaninterval;

import java.util.List;

public class PrimesInAnInterval {

	public static void main(String[] args) {

		PrimesFinder primesFinder = null;
		try {
			primesFinder = new PrimesFinder(2, 20);
		} catch (InvalidRangeException e) {
			System.out.println(e.getMessage());
		}
		List<Integer> primes = primesFinder.primesInAnInterval();

		System.out.println(primes);

	}

}
