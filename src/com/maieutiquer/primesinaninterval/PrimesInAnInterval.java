package com.maieutiquer.primesinaninterval;

import java.util.ArrayList;
import java.util.List;

public class PrimesInAnInterval {

	private static boolean validInput(int from, int to) {
		boolean ascending = (from <= to);
		boolean positive = (from > 0);
		
		return ascending && positive;
	}

	private static boolean isPrime(int number) {
		for (int i = 2; i <= Math.sqrt(number); i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}

	private static List<Integer> primesInAnInterval(int from, int to) {
		if (!validInput(from, to)) {
			// TODO probably trow exception or something
			System.out.println("invalid input");
			return null;
		}

		List<Integer> primes = new ArrayList<Integer>();

		for (int i = from; i <= to; i++) {
			if (isPrime(i)) {
				primes.add(i);
			}
		}

		return primes;
	}

	public static void main(String[] args) {

		List<Integer> primes = primesInAnInterval(2, 20);

		System.out.println(primes);

	}

}
