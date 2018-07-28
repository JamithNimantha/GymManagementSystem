/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.gymmanagementsystem.business.custom;

import java.util.ArrayList;
import lk.ijse.gymmanagementsystem.business.SuperBO;
import lk.ijse.gymmanagementsystem.model.CustomDTO;
import lk.ijse.gymmanagementsystem.model.MeasurementDTO;

/**
 *
 * @author jamith
 */
public interface MeasurementBO extends SuperBO{
    public boolean addMeasurent(MeasurementDTO measurementDTO) throws Exception;
    public ArrayList<CustomDTO> getAllMeasurements() throws Exception;
}
