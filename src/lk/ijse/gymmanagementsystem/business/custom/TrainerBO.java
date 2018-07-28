/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.gymmanagementsystem.business.custom;

import java.util.ArrayList;
import lk.ijse.gymmanagementsystem.business.SuperBO;
import lk.ijse.gymmanagementsystem.model.TrainerDTO;

/**
 *
 * @author jamith
 */
public interface TrainerBO extends SuperBO{
    public boolean addTrainer(TrainerDTO trainerDTO) throws Exception;
    public ArrayList<TrainerDTO> getAllTrainers() throws Exception;
    public ArrayList<String> getAllTrainersNames() throws Exception;
     public String searchTrainersUsingName(String name) throws Exception;
    
}
