package com.maieutiquer.primesinaninterval;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PrimesFinder {

	private int from;
	private int to;

	public PrimesFinder(int from, int to) throws InvalidRangeException {
		if (!validInput(from, to)) {
			throw new InvalidRangeException();
		}
		this.from = from;
		this.to = to;
	}

	private boolean validInput(int from, int to) {
		boolean ascending = (from < to);
		boolean positive = (from > 0);

		return ascending && positive;
	}

	private boolean isPrime(int number) {
		for (int i = 2; i <= Math.sqrt(number); i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}

	public List<Integer> primesInAnInterval() {

		List<Integer> primes = new ArrayList<Integer>();

		/*
		// the old fashioned way
		for (int i = from; i <= to; i++) {
			if (isPrime(i)) {
				primes.add(i);
			}
		}
		*/

		// Let's try something new.
		// Is it better than a for-loop?
		primes = IntStream.range(this.from, this.to + 1) // to inclusive
			.filter(p -> isPrime(p))
			.boxed() // turns an IntStream into a Stream<Integer>
			.collect(Collectors.toList());

		return primes;
	}

}
