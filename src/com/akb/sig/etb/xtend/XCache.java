package com.akb.sig.etb.xtend;

import java.util.HashMap;

import com.akb.sig.etb.Cache;

public class XCache extends Cache {
	
	private HashMap<Integer, Box> cache;
	
	public XCache () {
		cache = new HashMap<Integer, Box>();
		
	}
	
	@Override
	public synchronized Box getCache() {
		if (cache.size() == 0) return null;
		int key = (int) cache.keySet().toArray()[0];
		Box ret = cache.get(key);
		cache.remove(key, ret);
		return ret;
	}
	
	@Override
	public synchronized boolean setCache(Box cache) {
		if (this.cache.size() == 10) return false;
		this.cache.put(cache.hashCode(), cache);
		return true;
	}

}
