package com.akb.sig.etb;

import com.akb.sig.etb.Cache.Box;

public class BoxFactory extends Thread {

	private Cache c; 
	
	public BoxFactory(Cache c) {
		this.c = c; 
	}

	@Override
	public void run () {
		int n = 1;
		while (true) 
			try {
				if (c.setCache(new Box(n))) 
					Thread.sleep(1000 * n);
				else 
					continue;
				n++;
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	
}
