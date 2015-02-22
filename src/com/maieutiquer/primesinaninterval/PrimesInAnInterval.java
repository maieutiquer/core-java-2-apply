package com.maieutiquer.primesinaninterval;

import java.util.List;

public class PrimesInAnInterval {

	public static void main(String[] args) {

		PrimesFinder primesFinder = new PrimesFinder();

		List<Integer> primes = null;
		try {
			primes = primesFinder.primesInAnInterval(2, 20);
		} catch (InvalidRangeException e) {
			System.out.println(e.getMessage());
		}

		System.out.println(primes);

	}

}
