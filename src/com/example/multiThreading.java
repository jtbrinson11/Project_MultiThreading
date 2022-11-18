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
        //in a similar fashion, a boolean variable can be created to signal the thread to stop in case of infinite-loops for instance
        //because of cases where the thread might cache the variable and never see the chance, use the volatile keyword to ensure it isn't missed

        //the join method is a way of forcing the threads to wait for something to happen
        //a better method is to create a method that modifies the variable that both threads refer to, have the threads call the method, and declare the method as synchronized so that it forces one of the calls to wait
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

    //use an ExecutorService to run some tasks asynchronously that will assign tasks as threads become available
    //use a CountDownLatch to ensure that a task waits for others to finish
    //use a BlockingQueue to fill a queue up to a point, and block inserts until it gets empty enough
    //use a ReentrantLock to allow a thread to be used more than once, and to offer more flexibility with running threads instead of the synchronized keyword
    //use a Semaphore to grant access to a thread only through the semaphore itself by way of a counter, if the counter is 0, deny access, if greater than 0, grant access
    //use Callable as a way to return a result when a thread is complete, and Future as a way to store the result when the Callable is finished
    //use SwingWorker as a way to run background tasks while displaying a gui app