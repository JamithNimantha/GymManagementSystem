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
public class Measurement {
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
    private String membership_id;

    public Measurement() {
    }

    public Measurement(String measurement_id, double height, double weight, double bmi, String bmi_status, double chest, double waist, double thigs, double arms, String result_date, String membership_id) {
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

    @Override
    public String toString() {
        return "Measurement{" + "measurement_id=" + measurement_id + ", height=" + height + ", weight=" + weight + ", bmi=" + bmi + ", bmi_status=" + bmi_status + ", chest=" + chest + ", waist=" + waist + ", thigs=" + thigs + ", arms=" + arms + ", result_date=" + result_date + ", membership_id=" + membership_id + '}';
    }

    
    
    
}
