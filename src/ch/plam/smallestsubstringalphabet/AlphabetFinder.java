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


	private String findAlphabet(String characterString) {

		// initialize indices
		int alphabetBeginIndex = 0;
		int alphabetEndIndex = characterString.length();

		// initialize alphabet
		List<Boolean> alphabet = new ArrayList<Boolean>(Arrays.asList(new Boolean[10]));
		Collections.fill(alphabet, Boolean.FALSE);

		String substringWithAlphabet = characterString;

		for (int i = alphabetBeginIndex; i < alphabetEndIndex; i++) {

			// TODO main algorithm goes here

		}

		return substringWithAlphabet;
	}

	public String smallestSubstringContainingTheAlphabet(String characterString)
			throws InvalidInputStringException {

		// no whitespaces
		// nothing outside of ASCII
		if (!validInput(characterString)) {
			throw new InvalidInputStringException("No whitespaces and nothing outside of ASCII allowed.");
		}

		// case insensitive
		String lowered = characterString.toLowerCase();

		return findAlphabet(lowered);
	}

}
