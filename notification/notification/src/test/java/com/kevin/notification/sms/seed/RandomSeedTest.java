package com.kevin.notification.sms.seed;

import static org.junit.Assert.*;

import org.junit.Test;

public class RandomSeedTest {
	class RandomThread{
		
		public int getCode(){
			return RandomSeed.getInstance().createValidationCode();
		}
		
		public boolean valid(int code){
			return RandomSeed.getInstance().valide(code);
		}
	}
	
	@Test
	public void testAnotherValid() throws InterruptedException{
		int code = new RandomThread().getCode();
		System.out.println(code);
		Thread.sleep(3000);
		System.out.println(new RandomThread().valid(code));
	}
	@Test
	public void testValide() throws InterruptedException {
		RandomSeed seed = RandomSeed.getInstance(6, 1);
		RandomSeed seed2 = RandomSeed.getInstance(5, 2);
		
		int number = seed.createValidationCode();
		System.out.println(number);
		System.out.println(seed.valide(number));
		System.out.println(seed2.valide(number));
		
	}

	@Test
	public void testMulitipyValide() throws InterruptedException {
		final RandomSeed seed =  RandomSeed.getInstance();
		for (int i = 0; i < 10000; i++) {
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
					if(!seed.valide(number)){
						System.out.println(Thread.currentThread().getName() + " :1: " + seed.valide(number));
					}
					try {
						Thread.sleep(31000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					if(seed.valide(number)){
						System.out.println(Thread.currentThread().getName() + " :2: " + seed.valide(number));
					}
				}
			}).start();
		}
		Thread.sleep(62000);

	}
}
