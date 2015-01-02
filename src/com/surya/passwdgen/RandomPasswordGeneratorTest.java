package com.surya.passwdgen;

import org.junit.Test;

import com.surya.passwdgen.helpers.PasswordProperties;

public class RandomPasswordGeneratorTest {

	@Test
	public void defaultPassword() {
		System.out.println("*** Default Password");
		RandomPasswordGenerator rpg = new RandomPasswordGenerator();
		System.out.println(rpg.generatePassword());
	}
	
	@Test
	public void charactersOnly() {
		System.out.println("*** Characters Only");
		PasswordProperties pp = new PasswordProperties();
		pp.setHasLowerCase(true);
		pp.setHasUpperCase(true);
		pp.setMinLength(10);
		pp.setMaxLength(20);
		RandomPasswordGenerator rpg = new RandomPasswordGenerator(pp);
		System.out.println(rpg.generatePassword());
	}
	
	@Test
	public void charsNumbersOnly() {
		System.out.println("*** Characters and Numbers Only");
		PasswordProperties pp = new PasswordProperties();
		pp.setHasLowerCase(true);
		pp.setHasUpperCase(true);
		pp.setHasNumbers(true);
		pp.setMinLength(7);
		pp.setMaxLength(10);
		RandomPasswordGenerator rpg = new RandomPasswordGenerator(pp);
		System.out.println(rpg.generatePassword());
	}

}
