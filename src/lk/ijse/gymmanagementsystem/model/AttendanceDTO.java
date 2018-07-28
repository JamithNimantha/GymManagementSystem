/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.gymmanagementsystem.model;

/**
 *
 * @author jamith
 */
public class AttendanceDTO {
    private String attendance_id;
    private String attendance_date;
    private String in_time;
    private String member_id;

    public AttendanceDTO() {
    }

    public AttendanceDTO(String attendance_id, String attendance_date, String in_time, String member_id) {
        this.attendance_id = attendance_id;
        this.attendance_date = attendance_date;
        this.in_time = in_time;
        this.member_id = member_id;
    }

    /**
     * @return the attendance_id
     */
    public String getAttendance_id() {
        return attendance_id;
    }

    /**
     * @param attendance_id the attendance_id to set
     */
    public void setAttendance_id(String attendance_id) {
        this.attendance_id = attendance_id;
    }

    /**
     * @return the attendance_date
     */
    public String getAttendance_date() {
        return attendance_date;
    }

    /**
     * @param attendance_date the attendance_date to set
     */
    public void setAttendance_date(String attendance_date) {
        this.attendance_date = attendance_date;
    }

    /**
     * @return the in_time
     */
    public String getIn_time() {
        return in_time;
    }

    /**
     * @param in_time the in_time to set
     */
    public void setIn_time(String in_time) {
        this.in_time = in_time;
    }

    /**
     * @return the member_id
     */
    public String getMember_id() {
        return member_id;
    }

    /**
     * @param member_id the member_id to set
     */
    public void setMember_id(String member_id) {
        this.member_id = member_id;
    }

    @Override
    public String toString() {
        return "AttendanceDTO{" + "attendance_id=" + attendance_id + ", attendance_date=" + attendance_date + ", in_time=" + in_time + ", member_id=" + member_id + '}';
    }
    
    
}
