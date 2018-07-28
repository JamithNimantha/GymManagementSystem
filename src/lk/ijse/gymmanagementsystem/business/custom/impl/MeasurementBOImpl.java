/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.gymmanagementsystem.business.custom.impl;

import java.sql.Connection;
import java.util.ArrayList;
import lk.ijse.gymmanagementsystem.business.custom.MeasurementBO;
import lk.ijse.gymmanagementsystem.dao.DAOFactory;
import lk.ijse.gymmanagementsystem.dao.custom.MeasurementDAO;
import lk.ijse.gymmanagementsystem.dao.custom.QueryDAO;
import lk.ijse.gymmanagementsystem.db.DBConnection;
import lk.ijse.gymmanagementsystem.entity.CustomEntity;
import lk.ijse.gymmanagementsystem.entity.Measurement;
import lk.ijse.gymmanagementsystem.model.CustomDTO;
import lk.ijse.gymmanagementsystem.model.MeasurementDTO;


public class MeasurementBOImpl implements MeasurementBO {
    private MeasurementDAO measurementDAO;
    private QueryDAO queryDAO;

    public MeasurementBOImpl() {
        measurementDAO=DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.MEASUREMENT);
        queryDAO=DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.QUERY);
    }
    
    

    @Override
    public boolean addMeasurent(MeasurementDTO measurementDTO) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        connection.setAutoCommit(false);
        
        boolean result  = measurementDAO.save(new Measurement(measurementDTO.getMeasurementID(), measurementDTO.getHeight(), measurementDTO.getWeight(), measurementDTO.getBmi(), measurementDTO.getBmiStatus(), measurementDTO.getChest(), measurementDTO.getWaist(), measurementDTO.getThigs(), measurementDTO.getArm(),measurementDTO.getResultDate(), measurementDTO.getMemberID()));
        try{
            if(!result){
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
    public ArrayList<CustomDTO> getAllMeasurements() throws Exception {
        ArrayList<CustomEntity> al=queryDAO.getAllMeasurements();
        ArrayList<CustomDTO> dTOs= new ArrayList<>();
        for (CustomEntity c : al) {
            dTOs.add(new CustomDTO(c.getFull_name(), c.getMeasurement_id(), c.getHeight(), c.getWeight(), c.getBmi(), c.getBmi_status(), c.getChest(), c.getWaist(), c.getThigs(), c.getArms(), c.getResult_date(), c.getMembership_id()));
            
            
        }
        return dTOs;
    }
    
}
