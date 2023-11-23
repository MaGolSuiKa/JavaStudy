package com.geekaca.studentclasssystem.domain;

import java.io.Serializable;
import lombok.Data;

/**
 * 课程阶段
 * @TableName phase
 */
@Data
public class Phase implements Serializable {
    /**
     * 
     */
    private Integer phaseId;

    /**
     * 
     */
    private String phaseName;

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
        Phase other = (Phase) that;
        return (this.getPhaseId() == null ? other.getPhaseId() == null : this.getPhaseId().equals(other.getPhaseId()))
            && (this.getPhaseName() == null ? other.getPhaseName() == null : this.getPhaseName().equals(other.getPhaseName()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getPhaseId() == null) ? 0 : getPhaseId().hashCode());
        result = prime * result + ((getPhaseName() == null) ? 0 : getPhaseName().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", phaseId=").append(phaseId);
        sb.append(", phaseName=").append(phaseName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}