package com.geekaca.studentclasssystem.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 出勤表
 * @TableName attendance
 */
@Data
public class Attendance implements Serializable {
    /**
     * 
     */
    private Integer attendanceId;

    /**
     * 班级id
     */
    private Integer classId;

    /**
     * 学生id
     */
    private Integer stuId;

    /**
     * 是否出勤，是“1”否“0”迟到“2”
     */
    private Integer state;

    /**
     * 日期时间
     */
    private Date attDate;

    /**
     * 作业情况，“1”完成，“0”未完成
     */
    private Integer homework;

    /**
     * 备注
     */
    private String comment;

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
        Attendance other = (Attendance) that;
        return (this.getAttendanceId() == null ? other.getAttendanceId() == null : this.getAttendanceId().equals(other.getAttendanceId()))
            && (this.getClassId() == null ? other.getClassId() == null : this.getClassId().equals(other.getClassId()))
            && (this.getStuId() == null ? other.getStuId() == null : this.getStuId().equals(other.getStuId()))
            && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()))
            && (this.getAttDate() == null ? other.getAttDate() == null : this.getAttDate().equals(other.getAttDate()))
            && (this.getHomework() == null ? other.getHomework() == null : this.getHomework().equals(other.getHomework()))
            && (this.getComment() == null ? other.getComment() == null : this.getComment().equals(other.getComment()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getAttendanceId() == null) ? 0 : getAttendanceId().hashCode());
        result = prime * result + ((getClassId() == null) ? 0 : getClassId().hashCode());
        result = prime * result + ((getStuId() == null) ? 0 : getStuId().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        result = prime * result + ((getAttDate() == null) ? 0 : getAttDate().hashCode());
        result = prime * result + ((getHomework() == null) ? 0 : getHomework().hashCode());
        result = prime * result + ((getComment() == null) ? 0 : getComment().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", attendanceId=").append(attendanceId);
        sb.append(", classId=").append(classId);
        sb.append(", stuId=").append(stuId);
        sb.append(", state=").append(state);
        sb.append(", attDate=").append(attDate);
        sb.append(", homework=").append(homework);
        sb.append(", comment=").append(comment);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}