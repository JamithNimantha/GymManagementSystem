/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.gymmanagementsystem.dao.custom.impl;

import java.util.ArrayList;
import lk.ijse.gymmanagementsystem.dao.CrudUtil;
import lk.ijse.gymmanagementsystem.dao.custom.MembershipDAO;
import lk.ijse.gymmanagementsystem.entity.Membership;


public class MembershipDAOImpl implements MembershipDAO {

    @Override
    public boolean save(Membership entity) throws Exception {
        return CrudUtil.executeUpdate("insert into Membership values(?,?,?,?,?)",entity.getMembership_id(),entity.getFirst_payment_date(),entity.getRegistration_id(),entity.getPackage_id(),entity.getTrainer_id())>0;
    }

    @Override
    public boolean update(Membership entity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Membership search(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Membership> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
