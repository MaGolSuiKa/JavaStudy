package com.geekaca.studentclasssystem.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 学生表
 * @TableName student
 */
@Data
public class Student implements Serializable {
    /**
     * 
     */
    private Integer stuId;

    /**
     * 姓名
     */
    private String stuName;

    /**
     * 入学时间
     */
    private Date stuStartDate;

    /**
     * 备注
     */
    private String stuComment;

    private Classes  classes;
    private Curriculum curriculum;
    private Phase   phase;

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
        Student other = (Student) that;
        return (this.getStuId() == null ? other.getStuId() == null : this.getStuId().equals(other.getStuId()))
            && (this.getStuName() == null ? other.getStuName() == null : this.getStuName().equals(other.getStuName()))
            && (this.getStuStartDate() == null ? other.getStuStartDate() == null : this.getStuStartDate().equals(other.getStuStartDate()))
            && (this.getStuComment() == null ? other.getStuComment() == null : this.getStuComment().equals(other.getStuComment()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getStuId() == null) ? 0 : getStuId().hashCode());
        result = prime * result + ((getStuName() == null) ? 0 : getStuName().hashCode());
        result = prime * result + ((getStuStartDate() == null) ? 0 : getStuStartDate().hashCode());
        result = prime * result + ((getStuComment() == null) ? 0 : getStuComment().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", stuId=").append(stuId);
        sb.append(", stuName=").append(stuName);
        sb.append(", stuStartDate=").append(stuStartDate);
        sb.append(", stuComment=").append(stuComment);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}