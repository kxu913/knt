package com.ny6design.core;

import static org.junit.Assert.*;

import org.junit.Test;

public class ThreadLocalRandomTest {

	@Test
	public void testNextIntIntInt() throws InterruptedException {
		for(int i =0;i<100;i++){
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					int seed = (int) (ThreadLocalRandom.current().getFixedLengthRandom(5));
					System.out.println(Thread.currentThread().getName()+ ":" +seed);
				}
			}).start();
		}
		
		Thread.currentThread().sleep(10000l);
		
	}

}
