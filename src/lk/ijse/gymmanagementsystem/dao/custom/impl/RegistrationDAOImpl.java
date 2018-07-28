/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.gymmanagementsystem.dao.custom.impl;

import java.util.ArrayList;
import lk.ijse.gymmanagementsystem.dao.CrudUtil;
import lk.ijse.gymmanagementsystem.dao.custom.RegistrationDAO;
import lk.ijse.gymmanagementsystem.entity.Registration;

/**
 *
 * @author jamith
 */
public class RegistrationDAOImpl implements RegistrationDAO{

    @Override
    public boolean save(Registration entity) throws Exception {
        return CrudUtil.executeUpdate("Insert into Registration values(?,?,?) ", entity.getRegistration_id(),entity.getJoining_date(),entity.getMember_id())>0;
    }

    @Override
    public boolean update(Registration entity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Registration search(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Registration> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
