/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.gymmanagementsystem.dao.custom.impl;

import java.util.ArrayList;
import lk.ijse.gymmanagementsystem.dao.CrudUtil;
import lk.ijse.gymmanagementsystem.dao.custom.PaymentDAO;
import lk.ijse.gymmanagementsystem.entity.Payment;


public class PaymentDAOImpl implements PaymentDAO {

    @Override
    public boolean save(Payment entity) throws Exception {
        return CrudUtil.executeUpdate("insert into Payment values(?,?,?,?,?,?)", entity.getPayment_id(),entity.getPayment_date(),entity.getPayment_time(),entity.getPayment_description(),entity.getPayment_amount(),entity.getMembership_id())>0;
    }

    @Override
    public boolean update(Payment entity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Payment search(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Payment> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
