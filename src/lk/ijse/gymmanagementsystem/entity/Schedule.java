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
public class Schedule {
    private String schedule_id;
    private String membership_id;
    private String trainer_id;
    private String schedule_date;

    public Schedule() {
    }

    public Schedule(String schedule_id, String membership_id, String trainer_id, String schedule_date) {
        this.schedule_id = schedule_id;
        this.membership_id = membership_id;
        this.trainer_id = trainer_id;
        this.schedule_date = schedule_date;
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
     * @return the membership_id
     */
    public String getMembership_id() {
        return membership_id;
    }

    /**
     * @param membership_id the membership_id to set
     */
    public void setMembership_id(String membership_id) {
        this.membership_id = membership_id;
    }

    /**
     * @return the trainer_id
     */
    public String getTrainer_id() {
        return trainer_id;
    }

    /**
     * @param trainer_id the trainer_id to set
     */
    public void setTrainer_id(String trainer_id) {
        this.trainer_id = trainer_id;
    }

    /**
     * @return the schedule_date
     */
    public String getSchedule_date() {
        return schedule_date;
    }

    /**
     * @param schedule_date the schedule_date to set
     */
    public void setSchedule_date(String schedule_date) {
        this.schedule_date = schedule_date;
    }
    
}
