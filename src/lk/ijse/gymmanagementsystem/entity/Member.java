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
public class Member {
    private String member_id;
    private String full_name;
    private String address;
    private String gender;
    private String mobile_number;
    private String date_of_birth;
    private String email;

    public Member() {
    }

    public Member(String member_id, String full_name, String address, String gender, String mobile_number, String date_of_birth, String email) {
        this.member_id = member_id;
        this.full_name = full_name;
        this.address = address;
        this.gender = gender;
        this.mobile_number = mobile_number;
        this.date_of_birth = date_of_birth;
        this.email = email;
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

    /**
     * @return the full_name
     */
    public String getFull_name() {
        return full_name;
    }

    /**
     * @param full_name the full_name to set
     */
    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return the mobile_number
     */
    public String getMobile_number() {
        return mobile_number;
    }

    /**
     * @param mobile_number the mobile_number to set
     */
    public void setMobile_number(String mobile_number) {
        this.mobile_number = mobile_number;
    }

    /**
     * @return the date_of_birth
     */
    public String getDate_of_birth() {
        return date_of_birth;
    }

    /**
     * @param date_of_birth the date_of_birth to set
     */
    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Member{" + "member_id=" + member_id + ", full_name=" + full_name + ", address=" + address + ", gender=" + gender + ", mobile_number=" + mobile_number + ", date_of_birth=" + date_of_birth + ", email=" + email + '}';
    }

    
    
    
}
