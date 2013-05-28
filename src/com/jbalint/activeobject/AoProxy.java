package com.jbalint.activeobject;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class AoProxy implements InvocationHandler {
    private Object target;
    private Scheduler scheduler;

    public AoProxy(Object target, Scheduler scheduler) {
	this.target = target;
	this.scheduler = scheduler;
    }

    public Object invoke(Object proxy, Method method, Object args[]) {
	MethodRequest mr = new MethodRequest(target, method, args);
	scheduler.insert(mr);
	return null; // TODO
    }

    public static Object create(Object servant, Scheduler scheduler, Class interfaces[]) {
	AoProxy aoProxy = new AoProxy(servant, scheduler);
	return Proxy.newProxyInstance(AoProxy.class.getClassLoader(), interfaces, aoProxy);
    }
}
