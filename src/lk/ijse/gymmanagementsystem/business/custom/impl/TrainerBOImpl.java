/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.gymmanagementsystem.business.custom.impl;

import java.sql.Connection;
import java.util.ArrayList;
import lk.ijse.gymmanagementsystem.business.custom.TrainerBO;
import lk.ijse.gymmanagementsystem.dao.DAOFactory;
import lk.ijse.gymmanagementsystem.dao.custom.TrainerDAO;
import lk.ijse.gymmanagementsystem.db.DBConnection;
import lk.ijse.gymmanagementsystem.entity.Trainer;
import lk.ijse.gymmanagementsystem.model.TrainerDTO;


public class TrainerBOImpl implements TrainerBO {
    private static TrainerDAO trainerDAO ;

    public TrainerBOImpl() {
        trainerDAO=DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.TRAINER);
    }
    
    

    @Override
    public boolean addTrainer(TrainerDTO trainerDTO) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        connection.setAutoCommit(false);
        
        boolean result = trainerDAO.save(new Trainer(trainerDTO.getTrainer_id(), trainerDTO.getFull_name(), trainerDTO.getAddress(),trainerDTO.getGender(),trainerDTO.getMobile_number(), trainerDTO.getDate_of_birth(), trainerDTO.getEmail(), trainerDTO.getJoining_date(),trainerDTO.getDescription()));
        try {
            if (!result) {
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
    public ArrayList<TrainerDTO> getAllTrainers() throws Exception {
        ArrayList<Trainer> trainers = trainerDAO.getAll();
        ArrayList<TrainerDTO> dTOs = new ArrayList<>();
        for (Trainer t : trainers) {
            dTOs.add(new TrainerDTO(t.getTrainer_id(), t.getFull_name(), t.getDate_of_birth(), t.getGender(), t.getMobile_number(), t.getAddress(), t.getEmail(), t.getJoining_date(), t.getTrainer_description()));
            
        }
        return dTOs;
    }

    @Override
    public String searchTrainersUsingName(String name) throws Exception {
        Trainer all = trainerDAO.searchTrainerUsingName(name);
        return all.getTrainer_id();
        
    }

    @Override
    public ArrayList<String> getAllTrainersNames() throws Exception {
        ArrayList<Trainer> trainers = trainerDAO.getAll();
        ArrayList<String> dTOs = new ArrayList<>();
        for (Trainer t : trainers) {
            dTOs.add(t.getFull_name());
        }
        return dTOs;
    }

   
    
}
