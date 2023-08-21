package com.geekaca.pojo;


//type_id, type_name
public class Type {
    private Integer idt;
    private String typeName;

    public Type(String typeName) {
        this.typeName = typeName;
    }

    public Integer getIdt() {
        return idt;
    }

    public void setIdt(Integer idt) {
        this.idt = idt;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return "Type{" +
                "id=" + idt +
                ", typeName='" + typeName + '\'' +
                '}';
    }
}
