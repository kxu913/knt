package com.kevin.notification.sms.seed;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.kevin.notification.core.ThreadLocalRandom;

/**
 * used to create seed for validation
 * 
 * @author kxu
 * 
 */

public class RandomSeed {

	private final static int DEFAULT_DIGIT = 6;
	/**
	 * expired time, unit is minutes
	 */
	private final static int DEFAULT_EXPIREDTIME = 1;

	/**
	 * the digit of validation number
	 */
	private final int digit;
	/**
	 * expired time, unit is minutes
	 */
	private final int expiredTime;

	private int seed;

	private long createTime;

	/**
	 * used to store seed which had been created for validating
	 */
	private Map<Integer, RandomSeed> seeds = new ConcurrentHashMap<Integer, RandomSeed>();

	private RandomSeed(RandomSeedBulder builder) {
		this.digit = builder.digit;
		this.expiredTime = builder.expiredTime;
		this.createTime = builder.createTime;
		this.seed = builder.seed;
	}

	public static RandomSeed getInstance(int digit, int expiredTime) {
		return RandomSeedHolder.getInstance(digit, expiredTime);
	}

	public static RandomSeed getInstance() {
		return RandomSeedHolder.getInstance(DEFAULT_DIGIT, DEFAULT_EXPIREDTIME);
	}

	/**
	 * holder for get instance
	 * 
	 * @author kxu
	 * 
	 */
	private static final class RandomSeedHolder {
		private final static Map<Integer, RandomSeed> INSTANCES = new ConcurrentHashMap<Integer, RandomSeed>();;

		private static RandomSeed getInstance(int digit, int expiredTime) {
			RandomSeed instance = INSTANCES.get(createKey(digit, expiredTime));
			if (instance == null) {
				instance = new RandomSeedBulder().setDigit(digit).setExpiredMinutes(expiredTime).build();
				INSTANCES.put(createKey(digit, expiredTime), instance);
			}
			return instance;
		}
	}

	public static class RandomSeedBulder {
		private int digit = DEFAULT_DIGIT;
		/**
		 * expired time, unit is minutes
		 */
		private int expiredTime = DEFAULT_EXPIREDTIME;

		private int seed;

		private long createTime;

		public RandomSeedBulder setDigit(int digit) {
			this.digit = digit;
			return this;
		}

		public RandomSeedBulder setExpiredMinutes(int expiredMinutes) {
			this.expiredTime = expiredMinutes;
			return this;
		}

		public RandomSeedBulder setCreateTime(long createTime) {
			this.createTime = createTime;
			return this;
		}

		public RandomSeedBulder setSeed(int seed) {
			this.seed = seed;
			return this;
		}

		public RandomSeed build() {
			return new RandomSeed(this);
		}

	}

	private static int createKey(Integer digit, Integer expiredTime) {
		return digit * 10 + expiredTime * 20;
	}

	public int createValidationCode() {
		ThreadLocalRandom random = ThreadLocalRandom.current();
		seed = random.getFixedLengthRandom(digit);
		createTime = System.currentTimeMillis();
		seeds.put(seed, new RandomSeedBulder().setCreateTime(createTime).setSeed(seed).build());
		return seed;
	}

	public boolean valide(int number) {
		RandomSeed seedObject = seeds.get(number);
		if (seedObject != null) {
			long gap = System.currentTimeMillis() - seedObject.createTime;
			boolean isExpired = gap > seedObject.expiredTime * 60 * 1000;
			if (isExpired) {
				seeds.remove(seedObject);
				return false;
			} else {
				return number == seedObject.seed && gap <= seedObject.expiredTime * 60 * 1000;
			}
		}
		return false;
	}

}
