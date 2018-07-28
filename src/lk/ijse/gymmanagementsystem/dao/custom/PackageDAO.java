/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.gymmanagementsystem.dao.custom;

import lk.ijse.gymmanagementsystem.dao.CrudDAO;
import lk.ijse.gymmanagementsystem.entity.Package;

/**
 *
 * @author jamith
 */
public interface PackageDAO extends CrudDAO<Package, String>{
    public Package searchPackageUsingName(String name) throws Exception;
}
