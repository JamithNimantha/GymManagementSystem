/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.gymmanagementsystem.business.custom.impl;

import java.sql.Connection;
import java.util.ArrayList;
import lk.ijse.gymmanagementsystem.business.custom.WorkoutBO;
import lk.ijse.gymmanagementsystem.dao.DAOFactory;
import lk.ijse.gymmanagementsystem.dao.custom.WorkoutDAO;
import lk.ijse.gymmanagementsystem.db.DBConnection;
import lk.ijse.gymmanagementsystem.entity.Workout;
import lk.ijse.gymmanagementsystem.model.WorkoutDTO;


public class WorkoutBOImpl implements WorkoutBO {
    
    public WorkoutDAO workoutDAO;

    public WorkoutBOImpl() {
        workoutDAO=DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.WORKOUT);
    }
    
    

    @Override
    public boolean addWorkout(WorkoutDTO workoutDTO) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        connection.setAutoCommit(false);
        boolean save = workoutDAO.save(new Workout(workoutDTO.getWorkout_id(), workoutDTO.getWorkout_name(), workoutDTO.getWorkout_description()));
       
        try {
            if (!save) {
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
    public ArrayList<WorkoutDTO> getAllWorkouts() throws Exception {
        ArrayList<Workout> all = workoutDAO.getAll();
        ArrayList<WorkoutDTO> dTOs = new ArrayList<>();
        for (Workout w : all) {
            dTOs.add(new WorkoutDTO(w.getWorkout_id(), w.getWorkout_name(), w.getWorkout_description()));
            
        }
        return dTOs;
    }

    @Override
    public ArrayList<String> getAllWorkoutsNames() throws Exception {
         ArrayList<String> nameList = new ArrayList<>();
        ArrayList<Workout> all = workoutDAO.getAll();
        for (Workout workout : all) {
            nameList.add(workout.getWorkout_name());
            
        }
        return nameList;
    }

    @Override
    public String searchWorkoutUsingName(String name) throws Exception {
        Workout searchWorkoutUsingName = workoutDAO.searchWorkoutUsingName(name);
        return searchWorkoutUsingName.getWorkout_id();
    }
    
}
