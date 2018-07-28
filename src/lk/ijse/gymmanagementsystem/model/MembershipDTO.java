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
public class MembershipDTO {
    private String membership_id;
    private String first_payment_id;
    private String registration_id;
    private String package_id;
    private String trainer_id;

    public MembershipDTO() {
    }

    public MembershipDTO(String membership_id, String first_payment_id, String registration_id, String package_id, String trainer_id) {
        this.membership_id = membership_id;
        this.first_payment_id = first_payment_id;
        this.registration_id = registration_id;
        this.package_id = package_id;
        this.trainer_id = trainer_id;
    }

    @Override
    public String toString() {
        return "MembershipDTO{" + "membership_id=" + getMembership_id() + ", first_payment_id=" + getFirst_payment_id() + ", registration_id=" + getRegistration_id() + ", package_id=" + getPackage_id() + ", trainer_id=" + getTrainer_id() + '}';
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
     * @return the first_payment_id
     */
    public String getFirst_payment_id() {
        return first_payment_id;
    }

    /**
     * @param first_payment_id the first_payment_id to set
     */
    public void setFirst_payment_id(String first_payment_id) {
        this.first_payment_id = first_payment_id;
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
    
    
}
