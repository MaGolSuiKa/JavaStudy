package com.geekaca.studentclasssystem.domain;

import java.io.Serializable;
import lombok.Data;

/**
 * 学生对应班级表
 * @TableName stu_class
 */
@Data
public class StuClass implements Serializable {
    /**
     * 
     */
    private Integer stuClassId;

    /**
     * 
     */
    private Integer stuId;

    /**
     * 
     */
    private String classId;

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
        StuClass other = (StuClass) that;
        return (this.getStuClassId() == null ? other.getStuClassId() == null : this.getStuClassId().equals(other.getStuClassId()))
            && (this.getStuId() == null ? other.getStuId() == null : this.getStuId().equals(other.getStuId()))
            && (this.getClassId() == null ? other.getClassId() == null : this.getClassId().equals(other.getClassId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getStuClassId() == null) ? 0 : getStuClassId().hashCode());
        result = prime * result + ((getStuId() == null) ? 0 : getStuId().hashCode());
        result = prime * result + ((getClassId() == null) ? 0 : getClassId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", stuClassId=").append(stuClassId);
        sb.append(", stuId=").append(stuId);
        sb.append(", classId=").append(classId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}