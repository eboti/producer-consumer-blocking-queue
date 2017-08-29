package com;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

// no need wait/notify, since it's automatic because of the blocking queue
public class App {

	public static void main(String[] args) {
		
		BlockingQueue<Object> sharedQueue = new LinkedBlockingDeque<Object>();
		
		Thread producerThread = new Thread(new Producer(sharedQueue), Producer.class.getSimpleName());
		Thread consumerThread = new Thread(new Consumer(sharedQueue), Consumer.class.getSimpleName());
		
		producerThread.start();
		consumerThread.start();
	}

}
