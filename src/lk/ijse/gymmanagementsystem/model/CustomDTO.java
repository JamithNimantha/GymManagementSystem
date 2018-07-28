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
public class CustomDTO {
    private String first_name;
    private String attendance_id;
    private String attendance_date;
    private String in_time;
    private String membership_id;
    
    
     

    public CustomDTO(String first_name, String attendance_id, String attendance_date, String in_time, String membership_id) {
        this.first_name = first_name;
        this.attendance_id = attendance_id;
        this.attendance_date = attendance_date;
        this.in_time = in_time;
        this.membership_id = membership_id;
    }
    
    private String full_name;
    private String measurement_id;
    private double height;
    private double weight;
    private double bmi;
    private String bmi_status;
    private double chest;
    private double waist;
    private double thigs;
    private double arms;
    private String result_date;
    

    public CustomDTO() {
    }

    public CustomDTO(String full_name, String measurement_id, double height, double weight, double bmi, String bmi_status, double chest, double waist, double thigs, double arms, String result_date, String membership_id) {
        this.full_name = full_name;
        this.measurement_id = measurement_id;
        this.height = height;
        this.weight = weight;
        this.bmi = bmi;
        this.bmi_status = bmi_status;
        this.chest = chest;
        this.waist = waist;
        this.thigs = thigs;
        this.arms = arms;
        this.result_date = result_date;
        this.membership_id = membership_id;
    }
    
    private String member_id;
private String address;
private String gender;
private String mobile_number;
private String date_of_birth;
private String email;
private String joining_date;
private String package_name;
private String t_full_name;

    


    public CustomDTO(String member_id, String full_name, String address, String gender, String mobile_number, String date_of_birth, String email, String joining_date, String package_name, String t_full_name) {
        this.member_id = member_id;
        this.full_name = full_name;
        this.address = address;
        this.gender = gender;
        this.mobile_number = mobile_number;
        this.date_of_birth = date_of_birth;
        this.email = email;
        this.joining_date = joining_date;
        this.package_name = package_name;
        this.t_full_name = t_full_name;
    }
    
    private String payment_id;
    private String payment_date;
    private String payment_time;
    private String payment_description;
    private double payment_amount;

    public CustomDTO(String full_name, String payment_id, String payment_date, String payment_time, String payment_description, double payment_amount) {
        this.full_name = full_name;
        this.payment_id = payment_id;
        this.payment_date = payment_date;
        this.payment_time = payment_time;
        this.payment_description = payment_description;
        this.payment_amount = payment_amount;
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
     * @return the payment_id
     */
    public String getPayment_id() {
        return payment_id;
    }

    /**
     * @param payment_id the payment_id to set
     */
    public void setPayment_id(String payment_id) {
        this.payment_id = payment_id;
    }

    /**
     * @return the payment_date
     */
    public String getPayment_date() {
        return payment_date;
    }

    /**
     * @param payment_date the payment_date to set
     */
    public void setPayment_date(String payment_date) {
        this.payment_date = payment_date;
    }

    /**
     * @return the payment_time
     */
    public String getPayment_time() {
        return payment_time;
    }

    /**
     * @param payment_time the payment_time to set
     */
    public void setPayment_time(String payment_time) {
        this.payment_time = payment_time;
    }

    /**
     * @return the payment_description
     */
    public String getPayment_description() {
        return payment_description;
    }

    /**
     * @param payment_description the payment_description to set
     */
    public void setPayment_description(String payment_description) {
        this.payment_description = payment_description;
    }

    /**
     * @return the payment_amount
     */
    public double getPayment_amount() {
        return payment_amount;
    }

    /**
     * @param payment_amount the payment_amount to set
     */
    public void setPayment_amount(double payment_amount) {
        this.payment_amount = payment_amount;
    }

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
     * @return the package_name
     */
    public String getPackage_name() {
        return package_name;
    }

    /**
     * @param package_name the package_name to set
     */
    public void setPackage_name(String package_name) {
        this.package_name = package_name;
    }

    /**
     * @return the t_full_name
     */
    public String getT_full_name() {
        return t_full_name;
    }

    /**
     * @param t_full_name the t_full_name to set
     */
    public void setT_full_name(String t_full_name) {
        this.t_full_name = t_full_name;
    }

    /**
     * @return the full_name
     */
    

    /**
     * @return the measurement_id
     */
    public String getMeasurement_id() {
        return measurement_id;
    }

    /**
     * @param measurement_id the measurement_id to set
     */
    public void setMeasurement_id(String measurement_id) {
        this.measurement_id = measurement_id;
    }

    /**
     * @return the height
     */
    public double getHeight() {
        return height;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * @return the weight
     */
    public double getWeight() {
        return weight;
    }

    /**
     * @param weight the weight to set
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * @return the bmi
     */
    public double getBmi() {
        return bmi;
    }

    /**
     * @param bmi the bmi to set
     */
    public void setBmi(double bmi) {
        this.bmi = bmi;
    }

    /**
     * @return the bmi_status
     */
    public String getBmi_status() {
        return bmi_status;
    }

    /**
     * @param bmi_status the bmi_status to set
     */
    public void setBmi_status(String bmi_status) {
        this.bmi_status = bmi_status;
    }

    /**
     * @return the chest
     */
    public double getChest() {
        return chest;
    }

    /**
     * @param chest the chest to set
     */
    public void setChest(double chest) {
        this.chest = chest;
    }

    /**
     * @return the waist
     */
    public double getWaist() {
        return waist;
    }

    /**
     * @param waist the waist to set
     */
    public void setWaist(double waist) {
        this.waist = waist;
    }

    /**
     * @return the thigs
     */
    public double getThigs() {
        return thigs;
    }

    /**
     * @param thigs the thigs to set
     */
    public void setThigs(double thigs) {
        this.thigs = thigs;
    }

    /**
     * @return the arms
     */
    public double getArms() {
        return arms;
    }

    /**
     * @param arms the arms to set
     */
    public void setArms(double arms) {
        this.arms = arms;
    }

    /**
     * @return the result_date
     */
    public String getResult_date() {
        return result_date;
    }

    /**
     * @param result_date the result_date to set
     */
    public void setResult_date(String result_date) {
        this.result_date = result_date;
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
    /**
     * @return the first_name
     */
    public String getFirst_name() {
        return first_name;
    }

    /**
     * @param first_name the first_name to set
     */
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
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
    

    /**
     * @param membership_id the membership_id to set
     */
   
    
    
}
