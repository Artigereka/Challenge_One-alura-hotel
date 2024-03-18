package com.alura.hotel.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Format {
	
	// Check if it has date format
	// Use in Row editing from the view "Busqueda"

	public Format() {
		throw new AssertionError("This class cannot be instantiated.");
	}

	public static boolean isValidString(String input) {
		if (input.matches("[a-zA-Z ]+")) {
			return true;
		}
		return false;
	}

	public static boolean isValidNumber(String input) {
		if (input.matches("\\d+")) {
			return true;
		}
		return false;
	}

	public static boolean isValidDate(String input) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);

		try {
			dateFormat.parse(input);
			return true;
		} catch (ParseException e) {
			return false;
		}
	}

	public static String capitalize(String input) {
		if (input == null || input.isEmpty()) {
			return input; // Return the input as is if it's null or empty
		}
		return input.substring(0, 1).toUpperCase() + input.substring(1);
	}

}