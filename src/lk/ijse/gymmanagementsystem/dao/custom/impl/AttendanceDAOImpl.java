/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.gymmanagementsystem.dao.custom.impl;

import java.util.ArrayList;
import lk.ijse.gymmanagementsystem.dao.CrudUtil;
import lk.ijse.gymmanagementsystem.dao.custom.AttendanceDAO;
import lk.ijse.gymmanagementsystem.entity.Attendance;


public class AttendanceDAOImpl implements AttendanceDAO {

    @Override
    public boolean save(Attendance entity) throws Exception {
        return CrudUtil.executeUpdate("insert into Attendance values(?,?,?,?)", entity.getAttendance_id(),entity.getAttendance_date(),entity.getIn_time(),entity.getMembership_id())>0;
    }

    @Override
    public boolean update(Attendance entity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Attendance search(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Attendance> getAll() throws Exception {
        return null;
    }

   
    
    
}
