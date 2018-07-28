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
public class RegistrationDTO {
    private String registration_id;
    private String Joining_date;
    private String member_id;

    public RegistrationDTO() {
    }

    public RegistrationDTO(String registration_id, String Joining_date, String member_id) {
        this.registration_id = registration_id;
        this.Joining_date = Joining_date;
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
     * @return the Joining_date
     */
    public String getJoining_date() {
        return Joining_date;
    }

    /**
     * @param Joining_date the Joining_date to set
     */
    public void setJoining_date(String Joining_date) {
        this.Joining_date = Joining_date;
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
        return "RegistrationDTO{" + "registration_id=" + registration_id + ", Joining_date=" + Joining_date + ", member_id=" + member_id + '}';
    }
    
    
}

