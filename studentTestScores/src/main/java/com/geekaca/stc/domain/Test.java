package com.geekaca.stc.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 成绩表
 * @TableName tb_test
 */
@Data
public class Test implements Serializable {
    /**
     * 
     */
    private Integer testId;

    /**
     * 
     */
    private String stuNo;

    /**
     * 
     */
    private Integer testSubject;
    private Subjects subjects;

    /**
     * 
     */
    private Double testScores;

    /**
     * 
     */
    private Date testDate;

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
        Test other = (Test) that;
        return (this.getTestId() == null ? other.getTestId() == null : this.getTestId().equals(other.getTestId()))
            && (this.getStuNo() == null ? other.getStuNo() == null : this.getStuNo().equals(other.getStuNo()))
            && (this.getTestSubject() == null ? other.getTestSubject() == null : this.getTestSubject().equals(other.getTestSubject()))
            && (this.getTestScores() == null ? other.getTestScores() == null : this.getTestScores().equals(other.getTestScores()))
            && (this.getTestDate() == null ? other.getTestDate() == null : this.getTestDate().equals(other.getTestDate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getTestId() == null) ? 0 : getTestId().hashCode());
        result = prime * result + ((getStuNo() == null) ? 0 : getStuNo().hashCode());
        result = prime * result + ((getTestSubject() == null) ? 0 : getTestSubject().hashCode());
        result = prime * result + ((getTestScores() == null) ? 0 : getTestScores().hashCode());
        result = prime * result + ((getTestDate() == null) ? 0 : getTestDate().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", testId=").append(testId);
        sb.append(", stuNo=").append(stuNo);
        sb.append(", testSubject=").append(testSubject);
        sb.append(", testScores=").append(testScores);
        sb.append(", testDate=").append(testDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}