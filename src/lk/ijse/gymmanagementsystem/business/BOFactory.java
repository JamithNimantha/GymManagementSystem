/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.gymmanagementsystem.business;

import lk.ijse.gymmanagementsystem.business.custom.impl.AttendanceBOImpl;
import lk.ijse.gymmanagementsystem.business.custom.impl.MeasurementBOImpl;
import lk.ijse.gymmanagementsystem.business.custom.impl.MemberBOImpl;
import lk.ijse.gymmanagementsystem.business.custom.impl.PackageBOImpl;
import lk.ijse.gymmanagementsystem.business.custom.impl.PaymentBOImpl;
import lk.ijse.gymmanagementsystem.business.custom.impl.ScheduleBOImpl;
import lk.ijse.gymmanagementsystem.business.custom.impl.TrainerBOImpl;
import lk.ijse.gymmanagementsystem.business.custom.impl.WorkoutBOImpl;

/**
 *
 * @author jamith
 */
public class BOFactory {
    
    public enum BOTypes{
       ATTENDANCE, MEASUREMENT, MEMBER,PACKAGE,PAYMENT,TRAINER,WORKOUT,SCHEDULE;
    }
    
    private static BOFactory boFactory;
    
    private BOFactory(){
        
    }
    
    public static BOFactory getInstance(){
        if (boFactory == null){
            boFactory = new BOFactory();
        }
        return boFactory;
    }
    
    public <T extends SuperBO> T getBO(BOTypes boType){
        switch(boType){
            case ATTENDANCE:
                return (T) new AttendanceBOImpl();
            case MEASUREMENT:
                return (T) new MeasurementBOImpl();
            case MEMBER:
                return (T) new MemberBOImpl();
            case PACKAGE:
                return (T) new PackageBOImpl();
            case PAYMENT:
                return (T) new PaymentBOImpl();
            case TRAINER:
                return (T) new TrainerBOImpl();
            case SCHEDULE:
                return (T) new ScheduleBOImpl();
                
            case WORKOUT:
                return (T) new WorkoutBOImpl();
            default:
                return null;
        }
    }
    
}
