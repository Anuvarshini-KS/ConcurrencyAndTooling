package com.kovanlabs.intern.AdvancedConcurrency;

import java.util.concurrent.*;

public class FutureResult {
    public static void main(String[]args) throws Exception
    {
        ExecutorService service = Executors.newFixedThreadPool(2);
        Callable<Integer> task = () ->
        {
            System.out.println("Calculation carried out by : "+Thread.currentThread().getName());
            return 267+543;
        };

        Future<Integer> future = service.submit(task);
        try{
            int result = future.get();
            System.out.println("Result : "+result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        service.shutdown();
    }
}
