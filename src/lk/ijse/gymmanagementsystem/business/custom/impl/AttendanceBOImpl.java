/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.gymmanagementsystem.business.custom.impl;

import java.sql.Connection;
import java.util.ArrayList;
import lk.ijse.gymmanagementsystem.business.custom.AttendanceBO;
import lk.ijse.gymmanagementsystem.dao.DAOFactory;
import lk.ijse.gymmanagementsystem.dao.custom.AttendanceDAO;
import lk.ijse.gymmanagementsystem.dao.custom.QueryDAO;
import lk.ijse.gymmanagementsystem.db.DBConnection;
import lk.ijse.gymmanagementsystem.entity.Attendance;
import lk.ijse.gymmanagementsystem.entity.CustomEntity;
import lk.ijse.gymmanagementsystem.model.AttendanceDTO;
import lk.ijse.gymmanagementsystem.model.CustomDTO;


public class AttendanceBOImpl implements AttendanceBO {
    private static AttendanceDAO attendanceDAO ;
    private static QueryDAO queryDAO;

    public AttendanceBOImpl() {
        attendanceDAO  = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ATTENDENCE);
        queryDAO= DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.QUERY);
    }
    
    

    @Override
    public boolean addAttendance(AttendanceDTO attendanceDTO) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        connection.setAutoCommit(false);
        
        boolean save = attendanceDAO.save(new Attendance(attendanceDTO.getAttendance_id(), attendanceDTO.getAttendance_date(),attendanceDTO.getIn_time(), attendanceDTO.getMember_id()));
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
    public ArrayList<AttendanceDTO> getAllAttendance() throws Exception {
        
        return null;
    }

    @Override
    public ArrayList<CustomDTO> getAllAttendanceToTable() throws Exception {
        ArrayList<CustomEntity> customEntitys = queryDAO.getToAttendanceTaable();
        ArrayList<CustomDTO> arrayList = new ArrayList<>();
        for (CustomEntity c: customEntitys) {
            arrayList.add(new CustomDTO(c.getFirst_name(), c.getAttendance_id(), c.getAttendance_date(), c.getIn_time(), c.getMembership_id()));
            
        }
            
        return arrayList;
    }
    
}
