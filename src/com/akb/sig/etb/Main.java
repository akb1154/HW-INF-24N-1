package com.akb.sig.etb;

import com.akb.sig.etb.xtend.*;

public class Main {

	public static void main(String[] args) {
		XCache cache = new XCache (); 
		XBoxFactory factory = new XBoxFactory (cache); 
		XBoxStorage storage = new XBoxStorage (cache);
		factory.start();
		storage.start();
	}

}
