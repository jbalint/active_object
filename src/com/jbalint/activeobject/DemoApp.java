package com.jbalint.activeobject;

import java.lang.reflect.*;
import java.util.*;

public class DemoApp {
    public static void main(String args[]) throws InterruptedException /* sleep() */ {
	DemoMessageQueue demoMq = new DemoMessageQueue();
	Scheduler scheduler = new Scheduler();
	scheduler.runService();
	AoProxy proxy = new AoProxy(demoMq, scheduler);
	MessageQueue mqProxy = (MessageQueue)Proxy.newProxyInstance(DemoApp.class.getClassLoader(), new Class[] {MessageQueue.class}, proxy);
	mqProxy.put("test");
	Thread.sleep(1000);
    }
}
