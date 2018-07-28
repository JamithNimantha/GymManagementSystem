/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.gymmanagementsystem.dao.custom;

import java.util.ArrayList;
import lk.ijse.gymmanagementsystem.dao.CrudDAO;
import lk.ijse.gymmanagementsystem.entity.Trainer;

/**
 *
 * @author jamith
 */
public interface TrainerDAO extends CrudDAO<Trainer, String>{
    public Trainer searchTrainerUsingName(String name) throws Exception;
    public ArrayList<String> getAllTrainersNames() throws Exception;
}
