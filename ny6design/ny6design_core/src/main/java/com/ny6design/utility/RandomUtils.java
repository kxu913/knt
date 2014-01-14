package com.ny6design.utility;


import java.util.Random;

import com.ny6design.core.ThreadLocalRandom;
/**
 * 
 * @author kevin
 *
 */
public class RandomUtils {

	public static final String allChar = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

	public static final String letterChar = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

	public static final String numberChar = "0123456789";

	public static String generateMixString(int length) {

		StringBuffer sb = new StringBuffer();

		Random random = ThreadLocalRandom.current();

		for (int i = 0; i < length; i++) {

			sb.append(allChar.charAt(random.nextInt(letterChar.length())));

		}

		return sb.toString();

	}

	public static String generateNumberString(int length) {

		StringBuffer sb = new StringBuffer();

		Random random = new Random();

		for (int i = 0; i < length; i++) {

			sb.append(numberChar.charAt(random.nextInt(numberChar.length())));

		}

		return sb.toString();

	}

	public static String generateUpperString(int length) {

		return generateMixString(length).toUpperCase();

	}

}
