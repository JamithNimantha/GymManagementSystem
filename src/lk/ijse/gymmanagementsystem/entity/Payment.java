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
public class Payment {
    private String payment_id;
    private String payment_date;
    private String payment_time;
    private String payment_description;
    private double payment_amount;
    private String membership_id;

    public Payment() {
    }

    public Payment(String payment_id, String payment_date, String payment_time, String payment_description, double payment_amount, String membership_id) {
        this.payment_id = payment_id;
        this.payment_date = payment_date;
        this.payment_time = payment_time;
        this.payment_description = payment_description;
        this.payment_amount = payment_amount;
        this.membership_id = membership_id;
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
        return "Payment{" + "payment_id=" + payment_id + ", payment_date=" + payment_date + ", payment_time=" + payment_time + ", payment_description=" + payment_description + ", payment_amount=" + payment_amount + ", membership_id=" + membership_id + '}';
    }

   

    
    
    
}
