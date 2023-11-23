package com.geekaca.studentclasssystem.domain;

import java.io.Serializable;
import lombok.Data;

/**
 * 课程表（具体名目）
 * @TableName curriculum
 */
@Data
public class Curriculum implements Serializable {
    /**
     * 
     */
    private Integer curriculumId;

    /**
     * 
     */
    private String curriculumName;

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
        Curriculum other = (Curriculum) that;
        return (this.getCurriculumId() == null ? other.getCurriculumId() == null : this.getCurriculumId().equals(other.getCurriculumId()))
            && (this.getCurriculumName() == null ? other.getCurriculumName() == null : this.getCurriculumName().equals(other.getCurriculumName()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCurriculumId() == null) ? 0 : getCurriculumId().hashCode());
        result = prime * result + ((getCurriculumName() == null) ? 0 : getCurriculumName().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", curriculumId=").append(curriculumId);
        sb.append(", curriculumName=").append(curriculumName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}