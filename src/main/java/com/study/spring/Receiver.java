package com.study.spring;

public class Receiver {
    public void onMessage(String message) {
        System.out.println("Receive message: " + message);
    }
}
