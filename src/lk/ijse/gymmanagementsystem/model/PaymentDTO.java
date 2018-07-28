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
public class PaymentDTO {
    private String paymentID;
    private String paymentDate;
    private String paymentTime;
    private String description;
    private double amount;
    private String memberID;

    public PaymentDTO() {
    }

    public PaymentDTO(String paymentID, String paymentDate, String paymentTime, String description, double amount, String memberID) {
        this.paymentID = paymentID;
        this.paymentDate = paymentDate;
        this.paymentTime = paymentTime;
        this.description = description;
        this.amount = amount;
        this.memberID = memberID;
    }

    /**
     * @return the paymentID
     */
    public String getPaymentID() {
        return paymentID;
    }

    /**
     * @param paymentID the paymentID to set
     */
    public void setPaymentID(String paymentID) {
        this.paymentID = paymentID;
    }

    /**
     * @return the paymentDate
     */
    public String getPaymentDate() {
        return paymentDate;
    }

    /**
     * @param paymentDate the paymentDate to set
     */
    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    /**
     * @return the paymentTime
     */
    public String getPaymentTime() {
        return paymentTime;
    }

    /**
     * @param paymentTime the paymentTime to set
     */
    public void setPaymentTime(String paymentTime) {
        this.paymentTime = paymentTime;
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

    /**
     * @return the amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(double amount) {
        this.amount = amount;
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
        return "PaymentDTO{" + "paymentID=" + paymentID + ", paymentDate=" + paymentDate + ", paymentTime=" + paymentTime + ", description=" + description + ", amount=" + amount + ", memberID=" + memberID + '}';
    }

   

    
    
    
     
    
    
}
