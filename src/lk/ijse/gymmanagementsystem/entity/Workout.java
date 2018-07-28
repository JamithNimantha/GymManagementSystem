/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.gymmanagementsystem.entity;

/**
 *
 * @author jamith
 */
public class Workout {
    private String workout_id;
    private String workout_name;
    private String workout_description;

    public Workout() {
    }

    public Workout(String workout_id, String workout_name, String workout_description) {
        this.workout_id = workout_id;
        this.workout_name = workout_name;
        this.workout_description = workout_description;
    }

    /**
     * @return the workout_id
     */
    public String getWorkout_id() {
        return workout_id;
    }

    /**
     * @param workout_id the workout_id to set
     */
    public void setWorkout_id(String workout_id) {
        this.workout_id = workout_id;
    }

    /**
     * @return the workout_name
     */
    public String getWorkout_name() {
        return workout_name;
    }

    /**
     * @param workout_name the workout_name to set
     */
    public void setWorkout_name(String workout_name) {
        this.workout_name = workout_name;
    }

    /**
     * @return the workout_description
     */
    public String getWorkout_description() {
        return workout_description;
    }

    /**
     * @param workout_description the workout_description to set
     */
    public void setWorkout_description(String workout_description) {
        this.workout_description = workout_description;
    }

    @Override
    public String toString() {
        return "Workout{" + "workout_id=" + workout_id + ", workout_name=" + workout_name + ", workout_description=" + workout_description + '}';
    }
    
    
}
