package com.akb.sig.etb;

public class Cache {

	private Box cache;
	
	public Cache () {
		cache = null;
	}
	
	public synchronized boolean setCache (Box cache) {
			if (!isFree()) return false; 
			this.cache = cache;
			return true; 			
	}
	
	public synchronized Box getCache () {
			if (isFree()) return null; 
			Box tmp = cache; 
			cache = null; 
			notify();
			return tmp;			
	}
	
	private boolean isFree () {
		return (cache==null);
	}
	
	
	public static class Box {

		private int n; 
		
		public Box (int n) {
			System.out.printf("Created Box: %x (%x)\n", n, hashCode());
			this.n = n;
		}
		
		public void end () {
			System.err.printf(" Stored Box: %x (%x)\n", n, hashCode());
		}

		public int getId() {
			return n;
		}
	}
}
