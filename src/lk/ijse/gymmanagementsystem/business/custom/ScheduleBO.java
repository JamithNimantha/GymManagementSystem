/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.gymmanagementsystem.business.custom;

import lk.ijse.gymmanagementsystem.business.SuperBO;
import lk.ijse.gymmanagementsystem.model.ScheduleDTO;

/**
 *
 * @author jamith
 */
public interface ScheduleBO extends SuperBO{
    public boolean addSchedule(ScheduleDTO scheduleDTO) throws Exception;
    
}
