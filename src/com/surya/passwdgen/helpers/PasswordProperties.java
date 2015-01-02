package com.surya.passwdgen.helpers;

public class PasswordProperties {
	private boolean startsWithACharacter;
	private boolean hasUpperCase;
	private boolean hasLowerCase;
	private boolean hasSpecialCharacters;
	private boolean hasNumbers;
	private int maxLength;
	private int minLength;
	
	public static final int PASSWORD_MIN_LENGTH = 8;
	public static final int PASSWORD_MAX_LENGTH = 15;

	public boolean doesStartWithACharacter() {
		return startsWithACharacter;
	}

	public void setStartsWithACharacter(boolean startsWithACharacter) {
		this.startsWithACharacter = startsWithACharacter;
	}

	public boolean hasUpperCase() {
		return hasUpperCase;
	}

	public void setHasUpperCase(boolean hasUpperCase) {
		this.hasUpperCase = hasUpperCase;
	}

	public boolean hasLowerCase() {
		return hasLowerCase;
	}

	public void setHasLowerCase(boolean hasLowerCase) {
		this.hasLowerCase = hasLowerCase;
	}

	public boolean hasSpecialCharacters() {
		return hasSpecialCharacters;
	}

	public void setHasSpecialCharacters(boolean hasSpecialCharacters) {
		this.hasSpecialCharacters = hasSpecialCharacters;
	}

	public boolean hasNumbers() {
		return hasNumbers;
	}

	public void setHasNumbers(boolean hasNumbers) {
		this.hasNumbers = hasNumbers;
	}

	public int getMaxLength() {
		return maxLength;
	}

	public void setMaxLength(int maxLength) {
		this.maxLength = maxLength;
	}

	public int getMinLength() {
		return minLength;
	}

	public void setMinLength(int minLength) {
		this.minLength = minLength;
	}
}
