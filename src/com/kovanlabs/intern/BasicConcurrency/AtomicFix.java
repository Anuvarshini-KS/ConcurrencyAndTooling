package com.kovanlabs.intern.BasicConcurrency;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicFix {
    static AtomicInteger count = new AtomicInteger(0);
    public static void main(String[]args) throws InterruptedException
    {
        Thread[] threads = new Thread[10];
        for(int i=0;i<10;i++)
        {
            threads[i] = new Thread(()->{
                for(int j=0;j<1000;j++)
                {
                    count.incrementAndGet();
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
        System.out.println("Count value : "+count.get());
    }
}
