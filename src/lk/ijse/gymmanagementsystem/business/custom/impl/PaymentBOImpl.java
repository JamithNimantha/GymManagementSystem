/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.gymmanagementsystem.business.custom.impl;

import java.sql.Connection;
import java.util.ArrayList;
import lk.ijse.gymmanagementsystem.business.custom.PaymentBO;
import lk.ijse.gymmanagementsystem.dao.DAOFactory;
import lk.ijse.gymmanagementsystem.dao.custom.PaymentDAO;
import lk.ijse.gymmanagementsystem.dao.custom.QueryDAO;
import lk.ijse.gymmanagementsystem.db.DBConnection;
import lk.ijse.gymmanagementsystem.entity.CustomEntity;
import lk.ijse.gymmanagementsystem.entity.Payment;
import lk.ijse.gymmanagementsystem.model.CustomDTO;
import lk.ijse.gymmanagementsystem.model.PaymentDTO;


public class PaymentBOImpl implements PaymentBO {
private PaymentDAO paymentDAO;
private QueryDAO queryDAO;
    public PaymentBOImpl() {
        paymentDAO=DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.PAYMENT);
        queryDAO=DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.QUERY);
    }

    @Override
    public boolean addPayment(PaymentDTO paymentDTO) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        connection.setAutoCommit(false);
        
        boolean save = paymentDAO.save(new Payment(paymentDTO.getPaymentID(), paymentDTO.getPaymentDate(), paymentDTO.getPaymentTime(), paymentDTO.getDescription(), paymentDTO.getAmount(), paymentDTO.getMemberID()));
        try{
            if(!save){
            connection.rollback();
            return false;
            }
           connection.commit();
           return true;

        }finally{
            connection.setAutoCommit(true);
        }
    }

    @Override
    public ArrayList<CustomDTO> getAllPaymentDetails() throws Exception {
        ArrayList<CustomEntity> customEntitys=queryDAO.getAllPaymentDetails();
        ArrayList<CustomDTO> customDTOs =new ArrayList<>();
        for (CustomEntity c : customEntitys) {
            customDTOs.add(new CustomDTO(c.getFull_name(), c.getPayment_id(), c.getPayment_date(), c.getPayment_time(), c.getPayment_description(), c.getPayment_amount()));
            
        }
        return customDTOs;
    }
    
}
