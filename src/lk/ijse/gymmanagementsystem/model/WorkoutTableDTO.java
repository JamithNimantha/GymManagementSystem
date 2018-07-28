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
public class WorkoutTableDTO {
    private String id;
    private String name;
    private String sets;
    private String reps;
    private String rest;

    public WorkoutTableDTO() {
    }

    public WorkoutTableDTO(String id, String name, String sets, String reps, String rest) {
        this.id = id;
        this.name = name;
        this.sets = sets;
        this.reps = reps;
        this.rest = rest;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "WorkoutTableDTO{" + "id=" + id + ", name=" + name + ", sets=" + sets + ", reps=" + reps + ", rest=" + rest + '}';
    }
    
    
}
