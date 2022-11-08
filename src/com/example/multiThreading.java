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

class CustomThread1 implements Runnable {

    @Override
    public void run() {
        String[] message = {"Here's", "another", "example", "of", "multi-threading"};

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

    //creates the threads and runs them
    //they don't run in the order that they are created in the following lines
    public static void main(String[] args) {
        CustomThread thd = new CustomThread();
        thd.start();

        CustomThread thd1 = new CustomThread();
        thd1.start();

        System.out.println("\n\n\n");

        Thread thread = new Thread(new CustomThread1());
        Thread thread1 = new Thread(new CustomThread1());

        thread.start();
        thread1.start();

        //this is another method to create a thread without making a class
        Thread threadCustom = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                System.out.println("Custom Thread");
            }
        });

        threadCustom.start();
    }
}
