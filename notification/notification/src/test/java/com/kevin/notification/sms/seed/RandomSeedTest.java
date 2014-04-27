package com.kevin.notification.sms.seed;

import static org.junit.Assert.*;

import org.junit.Test;

public class RandomSeedTest {

	@Test
	public void testValide() throws InterruptedException {
		RandomSeed seed = RandomSeed.getDefaultSeedInstance(4, 1);
		int number = seed.createValidationCode();
		System.out.println(number);
		assertFalse(seed.valide(number + 1));
		Thread.sleep(30000);
		assertTrue(seed.valide(number));
		Thread.sleep(31000);
		assertFalse(seed.valide(number));

		number = seed.createValidationCode();
		System.out.println(number);
		assertFalse(seed.valide(number + 1));
		Thread.sleep(30000);
		assertTrue(seed.valide(number));
		Thread.sleep(31000);
		assertFalse(seed.valide(number));
	}

	@Test
	public void testMulitipyValide() throws InterruptedException {
		final RandomSeed seed = RandomSeed.getDefaultSeedInstance();
		for (int i = 0; i < 100; i++) {
			new Thread(new Runnable() {

				@Override
				public void run() {
					int number = seed.createValidationCode();
					System.out.println(Thread.currentThread().getName() + " :seed: " + number);
					try {
						Thread.sleep(30000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName() + " :1: " + seed.valide(number));
					try {
						Thread.sleep(31000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName() + " :2: " + seed.valide(number));
				}
			}).start();
		}
		Thread.sleep(62000);

	}
}
