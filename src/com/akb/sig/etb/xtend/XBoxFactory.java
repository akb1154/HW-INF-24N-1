package com.akb.sig.etb.xtend;

import com.akb.sig.etb.BoxFactory;

public class XBoxFactory extends ThreadGroup {
	
	private BoxFactory[] bf; 
	
	public XBoxFactory (XCache x) {
		super("XBoxFactory");
		this.bf = new BoxFactory[10];
		for (int i=0; i<bf.length; i++)
			bf[i] = new BoxFactory (x);
	}
	
	public void start () {
		for (BoxFactory b : bf)
			b.start();
	}
}
