package com.geekaca.pojo;


//id, type_id, type_name
public class Type extends Brand{
    private Integer idt;
    private Integer typeid;
    private String typeName;

    public Integer getIdt() {
        return idt;
    }

    public void setIdt(Integer idt) {
        this.idt = idt;
    }

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
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
                ", typeId=" + typeid +
                ", typeName='" + typeName + '\'' +
                '}';
    }
}
