/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.gymmanagementsystem.dao.custom.impl;

import java.util.ArrayList;
import lk.ijse.gymmanagementsystem.dao.CrudUtil;
import lk.ijse.gymmanagementsystem.dao.custom.ScheduleDetailDAO;
import lk.ijse.gymmanagementsystem.entity.ScheduleDetail;

/**
 *
 * @author jamith
 */
public class ScheduleDetailDAOImpl implements ScheduleDetailDAO{

    @Override
    public boolean save(ScheduleDetail entity) throws Exception {
                return CrudUtil.executeUpdate("Insert into ScheduleDetail values(?,?,?,?,?) ", entity.getSchedule_id(),entity.getWorkout_id(),entity.getSets(),entity.getReps(),entity.getRest())>0;

    }

    @Override
    public boolean update(ScheduleDetail entity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ScheduleDetail search(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<ScheduleDetail> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
