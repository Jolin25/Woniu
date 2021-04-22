package com.java.lang.learn;

public class Regexp {
	public static void main(String[] args) {
		String string = "Madam, I am Adam";

		// Starts with
		boolean b = string.startsWith("Mad"); // true

		// Ends with
		b = string.endsWith("dam"); // true

		// Anywhere
		b = string.indexOf("I am") > 0; // true

		// To ignore case, regular expressions must be used

		// Starts with
		b = string.matches("(?i)mad.*");
		System.out.println(b);
		// Ends with
		b = string.matches("(?i).*adam");

		// Anywhere
		b = string.matches("(?i).*i am.*");

	}
}
