package com.akb.sig.etb;

import com.akb.sig.etb.Cache.Box;

public class BoxStorage extends Thread {

	private Cache c; 
	
	public BoxStorage (Cache c) {
		this.c = c;
	}

	@Override
	public void run() {
		while (true) 
			try {
				Box tmp = c.getCache();
				if (tmp == null) {
					sleep(128);
					continue;
				}
				tmp.end();
				sleep (getTime(tmp.getId()));
				System.gc();
			} catch (Exception e) {
				e.printStackTrace();
			}
	}

	// random time between 1500 and 500 ms;
	private long getTime(int id) {
		return id * (((int)(1000*Math.random()))%1001 + 500);
	}
}
