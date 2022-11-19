package com.xec;

class TestThread extends Thread{
    String name;

    TestThread(String name){
        this.name=name;
    }

    @Override
    public void run() {
        System.out.println("Thread is running :" + name);
    }
}
public class MyThreadJoin {
    public static void main(String[] args) {
        TestThread t1= new TestThread("1");
        TestThread t2= new TestThread("2");

        Thread t3=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 4; i++) {
                    System.out.println("A " + i);
                }
            }
        });
        try {
            t1.start();
            t1.join();
            t2.start();
            t2.join();
            t3.start();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
