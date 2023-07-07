package com.geekaca.homework;



class CountPuls extends Thread {
    private NumsTarget nt;

    public CountPuls(String name, NumsTarget nt) {
        super(name);
        this.nt = nt;
    }

    @Override
    public void run() {
        nt.numsPlus();
    }
}
