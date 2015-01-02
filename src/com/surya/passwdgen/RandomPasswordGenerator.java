package com.surya.passwdgen;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import com.surya.passwdgen.helpers.PasswordProperties;

public class RandomPasswordGenerator {
	private PasswordProperties pp = null;
	private static final String LOWER_CASE = "LOWER_CASE";
	private static final String UPPER_CASE = "UPPER_CASE";
	private static final String NUMBERS = "NUMBERS";
	private static final String SPECIAL_CHARACTERS = "SPECIAL_CHARACTERS";

	public RandomPasswordGenerator() {
		pp = new PasswordProperties();
		pp.setHasLowerCase(true);
		pp.setHasNumbers(true);
		pp.setHasUpperCase(true);
		pp.setHasSpecialCharacters(true);
		pp.setMinLength(PasswordProperties.PASSWORD_MIN_LENGTH);
		pp.setMaxLength(PasswordProperties.PASSWORD_MAX_LENGTH);
	}

	public RandomPasswordGenerator(PasswordProperties passwdProps) {
		this.pp = passwdProps;
	}

	/**
	 * This method is used to generate a random password.
	 * 
	 * @return - Random password.
	 */
	public String generatePassword() {
		int passwordLength = getRandomNumber(pp.getMinLength(), pp.getMaxLength());
		final List<String> allowedTypes = getAllowedCharacterTypes();
		
		if(allowedTypes.size() == 0) {
			throw new RuntimeException("Please select atleast one character type to be present in the password.");
		}

		StringBuffer password = new StringBuffer();
		int prevCharOption = -1;
		String characterType = null; 
		
		for (int i = 0; i < passwordLength; i++) {
			int charTypeIndex = getRandomNumber(0, allowedTypes.size() - 1);
			if (i == 0 && pp.doesStartWithACharacter()) {
				if(pp.hasLowerCase()) {
					charTypeIndex = allowedTypes.indexOf(LOWER_CASE);
				} else if(pp.hasUpperCase()) {
					charTypeIndex = allowedTypes.indexOf(UPPER_CASE);
				} else {
					throw new RuntimeException("Password expected to start with a character, but neither LOWER or UPPER case flag set.");
				}
			} else {
				while (prevCharOption == charTypeIndex) {
					charTypeIndex = getRandomNumber(0, allowedTypes.size() - 1);
				}
			}			
			prevCharOption = charTypeIndex;
			characterType = allowedTypes.get(charTypeIndex);

			char currChar = ' ';
			switch (characterType) {
			case LOWER_CASE:
				// ASCII Range - 97 to 122 - Lower Case letters
				currChar = (char) getRandomNumber(97, 122);
				break;
			case UPPER_CASE:
				// ASCII Range - 65 to 90 - Upper Case letters
				currChar = (char) getRandomNumber(65, 90);
				break;
			case NUMBERS:
				// ASCII Range - 48 to 57 - Numbers
				currChar = (char) getRandomNumber(48, 57);
				break;
			case SPECIAL_CHARACTERS:
				// ASCII Ranges - 32-47, 58-64, 91-96, 123-126
				currChar = getSpecialCharacter();
				break;
			}

			password.append(currChar);
		}

		return password.toString();
	}
	
	/**
	 * This method returns a list of all character type allowed
	 * to be present in the password.
	 * 
	 * @return - List of allowed character types.
	 */
	private List<String> getAllowedCharacterTypes() {
		List<String> allowedTypes = new ArrayList<String>();
		if(pp.hasLowerCase()) {
			allowedTypes.add(LOWER_CASE);
		}
		if(pp.hasUpperCase()) {
			allowedTypes.add(UPPER_CASE);
		}
		if(pp.hasNumbers()) {
			allowedTypes.add(NUMBERS);
		}
		if(pp.hasSpecialCharacters()) {
			allowedTypes.add(SPECIAL_CHARACTERS);
		}
		
		return allowedTypes;
	}

	/**
	 * Generates a random number with in the ranges provided - Both inclusive.
	 * 
	 * @param lowerLimit
	 *            - Lower Limit
	 * @param upperLimit
	 *            - Upper Limit
	 * 
	 * @return - A number with in the range.
	 */
	private int getRandomNumber(int lowerLimit, int upperLimit) {
		long currTime = new Date().getTime();
		Random r = new Random(currTime);
		int rNum = lowerLimit + r.nextInt(upperLimit - lowerLimit);

		if (currTime % 10 == 0) {
			rNum++;
		}

		if (rNum > upperLimit) {
			rNum = upperLimit;
		}

		return rNum;
	}

	/**
	 * This method will return a special character generated at random with in
	 * the printable ASCII range.
	 * 
	 * @return - A special character.
	 */
	private char getSpecialCharacter() {
		// ASCII Ranges - 32 to 47, 58 to 64, 91 to 96, 123 to 126
		int rangeSelector = getRandomNumber(0, 3);
		char specialChar = '#';
		switch (rangeSelector) {
		case 0:
			specialChar = (char) getRandomNumber(32, 47);
			break;
		case 1:
			specialChar = (char) getRandomNumber(58, 64);
			break;
		case 2:
			specialChar = (char) getRandomNumber(91, 96);
			break;
		case 3:
			specialChar = (char) getRandomNumber(123, 126);
			break;
		}

		return specialChar;
	}
}
