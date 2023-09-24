package com.geekaca.stc.domain;

import java.io.Serializable;
import lombok.Data;

/**
 * 科目
 * @TableName tb_subjects
 */
@Data
public class Subjects implements Serializable {
    /**
     * 
     */
    private Integer subId;

    /**
     * 
     */
    private String subName;

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
        Subjects other = (Subjects) that;
        return (this.getSubId() == null ? other.getSubId() == null : this.getSubId().equals(other.getSubId()))
            && (this.getSubName() == null ? other.getSubName() == null : this.getSubName().equals(other.getSubName()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getSubId() == null) ? 0 : getSubId().hashCode());
        result = prime * result + ((getSubName() == null) ? 0 : getSubName().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", subId=").append(subId);
        sb.append(", subName=").append(subName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}