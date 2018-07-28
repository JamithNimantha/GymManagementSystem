/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.gymmanagementsystem.business.custom.impl;

import java.sql.Connection;
import java.util.ArrayList;
import lk.ijse.gymmanagementsystem.business.custom.PackageBO;
import lk.ijse.gymmanagementsystem.dao.custom.PackageDAO;
import lk.ijse.gymmanagementsystem.dao.custom.impl.PackageDAOImpl;
import lk.ijse.gymmanagementsystem.db.DBConnection;
import lk.ijse.gymmanagementsystem.model.PackageDTO;
import lk.ijse.gymmanagementsystem.entity.Package;


public class PackageBOImpl implements PackageBO {
    
    private static PackageDAO packageDAO = new PackageDAOImpl();

    @Override
    public boolean addPackage(PackageDTO packageDTO) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        connection.setAutoCommit(false);
        boolean save = packageDAO.save(new Package(packageDTO.getPackageID(), packageDTO.getName(), packageDTO.getDescription(),packageDTO.getFee()));
            try {
            if (!save) {
                connection.rollback();
                return false;
                
            }
            connection.commit();
            return true;
        } finally {
                connection.setAutoCommit(true);
        }
            
            
    }

    @Override
    public ArrayList<String> getAllPackageNames() throws Exception {
        ArrayList<Package> all = packageDAO.getAll();
        ArrayList<String> nameList = new ArrayList<>();
        for (Package p : all) {
            nameList.add(p.getPackage_name());
        }
        return nameList;
    }

    @Override
    public String searchPackageUsingName(String name) throws Exception {
        Package all = packageDAO.searchPackageUsingName(name);
        return all.getPackage_id();
    }

    @Override
    public ArrayList<PackageDTO> getAllPackages() throws Exception {
        ArrayList<Package> all = packageDAO.getAll();
        ArrayList<PackageDTO> nameList = new ArrayList<>();
        for (Package p : all) {
            nameList.add(new PackageDTO(p.getPackage_id(), p.getPackage_name(), p.getPackage_description(), p.getPackage_fee()));
        }
        return nameList;
    }
    
}
