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
public class Membership {
    private String membership_id;
    private String first_payment_date;
    private String registration_id;
    private String package_id;
    private String trainer_id;

    public Membership() {
    }

    public Membership(String member_id, String first_payment_date, String registration_id, String package_id, String trainer_id) {
        this.membership_id = member_id;
        this.first_payment_date = first_payment_date;
        this.registration_id = registration_id;
        this.package_id = package_id;
        this.trainer_id = trainer_id;
    }

    /**
     * @return the member_id
     */
    public String getMembership_id() {
        return membership_id;
    }

    /**
     * @param member_id the member_id to set
     */
    public void setMembership_id(String member_id) {
        this.membership_id = member_id;
    }

    /**
     * @return the first_payment_date
     */
    public String getFirst_payment_date() {
        return first_payment_date;
    }

    /**
     * @param first_payment_date the first_payment_date to set
     */
    public void setFirst_payment_date(String first_payment_date) {
        this.first_payment_date = first_payment_date;
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
     * @return the package_id
     */
    public String getPackage_id() {
        return package_id;
    }

    /**
     * @param package_id the package_id to set
     */
    public void setPackage_id(String package_id) {
        this.package_id = package_id;
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

    @Override
    public String toString() {
        return "Membership{" + "member_id=" + membership_id + ", first_payment_date=" + first_payment_date + ", registration_id=" + registration_id + ", package_id=" + package_id + ", trainer_id=" + trainer_id + '}';
    }
    
    
}
