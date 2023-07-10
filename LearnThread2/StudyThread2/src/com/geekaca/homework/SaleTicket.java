package com.geekaca.homework;

import java.util.HashMap;
import java.util.Map;

public class SaleTicket implements Runnable {
    private Ticket ticket;

    private static Map<Integer, String> ticketMap = new HashMap<>();
    private static final Object lock = new Object();

    public SaleTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    @Override
    public void run() {
        String saleName = Thread.currentThread().getName();

        synchronized (lock) {
            while (ticket.getTicketNums() > 0) {
                ticket.saleTicket();
                if(!ticketMap.containsKey(ticket.getTicketNums())){
                    try {
                        ticketMap.put(ticket.getTicketNums(),saleName);
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else {
                    System.out.println("!");
                }
            }
            System.out.println(saleName+"票已售完");
        }
    }
}
