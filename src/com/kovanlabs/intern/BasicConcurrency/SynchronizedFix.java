package com.kovanlabs.intern.BasicConcurrency;

public class SynchronizedFix {
    static int count = 0;
    static synchronized void increment()
    {
        count++;
    }
    public static void main(String[]args) throws InterruptedException
    {
        Thread[] threads = new Thread[10];
        for(int i=0;i<10;i++)
        {
            threads[i] = new Thread(()->{
                for(int j=0;j<1000;j++)
                {
                    increment();
                }
            });
        }
        for(Thread t : threads)
        {
            t.start();
        }
        for(Thread t : threads)
        {
            t.join();
        }
        System.out.println("Count value : "+count);
    }
}
