package com.geekaca.threadpool;

import java.util.concurrent.*;

public class ThreadPoolTest01 {
    public static void main(String[] args) {
        ExecutorService pool = new ThreadPoolExecutor(1, 7, 1, TimeUnit.SECONDS, new ArrayBlockingQueue(7),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        //                                              ↑默认处理策略
        pool.execute(new TestRunnable(1, 10));
        pool.execute(new TestRunnable(2, 9));
        pool.execute(new TestRunnable(3, 8));
        pool.execute(new TestRunnable(4, 7));
        pool.execute(new TestRunnable(5, 6));
        pool.execute(new TestRunnable(6, 5));
        pool.execute(new TestRunnable(7, 4));

        pool.shutdown();
    }
}

class TestRunnable implements Runnable {
    private int start;
    private int count;

    public TestRunnable(int start, int count) {
        this.start = start;
        this.count = count;
    }

    @Override
    public void run() {
        for (int i = 0; i < count; i++) {

            try {
                System.out.print(start+" ");
                start ++;
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(".");
    }
}