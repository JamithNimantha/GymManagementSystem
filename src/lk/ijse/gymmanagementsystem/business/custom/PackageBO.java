/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.gymmanagementsystem.business.custom;

import java.util.ArrayList;
import lk.ijse.gymmanagementsystem.business.SuperBO;
import lk.ijse.gymmanagementsystem.model.PackageDTO;

/**
 *
 * @author jamith
 */
public interface PackageBO extends SuperBO{
    public boolean addPackage(PackageDTO packageDTO) throws Exception;
    public ArrayList<String> getAllPackageNames() throws Exception;
    public String searchPackageUsingName(String name) throws Exception;
    public ArrayList<PackageDTO> getAllPackages() throws Exception;
}
