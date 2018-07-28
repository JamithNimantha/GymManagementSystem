/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.gymmanagementsystem.dao.custom.impl;

import java.util.ArrayList;
import lk.ijse.gymmanagementsystem.dao.CrudUtil;
import lk.ijse.gymmanagementsystem.dao.custom.ScheduleDAO;
import lk.ijse.gymmanagementsystem.entity.Schedule;


public class ScheduleDAOImpl implements ScheduleDAO {

    @Override
    public boolean save(Schedule entity) throws Exception {
                return CrudUtil.executeUpdate("Insert into Schedule values(?,?,?,?) ", entity.getSchedule_id(),entity.getMembership_id(),entity.getTrainer_id(),entity.getSchedule_date())>0;

    }

    @Override
    public boolean update(Schedule entity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Schedule search(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Schedule> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
