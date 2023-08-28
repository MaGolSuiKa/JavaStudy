package com.geekaca.dao;

import java.util.*;

public class BookDao {
    private int[] dArray;
    private List<String> dList;
    private Set<String> dSet;
    private Map<String,String> dMap;
    private Properties dProperties;

    public int[] getdArray() {
        return dArray;
    }

    public void setdArray(int[] dArray) {
        this.dArray = dArray;
    }

    public List<String> getdList() {
        return dList;
    }

    public void setdList(List<String> dList) {
        this.dList = dList;
    }

    public Set<String> getdSet() {
        return dSet;
    }

    public void setdSet(Set<String> dSet) {
        this.dSet = dSet;
    }

    public Map<String, String> getdMap() {
        return dMap;
    }

    public void setdMap(Map<String, String> dMap) {
        this.dMap = dMap;
    }

    public Properties getdProperties() {
        return dProperties;
    }

    public void setdProperties(Properties dProperties) {
        this.dProperties = dProperties;
    }

    public int bookSave(){
        System.out.println("bookSave");
        return 0;
    }

    public void show() {
        System.out.println("book dao save");

        System.out.println("遍历数组:" + Arrays.toString(dArray));

        System.out.println("遍历List" + dList);

        System.out.println("遍历Set" + dSet);

        System.out.println("遍历Map" + dMap);

        System.out.println("遍历Properties" + dProperties);
    }
}
