package com.dayday.action;

import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class HashMapTest {
	
	public static void main(String[] args) throws InterruptedException {
		final HashMap<String, String> map = new HashMap<String, String>();
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0; i<10000; i++){
					new Thread(new Runnable() {
						@Override
						public void run() {
							map.put(UUID.randomUUID().toString(), "");
						}
					}, "ftf"+i).start();;
				}
			}
		}, "ftf");
		t.start();
		t.join();
		ConcurrentHashMap<String, String> cmap = new ConcurrentHashMap<>();
	}

}
