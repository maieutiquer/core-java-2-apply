package ch.plam.smallestsubstringalphabet;

public class SmallestSubstringContainingTheAlphabet {

	public static void main(String[] args) {

		String stringOfAscii1 = "aaaabcdefghijklmnopqrstuvwxyz";
		String stringOfAscii2 = "abcdefghijklmn124345678!@#$%^&*opqrstuvwxyz!*abcdefghijklmn";
		
		AlphabetFinder alphabetFinder = new AlphabetFinder();
		
		try {
			System.out.println(alphabetFinder.smallestSubstringContainingTheAlphabet(stringOfAscii1));
		} catch (InvalidInputStringException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			System.out.println(alphabetFinder.smallestSubstringContainingTheAlphabet(stringOfAscii2));
		} catch (InvalidInputStringException e) {
			System.out.println(e.getMessage());
		}

	}

}
