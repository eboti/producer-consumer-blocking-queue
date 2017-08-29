package com;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

	private final BlockingQueue<Object> sharedQueue;

	public Consumer(BlockingQueue<Object> sharedQueue) {
		super();
		this.sharedQueue = sharedQueue;
	}

	@Override
	public void run() {
		while (true) {
			try {
				System.out.println(
						Thread.currentThread().getName() + " consumes: " + sharedQueue.take());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
