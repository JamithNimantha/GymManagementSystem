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
public class Registration {
    private String registration_id;
    private String joining_date;
    private String member_id;

    public Registration() {
    }

    public Registration(String registration_id, String joining_date, String member_id) {
        this.registration_id = registration_id;
        this.joining_date = joining_date;
        this.member_id = member_id;
    }

    /**
     * @return the registration_id
     */
    public String getRegistration_id() {
        return registration_id;
    }

    /**
     * @param registration_id the registration_id to set
     */
    public void setRegistration_id(String registration_id) {
        this.registration_id = registration_id;
    }

    /**
     * @return the joining_date
     */
    public String getJoining_date() {
        return joining_date;
    }

    /**
     * @param joining_date the joining_date to set
     */
    public void setJoining_date(String joining_date) {
        this.joining_date = joining_date;
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
        return "Registration{" + "registration_id=" + registration_id + ", joining_date=" + joining_date + ", member_id=" + member_id + '}';
    }
    
}
