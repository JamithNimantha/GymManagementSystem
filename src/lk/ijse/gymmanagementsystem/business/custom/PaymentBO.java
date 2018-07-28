/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.gymmanagementsystem.business.custom;

import java.util.ArrayList;
import lk.ijse.gymmanagementsystem.business.SuperBO;
import lk.ijse.gymmanagementsystem.model.CustomDTO;
import lk.ijse.gymmanagementsystem.model.PaymentDTO;

/**
 *
 * @author jamith
 */
public interface PaymentBO extends SuperBO{
    public boolean addPayment(PaymentDTO paymentDTO) throws Exception;
    public ArrayList<CustomDTO> getAllPaymentDetails() throws Exception;
    
}
