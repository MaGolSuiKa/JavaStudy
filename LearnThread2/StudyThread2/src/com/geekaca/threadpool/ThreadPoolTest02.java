package com.geekaca.threadpool;

import java.util.concurrent.*;

public class ThreadPoolTest02 {
    public static void main(String[] args) {
        ExecutorService pool = new ThreadPoolExecutor(2, 5, 2, TimeUnit.SECONDS, new ArrayBlockingQueue(8),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.DiscardOldestPolicy());
        //                                                                  ↑抛弃队列中等待最久的任务 然后把当前任务加入队列中
        Future<String> future1 = pool.submit(new TestCallable(10));
        Future<String> future2 = pool.submit(new TestCallable(20));
        Future<String> future3 = pool.submit(new TestCallable(4));
        Future<String> future4 = pool.submit(new TestCallable(5));
        Future<String> future5 = pool.submit(new TestCallable(6));
        Future<String> future6 = pool.submit(new TestCallable(7));
        Future<String> future7 = pool.submit(new TestCallable(8));

        try {
            System.out.println(future1.get());
            System.out.println(future2.get());
            System.out.println(future3.get());
            System.out.println(future4.get());
            System.out.println(future5.get());
            System.out.println(future6.get());
            System.out.println(future7.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        pool.shutdown();
    }
}

class TestCallable implements Callable<String> {
    private int n;

    public TestCallable(int n) {
        this.n = n;
    }

    @Override
    public String call() throws Exception {
        double nums = 1;
        for (int i = 0; i < n; i++) {
            nums *= n;
        }
        return "结果为："+nums;
    }
}