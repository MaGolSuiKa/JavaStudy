package com.geekaca.homework;


import java.util.concurrent.*;

public class Test03 {
    public static void main(String[] args) {
        Ticket t = new Ticket(20);
        SaleTicket saleTicket = new SaleTicket(t);
        ExecutorService pool = new ThreadPoolExecutor(8, 10, 1,
                TimeUnit.SECONDS, new ArrayBlockingQueue(20),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        pool.execute(saleTicket);
        pool.execute(saleTicket);
        pool.execute(saleTicket);
        pool.execute(saleTicket);
        pool.execute(saleTicket);
        pool.execute(saleTicket);
        pool.execute(saleTicket);
        pool.execute(saleTicket);

        pool.shutdown();
    }
}
