package com.geekaca.stc.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 学生表
 * @TableName tb_stu
 */
@Data
public class Stu implements Serializable {
    /**
     * 
     */
    private Integer stuId;

    /**
     * 
     */
    private String stuName;

    /**
     * 
     */
    private Date stuJoindate;

    /**
     * 
     */
    private Integer stuGender;

    /**
     * 
     */
    private String stuNo;

    /**
     * 
     */
    private Integer classNo;

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
        Stu other = (Stu) that;
        return (this.getStuId() == null ? other.getStuId() == null : this.getStuId().equals(other.getStuId()))
            && (this.getStuName() == null ? other.getStuName() == null : this.getStuName().equals(other.getStuName()))
            && (this.getStuJoindate() == null ? other.getStuJoindate() == null : this.getStuJoindate().equals(other.getStuJoindate()))
            && (this.getStuGender() == null ? other.getStuGender() == null : this.getStuGender().equals(other.getStuGender()))
            && (this.getStuNo() == null ? other.getStuNo() == null : this.getStuNo().equals(other.getStuNo()))
            && (this.getClassNo() == null ? other.getClassNo() == null : this.getClassNo().equals(other.getClassNo()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getStuId() == null) ? 0 : getStuId().hashCode());
        result = prime * result + ((getStuName() == null) ? 0 : getStuName().hashCode());
        result = prime * result + ((getStuJoindate() == null) ? 0 : getStuJoindate().hashCode());
        result = prime * result + ((getStuGender() == null) ? 0 : getStuGender().hashCode());
        result = prime * result + ((getStuNo() == null) ? 0 : getStuNo().hashCode());
        result = prime * result + ((getClassNo() == null) ? 0 : getClassNo().hashCode());
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
        sb.append(", stuJoindate=").append(stuJoindate);
        sb.append(", stuGender=").append(stuGender);
        sb.append(", stuNo=").append(stuNo);
        sb.append(", classNo=").append(classNo);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}