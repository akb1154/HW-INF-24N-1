package com.akb.sig.etb.xtend;

import com.akb.sig.etb.BoxStorage;

public class XBoxStorage extends ThreadGroup{
	
	private BoxStorage[] bs; 
	
	public XBoxStorage (XCache x) {
		super("XBoxStorage");
		this.bs = new BoxStorage[10];
		for (int i=0; i<bs.length; i++)
			bs[i] = new BoxStorage (x);
	}
	
	public void start () {
		for (BoxStorage b : bs)
			b.start();
	}
}
