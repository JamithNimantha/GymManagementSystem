/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.gymmanagementsystem.business.custom;

import java.util.ArrayList;
import lk.ijse.gymmanagementsystem.business.SuperBO;
import lk.ijse.gymmanagementsystem.model.WorkoutDTO;

/**
 *
 * @author jamith
 */
public interface WorkoutBO extends SuperBO{
    public boolean addWorkout(WorkoutDTO workoutDTO) throws Exception;
    public ArrayList<WorkoutDTO> getAllWorkouts() throws Exception;
    public ArrayList<String> getAllWorkoutsNames() throws Exception;
    public String searchWorkoutUsingName(String name) throws Exception;
}
