package com.geekaca.pojo;


//type_id, type_name
public class Type {
    private Integer typeId;
    private String typeName;

    public Type(String typeName) {
        this.typeName = typeName;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
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
                "id=" + typeId +
                ", typeName='" + typeName + '\'' +
                '}';
    }
}
