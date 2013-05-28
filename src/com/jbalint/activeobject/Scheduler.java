package com.jbalint.activeobject;

import java.util.Iterator;
import java.util.LinkedList;

public class Scheduler implements Runnable {
    private LinkedList activationList = new LinkedList();

    public void insert(MethodRequest r) {
	synchronized (activationList) {
	    activationList.add(r);
	    activationList.notify();
	}
    }

    public void run() {
	while (true) {
	    synchronized (activationList) {
		try {
		    activationList.wait();
		    for (Iterator i = activationList.iterator(); i.hasNext(); ) {
			MethodRequest mr = (MethodRequest)i.next();
			i.remove();
			mr.call(); // TODO result
		    }
		} catch(InterruptedException ex) {
		} catch(Exception ex) {
		    ex.printStackTrace();
		}
	    }
	}
    }

    public void runService() {
	Thread t = new Thread(this, "Active Object Scheduler");
	t.setDaemon(true);
	t.start();
    }
}
