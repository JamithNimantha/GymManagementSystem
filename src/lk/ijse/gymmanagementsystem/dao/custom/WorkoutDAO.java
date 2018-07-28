/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.gymmanagementsystem.dao.custom;

import lk.ijse.gymmanagementsystem.dao.CrudDAO;
import lk.ijse.gymmanagementsystem.entity.Workout;

/**
 *
 * @author jamith
 */
public interface WorkoutDAO extends CrudDAO<Workout, Object>{
    public Workout searchWorkoutUsingName(String name) throws Exception;
}
