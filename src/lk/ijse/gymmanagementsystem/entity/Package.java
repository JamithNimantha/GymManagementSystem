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
public class Package {
    private String package_id;
    private String package_name;
    private String package_description;
    private Double package_fee;

    public Package() {
    }

    public Package(String package_id, String package_name, String package_description, Double package_fee) {
        this.package_id = package_id;
        this.package_name = package_name;
        this.package_description = package_description;
        this.package_fee = package_fee;
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
     * @return the package_description
     */
    public String getPackage_description() {
        return package_description;
    }

    /**
     * @param package_description the package_description to set
     */
    public void setPackage_description(String package_description) {
        this.package_description = package_description;
    }

    /**
     * @return the package_fee
     */
    public Double getPackage_fee() {
        return package_fee;
    }

    /**
     * @param package_fee the package_fee to set
     */
    public void setPackage_fee(Double package_fee) {
        this.package_fee = package_fee;
    }

    @Override
    public String toString() {
        return "Package{" + "package_id=" + package_id + ", package_name=" + package_name + ", package_description=" + package_description + ", package_fee=" + package_fee + '}';
    }
    
    
}
