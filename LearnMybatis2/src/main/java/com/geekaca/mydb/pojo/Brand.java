package com.geekaca.mydb.pojo;

public class Brand {
    private Integer goodsId;
    private String goodsTitle;
    private double goodsPrice;

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsTitle() {
        return goodsTitle;
    }

    public void setGoodsTitle(String goodstitle) {
        this.goodsTitle = goodstitle;
    }

    public double getGoodSprice() {
        return goodsPrice;
    }

    public void setGoodsPrice(double goodsprice) {
        this.goodsPrice = goodsprice;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "goodsId=" + goodsId +
                ", goodstitle='" + goodsTitle + '\'' +
                ", goodsprice=" + goodsPrice +
                '}';
    }
}
