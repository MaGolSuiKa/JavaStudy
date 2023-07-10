package com.geekaca.homework;

public class Ticket {
    private int ticketNums;

    public Ticket(int ticketNums) {
        this.ticketNums = ticketNums;
    }

    public void saleTicket() {
        String name = Thread.currentThread().getName();
        this.ticketNums--;
        System.out.println(name + "售出一张票，剩余：" + ticketNums + "张");
    }

    public int getTicketNums() {
        return ticketNums;
    }

    public void setTicketNums(int ticketNums) {
        this.ticketNums = ticketNums;
    }
}
