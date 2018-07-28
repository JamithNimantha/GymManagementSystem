/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.gymmanagementsystem.dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import lk.ijse.gymmanagementsystem.dao.CrudUtil;
import lk.ijse.gymmanagementsystem.dao.custom.TrainerDAO;
import lk.ijse.gymmanagementsystem.entity.Trainer;


public class TrainerDAOImpl implements TrainerDAO {

    @Override
    public boolean save(Trainer entity) throws Exception {
        return CrudUtil.executeUpdate("insert into Trainer values(?,?,?,?,?,?,?,?,?)",entity.getTrainer_id(),entity.getFull_name(),entity.getAddress(),entity.getGender(),entity.getMobile_number(),entity.getDate_of_birth(),entity.getEmail(),entity.getJoining_date(),entity.getTrainer_description())>0;
    }

    @Override
    public boolean update(Trainer entity) throws Exception {
        return true;
    }

    @Override
    public boolean delete(String id) throws Exception {
        return true;
    }

    @Override
    public Trainer search(String id) throws Exception {
        return null;
    }

    @Override
    public ArrayList<Trainer> getAll() throws Exception {
        ArrayList<Trainer> allTrainers = new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("select * from Trainer");
        while (rst.next()) {            
            allTrainers.add(new Trainer(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5), rst.getString(6), rst.getString(7), rst.getString(8), rst.getString(9)));
        }
        return allTrainers;
    }

    @Override
    public Trainer searchTrainerUsingName(String name) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("select * from Trainer where full_name=? ",name);
        if (rst.next()) {
            return  new Trainer(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5), rst.getString(6), rst.getString(7), rst.getString(8), rst.getString(9));
        } else {
            return null;
        }
    }

    @Override
    public ArrayList<String> getAllTrainersNames() throws Exception {
        /*rrayList<Trainer> arrayList = new ArrayList<>();
                ResultSet rst = CrudUtil.executeQuery("select * from Trainer");
                while (rst.next()) {
                arrayList.add(new Trainer(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5), rst.getString(6), rst.getString(7), rst.getString(8), rst.getString(9)));
                
                }*/
        return null;

    }

    
    
}
