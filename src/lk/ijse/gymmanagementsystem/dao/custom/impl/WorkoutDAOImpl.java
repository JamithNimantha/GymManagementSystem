/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.gymmanagementsystem.dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import lk.ijse.gymmanagementsystem.dao.CrudUtil;
import lk.ijse.gymmanagementsystem.dao.custom.WorkoutDAO;
import lk.ijse.gymmanagementsystem.entity.Workout;


public class WorkoutDAOImpl implements WorkoutDAO {

    @Override
    public boolean save(Workout entity) throws Exception {
        return CrudUtil.executeUpdate("insert into Workout values(?,?,?)", entity.getWorkout_id(),entity.getWorkout_name(),entity.getWorkout_description())>0;
    }

    @Override
    public boolean update(Workout entity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Object id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Workout search(Object id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Workout> getAll() throws Exception {
        ArrayList<Workout> workouts = new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("select * from Workout");
        while (rst.next()) {
            workouts.add(new Workout(rst.getString(1), rst.getString(2), rst.getString(3)));
        }
        return workouts;
    }

    @Override
    public Workout searchWorkoutUsingName(String name) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("select * from Workout where workout_name=? ",name);
        if(rst.next()){
            return new Workout(rst.getString(1), rst.getString(2), rst.getString(3));
        }else{
            return null;
        }
    }
    
}
