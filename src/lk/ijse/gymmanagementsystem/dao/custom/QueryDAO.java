/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.gymmanagementsystem.dao.custom;

import java.util.ArrayList;
import lk.ijse.gymmanagementsystem.dao.SuperDAO;
import lk.ijse.gymmanagementsystem.entity.CustomEntity;

/**
 *
 * @author jamith
 */
public interface QueryDAO extends SuperDAO{
    public ArrayList<CustomEntity> getToAttendanceTaable() throws Exception;
    public ArrayList<CustomEntity> getAllMeasurements() throws Exception;
    public ArrayList<CustomEntity> getAllMemberDetails() throws Exception;
     public ArrayList<CustomEntity> getAllPaymentDetails() throws Exception;
}
