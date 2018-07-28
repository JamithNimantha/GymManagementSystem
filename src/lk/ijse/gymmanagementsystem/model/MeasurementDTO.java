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
public class MeasurementDTO {
    private String MeasurementID;
    private double height;
    private double weight;
    private double bmi;
    private String bmiStatus;
    private double chest;
    private double waist;
    private double thigs;
    private double arm;
    private String resultDate;
    private String memberID;

    public MeasurementDTO() {
    }

    public MeasurementDTO(String MeasurementID, double height, double weight, double bmi, String bmiStatus, double chest, double waist, double thigs, double arm, String resultDate, String memberID) {
        this.MeasurementID = MeasurementID;
        this.height = height;
        this.weight = weight;
        this.bmi = bmi;
        this.bmiStatus = bmiStatus;
        this.chest = chest;
        this.waist = waist;
        this.thigs = thigs;
        this.arm = arm;
        this.resultDate = resultDate;
        this.memberID = memberID;
    }

    /**
     * @return the MeasurementID
     */
    public String getMeasurementID() {
        return MeasurementID;
    }

    /**
     * @param MeasurementID the MeasurementID to set
     */
    public void setMeasurementID(String MeasurementID) {
        this.MeasurementID = MeasurementID;
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
     * @return the bmiStatus
     */
    public String getBmiStatus() {
        return bmiStatus;
    }

    /**
     * @param bmiStatus the bmiStatus to set
     */
    public void setBmiStatus(String bmiStatus) {
        this.bmiStatus = bmiStatus;
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
     * @return the arm
     */
    public double getArm() {
        return arm;
    }

    /**
     * @param arm the arm to set
     */
    public void setArm(double arm) {
        this.arm = arm;
    }

    /**
     * @return the resultDate
     */
    public String getResultDate() {
        return resultDate;
    }

    /**
     * @param resultDate the resultDate to set
     */
    public void setResultDate(String resultDate) {
        this.resultDate = resultDate;
    }

    /**
     * @return the memberID
     */
    public String getMemberID() {
        return memberID;
    }

    /**
     * @param memberID the memberID to set
     */
    public void setMemberID(String memberID) {
        this.memberID = memberID;
    }

    @Override
    public String toString() {
        return "MeasurementDTO{" + "MeasurementID=" + MeasurementID + ", height=" + height + ", weight=" + weight + ", bmi=" + bmi + ", bmiStatus=" + bmiStatus + ", chest=" + chest + ", waist=" + waist + ", thigs=" + thigs + ", arm=" + arm + ", resultDate=" + resultDate + ", memberID=" + memberID + '}';
    }
    
    
}
