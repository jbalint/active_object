package com.jbalint.activeobject;

// servant
public class DemoMessageQueue implements MessageQueue {
    public void put(Object message) {
	System.out.println("Putting message '" + message + "' on thread " + Thread.currentThread());
    }

    public Object get() {
	Object message = new Object();
	System.out.println("Getting message '" + message + "' on thread " + Thread.currentThread());
	return message;
    }
}

