package ch.plam.smallestsubstringalphabet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AlphabetFinder {

	private boolean validInput(String characterString) {

		boolean containsWhitespace = characterString.indexOf(' ') != -1;
		boolean isInAscii = StringUtils.hasOnlyAscii(characterString);

		return !containsWhitespace && isInAscii;
	}

	private boolean isLetterLowercase(char ch) {
		return Character.getNumericValue(ch) >= 10 
				&& Character.getNumericValue(ch) <= 35;
	}

	// returns the end index
	private int fillAlphabetWithChars(String characterString, List<Character> alphabet) {

		for (int i = 0; i < characterString.length(); i++) {
				char currentChar = characterString.charAt(i);
				if (isLetterLowercase(currentChar) && !alphabet.contains(currentChar)) {
					alphabet.add(currentChar);
				}
			if (!(alphabet.size() < 26)) {
				return i + 1;
			}
		}
		return -1;
	}

	// returns the begin index
	private int shortenCharacterStringWithAlphabet(String characterString, int alphabetBeginIndex, int alphabetEndIndex) {

		List<Character> alphabet = new ArrayList<>();

		if (characterString.charAt(alphabetBeginIndex) == 'a') {
			
		}
		
		for (int i = alphabetBeginIndex; i < alphabetEndIndex; i++) {
			
		}

		return alphabetBeginIndex;
	}

	private String findShortestWithAlphabet(String characterString) {

		// initialize indices, both inclusive
		int alphabetBeginIndex = 0;
		int alphabetEndIndex = characterString.length();

		// initialize alphabet
		List<Character> alphabet = new ArrayList<>();

		// work with lowercase
		String lowerString = characterString.toLowerCase();

		alphabetEndIndex = fillAlphabetWithChars(lowerString, alphabet);

		if (alphabetEndIndex == -1) {
			// how do we handle this? Should it throw an exception?
			return "This string does not contain the alphabet.";
		}

		// TODO when all letters are found,
		// start trying to shorten the string from its start,
		// otherwise continue expanding
		alphabetBeginIndex = shortenCharacterStringWithAlphabet(lowerString, 0, alphabetEndIndex);

		//return alphabet.toString();
		return characterString.substring(alphabetBeginIndex, alphabetEndIndex);
	}

	public String smallestSubstringContainingTheAlphabet(String characterString)
			throws InvalidInputStringException {

		// no whitespaces
		// nothing outside of ASCII
		if (!validInput(characterString)) {
			throw new InvalidInputStringException(
					"No whitespaces and nothing outside of ASCII allowed."
					);
		}

		return findShortestWithAlphabet(characterString);
	}

}
