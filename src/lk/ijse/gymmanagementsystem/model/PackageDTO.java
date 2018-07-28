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
public class PackageDTO {
    private String packageID;
    private String name;
    private String description;
    private Double fee;

    public PackageDTO() {
    }

    public PackageDTO(String packageID, String name, String description, Double fee) {
        this.packageID = packageID;
        this.name = name;
        this.description = description;
        this.fee = fee;
    }

    /**
     * @return the packageID
     */
    public String getPackageID() {
        return packageID;
    }

    /**
     * @param packageID the packageID to set
     */
    public void setPackageID(String packageID) {
        this.packageID = packageID;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
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
     * @return the fee
     */
    public Double getFee() {
        return fee;
    }

    /**
     * @param fee the fee to set
     */
    public void setFee(Double fee) {
        this.fee = fee;
    }

    @Override
    public String toString() {
        return "Package{" + "packageID=" + packageID + ", name=" + name + ", description=" + description + ", fee=" + fee + '}';
    }
    
    
}
