package com.jbalint.activeobject;

public interface MessageQueue {
    public void put(Object message);
    public Object get();
}
