package com.jbalint.activeobject;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodRequest {
    private Object target;
    private Method method;
    private Object args[];

    public MethodRequest(Object target, Method method, Object args[]) {
	this.target = target;
	this.method = method;
	this.args = args;
    }

    public Object call() throws IllegalAccessException, InvocationTargetException {
	return method.invoke(target, args);
    }
}
