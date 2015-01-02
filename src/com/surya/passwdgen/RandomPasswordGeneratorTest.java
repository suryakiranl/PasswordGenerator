package com.surya.passwdgen;

import org.junit.Test;

public class RandomPasswordGeneratorTest {

	@Test
	public void test() {
		RandomPasswordGenerator rpg = new RandomPasswordGenerator();
		System.out.println(rpg.generatePassword());
	}

}
