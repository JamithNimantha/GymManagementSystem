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
public class TrainerDTO {
    private String trainer_id;
    private String full_name;
    private String date_of_birth;
    private String gender;
    private String mobile_number;
    private String address;
    private String email;
    private String joining_date;
    private String description;

    public TrainerDTO() {
    }

    public TrainerDTO(String trainer_id, String full_name, String date_of_birth, String gender, String mobile_number, String address, String email, String joining_date, String description) {
        this.trainer_id = trainer_id;
        this.full_name = full_name;
        this.date_of_birth = date_of_birth;
        this.gender = gender;
        this.mobile_number = mobile_number;
        this.address = address;
        this.email = email;
        this.joining_date = joining_date;
        this.description = description;
    }

    /**
     * @return the trainer_id
     */
    public String getTrainer_id() {
        return trainer_id;
    }

    /**
     * @param trainer_id the trainer_id to set
     */
    public void setTrainer_id(String trainer_id) {
        this.trainer_id = trainer_id;
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
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "TrainerDTO{" + "trainer_id=" + trainer_id + ", full_name=" + full_name + ", date_of_birth=" + date_of_birth + ", gender=" + gender + ", mobile_number=" + mobile_number + ", address=" + address + ", email=" + email + ", joining_date=" + joining_date + ", description=" + description + '}';
    }

    
    
}
