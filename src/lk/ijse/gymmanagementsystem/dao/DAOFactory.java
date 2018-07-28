/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.gymmanagementsystem.dao;

import lk.ijse.gymmanagementsystem.dao.custom.impl.AttendanceDAOImpl;
import lk.ijse.gymmanagementsystem.dao.custom.impl.MeasurementDAOImpl;
import lk.ijse.gymmanagementsystem.dao.custom.impl.MemberDAOImpl;
import lk.ijse.gymmanagementsystem.dao.custom.impl.MembershipDAOImpl;
import lk.ijse.gymmanagementsystem.dao.custom.impl.PackageDAOImpl;
import lk.ijse.gymmanagementsystem.dao.custom.impl.PaymentDAOImpl;
import lk.ijse.gymmanagementsystem.dao.custom.impl.QueryDAOImpl;
import lk.ijse.gymmanagementsystem.dao.custom.impl.RegistrationDAOImpl;
import lk.ijse.gymmanagementsystem.dao.custom.impl.ScheduleDAOImpl;
import lk.ijse.gymmanagementsystem.dao.custom.impl.ScheduleDetailDAOImpl;
import lk.ijse.gymmanagementsystem.dao.custom.impl.TrainerDAOImpl;
import lk.ijse.gymmanagementsystem.dao.custom.impl.WorkoutDAOImpl;

/**
 *
 * @author jamith
 */
public class DAOFactory {
   public enum DAOTypes{
        ATTENDENCE, MEASUREMENT, MEMBER, MEMBERSHIP,PACKAGE,PAYMENT,REGISTRATION,TRAINER,QUERY,WORKOUT,SCHEDULE,SCHEDULEDETAILS;
    }
    
    private static DAOFactory dAOFactory;
    
    private DAOFactory(){
        
    }
    
    public static DAOFactory getInstance(){
        if (dAOFactory == null){
            dAOFactory = new DAOFactory();
        }
        return dAOFactory;
    }
    
    public <T extends SuperDAO> T getDAO(DAOTypes daoType){
        switch(daoType){
            case ATTENDENCE:
                return (T) new AttendanceDAOImpl();
            case MEASUREMENT:
                return (T) new MeasurementDAOImpl();
            case MEMBER:
                return (T) new MemberDAOImpl();
            case MEMBERSHIP:
                return (T) new MembershipDAOImpl();
            case PACKAGE:
                return (T) new PackageDAOImpl();
            case PAYMENT:
                return (T) new PaymentDAOImpl();
             case REGISTRATION:
                return (T) new RegistrationDAOImpl();
            case TRAINER:
                return (T) new TrainerDAOImpl();
            case QUERY:
                return (T) new QueryDAOImpl();
            case WORKOUT:
                return (T) new WorkoutDAOImpl();
            case SCHEDULE:
                return (T) new ScheduleDAOImpl();
            case SCHEDULEDETAILS:
                return (T) new ScheduleDetailDAOImpl();
                
            default:
                return null;
        }
    } 
}
