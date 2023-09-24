package com.geekaca.stc.domain;

import java.io.Serializable;
import lombok.Data;

/**
 * 班级表
 * @TableName tb_class
 */
@Data
public class Class implements Serializable {
    /**
     * 
     */
    private Integer classId;

    /**
     * 
     */
    private String className;

    /**
     * 
     */
    private String classAddress;

    /**
     * 
     */
    private Integer classMembers;

    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Class other = (Class) that;
        return (this.getClassId() == null ? other.getClassId() == null : this.getClassId().equals(other.getClassId()))
            && (this.getClassName() == null ? other.getClassName() == null : this.getClassName().equals(other.getClassName()))
            && (this.getClassAddress() == null ? other.getClassAddress() == null : this.getClassAddress().equals(other.getClassAddress()))
            && (this.getClassMembers() == null ? other.getClassMembers() == null : this.getClassMembers().equals(other.getClassMembers()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getClassId() == null) ? 0 : getClassId().hashCode());
        result = prime * result + ((getClassName() == null) ? 0 : getClassName().hashCode());
        result = prime * result + ((getClassAddress() == null) ? 0 : getClassAddress().hashCode());
        result = prime * result + ((getClassMembers() == null) ? 0 : getClassMembers().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", classId=").append(classId);
        sb.append(", className=").append(className);
        sb.append(", classAddress=").append(classAddress);
        sb.append(", classMembers=").append(classMembers);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}