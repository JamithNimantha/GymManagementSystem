/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.gymmanagementsystem.business.custom.impl;

import java.sql.Connection;
import lk.ijse.gymmanagementsystem.business.custom.ScheduleBO;
import lk.ijse.gymmanagementsystem.dao.DAOFactory;
import lk.ijse.gymmanagementsystem.dao.custom.ScheduleDAO;
import lk.ijse.gymmanagementsystem.dao.custom.ScheduleDetailDAO;
import lk.ijse.gymmanagementsystem.db.DBConnection;
import lk.ijse.gymmanagementsystem.entity.Schedule;
import lk.ijse.gymmanagementsystem.entity.ScheduleDetail;
import lk.ijse.gymmanagementsystem.model.ScheduleDTO;
import lk.ijse.gymmanagementsystem.model.ScheduleDetailDTO;


public class ScheduleBOImpl implements ScheduleBO {
    
     private ScheduleDAO scheduleDAO;
     private ScheduleDetailDAO scheduleDetailDAO;

    public ScheduleBOImpl() {
         scheduleDAO  = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.SCHEDULE);
         scheduleDetailDAO=DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.SCHEDULEDETAILS);
    }
     
     

    @Override
    public boolean addSchedule(ScheduleDTO scheduleDTO) throws Exception {
         Connection connection = DBConnection.getInstance().getConnection();
         connection.setAutoCommit(false);
         try{
         boolean save = scheduleDAO.save(new Schedule(scheduleDTO.getSchedule_id(), scheduleDTO.getMembership_id(), scheduleDTO.getTrainer_id(), scheduleDTO.getSchedule_date()));
         if (!save) {
             connection.rollback();
             return false;
            
        }
         for(ScheduleDetailDTO scheduleDetailDTO :scheduleDTO.getScheduleDetailDTO()){
         save =scheduleDetailDAO.save(new ScheduleDetail(scheduleDetailDTO.getSchedule_id(), scheduleDetailDTO.getWorkout_id(), scheduleDetailDTO.getSets(), scheduleDetailDTO.getReps(), scheduleDetailDTO.getRest()));
         if (!save) {
             connection.rollback();
             return false;
            
        }
       }
         connection.commit();
         return true;
         }finally{
            connection.setAutoCommit(true);
        }
        
    }
    
    
}
