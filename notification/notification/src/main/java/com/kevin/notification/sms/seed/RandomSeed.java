package com.kevin.notification.sms.seed;

import com.kevin.notification.core.ThreadLocalRandom;

/**
 * used to create seed for validation
 * 
 * @author kxu
 * 
 */

public class RandomSeed {
	/**
	 * the digit of validation number
	 */
	private final int digit;
	/**
	 * expired time, unit is minutes
	 */
	private final int expiredTime;

	private transient int seed;

	private transient long createTime;

	private RandomSeed(RandomSeedBulder builder) {
		this.digit = builder.digit;
		this.expiredTime = builder.expiredTime;
	}

	public static class RandomSeedBulder {
		private int digit = 6;
		/**
		 * expired time, unit is minutes
		 */
		private int expiredTime = 1;

		public RandomSeedBulder setDigit(int digit) {
			this.digit = digit;
			return this;
		}

		public RandomSeedBulder setExpiredMinutes(int expiredMinutes) {
			this.expiredTime = expiredMinutes;
			return this;
		}

		public RandomSeed build() {
			return new RandomSeed(this);
		}

	}

	public int createValidationCode() {
		ThreadLocalRandom random = ThreadLocalRandom.current();
		seed = random.getFixedLengthRandom(digit);
		createTime = System.currentTimeMillis();
		return seed;
	}

	public boolean valide(int number) {
		long gap = System.currentTimeMillis() - createTime;
		return number == seed && gap <= expiredTime * 60 * 1000;
	}

}
