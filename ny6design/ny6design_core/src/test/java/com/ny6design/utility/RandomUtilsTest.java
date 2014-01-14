package com.ny6design.utility;

import static org.junit.Assert.*;

import org.junit.Test;

public class RandomUtilsTest {

	@Test
	public void test() {
		System.out.println("generateMixString(6)");
		for (int i = 0; i < 10; i++) {
			System.out.println(RandomUtils.generateUpperString(6));
		}

		System.out.println("generateNumberString(6)");
		for (int i = 0; i < 10; i++) {
			System.out.println(RandomUtils.generateNumberString(6));
		}
	}

}
