package ch.plam.smallestsubstringalphabet;

import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;

public class StringUtils {

	private static CharsetEncoder asciiEncoder = Charset.forName("US-ASCII").newEncoder();

	public static boolean hasOnlyAscii(String v) {
		return asciiEncoder.canEncode(v);
	}

}
