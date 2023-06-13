package com.geekaca.test02;

public class Teachers extends SchoolMembers {
    private String sectorName;

    public void makeHomework() {
        System.out.println("发布问题");
    }

    public String getSectorName() {
        return sectorName;
    }

    public void setSectorName(String sectorName) {
        this.sectorName = sectorName;
    }

    @Override
    public String toString() {
        return "Teachers{" +
                "names='" + names + '\'' +
                ", ages=" + ages +
                ", sectorName='" + sectorName + '\'' +
                '}';
    }
}
