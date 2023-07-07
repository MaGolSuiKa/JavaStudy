package com.geekaca.homework;
import java.util.concurrent.locks.ReentrantLock;

public class NumsTarget {
    private int startNums;
    private int targetNums;
    private ReentrantLock lock = new ReentrantLock();

    public NumsTarget() {
    }

    public NumsTarget(int startNums, int targetNums) {
        this.startNums = startNums;
        this.targetNums = targetNums;
    }

    public void numsPlus() {
        String name = Thread.currentThread().getName();

        while (startNums < targetNums) {

            try {
                //lock.lock();
                synchronized (this){
                    startNums++;
                    Thread.sleep(100);
                }
                //lock.unlock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name + ":" + startNums);
        }

    }
}
