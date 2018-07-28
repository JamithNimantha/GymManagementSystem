/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.gymmanagementsystem.entity;

/**
 *
 * @author jamith
 */
public class Attendance {
    private String attendance_id;
    private String attendance_date;
    private String in_time;
    private String membership_id;

    public Attendance() {
    }

    public Attendance(String attendance_id, String attendance_date, String in_time, String membership_id) {
        this.attendance_id = attendance_id;
        this.attendance_date = attendance_date;
        this.in_time = in_time;
        this.membership_id = membership_id;
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
     * @return the membership_id
     */
    public String getMembership_id() {
        return membership_id;
    }

    /**
     * @param membership_id the membership_id to set
     */
    public void setMembership_id(String membership_id) {
        this.membership_id = membership_id;
    }

    @Override
    public String toString() {
        return "Attendance{" + "attendance_id=" + attendance_id + ", attendance_date=" + attendance_date + ", in_time=" + in_time + ", membership_id=" + membership_id + '}';
    }
    
    
}
