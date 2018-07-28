/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.gymmanagementsystem.model;

/**
 *
 * @author jamith
 */
public class ScheduleDetailDTO {
    private String schedule_id;
    private String workout_id;
    private String sets;
    private String reps;
    private String rest;

    public ScheduleDetailDTO() {
    }

    public ScheduleDetailDTO(String schedule_id, String workout_id, String sets, String reps, String rest) {
        this.schedule_id = schedule_id;
        this.workout_id = workout_id;
        this.sets = sets;
        this.reps = reps;
        this.rest = rest;
    }

    /**
     * @return the schedule_id
     */
    public String getSchedule_id() {
        return schedule_id;
    }

    /**
     * @param schedule_id the schedule_id to set
     */
    public void setSchedule_id(String schedule_id) {
        this.schedule_id = schedule_id;
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
     * @return the sets
     */
    public String getSets() {
        return sets;
    }

    /**
     * @param sets the sets to set
     */
    public void setSets(String sets) {
        this.sets = sets;
    }

    /**
     * @return the reps
     */
    public String getReps() {
        return reps;
    }

    /**
     * @param reps the reps to set
     */
    public void setReps(String reps) {
        this.reps = reps;
    }

    /**
     * @return the rest
     */
    public String getRest() {
        return rest;
    }

    /**
     * @param rest the rest to set
     */
    public void setRest(String rest) {
        this.rest = rest;
    }

    
    
    
}
