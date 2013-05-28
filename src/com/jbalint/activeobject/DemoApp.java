package com.jbalint.activeobject;

public class DemoApp {
    public static void main(String args[]) throws InterruptedException /* sleep() */ {
	DemoMessageQueue demoMq = new DemoMessageQueue();
	Scheduler scheduler = new Scheduler();
	scheduler.runService();
	MessageQueue mqProxy = (MessageQueue)AoProxy.create(demoMq, scheduler, new Class[] {MessageQueue.class});
	mqProxy.put("test");
	Thread.sleep(1000);
    }
}
