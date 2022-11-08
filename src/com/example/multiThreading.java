package com.example;

class CustomThread extends Thread{

    @Override
    public void run() {
        String[] message = {"This", "is", "my", "first", "multi-threading", "project"};

        for (String pMessage : message) {
            System.out.println(pMessage);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

public class multiThreading {

    public static void main(String[] args) {
        CustomThread thd = new CustomThread();
        thd.start();
    }
}
