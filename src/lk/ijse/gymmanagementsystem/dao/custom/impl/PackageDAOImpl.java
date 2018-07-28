/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.gymmanagementsystem.dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import lk.ijse.gymmanagementsystem.dao.CrudUtil;
import lk.ijse.gymmanagementsystem.dao.custom.PackageDAO;
import lk.ijse.gymmanagementsystem.entity.Package;


public class PackageDAOImpl implements PackageDAO {

    @Override
    public boolean save(Package entity) throws Exception {
        return CrudUtil.executeUpdate("insert into Package values(?,?,?,?)", entity.getPackage_id(),entity.getPackage_name(),entity.getPackage_description(),entity.getPackage_fee())>0;
    }

    @Override
    public boolean update(Package entity) throws Exception {
        return true;
        
    }

    @Override
    public boolean delete(String id) throws Exception {
        return true;
    }

    @Override
    public Package search(String id) throws Exception {
        return null;
        
    }

    @Override
    public ArrayList<Package> getAll() throws Exception {
        ArrayList<Package> arrayList = new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("select * from Package");
        while (rst.next()) {            
            arrayList.add(new Package(rst.getString(1), rst.getString(2), rst.getString(3), rst.getDouble(4)));
        }
        
        return arrayList;
    }

    @Override
    public Package searchPackageUsingName(String name) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("select * from Package where package_name=? ",name);
        if(rst.next()){
            return new Package(rst.getString(1), rst.getString(2), rst.getString(3), rst.getDouble(4));
        }else{
            return null;
        }
    }

    
    
}
