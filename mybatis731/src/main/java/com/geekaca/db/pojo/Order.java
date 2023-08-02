package com.geekaca.db.pojo;

public class Order {
    //id, payment, payment_type, status
    private Integer id;
    //支付价格
    private Double payment;
    private Integer paymentType;
    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getPayment() {
        return payment;
    }

    public void setPayment(Double payment) {
        this.payment = payment;
    }

    public Integer getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(Integer paymentType) {
        this.paymentType = paymentType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", payment=" + payment +
                ", paymentType=" + paymentType +
                ", status=" + status +
                '}';
    }
}
