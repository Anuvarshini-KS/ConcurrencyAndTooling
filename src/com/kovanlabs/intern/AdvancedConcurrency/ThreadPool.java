package com.kovanlabs.intern.AdvancedConcurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {
    public static void main(String[]args)
    {
        ExecutorService service = Executors.newFixedThreadPool(3);
        for(int i=0;i<10;i++)
        {
            int task = i+1;
            service.execute(()->
            {
                try{
                    Thread.sleep(1000);
                    System.out.println("Task "+task+" is executed by "+Thread.currentThread().getName());
                }catch(InterruptedException e)
                {
                    throw new RuntimeException();
                }
            });
        }
        service.shutdown();
    }
}
