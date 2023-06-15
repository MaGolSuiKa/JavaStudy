package com.geekaca.homework.test2;

public abstract class Doujiangji {
    public abstract void wash();
    public abstract void putIn();

    public void powerON(){
        System.out.println("打开电源");
    }

    public final void Juicing(){
        //固定步骤
        wash();
        putIn();
        powerON();
    }
}
