/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.gymmanagementsystem.business.custom;

import java.util.ArrayList;
import lk.ijse.gymmanagementsystem.business.SuperBO;
import lk.ijse.gymmanagementsystem.model.AttendanceDTO;
import lk.ijse.gymmanagementsystem.model.CustomDTO;

/**
 *
 * @author jamith
 */
public interface AttendanceBO extends SuperBO{
    public boolean addAttendance(AttendanceDTO attendanceDTO) throws Exception;
    public ArrayList<AttendanceDTO> getAllAttendance() throws Exception;
    public ArrayList<CustomDTO> getAllAttendanceToTable() throws Exception;
    
}
